package ou1;

import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import ju1.h;
import ju1.n;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements nu1.f<com.bytedance.android.livesdk.dynamicstrategy.api.entity.b> {
    public a() {
    }

    @Override // nu1.f
    public final n a(h r110, Map r111) {
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.b r112 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.b) r110;
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r111, "stateMap");
        boolean r100 = true;
        boolean r101 = false;
        Map<String, ASTRunner.b0> r102 = ASTRunner.f123060a;     // Catch: Exception -> L5
        Object r113 = ASTRunner.c(r112, r111);     // Catch: Exception -> L5
    L13:
        if (r113 != null) goto L15;
        r113 = r112.f123027b;
    L17:
        return new n(r113, r100);
    L15:
        r100 = r101;
    L5:
        e = move-exception;
        int r103 = k.f510820a;
        String r104 = r112.f123026a;
        String r105 = e.getMessage();
        if (r105 != null) goto L9;
        r105 = "unknown";
    L9:
        Intrinsics.checkNotNullParameter(r104, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r105, "info");
        k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "ast_execute_error"), TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r104), TuplesKt.to("info", r105)}), e);
        int r106 = DynamicStrategyMonitor.f123031a;
        String r107 = r112.f123026a;
        String r114 = e.getMessage();
        if (r114 != null) goto L12;
        r114 = "ast execute error";
    L12:
        DynamicStrategyMonitor.d(r107, "ASTRuleStrategy", "", r114);
        r113 = null;
        r101 = true;
        goto L13
    }
}
