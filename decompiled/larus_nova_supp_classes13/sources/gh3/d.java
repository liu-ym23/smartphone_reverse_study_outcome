package gh3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public d() {
        super("similar_product_homepage_show");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("keys_cnt", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
