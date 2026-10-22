package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    /* JADX INFO: renamed from: jd3.a$a, reason: collision with other inner class name */
    public static final class C0208a {
    }

    static {
    }

    public a() {
        super("ec_goods_detail_page_exception");
        this.a = "";
        this.b = "";
    }

    public final void buildParams() {
        String r0 = this.a;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        appendParam("message", r0);
        String r2 = this.b;
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        appendParam("extra_message", r1);
    }
}
