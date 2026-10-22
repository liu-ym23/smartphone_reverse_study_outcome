package pe3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
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
    public String k;
    public String l;

    /* JADX INFO: renamed from: pe3.a$a, reason: collision with other inner class name */
    public static final class C0225a {
    }

    static {
    }

    public a() {
        super("product_ranking_entrance_show");
    }

    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r0 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("EVENT_ORIGIN_FEATURE", "TEMAI", r0);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.a, r0);
        appendParam("entrance_position", this.h, r0);
        appendParam("rank_id", this.k, r0);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.l, r0);
        appendParam("spu_rank", this.i, r0);
        appendParam("display_rank", this.c, r0);
        appendParam("inflow_list_type", this.j, r0);
        appendParam("ecom_entrance_form", this.b, r0);
        appendParam("commodity_id", this.d, r0);
        appendParam("commodity_type", this.e, r0);
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.f, r0);
        appendParam("module_label", this.g, r0);
    }
}
