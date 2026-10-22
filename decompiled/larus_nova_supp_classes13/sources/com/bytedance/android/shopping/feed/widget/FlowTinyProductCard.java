package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.view.InflowFeedCommentView;
import com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductCard;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductView;", "b", "Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductView;", "getFlowTinyProductView", "()Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductView;", "flowTinyProductView", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "c", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "getBottomBar", "()Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "bottomBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlowTinyProductCard extends FrameLayout {
    public final InflowFeedCommentView a;
    public final FlowTinyProductView b;
    public final InflowFeedBottomBarView c;
    public rd3.a d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FlowTinyProductCard a;
        public final /* synthetic */ Context b;

        public a(FlowTinyProductCard r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            rd3.a r4 = this.a.d;
            if (r4 == null) goto L5;
            FeedProductEventTracker.u(FeedProductEventTracker.a, this.b, r4, "pic", null, false, null, 120);
        L5:
            FeedProductEventTracker.m(FeedProductEventTracker.a, this.a.d, "pic", null, null, null, null, null, 124);
            ProductFeedActionHelper.f(this.b, this.a.d, "click", "click");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FlowTinyProductCard a;
        public final /* synthetic */ Context b;

        public b(FlowTinyProductCard r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            rd3.a r4 = this.a.d;
            if (r4 == null) goto L5;
            FeedProductEventTracker.u(FeedProductEventTracker.a, this.b, r4, "blank", null, false, null, 120);
        L5:
            FeedProductEventTracker.m(FeedProductEventTracker.a, this.a.d, "blank", null, null, null, null, null, 124);
            ProductFeedActionHelper.f(this.b, this.a.d, "click", "click");
        }
    }

    public FlowTinyProductCard(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowTinyProductCard(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final InflowFeedBottomBarView getBottomBar() {
        return this.c;
    }

    public final FlowTinyProductView getFlowTinyProductView() {
        return this.b;
    }

    public FlowTinyProductCard(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560715, this);
        this.a = (InflowFeedCommentView) findViewById(2131388706);
        FlowTinyProductView r5 = (FlowTinyProductView) findViewById(2131388707);
        this.b = r5;
        this.c = (InflowFeedBottomBarView) findViewById(2131388705);
        if (r5 == null) goto L7;
        ECDraweeView r6 = r5.getProductImage();
        if (r6 == null) goto L7;
        r6.setOnClickListener(new a(this, r2));
    L7:
        setOnClickListener(new b(this, r2));
    }

    public /* synthetic */ FlowTinyProductCard(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
