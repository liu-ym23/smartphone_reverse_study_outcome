package qi3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.android.ec.core.event.a {
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

    public static final class a {
    }

    static {
    }

    public c() {
        super("show_product_list");
    }

    public final void buildParams() {
        String r0 = this.d;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("author_id", r0, r1);
        appendParam("entrance_location", this.e, r1);
        appendParam("enter_from", this.a, r1);
        appendParam("source_page", this.f, r1);
        appendParam("page_name", this.b, r1);
        appendParam("page_type", this.c, r1);
        appendParam("tab_name", this.g, r1);
        appendParam("click_type", null, r1);
        appendParam("temp_id", this.h, r1);
        appendParam("customer_id", this.i, r1);
        appendParam("is_enter_preview", this.j, r1);
    }
}
