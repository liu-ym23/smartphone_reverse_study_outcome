package com.bytedance.badger.collect.impl.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.collect.impl.utils.NetworkTypeUtils;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.SoftReference;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public class NetworkStatusMonitor {
    private static final int MSG_RECEIVE_NETWORK_CHANGE = 1;
    private static final int MSG_RECEIVE_SIM_STATE_CHANGE = 2;
    private static volatile boolean mIsRunning;
    private static volatile NetworkStatusMonitor sInstance;
    private static final Object sLock = null;
    private volatile ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private volatile String mCurrentNetworkType;
    private final HandlerThread mHandlerThread;
    private Handler mMainHandler;
    private volatile ConnectivityManager.NetworkCallback mNetworkCallback;
    private BroadcastReceiver mNetworkStateReceiver;
    private OnNetworkChangeListener mOnNetworkChangeListener;
    private OnSimCardChangeListener mOnSimCardChangeListener;
    private SimStateChangeReceiver mSimStateChangeReceiver;
    private Handler mThreadHandler;

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkStatusMonitor this$0;

        private NetWorkChangeReceiver(NetworkStatusMonitor r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ NetWorkChangeReceiver(NetworkStatusMonitor r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L5;
            return;
        L5:
            if (NetworkStatusMonitor.access$600(this.this$0) == null) goto L9;
            KLog.i(Constants.TAGS.NETWORK_MONITOR, "广播监听# 网络类型发生变化，开始回调~~~");
            NetworkStatusMonitor.access$600(this.this$0).sendEmptyMessage(1);
            return;
        }
    }

    public interface OnNetworkChangeListener {
        void onNetworkTypeChange(String r100);
    }

    public interface OnSimCardChangeListener {
        void onSimCardChange();
    }

    public class SimStateChangeReceiver extends BroadcastReceiver {
        private static final String ACTION = "android.intent.action.SIM_STATE_CHANGED";
        final /* synthetic */ NetworkStatusMonitor this$0;

        private SimStateChangeReceiver(NetworkStatusMonitor r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ SimStateChangeReceiver(NetworkStatusMonitor r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (ACTION.equals(r101.getAction()) == false) goto L10;
            String r102 = r101.getStringExtra("ss");
            KLog.i(Constants.TAGS.NETWORK_MONITOR, "广播监听# SIM卡类型发生变化，当前状态=" + r102);
            if ("READY".equals(r102) == true) goto L7;
            return;
        L7:
            if (NetworkStatusMonitor.access$600(this.this$0) == null) goto L12;
            KLog.i(Constants.TAGS.NETWORK_MONITOR, "广播监听# SIM卡类型已经READY，开始回调~");
            NetworkStatusMonitor.access$600(this.this$0).sendEmptyMessage(2);
            return;
        L12:
            return;
        }
    }

    public static class ThreadHandler extends Handler {
        private final SoftReference<NetworkStatusMonitor> mReference;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            SoftReference<NetworkStatusMonitor> r101 = this.mReference;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            NetworkStatusMonitor.access$500(this.mReference.get(), r100);
            return;
        }

        public ThreadHandler(Looper r100, NetworkStatusMonitor r101) {
            super(r100);
            this.mReference = new SoftReference(r101);
        }
    }

    public synchronized void start() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L19:
        e = move-exception;
        KLog.e(Constants.TAGS.NETWORK_MONITOR, e);     // Catch: Throwable -> L17
    L21:
        monitor-exit(this);
        return;
    L4:
        if (mIsRunning == false) goto L7;
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "===已经开启监听===");     // Catch: Throwable -> L17 Exception -> L19
    L7:
        if (mIsRunning == false) goto L9;
    L15:
        this.mCurrentNetworkType = NetworkTypeUtils.getNetworkStatus(this.mContext);     // Catch: Throwable -> L17 Exception -> L19
    L9:
        if (this.mContext == null) goto L15;
        AnonymousClass1 r100 = null;
        if (Build.VERSION.SDK_INT < 24) goto L13;
        registerNetworkCallback();     // Catch: Throwable -> L17 Exception -> L19
    L14:
        IntentFilter r101 = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");     // Catch: Throwable -> L17 Exception -> L19
        SimStateChangeReceiver r102 = new SimStateChangeReceiver(this, r100);     // Catch: Throwable -> L17 Exception -> L19
        this.mSimStateChangeReceiver = r102;     // Catch: Throwable -> L17 Exception -> L19
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r102, r101);     // Catch: Throwable -> L17 Exception -> L19
        this.mMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17 Exception -> L19
        ThreadMethodProxy.start(this.mHandlerThread);     // Catch: Throwable -> L17 Exception -> L19
        this.mThreadHandler = new ThreadHandler(this.mHandlerThread.getLooper(), this);     // Catch: Throwable -> L17 Exception -> L19
        mIsRunning = true;     // Catch: Throwable -> L17 Exception -> L19
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "开启网络广播监听~~~");     // Catch: Throwable -> L17 Exception -> L19
        goto L15
    L13:
        IntentFilter r103 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L17 Exception -> L19
        NetWorkChangeReceiver r104 = new NetWorkChangeReceiver(this, r100);     // Catch: Throwable -> L17 Exception -> L19
        this.mNetworkStateReceiver = r104;     // Catch: Throwable -> L17 Exception -> L19
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r104, r103);     // Catch: Throwable -> L17 Exception -> L19
        goto L14
    }

    public synchronized void stop() {
        monitor-enter(this);
        Context r100 = this.mContext;     // Catch: Throwable -> L30
        if (r100 == null) goto L14;
        BroadcastReceiver r101 = this.mNetworkStateReceiver;     // Catch: Throwable -> L30
        if (r101 != null) goto L38;
    L9:
        SimStateChangeReceiver r102 = this.mSimStateChangeReceiver;     // Catch: Throwable -> L30
        if (r102 == null) goto L14;
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, r102);     // Catch: Exception -> L33 Throwable -> L30
    L12:
        this.mSimStateChangeReceiver = null;     // Catch: Throwable -> L30
        goto L14
    L38:
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Exception -> L34 Throwable -> L30
    L8:
        this.mNetworkStateReceiver = null;     // Catch: Throwable -> L30
    L14:
        if (this.mConnectivityManager != null) goto L16;
    L18:
        Object r103 = sLock;     // Catch: Throwable -> L30
        monitor-enter(r103);     // Catch: Throwable -> L30
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L21:
        if (sInstance != this) goto L23;
        sInstance = null;     // Catch: Throwable -> L27
    L23:
        monitor-exit(r103);     // Catch: Throwable -> L27
        this.mHandlerThread.quit();     // Catch: Throwable -> L30
        mIsRunning = false;     // Catch: Throwable -> L30
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "stop monitor done.");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L16:
        if (this.mNetworkCallback == null) goto L18;
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L35 Throwable -> L30
        this.mNetworkCallback = null;     // Catch: Exception -> L35 Throwable -> L30
        this.mConnectivityManager = null;     // Catch: Exception -> L35 Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    static {
        sLock = new Object();
    }

    private void notifyNetworkChange() {
        Handler r100 = this.mThreadHandler;
        if (r100 == null) goto L6;
        r100.sendEmptyMessage(1);
        return;
    }

    private void registerNetworkCallback() {
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkRequest r100 = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build();
        this.mNetworkCallback = new AnonymousClass3(this);
        this.mConnectivityManager.registerNetworkCallback(r100, this.mNetworkCallback);
    }

    public static boolean isStarted() {
        return mIsRunning;
    }

    private NetworkStatusMonitor(Context r100) {
        this.mContext = r100;
        this.mHandlerThread = new PthreadHandlerThreadV2("kite-network-type-monitor-thread");
    }

    public static /* synthetic */ String access$200(NetworkStatusMonitor r100) {
        return r100.mCurrentNetworkType;
    }

    public static /* synthetic */ OnNetworkChangeListener access$300(NetworkStatusMonitor r100) {
        return r100.mOnNetworkChangeListener;
    }

    public static /* synthetic */ OnSimCardChangeListener access$400(NetworkStatusMonitor r100) {
        return r100.mOnSimCardChangeListener;
    }

    public static /* synthetic */ Handler access$600(NetworkStatusMonitor r100) {
        return r100.mThreadHandler;
    }

    public static /* synthetic */ void access$700(NetworkStatusMonitor r100) {
        r100.notifyNetworkChange();
    }

    public static NetworkStatusMonitor getInstance(Context r100) {
        if (sInstance != null) goto L15;
        Object r101 = sLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkStatusMonitor(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void runOnNonUIThread(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.what;
        if (r101 != 1) goto L17;
        String r102 = this.mCurrentNetworkType;
        this.mCurrentNetworkType = NetworkTypeUtils.getNetworkStatus(this.mContext);
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "收到回调# lastNetworkType=" + r102 + ", mCurrentNetworkType=" + this.mCurrentNetworkType);
        if (TextUtils.isEmpty(r102) == false) goto L9;
    L15:
        KLog.w(Constants.TAGS.NETWORK_MONITOR, "callback# 网络状态未发生变化,lastNetworkType=" + r102 + ", mCurrentNetworkType=" + this.mCurrentNetworkType);
        return;
    L9:
        if (this.mOnNetworkChangeListener == null) goto L15;
        if (Objects.equals(r102, this.mCurrentNetworkType) == true) goto L15;
        Handler r103 = this.mMainHandler;
        if (r103 == null) goto L38;
        r103.post(new AnonymousClass1(this));
        return;
    L38:
        return;
    L17:
        if (r101 != 2) goto L41;
        Context r104 = this.mContext;
        if (r104 == null) goto L42;
        Runnable r105 = null;
        TelephonyManager r106 = (TelephonyManager) r104.getSystemService("phone");     // Catch: Exception -> L28
        if (r106 != null) goto L24;
    L26:
        KLog.w(Constants.TAGS.NETWORK_MONITOR, "回调失败# 当前SIM卡未就绪~~");     // Catch: Exception -> L28
    L35:
    L30:
        Handler r107 = this.mMainHandler;
        if (r107 == null) goto L43;
        if (r105 == null) goto L44;
        r107.post(r105);
        return;
    L44:
        return;
    L43:
        return;
    L24:
        if (r106.getSimState() != 5) goto L26;
        r105 = new AnonymousClass2(this);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        KLog.e(Constants.TAGS.NETWORK_MONITOR, e);
        goto L30
    L42:
        return;
    }

    public void setOnNetworkChangeListener(OnNetworkChangeListener r100) {
        this.mOnNetworkChangeListener = r100;
    }

    public void setOnSimCardChangeListener(OnSimCardChangeListener r100) {
        this.mOnSimCardChangeListener = r100;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    public static /* synthetic */ void access$500(NetworkStatusMonitor r100, Message r101) {
        r100.runOnNonUIThread(r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_badger_collect_impl_monitor_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
