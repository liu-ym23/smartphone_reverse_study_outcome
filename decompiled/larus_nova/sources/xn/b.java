package xn;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.window.base.common.starter.ECWindowAddCartStarter;
import com.bytedance.android.ec.window.base.common.starter.d;
import com.bytedance.android.ec.window.base.common.starter.e;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f564601f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f564602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.window.base.common.starter.c f564603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.window.base.common.starter.a f564604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.window.base.common.starter.b f564605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ECWindowAddCartStarter f564606e;

    public final void a(Activity r110, WindowV2ProductItemVO r111, e r112, String r113, Function1<? super Integer, Unit> r114, Function3<? super String, ? super String, ? super Long, Unit> r115, com.bytedance.android.btm.api.model.d r116, WindowEntranceInfoScene r117) {
        Intrinsics.checkNotNullParameter(r111, "currentItem");
        Intrinsics.checkNotNullParameter(r112, "require");
        Intrinsics.checkNotNullParameter(r113, "btmPageId");
        Intrinsics.checkNotNullParameter(r117, "entranceInfoScene");
        this.f564606e.a(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public final void b(Context r310, String r311, String r312, String r313, String r314, String r315, String r316, Integer r317, String r318, String r410, String r411, String r412, JSONObject r413, String r414, boolean r415, String r416, String r417, long r418, Boolean r510, Map r511, String r512, String r513, String r514, Integer r515, String r516, String r517, String r518) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "currentPromotionId");
        Intrinsics.checkNotNullParameter(r312, "enterFrom");
        Intrinsics.checkNotNullParameter("click_store_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r314, "kolId");
        Intrinsics.checkNotNullParameter(r315, "secKolId");
        this.f564604c.a(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518);
    }

    public final void c(Context r110, String r111, String r112, JSONObject r113, Map r114, String r115, Integer r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "followStatus");
        Intrinsics.checkNotNullParameter(r113, "entranceInfo");
        this.f564604c.b(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    static {
        f564601f = new b();
    }

    public b() {
        this.f564602a = new d();
        this.f564603b = new com.bytedance.android.ec.window.base.common.starter.c();
        this.f564604c = new com.bytedance.android.ec.window.base.common.starter.a();
        this.f564605d = new com.bytedance.android.ec.window.base.common.starter.b();
        this.f564606e = new ECWindowAddCartStarter();
    }
}
