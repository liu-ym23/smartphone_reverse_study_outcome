package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w0<T> implements Observer {
    public final /* synthetic */ ECShopLinkageHeaderVideoPresenter.b a;

    public w0(ECShopLinkageHeaderVideoPresenter.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Float r5 = (Float) r4;
        ECShopLinkageHeaderVideoPresenter r6 = this.a.a;
        int r0 = ECShopLinkageHeaderVideoPresenter.K;
        if (r6.Z() < 1.0f) goto L5;
        int r1 = 4;
    L6:
        ViewGroup r2 = r6.v;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L10:
        if (r2.getVisibility() == r1) goto L15;
        ViewGroup r3 = r6.v;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L14:
        r3.setVisibility(r1);
    L15:
        ViewGroup r7 = r6.w;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L19:
        if (r7.getVisibility() == r1) goto L24;
        ViewGroup r8 = r6.w;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L23:
        r8.setVisibility(r1);
    L24:
        if (r1 != 0) goto L26;
        r6.T().getVideoManager().h();
        return;
    L26:
        r6.T().getVideoManager().e();
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
