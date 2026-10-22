package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public final String b;
    public String c;
    public String d;
    public final String e;
    public final String f;
    public String g;
    public final String h;
    public final String i;
    public String j;
    public String k;
    public Integer l;
    public Integer m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    public static final class a {
    }

    static {
    }

    public t0() {
        super("single_comment_click");
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "0";
    }

    public final void buildParams() {
        String r0 = this.h;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("comment_entrance", r0, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a, r1);
        appendParam("author_id", this.b, r1);
        appendParam("comment_id", this.c, r1);
        appendParam("comment_rank", this.d, r1);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.e, r1);
        appendParam("comment_module", this.f, r1);
        appendParam("label_name", this.g, r1);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.i, r1);
        appendParam("is_append", this.j, r1);
        appendParam("user_comment_level", this.k, r1);
        appendParam("picture_num", String.valueOf(this.l), r1);
        appendParam("video_num", String.valueOf(this.m), r1);
        appendParam("with_same_comment", this.o, r1);
        appendParam("comment_module", this.n, r1);
        appendParam("is_anonymous", this.p, r1);
        appendParam("is_repeat_customer", this.q, r1);
        appendParam("is_live_fan_group", this.r, r1);
        appendParam("click_area", this.s, r1);
        appendParam("comment_type", this.t, r1);
    }
}
