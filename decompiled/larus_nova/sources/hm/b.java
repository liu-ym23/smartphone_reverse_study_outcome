package hm;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.store.common.datachannel.ECSShopSourceMethod;
import com.bytedance.android.ec.store.common.starter.f;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f485708c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.store.common.starter.c f485709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.store.common.starter.b f485710b;

    public final void a(Context r310, String r311, String r312, String r313, String r314, String r315, String r316, Integer r317, String r318, String r410, String r411, String r412, JSONObject r413, String r414, boolean r415, String r416, String r417, long r418, Boolean r510, Map r511, String r512, String r513, String r514, Integer r515, String r516, String r517, String r518) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "currentPromotionId");
        Intrinsics.checkNotNullParameter(r312, "enterFrom");
        Intrinsics.checkNotNullParameter("click_store_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r314, "kolId");
        Intrinsics.checkNotNullParameter(r315, "secKolId");
        this.f485710b.a(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518);
    }

    public final void b(Context r110, String r111, String r112, JSONObject r113, Map r114, String r115, Integer r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "followStatus");
        Intrinsics.checkNotNullParameter(r113, "entranceInfo");
        this.f485710b.b(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    static {
        f485708c = new b();
    }

    public b() {
        this.f485709a = new com.bytedance.android.ec.store.common.starter.c();
        this.f485710b = new com.bytedance.android.ec.store.common.starter.b();
    }

    public final void c(Activity r110, List<String> r111, String r112, ViewGroup r113, f r114, String r115, Function1<? super String, Unit> r210) {
        Intrinsics.checkNotNullParameter(r111, "awemeIds");
        Intrinsics.checkNotNullParameter(r112, "sessionId");
        Intrinsics.checkNotNullParameter(r113, "viewGroup");
        Intrinsics.checkNotNullParameter(r114, "require");
        Intrinsics.checkNotNullParameter(r210, "exitCallback");
        this.f485709a.getClass();
        Intrinsics.checkNotNullParameter(r111, "awemeIds");
        Intrinsics.checkNotNullParameter(r112, "sessionId");
        Intrinsics.checkNotNullParameter(r113, "viewGroup");
        Intrinsics.checkNotNullParameter(r114, "require");
        Intrinsics.checkNotNullParameter(r210, "exitCallback");
        if (r110 == null) goto L22;
        JSONObject r100 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, "store_page"), JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r114.f48226a.getDes()), JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r114.f48227b.getDes())});
        c.c(r100, r110);
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "$this$readInEntranceInfoAsString");
        Intrinsics.checkNotNullParameter("ecom_scene_id", "key");
        JSONObject r116 = c.d(r110);
        if (r116 != null) goto L8;
        r116 = new JSONObject();
    L8:
        r101.put("ecom_scene_id", r116.optString("ecom_scene_id"));
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r100);
        if (Intrinsics.areEqual(r114.f48227b.getDes(), ECSShopSourceMethod.STORE_SHOP_HEAD_INFO.getDes()) == false) goto L11;
        r101.put("enter_from", r114.f48227b.getDes() + "_" + r112);
    L11:
        r101.toString();
        boolean r102 = ECServiceManager.f42805a;
        s83.f r103 = ((g) ECServiceManager.c(g.class)).p();
        if (r103 == null) goto L21;
        Intrinsics.checkNotNullParameter(r110, "$this$readInEntranceInfoAsString");
        Intrinsics.checkNotNullParameter("search_params", "key");
        JSONObject r104 = c.d(r110);
        if (r104 != null) goto L16;
        r104 = new JSONObject();
    L16:
        String r105 = r104.optString("search_params");
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        r103.c(r110, r111, r112, r105, r113, r210);
        return;
    L21:
        return;
    }
}
