package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public i() {
        super("close_product_detail");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("close_method", r0, r1);
        appendParam("page_type", this.b, r1);
    }
}
