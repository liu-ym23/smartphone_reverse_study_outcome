package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.shopping.deepfeed.data.api.DeepFeedProductCouponApi;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.deepfeed.action.c {
    public final /* synthetic */ AbsDeepFeedProductVH a;
    public final /* synthetic */ InFeedProductV2 b;

    public d(AbsDeepFeedProductVH r1, InFeedProductV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.c
    public final void a(InFeedProductV2 r5, he3.l r6) {
        Intrinsics.checkNotNullParameter(r5, "product");
        Intrinsics.checkNotNullParameter(r6, "coupon");
        if (Intrinsics.areEqual(r5, this.b) == false) goto L11;
        Long r7 = r6.a();
        DeepFeedProductCouponApi r0 = com.bytedance.android.shopping.deepfeed.utlis.e.a;
        if (r7 != null) goto L8;
        return;
    L8:
        if (r7.longValue() != 2) goto L12;
        AbsDeepFeedProductVH r8 = this.a;
        r8.y4(r6, r8.P);
        return;
    L12:
        return;
    }
}
