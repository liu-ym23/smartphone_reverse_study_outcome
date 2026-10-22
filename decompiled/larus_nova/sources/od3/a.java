package od3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f522821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f522824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f522825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f522826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f522827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f522828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f522829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f522830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f522831m;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r100);
        appendParam("location", this.f522830l, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SIM_PRODUCT_ID, this.f522819a, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID_GROUP, this.f522820b, r100);
        appendParam("author_id", this.f522821c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, this.f522822d, r100);
        appendParam("source_page", this.f522823e, r100);
        appendParam("previous_page", this.f522824f, r100);
        appendParam("group_id", this.f522825g, r100);
        appendParam("request_id", this.f522826h, r100);
        appendParam("enter_from", this.f522827i, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f522828j, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, this.f522829k, r100);
        Map<String, String> r101 = this.f522831m;
        if (r101 == null) goto L6;
        appendParam(r101);
        return;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
