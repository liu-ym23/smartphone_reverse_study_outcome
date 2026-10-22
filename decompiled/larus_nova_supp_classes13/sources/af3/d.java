package af3;

import com.bytedance.android.shopping.mall.homepage.component.ECMFPageCardComponent;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public boolean a;
    public String b;
    public boolean c;
    public final c d;
    public final a e;
    public final g f;

    public final void a() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        JSONObject r1 = new JSONObject();
        r1.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1.put(SimilarProductParam.ENTER_FROM, this.f.b);
        r1.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.f.a);
        r1.put("is_open", this.a);
        int r3 = 0;
        r1.put("is_reopen", false);
        r1.put("is_special_reopen", false);
        this.d.b();
        r1.put("is_visible", false);
        r1.put("component", a.d(this.e.b, "component"));
        r3 = JSONObjectProtectorUtils.getInt(this.e.b, "plan_id");     // Catch: Exception -> L16
    L7:
        r1.put("plan_id", r3);
        JSONObject r0 = this.e.b.optJSONObject("track_extra");
        String r2 = "";
        if (r0 == null) goto L10;
        String r4 = r0.optString("interest", "");
    L11:
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        r1.put("interest", r2);
        r1.put("duration", System.currentTimeMillis() - this.f.c);
        r1.put("api_key", "marketing_resource_get");
        r1.put("break_reason", this.b);
        r1.put("card_source", "native");
        r1.put("is_first_screen_finished", this.d.a());
        Unit r5 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_popup_result_stat", r1);
        return;
    L10:
        r4 = null;
        goto L11
    }

    public d(ECMFPageCardComponent.a r2, a r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "mallAbility");
        Intrinsics.checkNotNullParameter(r3, "apiDataHelper");
        Intrinsics.checkNotNullParameter(r4, "queryMapHelper");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = "";
    }
}
