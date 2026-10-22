package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import com.bytedance.android.shopping.store.home.ECShopGroupAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements ECShopGroupAnimation.a {
    public final /* synthetic */ ECShopSortBarAndFilterPresenter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final int b() {
        return com.bytedance.android.shopping.extensions.b.b(0);
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final int a() {
        if (this.b <= 0) goto L9;
        if (Intrinsics.areEqual((Boolean) this.a.h.isBrandShop().getValue(), Boolean.TRUE) == false) goto L14;
        return com.bytedance.android.shopping.extensions.b.b(72);
    L14:
        return com.bytedance.android.shopping.extensions.b.b(80);
    L9:
        if (Intrinsics.areEqual((Boolean) this.a.h.isBrandShop().getValue(), Boolean.TRUE) == false) goto L12;
        return com.bytedance.android.shopping.extensions.b.b(40);
    L12:
        return com.bytedance.android.shopping.extensions.b.b(36);
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final void c(ECShopGroupAnimation.Direction r4) {
        Intrinsics.checkNotNullParameter(r4, "direction");
        if (r4 != ECShopGroupAnimation.Direction.REVERSE) goto L6;
        ((View) this.a.g.getValue()).setPadding(0, 0, 0, this.c);
    L6:
        if (r4 != ECShopGroupAnimation.Direction.FORWARD) goto L9;
        ((View) this.a.g.getValue()).setPadding(0, 0, 0, 0);
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
    public final void onChange(int r4, float r5) {
        ((View) this.a.g.getValue()).setPadding(0, 0, 0, (int) (this.c * (1 - r5)));
        p.a((View) this.a.g.getValue(), RangesKt.coerceAtLeast(r4, this.c));
    }

    public q(ECShopSortBarAndFilterPresenter r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
