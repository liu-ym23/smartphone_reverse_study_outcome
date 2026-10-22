package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.r1;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yd3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle1;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle1 extends HeaderNodeView {
    public static final /* synthetic */ int g = 0;
    public final TextView c;
    public final ViewGroup d;
    public final ECDraweeView e;
    public final TextView f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HeaderNodeViewStyle1 a;
        public final /* synthetic */ Context b;

        public a(HeaderNodeViewStyle1 r1, Context r2) {
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
            if (r1 == null) goto L10;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r1, "rank_entrance", null, null, null, null, null, 124);
        L10:
            rd3.a r13 = this.a.getAnchorInflowFeedItem();
            if (r13 == null) goto L15;
            yd3.p r14 = r13.i();
            if (r14 == null) goto L15;
            Integer r15 = Integer.valueOf(r14.getType());
        L16:
            if (r15 != null) goto L19;
            return;
        L19:
            if (r15.intValue() != 2) goto L38;
            r1 r16 = new r1();
            r16.a = "product_flow_page";
            rd3.a r2 = this.a.getAnchorInflowFeedItem();
            if (r2 == null) goto L25;
            rd3.o r3 = r2.g();
            if (r3 == null) goto L25;
            String r4 = r3.a();
        L26:
            r16.k = r4;
            rd3.a r5 = this.a.getAnchorInflowFeedItem();
            if (r5 == null) goto L31;
            Promotion r6 = r5.f();
            if (r6 == null) goto L31;
            String r7 = r6.getId();
        L32:
            r16.l = r7;
            rd3.a r8 = this.a.getAnchorInflowFeedItem();
            if (r8 == null) goto L35;
            Integer r9 = Integer.valueOf(r8.f);
        L36:
            r16.c = String.valueOf(r9);
            r16.post(null, null);
            return;
        L35:
            r9 = null;
        L31:
            r7 = null;
        L25:
            r4 = null;
            goto L26
        L38:
            return;
        L15:
            r15 = null;
            goto L16
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle1(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeViewStyle1(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "anchorInflowFeedItem");
        super.a(r3);
        ECDraweeView r4 = this.e;
        yd3.f r0 = getHeaderNode();
        String r1 = null;
        if (r0 == null) goto L7;
        t r2 = r0.d();
        if (r2 == null) goto L7;
        ECUrlModel r5 = r2.b();
    L8:
        y.a(r4, r5);
        TextView r6 = this.c;
        yd3.f r7 = getHeaderNode();
        if (r7 == null) goto L13;
        t r8 = r7.f();
        if (r8 == null) goto L13;
        String r9 = r8.c();
    L14:
        r6.setText(r9);
        TextView r10 = this.f;
        yd3.f r11 = getHeaderNode();
        if (r11 == null) goto L19;
        yd3.g r12 = r11.c();
        if (r12 == null) goto L19;
        r1 = r12.d();
    L19:
        r10.setText(r1);
        return;
    L13:
        r9 = null;
    L7:
        r5 = null;
        goto L8
    }

    public HeaderNodeViewStyle1(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560578, this, true);
        this.c = (TextView) findViewById(2131374307);
        this.e = findViewById(2131374308);
        ViewGroup r6 = (ViewGroup) findViewById(2131370793);
        this.d = r6;
        this.f = (TextView) findViewById(2131370794);
        r6.setOnClickListener(new a(this, r3));
        float r7 = 12;
        Resources r8 = Resources.getSystem();
        int r9 = MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
        Resources r10 = Resources.getSystem();
        setPadding(r9, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeViewStyle1(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
