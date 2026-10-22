package t3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f {
    static {
    }

    public static g a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        IntentFilter r100 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L5;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L5:
        boolean r101 = true;
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
        Intent r111 = ReceiverRegisterCrashOptimizer.registerReceiver(null, r100);
    L33:
        if (r111 != null) goto L35;
        return null;
    L35:
        int r102 = r111.getIntExtra("status", -1);
        int r103 = 0;
        if (r102 != 2) goto L38;
    L41:
        int r104 = r111.getIntExtra("level", 0);
        int r112 = r111.getIntExtra("scale", 100);
        if (r112 <= 0) goto L45;
        r103 = RangesKt.coerceIn((r104 * 100) / r112, 0, 100);
    L45:
        return new g(r103, r101);
    L38:
        if (r102 == 5) goto L41;
        r101 = false;
        goto L41
    L46:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L20;
        ReceiverRegisterAnrOptimizer.ResultWrapper r105 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r100, 0, null, null, 2, r110);     // Catch: Exception -> L29
        int r106 = r105.result;     // Catch: Exception -> L29
        if (r106 == 1) goto L18;
        if (r106 != 2) goto L14;
        r111 = new Intent();     // Catch: Exception -> L29
    L47:
        goto L33
    L14:
        if (r106 == 3) goto L16;
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L29
        goto L47
    L16:
        r111 = r105.intent;     // Catch: Exception -> L29
        goto L47
    L18:
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r111 = r110.registerReceiver(null, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L47
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r111 = r110.registerReceiver(null, r100);     // Catch: Exception -> L29
        goto L47
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        r111 = ContextCompat.registerReceiver(r110, null, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L47
    }
}
