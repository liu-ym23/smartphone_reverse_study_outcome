package pd3;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public Map<String, String> f;
    public String g;
    public String h;
    public Map<String, String> i;

    public void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a, r0);
        appendParam("author_id", this.c, r0);
        appendParam("group_id", this.b, r0);
        appendParam(SimilarProductParam.ENTER_FROM, this.e, r0);
        appendParam("module_label", this.d, r0);
        appendParam("price_info", this.g, r0);
        appendParam("image_url", this.h, r0);
        Map<String, String> r1 = this.f;
        if (r1 == null) goto L5;
        appendParam(r1);
    L5:
        Map<String, String> r2 = this.i;
        if (r2 == null) goto L9;
        appendParam(r2);
        return;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
