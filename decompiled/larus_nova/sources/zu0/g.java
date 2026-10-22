package zu0;

import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.profit.profitCheck.jsbridge.ReportProfitCheckTaskDataResultModel;
import com.bytedance.android.live.revenue.common.q;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends b<h, ReportProfitCheckTaskDataResultModel> {
    public g() {
    }

    public final Map<String, Object> j(String r100) {
        Map<String, Object> r101 = MapsKt.toMutableMap(q.a(new JSONObject(r100)));     // Catch: Exception -> L4
        r101.remove("room_id");     // Catch: Exception -> L4
        r101.remove("roomId");     // Catch: Exception -> L4
        r101.remove("user_id");     // Catch: Exception -> L4
        r101.remove("userId");     // Catch: Exception -> L4
        return r101;
    L4:
        finishWithFailure();
        return null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        h r102 = (h) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        h.a r103 = r102.a();
        if (r103 == null) goto L9;
        String r104 = r103.b();
        if (r104 == null) goto L9;
        Map<String, ? extends Object> r105 = j(r104);
        if (r105 == null) goto L9;
        boolean r106 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.EXHIBITION_INFO, r105, null);
    L9:
        h.a r107 = r102.a();
        if (r107 == null) goto L16;
        String r108 = r107.f();
        if (r108 == null) goto L16;
        Map<String, ? extends Object> r109 = j(r108);
        if (r109 == null) goto L16;
        boolean r110 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.GRADE_LEVEL, r109, null);
    L16:
        h.a r111 = r102.a();
        if (r111 == null) goto L23;
        String r112 = r111.g();
        if (r112 == null) goto L23;
        Map<String, ? extends Object> r113 = j(r112);
        if (r113 == null) goto L23;
        boolean r114 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.WISH_LIST, r113, null);
    L23:
        h.a r115 = r102.a();
        if (r115 == null) goto L30;
        String r116 = r115.c();
        if (r116 == null) goto L30;
        Map<String, ? extends Object> r117 = j(r116);
        if (r117 == null) goto L30;
        boolean r118 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.FANS_CLUB_PAGE, r117, null);
    L30:
        h.a r119 = r102.a();
        if (r119 == null) goto L37;
        String r120 = r119.a();
        if (r120 == null) goto L37;
        Map<String, ? extends Object> r121 = j(r120);
        if (r121 == null) goto L37;
        boolean r122 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.AUDIENCE_RANK_LIST, r121, null);
    L37:
        h.a r123 = r102.a();
        if (r123 == null) goto L44;
        String r124 = r123.e();
        if (r124 == null) goto L44;
        Map<String, ? extends Object> r125 = j(r124);
        if (r125 == null) goto L44;
        boolean r126 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.LINK_MIC_CONTRIBUTE_RANK_LIST, r125, null);
    L44:
        h.a r127 = r102.a();
        if (r127 == null) goto L58;
        String r128 = r127.d();
        if (r128 == null) goto L58;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L56
        Map<String, Object> r130 = j(r128);     // Catch: Throwable -> L56
        if (r130 == null) goto L54;
        Map<String, ? extends Object> r131 = MapsKt.toMutableMap(r130);     // Catch: Throwable -> L56
        if (r131 == null) goto L54;
        String r132 = String.valueOf(r131.remove("EventName"));     // Catch: Throwable -> L56
        long r133 = CastLongProtector.parseLong(String.valueOf(r131.remove("OriginType")));     // Catch: Throwable -> L56
        boolean r134 = com.bytedance.android.live.revenue.core.util.h.f91037a;     // Catch: Throwable -> L56
        com.bytedance.android.live.profit.privilege.c r135 = (com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class);     // Catch: Throwable -> L56
        ProfitCheckType r136 = ProfitCheckType.GENERAL_TASK;     // Catch: Throwable -> L56
        r136.setTypeName(r132);     // Catch: Throwable -> L56
        r136.setIndex(r133);     // Catch: Throwable -> L56
        Unit r137 = Unit.INSTANCE;     // Catch: Throwable -> L56
        r135.B1(r136, r131, null);     // Catch: Throwable -> L56
    L54:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L58:
        finishWithSuccess();
    }
}
