package sn2;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542650a = 0;

    static {
    }

    public static void a(rn2.a r110) {
        Intrinsics.checkNotNullParameter(r110, "livePowerBattery");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L32
        if (r110.f538667g != (-1)) goto L6;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L17;
        return;
    L17:
        HashMap r102 = new HashMap();     // Catch: Throwable -> L32
        long r103 = r110.f538668h - r110.f538667g;     // Catch: Throwable -> L32
        long r104 = r110.f538662b - r110.f538665e;     // Catch: Throwable -> L32
        r102.put("duration", String.valueOf(r103));     // Catch: Throwable -> L32
        r102.put("total_battery_power", String.valueOf(r104));     // Catch: Throwable -> L32
        r102.put("start_battery_level", String.valueOf(r110.f538664d));     // Catch: Throwable -> L32
        r102.put("start_battery_power", String.valueOf(r110.f538662b));     // Catch: Throwable -> L32
        r102.put("start_battery_origin_power", String.valueOf(r110.f538663c));     // Catch: Throwable -> L32
        r102.put("end_battery_power", String.valueOf(r110.f538665e));     // Catch: Throwable -> L32
        r102.put("end_battery_origin_power", String.valueOf(r110.f538666f));     // Catch: Throwable -> L32
        String r105 = "1";
        String r111 = "0";
        if (r110.f538661a == false) goto L21;
        Object r106 = "1";
    L22:
        r102.put(IPerformanceManager.Params.is_anchor, r106);     // Catch: Throwable -> L32
        if (r110.f538669i == true) goto L26;
        r105 = "0";
    L26:
        r102.put("has_charged", r105);     // Catch: Throwable -> L32
        if (r103 == 0) goto L30;
        r111 = String.valueOf((r104 / r103) * 1000);     // Catch: Throwable -> L32
    L30:
        r102.put("per_second_battery_power", r111);     // Catch: Throwable -> L32
        u.l().sendLog("livesdk_performance_power", r102, new Object[]{x.class, PadLoggerData.class});     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L21:
        r106 = "0";
        goto L22
    L6:
        if (r110.f538668h == (-1)) goto L14;
        if (r110.f538662b == (-1)) goto L14;
        if (r110.f538665e == (-1)) goto L14;
        r101 = true;
    L32:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
