package com.bytedance.android.shopping.deepfeed.slice.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import bd3.c;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.b;
import com.bytedance.android.shopping.deepfeed.slice.service.d;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressBar;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressTextLayout;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/indicator/DeepFeedSlcIndicatorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "state", "", "setPlayState", "fill", "setFillCurrent", "", "totalDuration", "setTotalDuration", "", "count", "setup", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcIndicatorView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final ProductCardProgressIndicator a;
    public final VideoProgressTextLayout b;
    public int c;
    public String d;
    public final VideoProgressBar e;
    public c f;
    public SlcTemplateContext g;

    public static final class a implements fd3.a {
        public final /* synthetic */ DeepFeedSlcIndicatorView a;

        @Override // fd3.a
        public final void onDragEnd() {
            DeepFeedSlcIndicatorView r0 = this.a;
            ExtensionsKt.gone(r0.b);
            b r1 = r0.R5();
            if (r1 == null) goto L5;
            r1.M(MapsKt.mapOf(TuplesKt.to("hidden_search", Boolean.FALSE)));
        L5:
            b r2 = r0.R5();
            if (r2 == null) goto L9;
            r2.Q();
            return;
        }

        @Override // fd3.a
        public final void onDragStart() {
            DeepFeedSlcIndicatorView r0 = this.a;
            r0.a.setVisibility(4);
            r0.e.setVisibility(0);
            r0.b.setVisibility(0);
            b r1 = r0.R5();
            if (r1 == null) goto L5;
            r1.M(MapsKt.mapOf(TuplesKt.to("hidden_search", Boolean.TRUE)));
        L5:
            float r2 = r0.e.getDragProgress();
            VideoProgressTextLayout r3 = r0.b;
            int r4 = r0.c;
            r3.a.setText(VideoProgressTextLayout.a((int) (r2 * r4)));
            r3.b.setText(VideoProgressTextLayout.a(r4));
        }

        public a(DeepFeedSlcIndicatorView r1) {
            this.a = r1;
        }

        @Override // fd3.a
        public final void a(float r4) {
            SlcTemplateContext r0 = this.a.g;
            d r1 = null;
            Object r2 = null;
            if (r0 == null) goto L9;
            Object r3 = r0.o(d.class);
            if ((r3 instanceof d) == false) goto L8;
            r2 = r3;
        L8:
            r1 = (d) r2;
        L9:
            if (r1 == null) goto L12;
            r1.b(r4 * 100);
            return;
        }

        @Override // fd3.a
        public final void b(float r4) {
            DeepFeedSlcIndicatorView r0 = this.a;
            int r1 = DeepFeedSlcIndicatorView.h;
            VideoProgressTextLayout r2 = r0.b;
            int r3 = r0.c;
            r2.a.setText(VideoProgressTextLayout.a((int) (r4 * r3)));
            r2.b.setText(VideoProgressTextLayout.a(r3));
        }

        @Override // fd3.a
        public final void c(float r3) {
            DeepFeedSlcIndicatorView r0 = this.a;
            int r1 = DeepFeedSlcIndicatorView.h;
            r0.getClass();
            this.a.b.setAlpha(r3);
            this.a.invalidate();
        }
    }

    public DeepFeedSlcIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedSlcIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setPlayState(boolean r1) {
    }

    public final b R5() {
        SlcTemplateContext r0 = this.g;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(b.class);
        if ((r2 instanceof b) == false) goto L9;
        r1 = r2;
    L9:
        return (b) r1;
    L10:
        return null;
    }

    public final void S5() {
        ExtensionsKt.gone(this.b);
        this.e.c(0.0f);
        setPlayState(false);
        this.a.b(0, 0.0f);
    }

    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        boolean r1 = false;
        if (Intrinsics.areEqual(this.d, "video") == false) goto L5;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L19;
        if (this.e.a(r5) == false) goto L19;
        return true;
    L19:
        if (this.e.getVisibility() != 0) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L26;
        if (this.e.a(r5) == false) goto L26;
        return true;
    L26:
        return super/*android.view.ViewGroup*/.onTouchEvent(r5);
    L5:
        if (Intrinsics.areEqual(this.d, "mix") == true) goto L7;
    L12:
        r0 = false;
        goto L14
    L7:
        if (this.a.i != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L9:
        r2 = false;
        goto L10
    }

    public final void setFillCurrent(boolean r2) {
        this.a.setFillCurrent(r2);
    }

    public final void setTotalDuration(long r3) {
        this.c = (int) (r3 / ((long) 1000));
    }

    public final void setup(int r2) {
        this.a.setup(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedSlcIndicatorView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        ProductCardProgressIndicator r14 = new ProductCardProgressIndicator(r11, null, 6, 0);
        this.a = r14;
        VideoProgressTextLayout r2 = new VideoProgressTextLayout(r11, null, 6, 0);
        r2.setAlpha(0.0f);
        Unit r0 = Unit.INSTANCE;
        this.b = r2;
        this.d = "image";
        VideoProgressBar r1 = new VideoProgressBar(r11, null, 4, 0);
        a r15 = new a(this);
        Intrinsics.checkNotNullParameter(r15, "callback");
        r1.j = r15;
        r1.k = true;
        r1.l = null;
        this.e = r1;
        this.f = new c("", 0, 0, "", 2.0d);
        r14.setId(ViewGroup.generateViewId());
        r1.setId(ViewGroup.generateViewId());
        r2.setId(ViewGroup.generateViewId());
        int r16 = com.bytedance.android.ec.hybrid.list.util.c.a;
        ConstraintLayout.LayoutParams r17 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(2));
        r17.topToTop = 0;
        r17.bottomToBottom = 0;
        r17.startToStart = 0;
        r17.endToEnd = 0;
        addView(r14, r17);
        ConstraintLayout.LayoutParams r18 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(2));
        r18.topToTop = 0;
        r18.bottomToBottom = 0;
        r18.startToStart = 0;
        r18.endToEnd = 0;
        addView(r1, r18);
        ConstraintLayout.LayoutParams r19 = new ConstraintLayout.LayoutParams(-1, -2);
        r19.bottomToTop = r1.getId();
        r19.startToStart = 0;
        r19.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) r19).bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.d(12);
        addView(r2, r19);
        setClipChildren(false);
        S5();
    }

    public /* synthetic */ DeepFeedSlcIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
