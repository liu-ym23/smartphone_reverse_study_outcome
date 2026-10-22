package com.bytedance.android.window.shop.holder.footer;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/footer/WindowHybridFooterHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", "Lcom/bytedance/android/window/shop/holder/footer/a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowHybridFooterHolder extends ECLoadMoreViewHolder implements a {
    public FooterStatus o;
    public final WindowFooterStatusView p;
    public final Lazy q;

    public WindowHybridFooterHolder(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FrameLayout r0 = new FrameLayout(r5);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r1 = Unit.INSTANCE;
        super(r0);
        this.o = FooterStatus.LOADING;
        this.p = new WindowFooterStatusView(r5);
        this.q = LazyKt.lazy(new WindowHybridFooterHolder$viewInitializer$2(this));
    }

    @Override // com.bytedance.android.window.shop.holder.footer.a
    public final void J1(FooterStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "newStatus");
        q4(r2);
    }

    public final void q4(FooterStatus r3) {
        Unit r0 = (Unit) this.q.getValue();
        this.o = r3;
        WindowFooterStatusView r1 = this.p;
        int r4 = d.a[r3.ordinal()];
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

    public void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super/*com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder*/.b4(r2, r3, r4);
        q4(this.o);
    }
}
