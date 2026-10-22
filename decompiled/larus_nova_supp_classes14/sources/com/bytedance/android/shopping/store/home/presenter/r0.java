package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0<T> implements Observer {
    public final /* synthetic */ ECShopLinkageHeaderVideoPresenter a;

    public r0(ECShopLinkageHeaderVideoPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        ECShopLinkageHeaderVideoPresenter r0 = this.a;
        if (((Float) r5).floatValue() <= 0) goto L5;
        int r6 = ECShopLinkageHeaderVideoPresenter.K;
        r0.getClass();
        return;
    L5:
        Pair<Integer, Integer> r7 = r0.u;
        if (r7 == null) goto L30;
        Integer r2 = (Integer) r0.T().getSlideDistance().getValue();
        if (r2 == null) goto L29;
        int r3 = Integer.valueOf(r2.intValue() * (-1)).intValue();
        if (r3 >= 0) goto L14;
        return;
    L14:
        if (r3 >= ((Number) r7.getSecond()).intValue()) goto L19;
        if (r0.H == false) goto L19;
        r0.H = false;
    L19:
        if (r3 > ((Number) r7.getSecond()).intValue()) goto L21;
    L23:
        ViewGroup r8 = r0.v;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L26:
        wg.a.d(r8, th.a.e(r0.u().c(), true).getResources().getDimensionPixelSize(2131166417) + r3);
        return;
    L21:
        if (r0.H == true) goto L23;
        r0.q0(1);
        goto L23
    L29:
        return;
    }
}
