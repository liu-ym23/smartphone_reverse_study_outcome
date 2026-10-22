package gh3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("key_id", r0, r1);
        appendParam("key_rank", this.b, r1);
        appendParam("product_rank", this.c, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.d, r1);
        appendParam("source_method", this.e, r1);
        appendParam("ecom_group_type", this.f, r1);
        appendParam("recommend_info", this.g, r1);
        appendParam("request_id", this.h, r1);
        appendParam("similar_type", this.i, r1);
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
