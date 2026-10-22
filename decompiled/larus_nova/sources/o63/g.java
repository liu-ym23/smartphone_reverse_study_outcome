package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522190e;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522189d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_PRODUCT_ID, this.f522190e, r101);
        super.buildParams();
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
