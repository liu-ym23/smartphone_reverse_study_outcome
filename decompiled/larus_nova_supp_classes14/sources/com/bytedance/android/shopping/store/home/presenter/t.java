package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ s.b a;

    public t(s.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Float r7 = (Float) r6;
        s r0 = this.a.a;
        float r1 = r7.floatValue();
        int r2 = s.E;
        if (r1 >= 0) goto L6;
        r0.getClass();
    L14:
        s r3 = this.a.a;
        if (r7.floatValue() < r3.A) goto L17;
        r3.y().setAlpha(r3.a0(0.5f));
        r3.y().setVisibility(0);
        return;
    L17:
        r3.y().setVisibility(4);
        return;
    L6:
        if (r0.U() == true) goto L14;
        float r4 = r0.a0(r0.A);
        SimpleDraweeView r5 = r0.z;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
    L10:
        r5.setAlpha(r4);
        View r8 = r0.y;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
    L13:
        r8.setAlpha(r4);
        goto L14
    }
}
