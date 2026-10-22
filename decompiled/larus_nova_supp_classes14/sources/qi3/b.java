package qi3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public Integer d;
    public String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public b() {
        super("enter_search");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("source_page", r0, r1);
        appendParam("entrance_location", this.b, r1);
        appendParam("temp_id", this.c, r1);
        appendParam("is_enter_preview", String.valueOf(this.d), r1);
        appendParam("store_type", this.e, r1);
        appendParam("page_name", this.f, r1);
        appendParam("author_id", this.g, r1);
    }
}
