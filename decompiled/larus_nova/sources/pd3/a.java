package pd3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f528663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f528664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f528665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f528666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f528667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f528668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f528669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f528670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f528671i;

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r100);
        appendParam("product_id", this.f528663a, r100);
        appendParam("author_id", this.f528665c, r100);
        appendParam("group_id", this.f528664b, r100);
        appendParam("enter_from", this.f528667e, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f528666d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO, this.f528669g, r100);
        appendParam("image_url", this.f528670h, r100);
        Map<String, String> r101 = this.f528668f;
        if (r101 == null) goto L5;
        appendParam(r101);
    L5:
        Map<String, String> r102 = this.f528671i;
        if (r102 == null) goto L9;
        appendParam(r102);
        return;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
