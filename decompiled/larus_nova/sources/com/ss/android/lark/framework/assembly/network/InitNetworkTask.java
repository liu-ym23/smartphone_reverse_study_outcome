package com.ss.android.lark.framework.assembly.network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.t;
import com.ss.android.lark.http.netstate.NetworkBroadcastReceiver;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.http.netstate.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class InitNetworkTask extends AbstractLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f425665c;

    public class a implements t {
        public a() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.t
        public final void a(Activity r100) {
            NetworkUtils.NetworkType r101 = NetworkUtils.a(r100);
            c.a.f425872a.b(r101);
        }
    }

    public InitNetworkTask() {
        this.f425665c = new a();
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r110) {
        a r100 = this.f425665c;
        if (r100 != null) goto L5;
        List<t> r101 = LifecycleHandler.f408816a;
    L7:
        if (NetworkBroadcastReceiver.f425864a != null) goto L9;
        NetworkBroadcastReceiver.f425864a = new NetworkBroadcastReceiver();
    L9:
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkBroadcastReceiver r103 = NetworkBroadcastReceiver.f425864a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r102);
        return;
    L40:
        throw e;
    L13:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L26;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L26;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r102, 0, null, null, 2, r110).result;     // Catch: Exception -> L35
        if (r104 != 1) goto L19;
        r110.registerReceiver(r103, r102);     // Catch: Exception -> L35
        return;
    L19:
        if (r104 != 2) goto L21;
        new Intent();     // Catch: Exception -> L35
        return;
    L21:
        if (r104 == 3) goto L42;
        r110.registerReceiver(r103, r102);     // Catch: Exception -> L35
        return;
    L42:
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        r110.registerReceiver(r103, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L35
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L31;
    L33:
        r110.registerReceiver(r103, r102);     // Catch: Exception -> L35
        return;
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L33;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        ContextCompat.registerReceiver(r110, r103, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L35
        return;
    L5:
        ((CopyOnWriteArrayList) LifecycleHandler.f408816a).add(r100);
        goto L7
    }
}
