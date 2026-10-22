package lu1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510820a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("DynamicStrategy", r100);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "info");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "ast_strategy_parse_error"), TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r100), TuplesKt.to("info", r101)}), null);
    }

    public static void g(String r100, Map r101) {
        k0.o().j(r100, r101);
    }

    public static void h(Map r100, Throwable r101) {
        k0.o().f("DynamicStrategy_error", r100);
        if (r101 == null) goto L6;
        k0.o().getClass();
        com.bytedance.android.live.core.log.g.e("DynamicStrategy_error", r101);
        return;
    }

    public static void c(ju1.c r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "factor");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        if (ku1.c.f506181a.getValue().d() == false) goto L6;
        g("DynamicStrategy_feature_change", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("name", r100.f500406a), TuplesKt.to("old_state", r101), TuplesKt.to("new_state", r102), TuplesKt.to("type", "feature")}));
        return;
    }

    public static void d(ju1.l r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (ku1.c.f506181a.getValue().d() == false) goto L6;
        g("DynamicStrategy_feature_change", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("name", r100.b()), TuplesKt.to("old_state", Boolean.valueOf(r101)), TuplesKt.to("new_state", Boolean.valueOf(r102)), TuplesKt.to("type", "scene")}));
        return;
    }

    public static void f(String r100, String r101, SimpleExpressException r102) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "expression");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "expression_execute_error"), TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r100), TuplesKt.to("expression", r101)}), r102);
    }

    public static void e(ju1.h r100, ju1.n r101, ju1.n r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r102, "newResult");
        Intrinsics.checkNotNullParameter(r103, "featureMap");
        Pair[] r104 = new Pair[6];
        r104[0] = TuplesKt.to("name", r100.b());
        r104[1] = TuplesKt.to("type", r100.d());
        if (r101 == null) goto L6;
        Object r105 = r101.c();
        if (r105 == null) goto L6;
    L7:
        r104[2] = TuplesKt.to("old_result", r105);
        r104[3] = TuplesKt.to("new_result", r102.c());
        r104[4] = TuplesKt.to("is_default", Boolean.valueOf(r102.f500413b));
        r104[5] = TuplesKt.to("feature_state", r103);
        g("DynamicStrategy_strategy_decide", MapsKt.mutableMapOf(r104));
        return;
    L6:
        r105 = "null";
        goto L7
    }

    public static void i(int r100, String r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "info");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_fetch_error"), TuplesKt.to("request_scene", Integer.valueOf(r100)), TuplesKt.to("version", r101), TuplesKt.to("info", r102)}), r103);
    }
}
