package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.ECShopGroupAnimation;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t3 implements ECShopGroupAnimation.a {
    public final /* synthetic */ ECShopTopTabPresenter.e a;

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final int b() {
        return com.bytedance.android.shopping.extensions.b.b(0);
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final int a() {
        return com.bytedance.android.shopping.extensions.b.b(36);
    }

    public t3(ECShopTopTabPresenter.e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final void c(ECShopGroupAnimation.Direction r3) {
        Intrinsics.checkNotNullParameter(r3, "direction");
        ECShopTopTabPresenter r0 = this.a.a;
        r0.A = false;
        if (r3 != ECShopGroupAnimation.Direction.REVERSE) goto L9;
        ECTabLayout r4 = r0.v;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L7:
        r4.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final void onChange(int r2, float r3) {
        ECTabLayout r4 = this.a.a.v;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L5:
        com.bytedance.android.shopping.store.hybridproduct.module.p.a(r4, r2);
    }
}
