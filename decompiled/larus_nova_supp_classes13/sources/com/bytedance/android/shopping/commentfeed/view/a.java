package com.bytedance.android.shopping.commentfeed.view;

import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements OverScrolledViewPager.a {
    public final /* synthetic */ CommentDetailFragment a;

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void onRefresh() {
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void a() {
        CommentDetailFragment r0 = this.a;
        int r1 = CommentDetailFragment.t;
        CommentListViewModel r2 = r0.S90();
        if (r2 != null) goto L5;
    L6:
        ECStatusView r3 = this.a.p;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L9:
        r3.setVisibility(0);
        oj.b r4 = r3.a;
        if (r4 == null) goto L14;
        r4.d();
        return;
    L14:
        return;
    L5:
        if (r2.getHasMoreComment() != true) goto L6;
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void onLoadMore() {
        ECStatusView r0 = this.a.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L5:
        r0.setVisibility(8);
    }

    public a(CommentDetailFragment r1) {
        this.a = r1;
    }
}
