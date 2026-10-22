package gh3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: gh3.a$a, reason: collision with other inner class name */
    public static final class C0199a {
    }

    static {
    }

    public a() {
        super("click_ecom_dislike");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("key_id", r0, r1);
        appendParam("key_rank", this.b, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.c, r1);
        appendParam("confirm_content", this.d, r1);
        appendParam("recommend_info", this.e, r1);
        appendParam("request_id", this.f, r1);
        appendParam("similar_type", this.g, r1);
    }
}
