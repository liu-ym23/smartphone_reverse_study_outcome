package com.bytedance.ee.bear.connection.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import fw4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class NetStateBRChangeManager extends a {
    public static final NetStateBRChangeManager e = null;
    public static final Lazy f = null;

    static {
        e = new NetStateBRChangeManager();
        f = LazyKt.lazy(NetStateBRChangeManager$RECEIVER$2.INSTANCE);
    }

    public NetStateBRChangeManager() {
    }

    @JvmStatic
    public static final void registerReceiver(Context r9) {
        tt5.a.b("BaseNetStateChangeService", "registerReceiver()... context = " + r9);
        IntentFilter r0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (r9 == null) goto L39;
        e.getClass();
        BroadcastReceiver r1 = (BroadcastReceiver) f.getValue();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L37:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r1, r0);
        return;
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L21;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r1, r0, 0, null, null, 2, r9).result;     // Catch: Exception -> L30
        if (r2 != 1) goto L14;
        r9.registerReceiver(r1, r0);     // Catch: Exception -> L30
    L36:
        return;
    L14:
        if (r2 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L36
    L16:
        if (r2 == 3) goto L36;
        r9.registerReceiver(r1, r0);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r9.registerReceiver(r1, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L36
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r9.registerReceiver(r1, r0);     // Catch: Exception -> L30
        goto L36
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r9, r1, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
        goto L36
    }

    @JvmStatic
    public static final void unregisterReceiver(Context r2) {
        tt5.a.b("BaseNetStateChangeService", "unregisterReceiver()... context = " + r2);
        if (r2 == null) goto L18;
        e.getClass();
        BroadcastReceiver r0 = (BroadcastReceiver) f.getValue();
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
        r2.unregisterReceiver(r0);
        return;
    L16:
    L10:
        e = move-exception;
        if (r0 == null) goto L13;
        Npth.addTag("unregisterReceiver", r0.toString());
    L13:
        e.printStackTrace();
        return;
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r2) == false) goto L19;
        r2.unregisterReceiver(r0);     // Catch: Exception -> L10
        return;
    L19:
        return;
    }
}
