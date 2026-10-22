package qoa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver;
import fpa.c;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AzerothCustomReceiver f534325a;

        public a(AzerothCustomReceiver r100) {
            this.f534325a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context r100, final Intent r101) {
            Runnable r102 = new qoa.a(this, r100, r101);
            c.f478390a.execute(r102);
        }
    }

    public static void a(Context r110, AzerothCustomReceiver r111) {
        if (Build.VERSION.SDK_INT < 33) goto L34;
        a r100 = new a(r111);
        IntentFilter r101 = new IntentFilter(r111.getClass().getName());
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101, 4);
        return;
    L33:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L20;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 4, null, null, 3, r110).result;     // Catch: Exception -> L29
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L17;
        if (r102 == 3) goto L64;
        r110.registerReceiver(r100, r101, 4);     // Catch: Exception -> L29
    L64:
        return;
    L17:
        new Intent();     // Catch: Exception -> L29
        goto L64
    L18:
        r110.registerReceiver(r100, r101, 4);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r110.registerReceiver(r100, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L64
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r110.registerReceiver(r100, r101, 4);     // Catch: Exception -> L29
        goto L64
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r110, r100, r101, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L29
        goto L64
    L34:
        a r103 = new a(r111);
        IntentFilter r104 = new IntentFilter(r111.getClass().getName());
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r104);
        return;
    L63:
        throw e;
    L38:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r104) == false) goto L49;
        int r112 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r104, 0, null, null, 2, r110).result;     // Catch: Exception -> L58
        if (r112 == 1) goto L47;
        if (r112 == 2) goto L46;
        if (r112 == 3) goto L67;
        r110.registerReceiver(r103, r104);     // Catch: Exception -> L58
    L67:
        return;
    L46:
        new Intent();     // Catch: Exception -> L58
        goto L67
    L47:
        r110.registerReceiver(r103, r104);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r110.registerReceiver(r103, r104, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L67
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r110.registerReceiver(r103, r104);     // Catch: Exception -> L58
        goto L67
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r104) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r110, r103, r104, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L67
    }

    public static void b(Context r100, AzerothCustomReceiver r101) {
        if (r100 == null) goto L7;
        AlarmManager r102 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Exception -> L9
        if (r102 != null) goto L6;
        return;
    L6:
        Intent r103 = new Intent(r101.getClass().getName());     // Catch: Exception -> L9
        r103.setPackage(r100.getPackageName());     // Catch: Exception -> L9
        PendingIntent r104 = PendingIntent.getBroadcast(r100, 0, r103, 201326592);     // Catch: Exception -> L9
        r102.set(3, SystemClock.elapsedRealtime() + r101.a(), r104);     // Catch: Exception -> L9
        return;
    L7:
        apa.a.b("AzerothAlarmUtil", "setCustomAlarm: context or receiver is null");     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        xoa.a.a(e, "setCustomAlarm execute failed", null);
    }
}
