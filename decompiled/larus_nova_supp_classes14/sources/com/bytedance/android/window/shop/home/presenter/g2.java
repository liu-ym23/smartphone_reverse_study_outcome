package com.bytedance.android.window.shop.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g2<T> implements Observer {
    public final /* synthetic */ ECWindowTopInfoBarPresenter.b a;
    public final /* synthetic */ boolean b;

    public g2(ECWindowTopInfoBarPresenter.b r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r9) {
        Pair r10 = (Pair) r9;
        ECWindowTopInfoBarPresenter r11 = this.a.a;
        int r0 = ECWindowTopInfoBarPresenter.u;
        float r12 = r11.Y(r11.w().b(2131370890).f().getHeight());
        View r1 = this.a.a.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L5:
        r1.setAlpha(r12);
        View r2 = this.a.a.o;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L8:
        int r3 = 0;
        if (r12 <= 0) goto L11;
        int r13 = 0;
    L12:
        r2.setVisibility(r13);
        View r14 = this.a.a.n;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("topBarContainer");
    L15:
        com.bytedance.android.ec.window.base.utils.c.d(r14, new ColorDrawable(0));
        if (this.b == false) goto L26;
        float r15 = this.a.a.Z(com.bytedance.android.shopping.extensions.b.b(74));
        ImageView r4 = this.a.a.s;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
    L21:
        if (r15 <= 0.1d) goto L24;
        r3 = 8;
    L24:
        r4.setVisibility(r3);
        return;
    L26:
        return;
    L11:
        r13 = 8;
        goto L12
    }
}
