package yk3;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated(message = "3D功能已下线, 请检查此埋点上报是否合理")
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f568121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f568122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f568123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f568124d;

    public a() {
        super("3dmodel_click_product");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f568121a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("author_id", r100, r101);
        appendParam("product_id", this.f568122b, r101);
        appendParam("enter_from", this.f568123c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f568124d, r101);
    }
}
