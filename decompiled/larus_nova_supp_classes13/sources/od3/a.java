package od3;

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
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public Map<String, String> m;

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page", r0);
        appendParam("location", this.l, r0);
        appendParam("sim_product_id", this.a, r0);
        appendParam("product_id_group", this.b, r0);
        appendParam("author_id", this.c, r0);
        appendParam("ecom_entrance_form", this.d, r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.e, r0);
        appendParam("previous_page", this.f, r0);
        appendParam("group_id", this.g, r0);
        appendParam("request_id", this.h, r0);
        appendParam(SimilarProductParam.ENTER_FROM, this.i, r0);
        appendParam("module_label", this.j, r0);
        appendParam("chnid", this.k, r0);
        Map<String, String> r1 = this.m;
        if (r1 == null) goto L6;
        appendParam(r1);
        return;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
