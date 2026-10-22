package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.android.ec.core.event.a {
    public static final Set<Long> p = null;
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
    public final String n;
    public final String o;

    public static final class a {
    }

    static {
        p = new LinkedHashSet();
    }

    public j() {
        super("comment_card_duration");
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
        this.k = "0";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
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
        appendParam("duration", this.k, r0);
        appendParam("comment_entrance", this.l, r0);
        appendParam("comment_tag", this.m, r0);
        appendParam("search_id", this.n, r0);
        appendParam("comment_module", this.o, r0);
        Set<Long> r1 = p;
        appendParam("comment_show_list", CollectionsKt.toList(r1).toString(), r0);
        r1.clear();
    }
}
