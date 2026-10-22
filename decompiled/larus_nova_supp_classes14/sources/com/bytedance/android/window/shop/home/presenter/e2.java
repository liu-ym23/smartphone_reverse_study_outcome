package com.bytedance.android.window.shop.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e2<T> implements Observer {
    public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter.d a;
    public final /* synthetic */ boolean b;

    public e2(ECWindowTopInfoBarEnhancedPresenter.d r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r9) {
        Pair r10 = (Pair) r9;
        ECWindowTopInfoBarEnhancedPresenter r11 = this.a.a;
        int r0 = ECWindowTopInfoBarEnhancedPresenter.C;
        float r12 = r11.Y(r11.w().b(2131370890).f().getHeight());
        if (this.a.a.O().isCroppedStyle() == true) goto L6;
        r12 = ((Interpolator) this.a.a.m.getValue()).getInterpolation(r12);
    L6:
        View r1 = this.a.a.p;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L9:
        r1.setAlpha(r12);
        View r2 = this.a.a.p;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L12:
        int r3 = 0;
        if (r12 <= 0) goto L15;
        int r13 = 0;
    L16:
        r2.setVisibility(r13);
        View r14 = this.a.a.o;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("topBarContainer");
    L19:
        com.bytedance.android.ec.window.base.utils.c.d(r14, new ColorDrawable(0));
        if (this.b == false) goto L30;
        float r15 = this.a.a.Z(com.bytedance.android.shopping.extensions.b.b(74));
        ImageView r4 = this.a.a.t;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
    L25:
        if (r15 <= 0.1d) goto L28;
        r3 = 8;
    L28:
        r4.setVisibility(r3);
        return;
    L30:
        return;
    L15:
        r13 = 8;
        goto L16
    }
}
