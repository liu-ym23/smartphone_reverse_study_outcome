package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    public b0() {
        super("order_schema");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("new_schema", r0, r1);
        appendParam("old_schema", this.b, r1);
        appendParam("scene", this.c, r1);
    }
}
