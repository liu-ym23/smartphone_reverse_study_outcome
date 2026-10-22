package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = null;
    private static final int UNKNOWN_LINK_SPEED = -1;
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private final Looper mLooper;
    private MyNetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private NetworkState mNetworkState;
    private final Observer mObserver;
    private boolean mRegisterNetworkCallbackFailed;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private WifiManagerDelegate mWifiManagerDelegate;

    public class AndroidRDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        LinkProperties mLinkProperties;
        NetworkCapabilities mNetworkCapabilities;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        private NetworkState getNetworkState(Network r13) {
            int r2 = -1;
            if (this.mNetworkCapabilities.hasTransport(1) == false) goto L5;
        L27:
            int r5 = 1;
        L28:
            int r6 = -1;
        L30:
            return new NetworkState(true, r5, r6, !this.mNetworkCapabilities.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r13)), null, ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
        L5:
            if (this.mNetworkCapabilities.hasTransport(5) == true) goto L27;
            if (this.mNetworkCapabilities.hasTransport(0) == false) goto L14;
            NetworkInfo r0 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getRawNetworkInfo(r13);
            if (r0 == null) goto L12;
            r2 = r0.getSubtype();
        L12:
            r6 = r2;
            r5 = 0;
            goto L30
        L14:
            if (this.mNetworkCapabilities.hasTransport(3) == false) goto L17;
            r5 = 9;
            goto L28
        L17:
            if (this.mNetworkCapabilities.hasTransport(2) == false) goto L20;
            r5 = 7;
            goto L28
        L20:
            if (this.mNetworkCapabilities.hasTransport(4) == false) goto L26;
            NetworkInfo r1 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkInfo(r13);
            if (r1 == null) goto L24;
            int r3 = r1.getType();
        L25:
            r5 = r3;
            goto L28
        L24:
            r3 = 17;
            goto L25
        L26:
            r5 = -1;
            goto L28
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r11) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, new NetworkState(false, -1, -1, false, null, null, false, XmlPullParser.NO_NAMESPACE));
            return;
        }

        public /* synthetic */ AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, 1 r2) {
            this(r1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            this.mNetworkCapabilities = r2;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r1));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            this.mLinkProperties = r2;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r1));
            return;
        }
    }

    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        public long getVpnNetId() {
            Network r0 = this.mVpnInPlace;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return NetworkChangeNotifierAutoDetect.networkToNetId(r0);
        }

        public void initializeVpnInPlace() {
            Network[] r0 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), null);
            this.mVpnInPlace = null;
            if (r0.length != 1) goto L10;
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r0[0]);
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r0[0];
            return;
        L12:
            return;
        }

        static {
        }

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        private boolean ignoreNetworkDueToVpn(Network r2) {
            Network r0 = this.mVpnInPlace;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.equals(r2) == true) goto L7;
            return true;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r9) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onAvailable");
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r9);     // Catch: Throwable -> L26
            if (ignoreConnectedNetwork(r9, r1) == false) goto L8;
            if (r0 == null) goto L37;
            r0.close();
            return;
        L37:
            return;
        L8:
            boolean r2 = false;
            if (r1 != null) goto L12;
            final boolean r6 = false;
        L20:
            if (r6 == false) goto L22;
            this.mVpnInPlace = r9;     // Catch: Throwable -> L26
        L22:
            final long r3 = NetworkChangeNotifierAutoDetect.networkToNetId(r9);     // Catch: Throwable -> L26
            final int r5 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r9);     // Catch: Throwable -> L26
            this.this$0.runOnThread(new AnonymousClass1(this, r3, r5, r6));     // Catch: Throwable -> L26
            if (r0 == null) goto L38;
            r0.close();
            return;
        L38:
            return;
        L12:
            if (r1.hasTransport(4) == false) goto L18;
            Network r4 = this.mVpnInPlace;     // Catch: Throwable -> L26
            if (r4 != null) goto L16;
        L17:
            r2 = true;
            goto L18
        L16:
            if (r9.equals(r4) == false) goto L17;
        L18:
            r6 = r2;
        L26:
            th = move-exception;
            if (r0 != null) goto L33;
        L32:
            throw th;
        L33:
            r0.close();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            th.addSuppressed(th);
            goto L32
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r6) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLost");
        L23:
            th = move-exception;
            if (r0 != null) goto L32;
        L29:
            throw th;
        L32:
            r0.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);
            goto L29
        L4:
            if (ignoreNetworkDueToVpn(r6) == false) goto L8;
            if (r0 == null) goto L35;
            r0.close();
            return;
        L35:
            return;
        L8:
            Network r1 = this.mVpnInPlace;     // Catch: Throwable -> L23
            int r2 = 0;
            if (r1 != null) goto L11;
        L13:
            final boolean r3 = false;
        L14:
            this.this$0.runOnThread(new AnonymousClass4(this, r6, r3));     // Catch: Throwable -> L23
            if (this.mVpnInPlace == null) goto L20;
            this.mVpnInPlace = null;     // Catch: Throwable -> L23
            Network[] r7 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), r6);     // Catch: Throwable -> L23
            int r4 = r7.length;     // Catch: Throwable -> L23
        L17:
            if (r2 >= r4) goto L19;
            onAvailable(r7[r2]);     // Catch: Throwable -> L23
            r2 = r2 + 1;     // Catch: Throwable -> L23
            goto L17
        L19:
            int r8 = this.this$0.getCurrentNetworkState().getConnectionType();     // Catch: Throwable -> L23
            this.this$0.runOnThread(new 5(this, r8));     // Catch: Throwable -> L23
        L20:
            if (r0 == null) goto L36;
            r0.close();
            return;
        L36:
            return;
        L11:
            if (r1.equals(r6) == false) goto L13;
            r3 = true;
            goto L14
        }

        public /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r1, 1 r2) {
            this(r1);
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r2, NetworkCapabilities r3) {
            if (r3 != null) goto L4;
            r3 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r2);
        L4:
            if (r3 != null) goto L6;
        L11:
            return true;
        L6:
            if (r3.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.access$600(this.this$0).vpnAccessible(r2) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r2, NetworkCapabilities r3) {
            if (ignoreNetworkDueToVpn(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r2, r3) == true) goto L8;
            return false;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r9) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onCapabilitiesChanged");
        L18:
            th = move-exception;
            if (r0 != null) goto L27;
        L24:
            throw th;
        L27:
            r0.close();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        L4:
            if (ignoreConnectedNetwork(r8, r9) == false) goto L8;
            if (r0 == null) goto L29;
            r0.close();
            return;
        L29:
            return;
        L8:
            final long r3 = NetworkChangeNotifierAutoDetect.networkToNetId(r8);     // Catch: Throwable -> L18
            final int r5 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r8);     // Catch: Throwable -> L18
            Network r10 = this.mVpnInPlace;     // Catch: Throwable -> L18
            if (r10 != null) goto L11;
        L13:
            final boolean r6 = false;
        L14:
            this.this$0.runOnThread(new AnonymousClass2(this, r3, r5, r6));     // Catch: Throwable -> L18
            if (r0 == null) goto L30;
            r0.close();
            return;
        L30:
            return;
        L11:
            if (r10.equals(r8) == false) goto L13;
            r6 = true;
            goto L14
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r4, int r5) {
            TraceEvent r6 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLosing");
        L12:
            th = move-exception;
            if (r6 != null) goto L21;
        L18:
            throw th;
        L21:
            r6.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        L4:
            if (ignoreConnectedNetwork(r4, null) == false) goto L8;
            if (r6 == null) goto L23;
            r6.close();
            return;
        L23:
            return;
        L8:
            long r0 = NetworkChangeNotifierAutoDetect.networkToNetId(r4);     // Catch: Throwable -> L12
            this.this$0.runOnThread(new 3(this, r0));     // Catch: Throwable -> L12
            if (r6 == null) goto L24;
            r6.close();
            return;
        }
    }

    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public static /* synthetic */ void a(NetworkChangeNotifierAutoDetect r0, Runnable r1) {
        r0.lambda$runOnThread$0(r1);
    }

    private static int convertToConnectionType(int r4, int r5) {
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L18;
        if (r4 == 4) goto L21;
        if (r4 == 5) goto L21;
        if (r4 != 6) goto L11;
        return 5;
    L11:
        if (r4 != 7) goto L13;
        return 7;
    L13:
        if (r4 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r5 == 20) goto L28;
        switch(r5) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L25;
            case 15: goto L25;
            default: goto L23;
        };
    L23:
        return 0;
    L24:
        return 5;
    L25:
        return 4;
    L26:
        return 3;
    L28:
        return 8;
    }

    static {
        TAG = "NetworkChangeNotifierAutoDetect";
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    public long getDefaultNetId() {
        Network r0 = this.mConnectivityManagerDelegate.getDefaultNetwork();
        if (r0 != null) goto L6;
        return -1;
    L6:
        return networkToNetId(r0);
    }

    public long[] getNetworksAndTypes() {
        Network[] r0 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r1 = new long[r0.length * 2];
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Network r5 = r0[r3];
        int r6 = r4 + 1;
        r1[r4] = networkToNetId(r5);
        r4 = r6 + 1;
        r1[r6] = this.mConnectivityManagerDelegate.getConnectionType(r5);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public long getVpnNetId() {
        MyNetworkCallback r0 = this.mNetworkCallback;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getVpnNetId();
    }

    private void connectionTypeChanged() {
        connectionTypeChangedTo(getCurrentNetworkState());
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered == false) goto L7;
        connectionTypeChanged();
        return;
    L7:
        if (this.mShouldSignalObserver == false) goto L9;
        connectionTypeChanged();
    L9:
        ConnectivityManager.NetworkCallback r0 = this.mDefaultNetworkCallback;
        if (r0 != null) goto L41;
    L14:
        int r2 = 0;
        if (this.mDefaultNetworkCallback == null) goto L43;
    L23:
        this.mRegistered = true;
        MyNetworkCallback r1 = this.mNetworkCallback;
        if (r1 == null) goto L46;
        r1.initializeVpnInPlace();
        this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);     // Catch: RuntimeException -> L28
    L30:
        if (this.mRegisterNetworkCallbackFailed == false) goto L32;
        return;
    L32:
        if (this.mShouldSignalObserver == false) goto L48;
        Network[] r3 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r4 = new long[r3.length];
    L35:
        if (r2 >= r3.length) goto L37;
        r4[r2] = networkToNetId(r3[r2]);
        r2 = r2 + 1;
        goto L35
    L37:
        this.mObserver.purgeActiveNetworkList(r4);
        return;
    L48:
        return;
    L28:
        this.mRegisterNetworkCallbackFailed = true;
        this.mNetworkCallback = null;
        goto L30
    L46:
        return;
    L43:
    L22:
        this.mIgnoreNextBroadcast = false;
        goto L23
    L17:
        if (INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ContextUtils.getApplicationContext(), this, this.mIntentFilter) == null) goto L19;
        boolean r5 = true;
    L20:
        this.mIgnoreNextBroadcast = r5;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r5 = false;
        goto L20
    L41:
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(r0, this.mHandler);     // Catch: RuntimeException -> L13
    L13:
        this.mDefaultNetworkCallback = null;
        goto L14
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        this.mRegistered = false;
        MyNetworkCallback r0 = this.mNetworkCallback;
        if (r0 == null) goto L8;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r0);
    L8:
        ConnectivityManager.NetworkCallback r1 = this.mDefaultNetworkCallback;
        if (r1 == null) goto L11;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r1);
        return;
    L11:
        INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ContextUtils.getApplicationContext(), this);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    public boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    public static /* synthetic */ boolean access$1100(NetworkChangeNotifierAutoDetect r0) {
        return r0.mIgnoreNextBroadcast;
    }

    public static /* synthetic */ boolean access$300(NetworkChangeNotifierAutoDetect r0) {
        return r0.mRegistered;
    }

    public static /* synthetic */ void access$400(NetworkChangeNotifierAutoDetect r0) {
        r0.connectionTypeChanged();
    }

    public static /* synthetic */ ConnectivityManagerDelegate access$600(NetworkChangeNotifierAutoDetect r0) {
        return r0.mConnectivityManagerDelegate;
    }

    public static /* synthetic */ Observer access$700(NetworkChangeNotifierAutoDetect r0) {
        return r0.mObserver;
    }

    private void connectionTypeChangedTo(NetworkState r3) {
        if (r3.getConnectionType() == this.mNetworkState.getConnectionType()) goto L5;
    L12:
        this.mObserver.onConnectionTypeChanged(r3.getConnectionType());
    L14:
        if (r3.getConnectionType() == this.mNetworkState.getConnectionType()) goto L16;
    L17:
        this.mObserver.onConnectionSubtypeChanged(r3.getConnectionSubtype());
    L19:
        if (r3.getConnectionCost() == this.mNetworkState.getConnectionCost()) goto L21;
        this.mObserver.onConnectionCostChanged(r3.getConnectionCost());
    L21:
        this.mNetworkState = r3;
        return;
    L16:
        if (r3.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype()) goto L19;
    L5:
        if (r3.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) == false) goto L12;
        if (r3.getDnsServers().equals(this.mNetworkState.getDnsServers()) == false) goto L12;
        if (r3.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) goto L12;
        if (r3.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName()) == true) goto L14;
        goto L12
    }

    private /* synthetic */ void lambda$runOnThread$0(Runnable r2) {
        if (this.mRegistered == false) goto L6;
        r2.run();
        return;
    }

    public static long networkToNetId(Network r2) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.getNetworkHandle(r2);
    L7:
        return CastIntegerProtector.parseInt(r2.toString());
    }

    public void runOnThread(Runnable r3) {
        if (onThread() == false) goto L5;
        r3.run();
        return;
    L5:
        this.mHandler.post(new a(this, r3));
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate r1) {
        this.mConnectivityManagerDelegate = r1;
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate r1) {
        this.mWifiManagerDelegate = r1;
    }

    public NetworkChangeNotifierAutoDetect(Observer r4, RegistrationPolicy r5) {
        Looper r0 = Looper.myLooper();
        this.mLooper = r0;
        this.mHandler = new Handler(r0);
        this.mObserver = r4;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        int r6 = Build.VERSION.SDK_INT;
        if (r6 >= 23) goto L5;
        this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
    L5:
        ConnectivityManager.NetworkCallback r1 = null;
        this.mNetworkCallback = new MyNetworkCallback(this, r1);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        if (r6 < 30) goto L9;
        this.mDefaultNetworkCallback = new AndroidRDefaultNetworkCallback(this, r1);
    L12:
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = r5;
        r5.init(this);
        this.mShouldSignalObserver = true;
        return;
    L9:
        if (r6 < 28) goto L11;
        r1 = new DefaultNetworkCallback(this, null);
    L11:
        this.mDefaultNetworkCallback = r1;
        goto L12
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ int access$000(int r0, int r1) {
        return convertToConnectionType(r0, r1);
    }

    public static /* synthetic */ Network[] access$100(ConnectivityManagerDelegate r0, Network r1) {
        return getAllNetworksFiltered(r0, r1);
    }

    public static /* synthetic */ boolean access$1102(NetworkChangeNotifierAutoDetect r0, boolean r1) {
        r0.mIgnoreNextBroadcast = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(NetworkChangeNotifierAutoDetect r0, NetworkState r1) {
        r0.connectionTypeChangedTo(r1);
    }

    private static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate r8, Network r9) {
        Network[] r0 = r8.getAllNetworksUnfiltered();
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L24;
        Network r5 = r0[r3];
        if (r5 == null) goto L22;
        if (r5.equals(r9) == true) goto L22;
        NetworkCapabilities r6 = r8.getNetworkCapabilities(r5);
        if (r6 == null) goto L22;
        if (r6.hasCapability(12) == false) goto L22;
        if (r6.hasTransport(4) == true) goto L18;
        r0[r4] = r5;
        r4 = r4 + 1;
        goto L22
    L18:
        if (r8.vpnAccessible(r5) == false) goto L22;
        return new Network[]{r5};
    L22:
        r3 = r3 + 1;
        goto L3
    L24:
        return (Network[]) Arrays.copyOf(r0, r4);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        runOnThread(new 1(this));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }
}
