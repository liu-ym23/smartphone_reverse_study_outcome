package fg9;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f476905a = null;

    static {
        f476905a = new a();
    }

    public a() {
    }

    public static void a(JSONObject r100, String r101, Object r102) {
        if (r102 == null) goto L5;
        r100.put(r101, r102);
        return;
    }

    public static void b(a r100, String r101, String r102, boolean r103, String r104, Long r105, Long r106, Long r107, Long r110, Long r111, String r112, int r113) {
        if ((r113 & 8) == 0) goto L6;
        r104 = null;
    L6:
        if ((r113 & 16) == 0) goto L9;
        r105 = null;
    L9:
        if ((r113 & 32) == 0) goto L12;
        r106 = null;
    L12:
        if ((r113 & 64) == 0) goto L15;
        r107 = null;
    L15:
        if ((r113 & 128) == 0) goto L18;
        r110 = null;
    L18:
        if ((r113 & 256) == 0) goto L21;
        r111 = null;
    L21:
        if ((r113 & 512) == 0) goto L23;
        r112 = null;
    L23:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r102, "result");
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L34
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L34
        r109.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r101);     // Catch: Throwable -> L34
        r109.put("result", r102);     // Catch: Throwable -> L34
        r109.put("force_default_config", r103);     // Catch: Throwable -> L34
        a(r109, "reason", r104);     // Catch: Throwable -> L34
        a(r109, "target_heap_size_mb", r105);     // Catch: Throwable -> L34
        a(r109, "target_region_size_mb", r106);     // Catch: Throwable -> L34
        a(r109, "expected_max_memory_mb", r107);     // Catch: Throwable -> L34
        a(r109, "max_memory_before_mb", r110);     // Catch: Throwable -> L34
        a(r109, "max_memory_after_mb", r111);     // Catch: Throwable -> L34
        if (r110 == null) goto L32;
        if (r111 == null) goto L32;
        r109.put("max_memory_delta_mb", r111.longValue() - r110.longValue());     // Catch: Throwable -> L34
        if (r111.longValue() <= r110.longValue()) goto L30;
        boolean r114 = true;
    L31:
        r109.put("memory_increased", r114);     // Catch: Throwable -> L34
        r109.put("max_memory_expand_ratio", b.a(r111.longValue(), r110.longValue()));     // Catch: Throwable -> L34
        goto L32
    L30:
        r114 = false;
    L32:
        a(r109, "error_message", r112);     // Catch: Throwable -> L34
        o.f365780a.reportEvent("heap_expand_opt_result", r109);     // Catch: Throwable -> L34
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L42;
        FLogger.f375446a.e("HeapExpandApplogReporter", "report heap expand applog failed, strategy: " + r101 + ", result: " + r102, r116);
        return;
    L42:
        return;
    L34:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }
}
