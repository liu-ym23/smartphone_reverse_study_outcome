package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498412f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498407a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("duration", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_FINAL_STATUS, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, null, r101);
        appendParam("author_id", null, r101);
        appendParam("room_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LIVE_GROUP_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null, r101);
        appendParam("source_page", null, r101);
        appendParam("previous_page", null, r101);
        appendParam("enter_method", null, r101);
        appendParam("product_id", null, r101);
        appendParam("follow_status", followStatus(null, null), r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r101);
        appendParam("page_name", null, r101);
        appendParam("group_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_VIRTUAL_COMMODITY_FLAG, this.f498408b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_WITH_COUPON, this.f498409c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, null, r101);
        appendParam("search_id", this.f498410d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, null, r101);
        appendParam("page_type", this.f498411e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_MESSAGE_SHOW_PV, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLOSE_METHOD, this.f498412f, r101);
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.f498408b = "0";
        this.f498409c = "0";
    }
}
