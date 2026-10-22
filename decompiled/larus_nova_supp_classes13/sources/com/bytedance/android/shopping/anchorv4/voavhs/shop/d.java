package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ AnchorV4ShopAndStoreView a;
    public final /* synthetic */ List b;

    public d(AnchorV4ShopAndStoreView r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RoundedFrameLayout r0 = this.a.Q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMask");
    L5:
        RoundedFrameLayout r2 = this.a.Q;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMask");
    L8:
        ConstraintLayout.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L41;
        ConstraintLayout.LayoutParams r4 = r3;
        MediaBoxElementView r5 = this.a.d;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L13:
        ((ViewGroup.MarginLayoutParams) r4).width = r5.getMeasuredWidth();
        MediaBoxElementView r6 = this.a.d;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L16:
        ((ViewGroup.MarginLayoutParams) r4).height = r6.getMeasuredHeight();
        Unit r7 = Unit.INSTANCE;
        r0.setLayoutParams(r4);
        RoundedFrameLayout r1 = this.a.Q;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMask");
    L19:
        MediaBoxElementView r8 = this.a.d;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L22:
        r1.setRadius(r8.getMeasuredHeight() / 2);
        View r9 = this.a.U;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarBorder");
    L25:
        View r10 = this.a.U;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("shopAvatarBorder");
    L28:
        ConstraintLayout.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L39;
        ConstraintLayout.LayoutParams r12 = r11;
        MediaBoxElementView r13 = this.a.d;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L33:
        ((ViewGroup.MarginLayoutParams) r12).width = r13.getMeasuredWidth();
        MediaBoxElementView r14 = this.a.d;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L36:
        ((ViewGroup.MarginLayoutParams) r12).height = r14.getMeasuredHeight();
        r9.setLayoutParams(r12);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L41:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
