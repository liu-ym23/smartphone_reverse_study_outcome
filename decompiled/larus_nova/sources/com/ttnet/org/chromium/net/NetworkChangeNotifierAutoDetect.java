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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import f06.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
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

        private AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r100) {
            this.this$0 = r100;
        }

        private NetworkState getNetworkState(Network r110) {
            int r100 = -1;
            if (this.mNetworkCapabilities.hasTransport(1) == false) goto L5;
        L27:
            int r101 = 1;
        L28:
            int r102 = -1;
        L30:
            return new NetworkState(true, r101, r102, !this.mNetworkCapabilities.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r110)), null, ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
        L5:
            if (this.mNetworkCapabilities.hasTransport(5) == true) goto L27;
            if (this.mNetworkCapabilities.hasTransport(0) == false) goto L14;
            NetworkInfo r103 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getRawNetworkInfo(r110);
            if (r103 == null) goto L12;
            r100 = r103.getSubtype();
        L12:
            r102 = r100;
            r101 = 0;
            goto L30
        L14:
            if (this.mNetworkCapabilities.hasTransport(3) == false) goto L17;
            r101 = 9;
            goto L28
        L17:
            if (this.mNetworkCapabilities.hasTransport(2) == false) goto L20;
            r101 = 7;
            goto L28
        L20:
            if (this.mNetworkCapabilities.hasTransport(4) == false) goto L26;
            NetworkInfo r104 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkInfo(r110);
            if (r104 == null) goto L24;
            int r105 = r104.getType();
        L25:
            r101 = r105;
            goto L28
        L24:
            r105 = 17;
            goto L25
        L26:
            r101 = -1;
            goto L28
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r110) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, new NetworkState(false, -1, -1, false, null, null, false, ""));
            return;
        }

        public /* synthetic */ AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            this.mNetworkCapabilities = r101;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r100));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r100, LinkProperties r101) {
            this.mLinkProperties = r101;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r100));
            return;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConnectivityManager mConnectivityManager;

        public Network[] getAllNetworksUnfiltered() {
            Network[] r100 = this.mConnectivityManager.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r100 == null) goto L7;
            return r100;
        L7:
            return new Network[0];
        L4:
            r100 = null;
            goto L5
        }

        public Network getDefaultNetwork() {
            if (Build.VERSION.SDK_INT >= 23) goto L40;
            Network r100 = null;
        L38:
            NetworkInfo r101 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L37
            if (r101 != null) goto L13;
            return null;
        L13:
            Network[] r102 = NetworkChangeNotifierAutoDetect.access$100(this, null);
            int r103 = r102.length;
            int r104 = 0;
        L14:
            if (r104 >= r103) goto L36;
            Network r105 = r102[r104];
            NetworkInfo r106 = getRawNetworkInfo(r105);
            if (r106 == null) goto L35;
            if (r106.getType() != r101.getType()) goto L20;
        L21:
            if (r100 != null) goto L23;
        L32:
            if (r100 == null) goto L34;
            Log.e(NetworkChangeNotifierAutoDetect.access$200(), "defaultNetwork != null", new Object[0]);
        L34:
            r100 = r105;
            goto L35
        L23:
            if (Build.VERSION.SDK_INT < 29) goto L32;
            if (r106.getDetailedState() == NetworkInfo.DetailedState.CONNECTING) goto L35;
            NetworkInfo r107 = getRawNetworkInfo(r100);
            if (r107 == null) goto L32;
            if (r107.getDetailedState() != NetworkInfo.DetailedState.CONNECTING) goto L32;
            r100 = null;
            goto L32
        L20:
            if (r106.getType() == 17) goto L21;
        L35:
            r104 = r104 + 1;
            goto L14
        L36:
            return r100;
        L37:
            return null;
        L40:
            r100 = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);     // Catch: Throwable -> L6
        L7:
            if (r100 == null) goto L38;
            return r100;
        L6:
            r100 = null;
            goto L7
        }

        public ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        static {
        }

        public ConnectivityManagerDelegate(Context r100) {
            this.mConnectivityManager = (ConnectivityManager) r100.getSystemService("connectivity");
        }

        private static String com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
            ArrayList r100 = new ArrayList();
            Object[] r111 = new Object[0];
            f06.b r112 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(102026);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r113 = r102;
            int r103 = r113.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r113[r104];
            int r114 = r104;
            int r115 = r103;
            d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
            if (r106.f474982a == true) goto L17;
            r100.add(r105);     // Catch: Exception -> L22
        L17:
            if (r106.f474982a == false) goto L21;
            return (String) r106.f474983b;
        L21:
            return r110.getExtraInfo();
        L14:
            r104 = r114 + 1;
            r103 = r115;
            goto L8
        L15:
            r106 = new d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }

        private NetworkInfo processActiveNetworkInfo(NetworkInfo r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.isConnected() == false) goto L9;
            return r100;
        L9:
            if (r100.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L12;
            return null;
        L12:
            if (ApplicationStatus.getStateForApplication() == 1) goto L14;
            return null;
        L14:
            return r100;
        }

        public int getConnectionType(Network r100) {
            NetworkInfo r101 = getNetworkInfo(r100);
            if (r101 != null) goto L5;
            return 6;
        L5:
            if (r101.isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(r101.getType(), r101.getSubtype());
        }

        public NetworkCapabilities getNetworkCapabilities(Network r100) {
            int r101 = 0;
        L4:
            if (r101 >= 2) goto L8;
            return this.mConnectivityManager.getNetworkCapabilities(r100);
        L7:
            r101 = r101 + 1;
            goto L4
        L8:
            return null;
        }

        public NetworkInfo getNetworkInfo(Network r100) {
            NetworkInfo r101 = getRawNetworkInfo(r100);
            if (r101 != null) goto L5;
            return r101;
        L5:
            if (r101.getType() != 17) goto L13;
            return this.mConnectivityManager.getActiveNetworkInfo();
        L8:
            return null;
        L13:
            return r101;
        }

        public NetworkState getNetworkState(WifiManagerDelegate r210) {
            NetworkInfo r100 = null;
            r100 = null;
            Network r101 = null;
        L16:
            Network r102 = null;
        L17:
            NetworkInfo r103 = processActiveNetworkInfo(r100);
            if (r103 != null) goto L22;
            return new NetworkState(false, -1, -1, false, null, null, false, "");
        L22:
            if (r102 == null) goto L41;
            NetworkCapabilities r104 = getNetworkCapabilities(r102);
            int r105 = 0;
            if (r104 != null) goto L26;
        L28:
            boolean r110 = false;
        L29:
            DnsStatus r106 = AndroidNetworkLibrary.getDnsStatus(r102);
            if (r106 == null) goto L32;
            ArrayList r111 = new ArrayList();
            byte[][] r107 = r106.getDnsServers();     // Catch: UnknownHostException -> L55
            int r108 = r107.length;     // Catch: UnknownHostException -> L55
        L35:
            if (r105 >= r108) goto L39;
            r111.add(InetAddress.getByAddress(r107[r105]));     // Catch: UnknownHostException -> L55
            r105 = r105 + 1;
        L39:
            return new NetworkState(true, r103.getType(), r103.getSubtype(), r110, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r102)), r111, r106.getPrivateDnsActive(), r106.getPrivateDnsServerName());
        L32:
            return new NetworkState(true, r103.getType(), r103.getSubtype(), r110, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r102)), null, false, "");
        L26:
            if (r104.hasCapability(11) == true) goto L28;
            r110 = true;
            goto L29
        L41:
            if (r103.getType() != 1) goto L54;
            if (Build.VERSION.SDK_INT >= 23) goto L54;
            if (r210 == null) goto L54;
            if (com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r103) == null) goto L52;
            if ("".equals(com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r103)) == true) goto L52;
            return new NetworkState(true, r103.getType(), r103.getSubtype(), false, com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r103), null, false, "");
        L52:
            return new NetworkState(true, r103.getType(), r103.getSubtype(), false, r210.getWifiSsid(), null, false, "");
        L54:
            return new NetworkState(true, r103.getType(), r103.getSubtype(), false, null, null, false, "");
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L14;
            r102 = getDefaultNetwork();     // Catch: Throwable -> L16
            NetworkInfo r109 = getNetworkInfo(r102);     // Catch: Throwable -> L13
            if (r109 != null) goto L9;
        L12:
            r101 = r102;
            NetworkInfo r112 = r109;
        L15:
            NetworkInfo r211 = r112;
            r102 = r101;
            r100 = r211;
            goto L17
        L9:
            if (r109.getType() != 17) goto L12;
            r112 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L13
            r101 = r102;
            goto L15
        L14:
            r112 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L16
            goto L15
        }

        public NetworkInfo getRawNetworkInfo(Network r100) {
            return this.mConnectivityManager.getNetworkInfo(r100);
        L4:
            return this.mConnectivityManager.getNetworkInfo(r100);
        L6:
            return null;
        }

        public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback r100) {
            this.mConnectivityManager.unregisterNetworkCallback(r100);     // Catch: Throwable -> L4
            return;
        }

        public boolean vpnAccessible(Network r100) {
            Socket r101 = new Socket();
            StrictModeContext r102 = StrictModeContext.allowAllVmPolicies();     // Catch: Throwable -> L17 IOException -> L20
            r100.bindSocket(r101);     // Catch: Throwable -> L10
            if (r102 == null) goto L30;
            r102.close();     // Catch: Throwable -> L17 IOException -> L20
        L30:
            r101.close();     // Catch: IOException -> L23
            return true;
        L36:
            return true;
        L10:
            th = move-exception;
            if (r102 != null) goto L32;
        L16:
            throw th;     // Catch: Throwable -> L17 IOException -> L20
        L32:
            r102.close();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L17 IOException -> L20
        L20:
            r101.close();     // Catch: IOException -> L25
            return false;
        L17:
            th = move-exception;
            r101.close();     // Catch: IOException -> L24
        L19:
            throw th;
        L37:
            return false;
        }

        public void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback r100, Handler r101) {
            ApiHelperForO.registerDefaultNetworkCallback(this.mConnectivityManager, r100, r101);     // Catch: Throwable -> L4
            return;
        }

        public void registerNetworkCallback(NetworkRequest r100, ConnectivityManager.NetworkCallback r101, Handler r102) {
            if (Build.VERSION.SDK_INT < 26) goto L5;
            ApiHelperForO.registerNetworkCallback(this.mConnectivityManager, r100, r101, r102);     // Catch: Throwable -> L7
        L8:
            return;
        L5:
            this.mConnectivityManager.registerNetworkCallback(r100, r101);     // Catch: Throwable -> L7
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r100) {
            this.this$0 = r100;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$400(this.this$0);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r100) {
            onAvailable(null);
        }

        public /* synthetic */ DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r100, LinkProperties r101) {
            onAvailable(null);
        }
    }

    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        public long getVpnNetId() {
            Network r100 = this.mVpnInPlace;
            if (r100 != null) goto L6;
            return -1;
        L6:
            return NetworkChangeNotifierAutoDetect.networkToNetId(r100);
        }

        public void initializeVpnInPlace() {
            Network[] r100 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), null);
            this.mVpnInPlace = null;
            if (r100.length != 1) goto L10;
            NetworkCapabilities r101 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r100[0]);
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r100[0];
            return;
        L12:
            return;
        }

        static {
        }

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r100) {
            this.this$0 = r100;
        }

        private boolean ignoreNetworkDueToVpn(Network r100) {
            Network r101 = this.mVpnInPlace;
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.equals(r100) == true) goto L7;
            return true;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            TraceEvent r101 = TraceEvent.scoped("NetworkChangeNotifierCallback::onAvailable");
            NetworkCapabilities r102 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r100);     // Catch: Throwable -> L26
            if (ignoreConnectedNetwork(r100, r102) == false) goto L8;
            if (r101 == null) goto L37;
            r101.close();
            return;
        L37:
            return;
        L8:
            boolean r103 = false;
            if (r102 != null) goto L12;
            final boolean r104 = false;
        L20:
            if (r104 == false) goto L22;
            this.mVpnInPlace = r100;     // Catch: Throwable -> L26
        L22:
            final long r105 = NetworkChangeNotifierAutoDetect.networkToNetId(r100);     // Catch: Throwable -> L26
            final int r106 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r100);     // Catch: Throwable -> L26
            this.this$0.runOnThread(new AnonymousClass1(this, r105, r106, r104));     // Catch: Throwable -> L26
            if (r101 == null) goto L38;
            r101.close();
            return;
        L38:
            return;
        L12:
            if (r102.hasTransport(4) == false) goto L18;
            Network r107 = this.mVpnInPlace;     // Catch: Throwable -> L26
            if (r107 != null) goto L16;
        L17:
            r103 = true;
            goto L18
        L16:
            if (r100.equals(r107) == false) goto L17;
        L18:
            r104 = r103;
        L26:
            th = move-exception;
            if (r101 != null) goto L33;
        L32:
            throw th;
        L33:
            r101.close();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            th.addSuppressed(th);
            goto L32
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r100) {
            TraceEvent r101 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLost");
        L23:
            th = move-exception;
            if (r101 != null) goto L32;
        L29:
            throw th;
        L32:
            r101.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);
            goto L29
        L4:
            if (ignoreNetworkDueToVpn(r100) == false) goto L8;
            if (r101 == null) goto L35;
            r101.close();
            return;
        L35:
            return;
        L8:
            Network r102 = this.mVpnInPlace;     // Catch: Throwable -> L23
            int r103 = 0;
            if (r102 != null) goto L11;
        L13:
            final boolean r104 = false;
        L14:
            this.this$0.runOnThread(new AnonymousClass4(this, r100, r104));     // Catch: Throwable -> L23
            if (this.mVpnInPlace == null) goto L20;
            this.mVpnInPlace = null;     // Catch: Throwable -> L23
            Network[] r105 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), r100);     // Catch: Throwable -> L23
            int r106 = r105.length;     // Catch: Throwable -> L23
        L17:
            if (r103 >= r106) goto L19;
            onAvailable(r105[r103]);     // Catch: Throwable -> L23
            r103 = r103 + 1;     // Catch: Throwable -> L23
            goto L17
        L19:
            final int r107 = this.this$0.getCurrentNetworkState().getConnectionType();     // Catch: Throwable -> L23
            this.this$0.runOnThread(new AnonymousClass5(this, r107));     // Catch: Throwable -> L23
        L20:
            if (r101 == null) goto L36;
            r101.close();
            return;
        L36:
            return;
        L11:
            if (r102.equals(r100) == false) goto L13;
            r104 = true;
            goto L14
        }

        public /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r100, AnonymousClass1 r101) {
            this(r100);
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r100, NetworkCapabilities r101) {
            if (r101 != null) goto L4;
            r101 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r100);
        L4:
            if (r101 != null) goto L6;
        L11:
            return true;
        L6:
            if (r101.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.access$600(this.this$0).vpnAccessible(r100) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r100, NetworkCapabilities r101) {
            if (ignoreNetworkDueToVpn(r100) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r100, r101) == true) goto L8;
            return false;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            TraceEvent r102 = TraceEvent.scoped("NetworkChangeNotifierCallback::onCapabilitiesChanged");
        L18:
            th = move-exception;
            if (r102 != null) goto L27;
        L24:
            throw th;
        L27:
            r102.close();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        L4:
            if (ignoreConnectedNetwork(r100, r101) == false) goto L8;
            if (r102 == null) goto L29;
            r102.close();
            return;
        L29:
            return;
        L8:
            final long r103 = NetworkChangeNotifierAutoDetect.networkToNetId(r100);     // Catch: Throwable -> L18
            final int r104 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r100);     // Catch: Throwable -> L18
            Network r105 = this.mVpnInPlace;     // Catch: Throwable -> L18
            if (r105 != null) goto L11;
        L13:
            final boolean r106 = false;
        L14:
            this.this$0.runOnThread(new AnonymousClass2(this, r103, r104, r106));     // Catch: Throwable -> L18
            if (r102 == null) goto L30;
            r102.close();
            return;
        L30:
            return;
        L11:
            if (r105.equals(r100) == false) goto L13;
            r106 = true;
            goto L14
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r100, int r101) {
            TraceEvent r102 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLosing");
        L12:
            th = move-exception;
            if (r102 != null) goto L21;
        L18:
            throw th;
        L21:
            r102.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        L4:
            if (ignoreConnectedNetwork(r100, null) == false) goto L8;
            if (r102 == null) goto L23;
            r102.close();
            return;
        L23:
            return;
        L8:
            final long r103 = NetworkChangeNotifierAutoDetect.networkToNetId(r100);     // Catch: Throwable -> L12
            this.this$0.runOnThread(new AnonymousClass3(this, r103));     // Catch: Throwable -> L12
            if (r102 == null) goto L24;
            r102.close();
            return;
        }
    }

    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class NetworkState {
        private final boolean mConnected;
        private final List<InetAddress> mDnsServers;
        private final boolean mIsMetered;
        private final boolean mIsPrivateDnsActive;
        private final String mNetworkIdentifier;
        private final String mPrivateDnsServerName;
        private final int mSubtype;
        private final int mType;

        public int getConnectionCost() {
            if (isMetered() == false) goto L6;
            return 2;
        L6:
            return 1;
        }

        public int getConnectionSubtype() {
            if (isConnected() == true) goto L6;
            return 1;
        L6:
            int r100 = getNetworkType();
            if (r100 == 0) goto L12;
            if (r100 == 4) goto L12;
            if (r100 == 5) goto L12;
            return 0;
        L12:
            switch(getNetworkSubType()) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L31;
                case 7: goto L29;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L16;
                case 15: goto L14;
                default: goto L13;
            };
        L13:
            return 0;
        L14:
            return 17;
        L16:
            return 16;
        L18:
            return 18;
        L20:
            return 13;
        L22:
            return 4;
        L23:
            return 12;
        L25:
            return 15;
        L27:
            return 14;
        L29:
            return 6;
        L31:
            return 11;
        L33:
            return 10;
        L35:
            return 5;
        L36:
            return 9;
        L38:
            return 8;
        L40:
            return 7;
        }

        public int getConnectionType() {
            if (isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(getNetworkType(), getNetworkSubType());
        }

        public List<InetAddress> getDnsServers() {
            return this.mDnsServers;
        }

        public String getNetworkIdentifier() {
            return this.mNetworkIdentifier;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public String getPrivateDnsServerName() {
            return this.mPrivateDnsServerName;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public boolean isMetered() {
            return this.mIsMetered;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }

        public NetworkState(boolean r100, int r101, int r102, boolean r103, String r104, List<InetAddress> r105, boolean r106, String r107) {
            this.mConnected = r100;
            this.mType = r101;
            this.mSubtype = r102;
            this.mIsMetered = r103;
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            this.mNetworkIdentifier = r104;
            if (r105 != null) goto L8;
            r105 = new ArrayList();
        L8:
            this.mDnsServers = r105;
            this.mIsPrivateDnsActive = r106;
            if (r107 != null) goto L11;
            r107 = "";
        L11:
            this.mPrivateDnsServerName = r107;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface Observer {
        void onConnectionCostChanged(int r100);

        void onConnectionSubtypeChanged(int r100);

        void onConnectionTypeChanged(int r100);

        void onNetworkConnect(long r100, int r101, boolean r102);

        void onNetworkDisconnect(long r100, boolean r101);

        void onNetworkSoonToDisconnect(long r100);

        void purgeActiveNetworkList(long[] r100);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private NetworkChangeNotifierAutoDetect mNotifier;

        public RegistrationPolicy() {
        }

        public abstract void destroy();

        public final void register() {
            this.mNotifier.register();
        }

        public final void unregister() {
            this.mNotifier.unregister();
        }

        static {
        }

        public void init(NetworkChangeNotifierAutoDetect r100) {
            this.mNotifier = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class WifiManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Context mContext;
        private boolean mHasWifiPermission;
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;
        private WifiManager mWifiManager;

        public String getWifiSsid() {
            return "";
        }

        private WifiInfo getWifiInfoLocked() {
            return com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(this.mWifiManager);
        L4:
            return com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(this.mWifiManager);
        L6:
            return null;
        }

        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed == false) goto L7;
            return this.mHasWifiPermission;
        L7:
            if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) != 0) goto L9;
            boolean r100 = true;
        L10:
            this.mHasWifiPermission = r100;
            if (r100 == false) goto L13;
            WifiManager r101 = (WifiManager) this.mContext.getSystemService("wifi");
        L14:
            this.mWifiManager = r101;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        L13:
            r101 = null;
            goto L14
        L9:
            r100 = false;
            goto L10
        }

        public WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        static {
        }

        public WifiManagerDelegate(Context r100) {
            this.mLock = new Object();
            this.mContext = r100;
        }

        private static WifiInfo com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$WifiManagerDelegate_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
            ArrayList r100 = new ArrayList();
            Object[] r111 = new Object[0];
            f06.b r112 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(102301);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r113 = r102;
            int r103 = r113.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r113[r104];
            int r114 = r104;
            int r115 = r103;
            d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
            if (r106.f474982a == true) goto L17;
            r100.add(r105);     // Catch: Exception -> L22
        L17:
            if (r106.f474982a == false) goto L21;
            return (WifiInfo) r106.f474983b;
        L21:
            return r110.getConnectionInfo();
        L14:
            r104 = r114 + 1;
            r103 = r115;
            goto L8
        L15:
            r106 = new d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public static /* synthetic */ void a(NetworkChangeNotifierAutoDetect r100, Runnable r101) {
        r100.lambda$runOnThread$0(r101);
    }

    private static int convertToConnectionType(int r100, int r101) {
        if (r100 == 0) goto L21;
        if (r100 == 1) goto L18;
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L21;
        if (r100 != 6) goto L11;
        return 5;
    L11:
        if (r100 != 7) goto L13;
        return 7;
    L13:
        if (r100 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r101 == 20) goto L28;
        switch(r101) {
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
        Network r100 = this.mConnectivityManagerDelegate.getDefaultNetwork();
        if (r100 != null) goto L6;
        return -1;
    L6:
        return networkToNetId(r100);
    }

    public long[] getNetworksAndTypes() {
        Network[] r100 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r101 = new long[r100.length * 2];
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Network r105 = r100[r103];
        int r106 = r104 + 1;
        r101[r104] = networkToNetId(r105);
        r104 = r106 + 1;
        r101[r106] = this.mConnectivityManagerDelegate.getConnectionType(r105);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public long getVpnNetId() {
        MyNetworkCallback r100 = this.mNetworkCallback;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getVpnNetId();
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
        ConnectivityManager.NetworkCallback r100 = this.mDefaultNetworkCallback;
        if (r100 != null) goto L41;
    L14:
        int r101 = 0;
        if (this.mDefaultNetworkCallback == null) goto L43;
    L23:
        this.mRegistered = true;
        MyNetworkCallback r102 = this.mNetworkCallback;
        if (r102 == null) goto L46;
        r102.initializeVpnInPlace();
        this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);     // Catch: RuntimeException -> L28
    L30:
        if (this.mRegisterNetworkCallbackFailed == false) goto L32;
        return;
    L32:
        if (this.mShouldSignalObserver == false) goto L48;
        Network[] r103 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r104 = new long[r103.length];
    L35:
        if (r101 >= r103.length) goto L37;
        r104[r101] = networkToNetId(r103[r101]);
        r101 = r101 + 1;
        goto L35
    L37:
        this.mObserver.purgeActiveNetworkList(r104);
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
        boolean r105 = true;
    L20:
        this.mIgnoreNextBroadcast = r105;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r105 = false;
        goto L20
    L41:
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(r100, this.mHandler);     // Catch: RuntimeException -> L13
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
        MyNetworkCallback r100 = this.mNetworkCallback;
        if (r100 == null) goto L8;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r100);
    L8:
        ConnectivityManager.NetworkCallback r101 = this.mDefaultNetworkCallback;
        if (r101 == null) goto L11;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r101);
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

    public static /* synthetic */ boolean access$1100(NetworkChangeNotifierAutoDetect r100) {
        return r100.mIgnoreNextBroadcast;
    }

    public static /* synthetic */ boolean access$300(NetworkChangeNotifierAutoDetect r100) {
        return r100.mRegistered;
    }

    public static /* synthetic */ void access$400(NetworkChangeNotifierAutoDetect r100) {
        r100.connectionTypeChanged();
    }

    public static /* synthetic */ ConnectivityManagerDelegate access$600(NetworkChangeNotifierAutoDetect r100) {
        return r100.mConnectivityManagerDelegate;
    }

    public static /* synthetic */ Observer access$700(NetworkChangeNotifierAutoDetect r100) {
        return r100.mObserver;
    }

    private void connectionTypeChangedTo(NetworkState r100) {
        if (r100.getConnectionType() == this.mNetworkState.getConnectionType()) goto L5;
    L12:
        this.mObserver.onConnectionTypeChanged(r100.getConnectionType());
    L14:
        if (r100.getConnectionType() == this.mNetworkState.getConnectionType()) goto L16;
    L17:
        this.mObserver.onConnectionSubtypeChanged(r100.getConnectionSubtype());
    L19:
        if (r100.getConnectionCost() == this.mNetworkState.getConnectionCost()) goto L21;
        this.mObserver.onConnectionCostChanged(r100.getConnectionCost());
    L21:
        this.mNetworkState = r100;
        return;
    L16:
        if (r100.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype()) goto L19;
    L5:
        if (r100.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) == false) goto L12;
        if (r100.getDnsServers().equals(this.mNetworkState.getDnsServers()) == false) goto L12;
        if (r100.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) goto L12;
        if (r100.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName()) == true) goto L14;
        goto L12
    }

    private /* synthetic */ void lambda$runOnThread$0(Runnable r100) {
        if (this.mRegistered == false) goto L6;
        r100.run();
        return;
    }

    public static long networkToNetId(Network r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.getNetworkHandle(r100);
    L7:
        return CastIntegerProtector.parseInt(r100.toString());
    }

    public void runOnThread(final Runnable r100) {
        if (onThread() == false) goto L5;
        r100.run();
        return;
    L5:
        this.mHandler.post(new a(this, r100));
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate r100) {
        this.mConnectivityManagerDelegate = r100;
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate r100) {
        this.mWifiManagerDelegate = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkChangeNotifierAutoDetect(Observer r100, RegistrationPolicy r101) {
        Looper r102 = Looper.myLooper();
        this.mLooper = r102;
        this.mHandler = new Handler(r102);
        this.mObserver = r100;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 23) goto L5;
        this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
    L5:
        DefaultNetworkCallback r104 = null;
        Object[] r105 = 0;
        Object[] r106 = 0;
        this.mNetworkCallback = new MyNetworkCallback(this, 0 == true ? 1 : 0);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        if (r103 < 30) goto L9;
        this.mDefaultNetworkCallback = new AndroidRDefaultNetworkCallback(this, r106 == true ? 1 : 0);
    L12:
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = r101;
        r101.init(this);
        this.mShouldSignalObserver = true;
        return;
    L9:
        if (r103 < 28) goto L11;
        r104 = new DefaultNetworkCallback(this, r105 == true ? 1 : 0);
    L11:
        this.mDefaultNetworkCallback = r104;
        goto L12
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ int access$000(int r100, int r101) {
        return convertToConnectionType(r100, r101);
    }

    public static /* synthetic */ Network[] access$100(ConnectivityManagerDelegate r100, Network r101) {
        return getAllNetworksFiltered(r100, r101);
    }

    public static /* synthetic */ boolean access$1102(NetworkChangeNotifierAutoDetect r100, boolean r101) {
        r100.mIgnoreNextBroadcast = r101;
        return r101;
    }

    public static /* synthetic */ void access$500(NetworkChangeNotifierAutoDetect r100, NetworkState r101) {
        r100.connectionTypeChangedTo(r101);
    }

    private static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate r100, Network r101) {
        Network[] r102 = r100.getAllNetworksUnfiltered();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L24;
        Network r106 = r102[r104];
        if (r106 == null) goto L22;
        if (r106.equals(r101) == true) goto L22;
        NetworkCapabilities r107 = r100.getNetworkCapabilities(r106);
        if (r107 == null) goto L22;
        if (r107.hasCapability(12) == false) goto L22;
        if (r107.hasTransport(4) == true) goto L18;
        r102[r105] = r106;
        r105 = r105 + 1;
        goto L22
    L18:
        if (r100.vpnAccessible(r106) == false) goto L22;
        return new Network[]{r106};
    L22:
        r104 = r104 + 1;
        goto L3
    L24:
        return (Network[]) Arrays.copyOf(r102, r105);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        runOnThread(new AnonymousClass1(this));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
