package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sq3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleTitleHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lsq3/i;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleTitleHolder extends ShopWindowItemHolder<i> {
    public final bp.a q;

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleTitleHolder(bp.a r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerView");
        super(r2);
        this.q = r2;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r5) {
        i r6 = (i) r5;
        Intrinsics.checkNotNullParameter(r6, "vo");
        this.q.getTextView().setText(r6.l);
        Integer r0 = r6.j;
        if (r0 == null) goto L5;
        int r1 = com.bytedance.android.shopping.extensions.b.b(r0);
    L6:
        Integer r7 = r6.k;
        if (r7 == null) goto L9;
        int r8 = com.bytedance.android.shopping.extensions.b.b(r7);
    L10:
        bp.a r2 = this.q;
        r2.setPadding(r2.getPaddingLeft(), r1, this.q.getPaddingRight(), r8);
        return;
    L9:
        r8 = this.q.getPaddingBottom();
        goto L10
    L5:
        r1 = this.q.getPaddingTop();
        goto L6
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r4) {
        return new Rect(0, d.a(16), 0, d.a(12));
    }
}
