package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public final String b;
    public String c;
    public String d;
    public final String e;
    public final String f;
    public String g;
    public final String h;
    public String i;
    public final String j;
    public String k;
    public String l;
    public Integer m;
    public Integer n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;

    public static final class a {
    }

    static {
    }

    public u0() {
        super("single_comment_show");
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
        this.l = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "0";
        this.u = "";
        this.v = "";
        this.w = "";
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
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.j, r1);
        appendParam("is_append", this.k, r1);
        appendParam("business_type", this.i, r1);
        appendParam("user_comment_level", this.l, r1);
        appendParam("picture_num", String.valueOf(this.m), r1);
        appendParam("video_num", String.valueOf(this.n), r1);
        appendParam("with_same_comment", this.p, r1);
        appendParam("comment_module", this.o, r1);
        appendParam("is_anonymous", this.q, r1);
        appendParam("is_repeat_customer", this.r, r1);
        appendParam("is_live_fan_group", this.s, r1);
        appendParam("comment_type", this.t, r1);
        appendParam("tab_name", this.u, r1);
        appendParam("tag_name", this.v, r1);
        appendParam("if_positive", this.w, r1);
    }
}
