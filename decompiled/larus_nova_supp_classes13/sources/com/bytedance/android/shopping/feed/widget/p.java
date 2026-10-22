package com.bytedance.android.shopping.feed.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.widget.banner.BannerRecyclerView;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ MainProductCardDetailView a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int r0 = this.a.getMeasuredHeight();
        int r1 = this.a.getMeasuredWidth();
        n1.i.getClass();
        int r2 = n1.a.b() - r0;
        int r3 = UnitExtensionKt.dp2px(40);
        if (r2 >= r3) goto L34;
        MainProductCardDetailView r4 = this.a;
        int r5 = r1 - (r3 - r2);
        BaseCardHeaderView r6 = r4.getCardHeaderView();
        View r7 = null;
        if (r6 == null) goto L14;
        VideoProductFeedBanner r8 = r6.getVideoProductFeedBanner();
        if (r8 == null) goto L14;
        RecyclerView.Adapter<BannerHolder> r9 = r8.b;
        if ((r9 instanceof MainCardImageBannerAdapter) == true) goto L11;
        r9 = null;
    L11:
        MainCardImageBannerAdapter r10 = (MainCardImageBannerAdapter) r9;
        if (r10 == null) goto L14;
        r10.f = Integer.valueOf(r5);
    L14:
        BaseCardHeaderView r11 = r4.getCardHeaderView();
        if (r11 == null) goto L23;
        VideoProductFeedBanner r12 = r11.getVideoProductFeedBanner();
        if (r12 == null) goto L23;
        BannerRecyclerView r13 = r12.getViewPager();
        if (r13 == null) goto L23;
        View r14 = r13.getChildAt(0);
        if (r14 == null) goto L23;
        r7 = r14.findViewById(2131375013);
    L23:
        if (r7 == null) goto L27;
        ViewGroup.LayoutParams r15 = r7.getLayoutParams();
        if (r15 == null) goto L27;
        r15.width = r5;
    L27:
        if (r7 == null) goto L31;
        ViewGroup.LayoutParams r16 = r7.getLayoutParams();
        if (r16 == null) goto L31;
        r16.height = r5;
    L31:
        if (r7 == null) goto L35;
        r7.requestLayout();
        return;
    L35:
        return;
    }

    public p(MainProductCardDetailView r1) {
        this.a = r1;
    }
}
