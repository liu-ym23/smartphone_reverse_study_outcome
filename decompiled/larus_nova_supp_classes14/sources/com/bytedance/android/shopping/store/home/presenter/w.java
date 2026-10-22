package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

    public w(ECShopCroppedStyleRootPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.intValue() > 0) goto L21;
        ECStoreAwemeFeedVideoZoomController r0 = this.a.F;
        if (r0 == null) goto L15;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0.e, r0.g});
        r0.d = r1;
        if (r1 == null) goto L12;
        r1.setDuration(100);
        r1.addUpdateListener(new w3(r0));
    L12:
        ValueAnimator r2 = r0.d;
        if (r2 == null) goto L15;
        r2.start();
    L15:
        int r7 = r6.intValue() * (-1);
        ECShopCroppedStyleRootPresenterV2 r3 = this.a;
        r3.getClass();
        int r4 = com.bytedance.android.shopping.store.home.p.a;
        if (r7 <= ((int) (((Number) r3.q.getValue()).intValue() * 0.35f))) goto L20;
        this.a.Q();
        return;
    L20:
        return;
    }
}
