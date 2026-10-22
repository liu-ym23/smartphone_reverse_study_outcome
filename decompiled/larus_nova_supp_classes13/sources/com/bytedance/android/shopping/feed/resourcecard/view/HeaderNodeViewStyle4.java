package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle4;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "getMoreContainer", "()Landroid/view/ViewGroup;", "moreContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle4 extends HeaderNodeView {
    public static final /* synthetic */ int e = 0;
    public final ViewGroup c;
    public final TextView d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HeaderNodeViewStyle4 a;
        public final /* synthetic */ Context b;

        public a(HeaderNodeViewStyle4 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            yd3.f r11 = this.a.getHeaderNode();
            if (r11 == null) goto L7;
            yd3.g r12 = r11.c();
            if (r12 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r12.c());
        L7:
            rd3.a r1 = this.a.getAnchorInflowFeedItem();
            if (r1 == null) goto L11;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r1, "button", null, null, null, null, null, 124);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle4(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeViewStyle4(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ViewGroup getMoreContainer() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorInflowFeedItem");
        super.a(r2);
        TextView r3 = this.d;
        yd3.f r0 = getHeaderNode();
        if (r0 == null) goto L7;
        yd3.g r1 = r0.c();
        if (r1 == null) goto L7;
        String r4 = r1.d();
    L8:
        r3.setText(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public HeaderNodeViewStyle4(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560580, this, true);
        ViewGroup r6 = (ViewGroup) findViewById(2131370793);
        this.c = r6;
        this.d = (TextView) findViewById(2131370794);
        r6.setOnClickListener(new a(this, r3));
        float r7 = 12;
        Resources r8 = Resources.getSystem();
        int r9 = MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
        Resources r10 = Resources.getSystem();
        setPadding(r9, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeViewStyle4(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
