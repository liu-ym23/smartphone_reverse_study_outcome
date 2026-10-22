package gh3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f481259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f481260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f481261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f481262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f481263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f481264i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f481256a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_RANK, this.f481257b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_RANK, this.f481258c, r101);
        appendParam("product_id", this.f481259d, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f481260e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, this.f481261f, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f481262g, r101);
        appendParam("request_id", this.f481263h, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE, this.f481264i, r101);
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
