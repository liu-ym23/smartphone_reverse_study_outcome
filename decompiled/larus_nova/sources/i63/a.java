package i63;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f488427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f488428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f488429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f488430d;

    /* JADX INFO: renamed from: i63.a$a, reason: collision with other inner class name */
    public static final class C6234a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", this.f488427a, r100);
        appendParam("entrance_position", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, this.f488429c, r100);
        appendParam("product_id", this.f488430d, r100);
        appendParam("spu_rank", null, r100);
        appendParam("display_rank", this.f488428b, r100);
        appendParam("inflow_list_type", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r100);
        appendParam("source_page", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, null, r100);
    }

    public a() {
        super("product_ranking_entrance_click");
    }
}
