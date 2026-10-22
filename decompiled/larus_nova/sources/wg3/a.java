package wg3;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.c;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4Param f559545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559546b;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(k.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        int r100 = com.bytedance.android.shopping.base.event.c.f170705a;
        com.bytedance.android.shopping.base.event.c.c(this.f559545a.getSessionId());
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        int r100 = com.bytedance.android.shopping.base.event.c.f170705a;
        com.bytedance.android.shopping.base.event.c.f(this.f559545a.getNativeParams().getFullMode(), this.f559545a.getSessionId(), this.f559546b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(k.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.bytedance.android.shopping.base.event.c.f170705a;
        com.bytedance.android.shopping.base.event.c.g(r100 instanceof k.d.a, this.f559545a.getSessionId());
    }

    public a(AnchorV4Param r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f559545a = r100;
        this.f559546b = r101;
    }
}
