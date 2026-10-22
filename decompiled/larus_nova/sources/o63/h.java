package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f522193f;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522191d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_PRODUCT_ID, this.f522192e, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_IS_REALLY_CLICK, this.f522193f, r101);
        super.buildParams();
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
