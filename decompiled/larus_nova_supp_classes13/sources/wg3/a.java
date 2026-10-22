package wg3;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.c;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements c {
    public final AnchorV4Param a;
    public final boolean b;

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
    public final void u(k.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        int r0 = com.bytedance.android.shopping.base.event.c.a;
        com.bytedance.android.shopping.base.event.c.c(this.a.getSessionId());
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        int r0 = com.bytedance.android.shopping.base.event.c.a;
        com.bytedance.android.shopping.base.event.c.f(this.a.getNativeParams().getFullMode(), this.a.getSessionId(), this.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(k.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        int r0 = com.bytedance.android.shopping.base.event.c.a;
        com.bytedance.android.shopping.base.event.c.g(r2 instanceof k.d.a, this.a.getSessionId());
    }

    public a(AnchorV4Param r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r2;
        this.b = r3;
    }
}
