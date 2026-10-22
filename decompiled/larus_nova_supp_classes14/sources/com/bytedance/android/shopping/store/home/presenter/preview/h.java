package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements vi3.a {
    public final /* synthetic */ ECShopLivePreviewPresenter a;

    public h(ECShopLivePreviewPresenter r1) {
        this.a = r1;
    }

    @Override // vi3.a
    public final void a(ShopContainerType r3, vi3.c r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        int r5 = r4.a() + com.bytedance.android.shopping.extensions.b.b(16);
        View r6 = this.a.r;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L6:
        if ((r6.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L13;
        if (((ViewGroup.MarginLayoutParams) r0).topMargin == r5) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L24;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = r5;
        r6.requestLayout();
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L24:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L14:
        r1 = false;
        goto L15
    }
}
