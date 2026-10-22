package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.helper.PdpIndexActionHelper;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements j73.f {
    public final /* synthetic */ PdpDynamicFeatureService a;

    public final PdpSliceLocalCacheHelper M() {
        x r0 = (x) this.a.N1(x.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.M();
    }

    public d(PdpDynamicFeatureService r1) {
        this.a = r1;
    }

    public final void R(List<String> r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ((p73.e) this.a.t.getValue()).b(r2, r3);
    }

    public final boolean t0(String r2, String r3, View r4, com.bytedance.android.ecom.arch.slice.g r5) {
        Intrinsics.checkNotNullParameter(r2, "indexName");
        Intrinsics.checkNotNullParameter(r3, "indexType");
        return ((PdpIndexActionHelper) this.a.u.getValue()).a(r2, r3, r4, r5);
    }
}
