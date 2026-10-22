package ywa;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.batterymonitor.charge.ChargeBroadcastReceiver;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends wwa.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f569362c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f569363b;

    /* JADX INFO: renamed from: ywa.a$a, reason: collision with other inner class name */
    public static class C8395a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f569364a = null;

        static {
            f569364a = new a();
        }
    }

    @Override // wwa.a
    public final void b() {
        this.f569363b = 1;
        Context r100 = getContext();
        if (r100 != null) goto L6;
        ChargeBroadcastReceiver r101 = ChargeBroadcastReceiver.f409785a;
        Log.e("BatteryMonitor", "failed to register ChargeBroadcast, context is null");
        return;
    L6:
        if (ChargeBroadcastReceiver.f409785a != null) goto L8;
        ChargeBroadcastReceiver.f409785a = new ChargeBroadcastReceiver();
    L8:
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r102.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ChargeBroadcastReceiver r110 = ChargeBroadcastReceiver.f409785a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r102);
        return;
    L39:
        throw e;
    L12:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L25;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r102, 0, null, null, 2, r100).result;     // Catch: Exception -> L34
        if (r103 != 1) goto L18;
        r100.registerReceiver(r110, r102);     // Catch: Exception -> L34
    L40:
        return;
    L18:
        if (r103 != 2) goto L20;
        new Intent();     // Catch: Exception -> L34
        goto L40
    L20:
        if (r103 == 3) goto L40;
        r100.registerReceiver(r110, r102);     // Catch: Exception -> L34
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r110, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        goto L40
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L30;
    L32:
        r100.registerReceiver(r110, r102);     // Catch: Exception -> L34
        goto L40
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r110, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
        goto L40
    }

    public a() {
    }

    public final void d(int r100) {
        Log.i("BatteryMonitor", a.class.getSimpleName() + " onStateChange called. state:" + r100);
        this.f569363b = r100;
        setChanged();
        notifyObservers();
    }
}
