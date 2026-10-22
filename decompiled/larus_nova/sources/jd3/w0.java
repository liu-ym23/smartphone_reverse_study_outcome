package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class w0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f498553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498556e;

    public static final class a {
    }

    static {
    }

    public w0() {
        super("slide_product_main_picture");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r100);
        appendParam("source_page", null, r100);
        appendParam("carrier_type", null, r100);
        appendParam("group_id", null, r100);
        appendParam("author_id", null, r100);
        appendParam("page_name", null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, null, r100);
        appendParam("previous_page", null, r100);
        appendParam("enter_method", null, r100);
        appendParam("product_id", this.f498552a, r100);
        appendParam("follow_status", followStatus(null, null), r100);
        Integer r101 = this.f498553b;
        if (r101 == null) goto L5;
        String r102 = String.valueOf(r101.intValue());
    L6:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ITEM_ORDER, r102, r100);
        appendParam("search_id", this.f498554c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null, r100);
        appendParam("page_type", this.f498555d, r100);
        String r103 = this.f498556e;
        if (r103 == null) goto L10;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r103, r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
