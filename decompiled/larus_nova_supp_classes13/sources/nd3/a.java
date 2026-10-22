package nd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.a, r0);
        appendParam("coupon_id", this.b, r0);
        appendParam("coupon_type", this.c, r0);
        appendParam("coupon_info", this.d, r0);
        appendParam("ecom_entrance_form", this.e, r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.f, r0);
        appendParam("group_id", this.g, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.h, r0);
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
