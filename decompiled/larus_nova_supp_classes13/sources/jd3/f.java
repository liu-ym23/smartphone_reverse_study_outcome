package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.ec.core.event.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public String k;
    public final String l;
    public String m;
    public String n;
    public final String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    public static final class a {
    }

    static {
    }

    public f() {
        super("click_comment_like");
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
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "0";
        this.s = "";
        this.t = "";
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail", r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, "product_detail", r0);
        appendParam("enter_method", this.c, r0);
        appendParam("author_id", this.a, r0);
        appendParam("group_id", this.b, r0);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, this.d, r0);
        appendParam("commodity_id", this.e, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.f, r0);
        appendParam("commodity_type", this.g, r0);
        appendParam("carrier_source", this.h, r0);
        appendParam("source_method", this.i, r0);
        appendParam("entrance_info", this.j, r0);
        appendParam("comment_entrance", this.o, r0);
        appendParam("comment_tag", this.k, r0);
        appendParam("search_id", this.l, r0);
        appendParam("comment_id", this.m, r0);
        appendParam("type", this.n, r0);
        appendParam("is_append", this.p, r0);
        appendParam("comment_switch_type", this.q, r0);
        appendParam("is_comment_big_pic_like", this.r, r0);
        appendParam("comment_module", this.s, r0);
        appendParam("with_same_comment", this.t, r0);
    }

    public final String getType() {
        return this.n;
    }
}
