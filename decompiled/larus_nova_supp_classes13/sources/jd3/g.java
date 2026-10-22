package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public g() {
        super("click_store_entrance");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("store_type", r0, r1);
        appendParam("shop_id", this.b, r1);
        appendParam("entrance_location", this.c, r1);
        appendParam("author_id", this.d, r1);
        appendParam("store_source_page", this.e, r1);
        appendParam("store_source_method", this.f, r1);
        appendParam("store_group_type", this.g, r1);
    }
}
