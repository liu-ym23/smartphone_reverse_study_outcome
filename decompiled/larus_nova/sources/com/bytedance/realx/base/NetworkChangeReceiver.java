package com.bytedance.realx.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private static final int NETWORK_TYPE_DISCONNECTED = 0;
    private static final int NETWORK_TYPE_LAN = 1;
    private static final int NETWORK_TYPE_MOBILE_2G = 3;
    private static final int NETWORK_TYPE_MOBILE_3G = 4;
    private static final int NETWORK_TYPE_MOBILE_4G = 5;
    private static final int NETWORK_TYPE_MOBILE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = -1;
    private static final int NETWORK_TYPE_WIFI = 2;
    private static final String TAG = "NetworkChangeReceiver";
    public static Object threadLock;
    private boolean firstChanged;
    private Context mContext;
    private final long nativeNetworkReceiver;
    private Intent networkChangeIntent;
    private NetworkTypeThread networkTypeThread;
    private NetworkTypeUtils.NetworkType sNetworkType;

    /* JADX INFO: renamed from: com.bytedance.realx.base.NetworkChangeReceiver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = null;

        static {
            int[] r100 = new int[NetworkTypeUtils.NetworkType.values().length];
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = r100;
            r100[NetworkTypeUtils.NetworkType.MOBILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.WIFI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_4G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkTypeUtils.NetworkType.MOBILE_5G.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public class NetworkTypeThread extends PthreadThreadV2 {
        public boolean keepAlive;
        final /* synthetic */ NetworkChangeReceiver this$0;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_bytedance_realx_base_NetworkChangeReceiver$NetworkTypeThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_realx_base_NetworkChangeReceiver$NetworkTypeThread__run$___twin___() {
        L2:
            Object r100 = NetworkChangeReceiver.threadLock;
            monitor-enter(r100);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (NetworkChangeReceiver.access$000(this.this$0) == false) goto L11;
            NetworkChangeReceiver.threadLock.wait();     // Catch: InterruptedException -> L8 Throwable -> L20
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L20
        L11:
            if (this.keepAlive == false) goto L18;
            NetworkChangeReceiver.access$100(this.this$0);     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L20
        L16:
            monitor-exit(r100);     // Catch: Throwable -> L20
            goto L2
        L14:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L20
            goto L16
        L18:
            monitor-exit(r100);     // Catch: Throwable -> L20
        }

        public void stopThread() {
            Object r100 = NetworkChangeReceiver.threadLock;
            monitor-enter(r100);
            RXLogging.i(NetworkChangeReceiver.TAG, "stopThread");     // Catch: Throwable -> L7
            this.keepAlive = false;     // Catch: Throwable -> L7
            NetworkChangeReceiver.threadLock.notify();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_realx_base_NetworkChangeReceiver$NetworkTypeThread_com_larus_apm_impl_protector_RunnableLancet_run(NetworkTypeThread r100) {
            r100.com_bytedance_realx_base_NetworkChangeReceiver$NetworkTypeThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public NetworkTypeThread(NetworkChangeReceiver r100, String r101) {
            this.this$0 = r100;
            super(r101);
            this.keepAlive = true;
        }
    }

    private native void nativeSetNetworkType(int r100, String r101, long r102);

    static {
        threadLock = new Object();
    }

    private void getNetworkTypeInternal() {
        NetworkTypeUtils.NetworkType r100 = NetworkTypeUtils.getNetworkType(this.mContext, this.networkChangeIntent);
        this.networkChangeIntent = null;
        RXLogging.i(TAG, "GetNetworkType, networkType： " + r100);
        if (this.firstChanged == true) goto L5;
    L6:
        this.firstChanged = true;
        nativeSetNetworkType(getConstantNetworkType(r100), NetworkTypeUtils.getDebugInfo(), this.nativeNetworkReceiver);
        this.sNetworkType = r100;
        return;
    L5:
        if (this.sNetworkType != r100) goto L6;
    }

    public void StartDetect() {
        if (this.networkTypeThread != null) goto L6;
        NetworkTypeThread r100 = new NetworkTypeThread(this, "NetworkTypeThread");
        this.networkTypeThread = r100;
        ThreadMethodProxy.start(r100);
        return;
    }

    public void StopDetect() {
        NetworkTypeThread r100 = this.networkTypeThread;
        if (r100 == null) goto L6;
        r100.stopThread();
        this.networkTypeThread.interrupt();
        this.networkTypeThread = null;
        NetworkTypeUtils.unregisterReceiver(this.mContext, this);
        return;
    }

    public NetworkChangeReceiver(long r100) {
        this.networkChangeIntent = null;
        this.sNetworkType = NetworkTypeUtils.NetworkType.NONE;
        this.firstChanged = false;
        RXLogging.i(TAG, "init, nativeNetworkReceiver: " + r100);
        Context r101 = ContextUtils.getApplicationContext();
        this.mContext = r101;
        this.nativeNetworkReceiver = r100;
        NetworkTypeUtils.registerReceiver(r101, this);
    }

    public static /* synthetic */ boolean access$000(NetworkChangeReceiver r100) {
        return r100.firstChanged;
    }

    public static /* synthetic */ void access$100(NetworkChangeReceiver r100) {
        r100.getNetworkTypeInternal();
    }

    private int getConstantNetworkType(NetworkTypeUtils.NetworkType r100) {
        if (r100.isAvailable() == true) goto L6;
        return 0;
    L6:
        return getType(r100);
    }

    private int getType(NetworkTypeUtils.NetworkType r100) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[r100.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 6;
    L6:
        return 5;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 2;
    L10:
        return 1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        RXLogging.i(TAG, "onReceive, action: " + r101.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L5;
    L8:
        Object r102 = threadLock;
        monitor-enter(r102);
        this.networkChangeIntent = r101;     // Catch: Throwable -> L13
        threadLock.notify();     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r101.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r101.getAction()) == true) goto L8;
    }
}
