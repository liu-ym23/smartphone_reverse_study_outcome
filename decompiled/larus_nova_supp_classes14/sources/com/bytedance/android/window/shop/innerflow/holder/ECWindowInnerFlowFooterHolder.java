package com.bytedance.android.window.shop.innerflow.holder;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.holder.footer.WindowFooterStatusView;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import np3.c;
import np3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowFooterHolder;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lcom/bytedance/android/window/shop/innerflow/holder/a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowFooterHolder extends ECShopInnerFlowItemHolder<a> {
    public FooterStatus b;
    public final WindowFooterStatusView c;
    public final Lazy d;

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void U3() {
    }

    public ECWindowInnerFlowFooterHolder(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        QUIManager r0 = new QUIManager();
        FrameLayout r1 = new FrameLayout(r6);
        r1.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r2 = Unit.INSTANCE;
        super(r0, r1);
        this.b = FooterStatus.LOADING;
        WindowFooterStatusView r3 = new WindowFooterStatusView(r6);
        r3.setNoMoreContent(r6.getText(2131896760).toString());
        this.c = r3;
        this.d = LazyKt.lazy(new ECWindowInnerFlowFooterHolder$viewInitializer$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void T3(vp3.b r2) {
        Intrinsics.checkNotNullParameter((a) r2, "vo");
        V3(this.b);
    }

    public final void V3(FooterStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "newStatus");
        Unit r0 = (Unit) this.d.getValue();
        this.b = r3;
        WindowFooterStatusView r1 = this.c;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        d r5 = np3.a.b;
    L13:
        r1.b(r5);
        return;
    L5:
        if (r4 != 2) goto L7;
        r5 = np3.b.b;
        goto L13
    L7:
        if (r4 != 3) goto L10;
        r5 = c.b;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
