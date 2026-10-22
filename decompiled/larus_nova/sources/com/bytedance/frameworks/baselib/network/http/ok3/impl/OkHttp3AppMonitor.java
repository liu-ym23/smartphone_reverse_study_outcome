package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3AppMonitor implements LifeCycleMonitor.AppStateListener {
    private static final String TAG = null;
    private LifeCycleMonitor mLifeCycleMonitor;
    private BroadcastReceiver mNetworkStateReceiver;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
    }

    static {
        TAG = "OkHttp3AppMonitor";
    }

    public OkHttp3AppMonitor() {
        this.mLifeCycleMonitor = new LifeCycleMonitor();
        this.mNetworkStateReceiver = new AnonymousClass1(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        HttpDns.getService().onResume();
    }

    private void registerForeBackgroundCallback(Context r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "register activity forground and background switch Callback");
    L6:
        if ((r100 instanceof Application) == false) goto L11;
        Application r101 = (Application) r100;
        if (r101 == null) goto L12;
        this.mLifeCycleMonitor.setAppStateChangedListener(this);
        r101.registerActivityLifecycleCallbacks(this.mLifeCycleMonitor);
        return;
    L12:
        return;
    }

    private void registerNetworkStateChanged(Context r100) {
        if (r100 == null) goto L7;
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        INVOKEVIRTUAL_com_bytedance_frameworks_baselib_network_http_ok3_impl_OkHttp3AppMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this.mNetworkStateReceiver, r101);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "register network state changed completed");
        return;
    L8:
        return;
    }

    public void registerAppMonitorListener(Context r100) {
        registerNetworkStateChanged(r100);
        registerForeBackgroundCallback(r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_frameworks_baselib_network_http_ok3_impl_OkHttp3AppMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
