package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.DataFetchLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService;
import kotlin.jvm.internal.Intrinsics;
import n83.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends pg3.a<e, PdpDataStore> {
    public final AnchorV4Param a;
    public final boolean b;
    public final u c;
    public final m d;
    public final boolean e;

    @Override // pg3.c
    public final wg3.a b() {
        return new wg3.a(this.a, this.e);
    }

    @Override // pg3.c
    public final e d() {
        return new e(this.a, new a(this.b));
    }

    @Override // pg3.c
    public final PdpDynamicFeatureService e() {
        return new PdpDynamicFeatureService();
    }

    @Override // pg3.c
    public final PdpRootComponent f() {
        if (this.a.getNativeParams().getFullMode() == false) goto L5;
        PdpRootComponent.a r0 = new b();
    L7:
        return new PdpRootComponent(r0, this.c, this.d);
    L5:
        r0 = new c(this.a);
        goto L7
    }

    @Override // pg3.c
    public final PdpDataFetchService a(DataFetchLifecycleDispatcher r3) {
        Intrinsics.checkNotNullParameter(r3, "contentQueryListener");
        return new PdpDataFetchService(r3, this.c);
    }

    @Override // pg3.c
    public final xg3.d c(RenderLifecycleDispatcher r3) {
        Intrinsics.checkNotNullParameter(r3, "renderListener");
        return new xg3.d(r3, new f(this));
    }

    public g(AnchorV4Param r2, boolean r3, u r4, m r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
