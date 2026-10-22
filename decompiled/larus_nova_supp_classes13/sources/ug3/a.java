package ug3;

import android.content.Context;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.lynx.d;
import com.bytedance.android.shopping.anchorv4.voavhs.lynx.e;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.o;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti.l;
import vg3.e0;
import vg3.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e, d {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> a;
    public final j b;
    public final /* synthetic */ d c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void a(com.bytedance.android.shopping.anchorv4.log.c r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        this.c.a(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void b(com.bytedance.android.shopping.anchorv4.log.d r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        Intrinsics.checkNotNullParameter(r3, "identifier");
        this.c.b(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.e
    public final float T() {
        CommonMeta r0 = this.a.d().getData().a().a();
        if (r0 != null) goto L7;
        return 375.0f;
    L7:
        return h73.a.f(r0);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.e
    public final boolean d() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a)).b.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.e
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e0 r0 = (e0) this.b.getService(e0.class);
        if (r0 == null) goto L6;
        r0.u(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.e
    public final p73.c S(p73.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "componentId");
        v r0 = (v) this.b.getService(v.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.S(r3, r4);
    }

    public a(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2, j r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "exposureService");
        this.c = r4;
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.e
    public final l U(Context r9, String r10, Map r11, com.bytedance.android.shopping.anchorv4.voavhs.lynx.c r12, com.bytedance.android.shopping.anchorv4.voavhs.lynx.b r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "initData");
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r13, "callback");
        o r7 = new o(r9, r10, r12, r11, true, r13);
        return this.a.e().D0().p(r7);
    }
}
