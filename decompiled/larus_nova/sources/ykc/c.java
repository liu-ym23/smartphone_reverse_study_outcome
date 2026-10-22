package ykc;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryManager f568297a;

    public c() {
    }

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public static BatteryManager a(Context r100) {
        if (f568297a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f568297a != null) goto L9;
        f568297a = (BatteryManager) r100.getSystemService("batterymanager");     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f568297a;
    }

    public static long b(Context r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        BatteryManager r101 = a(r100);
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.getLongProperty(4);
    }

    public static float c(Context r100) {
        if (r100 != null) goto L5;
        return -1.0f;
    L5:
        BatteryManager r101 = a(r100);
        if (r101 != null) goto L8;
        return -1.0f;
    L8:
        int r102 = 2;
        float r103 = r101.getLongProperty(2);
        if (r103 >= (-1.0E7f)) goto L11;
    L71:
        return -1.0f;
    L11:
        if (r103 > 1.0E7f) goto L71;
        int r104 = d.f568299b;
        boolean r105 = false;
        if (r104 == 3) goto L18;
        if (r104 != 1) goto L17;
    L16:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L67;
        int r107 = d.f568300c;
        if (r107 == 3) goto L36;
        if (r107 != 1) goto L35;
    L34:
        boolean r108 = true;
    L45:
        if (r108 == true) goto L67;
        int r109 = d.f568298a;
        if (r109 == 3) goto L51;
        if (r109 != 1) goto L59;
    L50:
        r105 = true;
    L59:
        if (r105 == false) goto L65;
        if (r103 > 10000.0f) goto L63;
        return r103;
    L63:
        return r103 / 1000.0f;
    L65:
        return r103 / 1000.0f;
    L51:
        String r110 = Build.BRAND;
        if (TextUtils.isEmpty(r110) == false) goto L54;
    L56:
        d.f568298a = r102;
        if (r102 != 1) goto L59;
    L54:
        if (r110.toLowerCase().contains(AppConstants.CHANNEL_OPPO) == false) goto L56;
        r102 = 1;
    L35:
        r108 = false;
        goto L45
    L36:
        String r111 = Build.BRAND;
        if (TextUtils.isEmpty(r111) == false) goto L39;
    L41:
        int r112 = 2;
    L42:
        d.f568300c = r112;
        if (r112 != 1) goto L35;
    L39:
        if (r111.toLowerCase().contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L41;
        r112 = 1;
    L67:
        if (r103 >= (-10000.0f)) goto L70;
        r103 = r103 / 1000.0f;
    L70:
        return -r103;
    L17:
        r106 = false;
        goto L30
    L18:
        String r113 = Build.HARDWARE;
        if (TextUtils.isEmpty(r113) == false) goto L21;
    L25:
        int r114 = 2;
    L26:
        d.f568299b = r114;
        if (r114 != 1) goto L17;
    L21:
        if (r113.toLowerCase().contains("hi") == false) goto L23;
    L24:
        r114 = 1;
        goto L26
    L23:
        if (r113.toLowerCase().contains("kirin") == false) goto L25;
        goto L24
    }

    public static float d(Context r110) {
        if (r110 != null) goto L5;
        return -1.0f;
    L5:
        IntentFilter r100 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        Intent r111 = ReceiverRegisterCrashOptimizer.registerReceiver(null, r100);
    L37:
        if (r111 != null) goto L40;
        return -1.0f;
    L40:
        return r111.getIntExtra("voltage", -1) / 1000.0f;
    L41:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r100, 0, null, null, 2, r110);     // Catch: Exception -> L33
        int r102 = r101.result;     // Catch: Exception -> L33
        if (r102 != 1) goto L16;
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L33
    L42:
        goto L37
    L16:
        if (r102 != 2) goto L18;
        r111 = new Intent();     // Catch: Exception -> L33
        goto L42
    L18:
        if (r102 == 3) goto L20;
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L33
        goto L42
    L20:
        r111 = r101.intent;     // Catch: Exception -> L33
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r111 = r110.registerReceiver(null, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        goto L42
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L31:
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L33
        goto L42
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        r111 = ContextCompat.registerReceiver(r110, null, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        goto L42
    }
}
