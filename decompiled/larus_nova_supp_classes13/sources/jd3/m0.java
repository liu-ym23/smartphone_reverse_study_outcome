package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m0 extends com.bytedance.android.ec.core.event.a {
    public String a;

    public static final class a {
    }

    static {
    }

    public m0() {
        super("product_extra_info_show");
        this.a = "";
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("info_name", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
