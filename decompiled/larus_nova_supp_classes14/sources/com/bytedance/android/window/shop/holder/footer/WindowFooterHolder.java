package com.bytedance.android.window.shop.holder.footer;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/footer/WindowFooterHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/j;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFooterHolder extends ShopWindowItemHolder<j> {
    public FooterStatus q;
    public final WindowFooterStatusView r;
    public final Lazy s;

    public WindowFooterHolder(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FrameLayout r0 = new FrameLayout(r5);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r1 = Unit.INSTANCE;
        super(r0);
        this.q = FooterStatus.LOADING;
        this.r = new WindowFooterStatusView(r5);
        this.s = LazyKt.lazy(new WindowFooterHolder$viewInitializer$2(this));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r2) {
        Intrinsics.checkNotNullParameter((j) r2, "vo");
        u4(this.q);
    }

    public final void u4(FooterStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "newStatus");
        Unit r0 = (Unit) this.s.getValue();
        this.q = r3;
        WindowFooterStatusView r1 = this.r;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        np3.d r5 = np3.a.b;
    L13:
        r1.b(r5);
        return;
    L5:
        if (r4 != 2) goto L7;
        r5 = np3.b.b;
        goto L13
    L7:
        if (r4 != 3) goto L10;
        r5 = np3.c.b;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
