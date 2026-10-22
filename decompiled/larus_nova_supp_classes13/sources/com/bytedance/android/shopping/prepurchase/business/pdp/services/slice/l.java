package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.p;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public final /* synthetic */ k a;

    public final p a() {
        j r1 = this.a.h8();
        k r2 = this.a;
        return new p(r1, r2.b, new k.a(r2));
    }

    public final PageFinder b() {
        return this.a.b.a().getPageFinder();
    }

    public final q c() {
        return new q(this.a.b);
    }

    public l(k r1) {
        this.a = r1;
    }
}
