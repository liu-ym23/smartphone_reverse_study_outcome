package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends com.bytedance.android.ec.core.event.a {
    public int a;
    public String b;
    public String c;
    public String d;

    public static final class a {
    }

    static {
    }

    public w() {
        super("ec_goods_detail_load_image");
        this.a = 1;
        this.b = "";
        this.c = "";
    }

    public final void buildParams() {
        String r0 = String.valueOf(this.a);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("result", r0, r1);
        appendParam("url", this.b, r1);
        appendParam("com.bytedance.android.ec.adapter.api.message", this.c, r1);
        appendParam("position", String.valueOf(this.d), r1);
    }

    public final void setResult(int r1) {
        this.a = r1;
    }
}
