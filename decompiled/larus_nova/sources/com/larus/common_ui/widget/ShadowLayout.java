package com.larus.common_ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z19.w;
import z19.x;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002NOB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u00020\nJ\u0018\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J0\u00106\u001a\u0002012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0014J\u0012\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\nH\u0016J\u001c\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J$\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\n2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\"\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0016J\u0012\u0010E\u001a\u00020F2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020BH\u0014J\b\u0010H\u001a\u00020IH\u0014J\u001a\u0010J\u001a\u0002012\b\u0010K\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\nH\u0002J\"\u0010L\u001a\u0002012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010M\u001a\u000201H\u0002R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R$\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010+\u001a\u00060,R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b-\u0010.¨\u0006P"}, d2 = {"Lcom/larus/common_ui/widget/ShadowLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "shadowSize", "getShadowSize", "()I", "setShadowSize", "(I)V", "Landroid/graphics/Point;", "shadowOffset", "getShadowOffset", "()Landroid/graphics/Point;", "setShadowOffset", "(Landroid/graphics/Point;)V", "shadowColor", "getShadowColor", "setShadowColor", "shadowRadius", "getShadowRadius", "setShadowRadius", "shadowStrokeWidth", "getShadowStrokeWidth", "setShadowStrokeWidth", "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", "shadowRect", "Landroid/graphics/RectF;", "shadowView", "Lcom/larus/common_ui/widget/ShadowLayout$UXShadowView;", "getShadowView", "()Lcom/larus/common_ui/widget/ShadowLayout$UXShadowView;", "shadowView$delegate", "applyStyle", "", "styleId", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "generateLayoutParams", "Lcom/larus/common_ui/widget/ShadowLayout$LayoutParams;", "lp", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "checkChildrenCountBeforeAddView", "view", "applyAttrs", "setUpPaint", "LayoutParams", "UXShadowView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowLayout extends ViewGroup {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f328524i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Point f328526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f328529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f328530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f328531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f328532h;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006,"}, d2 = {"Lcom/larus/common_ui/widget/ShadowLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "hasLeftMarginSet", "", "getHasLeftMarginSet$common_ui_mainlandRelease", "()Z", "setHasLeftMarginSet$common_ui_mainlandRelease", "(Z)V", "hasTopMarginSet", "getHasTopMarginSet$common_ui_mainlandRelease", "setHasTopMarginSet$common_ui_mainlandRelease", "hasRightMarginSet", "getHasRightMarginSet$common_ui_mainlandRelease", "setHasRightMarginSet$common_ui_mainlandRelease", "hasBottomMarginSet", "getHasBottomMarginSet$common_ui_mainlandRelease", "setHasBottomMarginSet$common_ui_mainlandRelease", "applyAttrs", "", PerfLog.PARAM_KEY_CONTEXT_ID, "setMargins", "left", "top", "right", "bottom", "setMarginStart", "start", "setMarginEnd", "end", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f328533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f328534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f328535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f328536d;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginEnd(int r100) {
            super.setMarginEnd(r100);
            if (getLayoutDirection() != 0) goto L5;
            this.f328535c = true;
            return;
        L5:
            this.f328533a = true;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginStart(int r100) {
            super.setMarginStart(r100);
            if (getLayoutDirection() != 0) goto L5;
            this.f328533a = true;
            return;
        L5:
            this.f328535c = true;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical});
            if (r102.getDimensionPixelSize(0, -1) < 0) goto L5;
            this.f328534b = true;
            this.f328533a = true;
            this.f328535c = true;
            this.f328536d = true;
        L32:
            r102.recycle();
            return;
        L5:
            int r103 = r102.getDimensionPixelSize(7, -1);
            int r104 = r102.getDimensionPixelSize(8, -1);
            if (r103 < 0) goto L9;
            this.f328533a = true;
            this.f328535c = true;
        L14:
            if (r104 < 0) goto L17;
            this.f328534b = true;
            this.f328536d = true;
            goto L32
        L17:
            if (r102.getDimensionPixelSize(2, -1) < 0) goto L20;
            this.f328534b = true;
        L20:
            if (r102.getDimensionPixelSize(4, -1) < 0) goto L22;
            this.f328536d = true;
        L22:
            int r105 = r102.getDimensionPixelSize(5, -1);
            int r106 = r102.getDimensionPixelSize(6, -1);
            if (getLayoutDirection() != 0) goto L28;
            if (r105 < 0) goto L26;
            this.f328533a = true;
        L26:
            if (r106 < 0) goto L32;
            this.f328535c = true;
            goto L32
        L28:
            if (r105 < 0) goto L30;
            this.f328535c = true;
        L30:
            if (r106 < 0) goto L32;
            this.f328533a = true;
            goto L32
        L9:
            if (r102.getDimensionPixelSize(1, -1) < 0) goto L12;
            this.f328533a = true;
        L12:
            if (r102.getDimensionPixelSize(3, -1) < 0) goto L14;
            this.f328535c = true;
            goto L14
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMargins(int r100, int r101, int r102, int r103) {
            super.setMargins(r100, r101, r102, r103);
            this.f328534b = true;
            this.f328533a = true;
            this.f328535c = true;
            this.f328536d = true;
        }
    }

    public final class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShadowLayout f328537a;

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            if (this.f328537a.getChildAt(1) == null) goto L8;
            ShadowLayout r101 = this.f328537a;
            if (r101.getShadowStrokeWidth() <= 0) goto L7;
            ShadowLayout.a(r101).setStyle(Paint.Style.STROKE);
            ShadowLayout.a(r101).setStrokeWidth(r101.getShadowStrokeWidth());
        L7:
            r100.drawRoundRect(r101.f328531g, r101.getShadowRadius(), r101.getShadowRadius(), ShadowLayout.a(r101));
        L8:
            super.onDraw(r100);
        }

        public a(ShadowLayout r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f328537a = r100;
            super(r101);
            if (Build.VERSION.SDK_INT >= 28) goto L6;
            setLayerType(1, null);
            return;
        }
    }

    private final Paint getShadowPaint() {
        return (Paint) this.f328530f.getValue();
    }

    private final a getShadowView() {
        return (a) this.f328532h.getValue();
    }

    public final void c() {
        float r100 = this.f328525a;
        int r101 = this.f328527c;
        Paint r102 = getShadowPaint();
        Point r103 = this.f328526b;
        r102.setShadowLayer(r100, r103.x, r103.y, r101);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public final int getShadowColor() {
        return this.f328527c;
    }

    public final Point getShadowOffset() {
        return this.f328526b;
    }

    public final int getShadowRadius() {
        return this.f328528d;
    }

    public final int getShadowSize() {
        return this.f328525a;
    }

    public final int getShadowStrokeWidth() {
        return this.f328529e;
    }

    public ShadowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ Paint a(ShadowLayout r100) {
        return r100.getShadowPaint();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        b(r100, getChildCount());
        super.addView(r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
        return new LayoutParams(r100);
    }

    public final void setShadowColor(int r100) {
        if (r100 == this.f328527c) goto L6;
        this.f328527c = r100;
        c();
        invalidate();
        getShadowView().invalidate();
        return;
    }

    public final void setShadowOffset(Point r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(r100, this.f328526b) == true) goto L6;
        this.f328526b = r100;
        c();
        requestLayout();
        getShadowView().requestLayout();
        return;
    }

    public final void setShadowRadius(int r100) {
        this.f328528d = r100;
        invalidate();
        getShadowView().invalidate();
    }

    public final void setShadowSize(int r100) {
        if (r100 == this.f328525a) goto L6;
        this.f328525a = r100;
        c();
        requestLayout();
        getShadowView().requestLayout();
        return;
    }

    public final void setShadowStrokeWidth(int r100) {
        this.f328529e = r100;
        invalidate();
        getShadowView().invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public ShadowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        b(r100, getChildCount());
        super.addView(r100, r101);
    }

    public final void b(View r100, int r101) {
        boolean r102 = true;
        if (getChildCount() >= 2) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L18;
        if (r101 != 0) goto L13;
        if (r101 == 0) goto L10;
    L12:
        r102 = false;
        goto L13
    L10:
        if ((r100 instanceof a) == false) goto L12;
    L13:
        if (r102 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("Must not add view at 0 in UXShadowLayout!".toString());
    L18:
        throw new IllegalArgumentException("UXShadowLayout can host only one direct child".toString());
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        View r100 = getChildAt(1);
        if (r100 == null) goto L21;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.common_ui.widget.ShadowLayout.LayoutParams");
        LayoutParams r102 = (LayoutParams) r101;
        int r103 = 0;
        if (r102.f328534b == false) goto L7;
        int r104 = 0;
    L8:
        int r105 = r104 + 0;
        if (r102.f328536d == false) goto L11;
        int r106 = 0;
    L12:
        int r107 = r105 + r106;
        if (r102.f328533a == false) goto L15;
        int r108 = 0;
    L16:
        int r109 = r108 + 0;
        if (r102.f328535c == true) goto L20;
        r103 = Math.max(0, this.f328525a + this.f328526b.x);
    L20:
        int r112 = r109 + r103;
        measureChildWithMargins(r100, r110, r112, r111, r107);
        int r113 = r100.getMeasuredWidth();
        int r114 = r100.getMeasuredHeight();
        setMeasuredDimension(((((r113 + ((ViewGroup.MarginLayoutParams) r102).leftMargin) + ((ViewGroup.MarginLayoutParams) r102).rightMargin) + getPaddingLeft()) + getPaddingRight()) + r112, ((((r114 + ((ViewGroup.MarginLayoutParams) r102).topMargin) + ((ViewGroup.MarginLayoutParams) r102).bottomMargin) + getPaddingTop()) + getPaddingBottom()) + r107);
        goto L21
    L15:
        r108 = Math.max(0, this.f328525a - this.f328526b.x);
        goto L16
    L11:
        r106 = Math.max(0, this.f328525a + this.f328526b.y);
        goto L12
    L7:
        r104 = Math.max(0, this.f328525a - this.f328526b.y);
    L21:
        getShadowView().measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101) {
        b(r100, r101);
        super.addView(r100, r101);
    }

    public ShadowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, com.larus.nova.R.style.larus_Shadow_None);
        this.f328526b = new Point(0, 0);
        this.f328530f = LazyKt.lazy(new w());
        this.f328531g = new RectF();
        this.f328532h = LazyKt.lazy(new x(this));
        addView(getShadowView(), 0, new LayoutParams(-1, -1));
        c();
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, com.larus.nova.R.attr.borderColor, com.larus.nova.R.attr.borderWidth, com.larus.nova.R.attr.bottomDividerColor, com.larus.nova.R.attr.bottomDividerHeight, com.larus.nova.R.attr.bottomDividerInsetLeft, com.larus.nova.R.attr.bottomDividerInsetRight, com.larus.nova.R.attr.clickable, com.larus.nova.R.attr.hideRadiusSide, com.larus.nova.R.attr.hl_angle, com.larus.nova.R.attr.hl_centerColor, com.larus.nova.R.attr.hl_cornerRadius, com.larus.nova.R.attr.hl_cornerRadius_leftBottom, com.larus.nova.R.attr.hl_cornerRadius_leftTop, com.larus.nova.R.attr.hl_cornerRadius_rightBottom, com.larus.nova.R.attr.hl_cornerRadius_rightTop, com.larus.nova.R.attr.hl_endColor, com.larus.nova.R.attr.hl_layoutBackground, com.larus.nova.R.attr.hl_layoutBackground_clickFalse, com.larus.nova.R.attr.hl_layoutBackground_selected, com.larus.nova.R.attr.hl_shadowColor, com.larus.nova.R.attr.hl_shadowHidden, com.larus.nova.R.attr.hl_shadowHiddenBottom, com.larus.nova.R.attr.hl_shadowHiddenLeft, com.larus.nova.R.attr.hl_shadowHiddenRight, com.larus.nova.R.attr.hl_shadowHiddenTop, com.larus.nova.R.attr.hl_shadowLimit, com.larus.nova.R.attr.hl_shadowOffsetX, com.larus.nova.R.attr.hl_shadowOffsetY, com.larus.nova.R.attr.hl_shadowSymmetry, com.larus.nova.R.attr.hl_shapeMode, com.larus.nova.R.attr.hl_startColor, com.larus.nova.R.attr.hl_strokeColor, com.larus.nova.R.attr.hl_strokeColor_true, com.larus.nova.R.attr.hl_strokeWith, com.larus.nova.R.attr.hl_stroke_dashGap, com.larus.nova.R.attr.hl_stroke_dashWidth, com.larus.nova.R.attr.leftDividerColor, com.larus.nova.R.attr.leftDividerInsetBottom, com.larus.nova.R.attr.leftDividerInsetTop, com.larus.nova.R.attr.leftDividerWidth, com.larus.nova.R.attr.outerNormalColor, com.larus.nova.R.attr.outlineExcludePadding, com.larus.nova.R.attr.outlineInsetBottom, com.larus.nova.R.attr.outlineInsetLeft, com.larus.nova.R.attr.outlineInsetRight, com.larus.nova.R.attr.outlineInsetTop, com.larus.nova.R.attr.radius, com.larus.nova.R.attr.rightDividerColor, com.larus.nova.R.attr.rightDividerInsetBottom, com.larus.nova.R.attr.rightDividerInsetTop, com.larus.nova.R.attr.rightDividerWidth, com.larus.nova.R.attr.shadowAlpha, com.larus.nova.R.attr.shadowElevation, com.larus.nova.R.attr.showBorderOnlyBeforeL, com.larus.nova.R.attr.topDividerColor, com.larus.nova.R.attr.topDividerHeight, com.larus.nova.R.attr.topDividerInsetLeft, com.larus.nova.R.attr.topDividerInsetRight, com.larus.nova.R.attr.useThemeGeneralShadowElevation, com.larus.nova.R.attr.ux_shadow_color, com.larus.nova.R.attr.ux_shadow_offset_x, com.larus.nova.R.attr.ux_shadow_offset_y, com.larus.nova.R.attr.ux_shadow_radius, com.larus.nova.R.attr.ux_shadow_size, com.larus.nova.R.attr.ux_shadow_strokeWidth}, r102, com.larus.nova.R.style.larus_Shadow_None);
        setShadowSize(r103.getDimensionPixelSize(67, 0));
        setShadowOffset(new Point(r103.getDimensionPixelSize(64, 0), r103.getDimensionPixelSize(65, 0)));
        setShadowColor(r103.getColor(63, this.f328527c));
        setShadowRadius(r103.getDimensionPixelSize(66, 0));
        setShadowStrokeWidth(r103.getDimensionPixelSize(68, 0));
        r103.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        b(r100, getChildCount());
        super.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        b(r100, r101);
        super.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        r105.layout(0, 0, r105.getMeasuredWidth(), r105.getMeasuredHeight());
        View r106 = getChildAt(1);
        if (r106 == null) goto L17;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.larus.common_ui.widget.ShadowLayout.LayoutParams");
        LayoutParams r108 = (LayoutParams) r107;
        if (r108.f328534b == false) goto L7;
        int r109 = getPaddingTop();
        int r110 = ((ViewGroup.MarginLayoutParams) r108).topMargin;
    L8:
        int r111 = r109 + r110;
        if (r108.f328533a == false) goto L11;
        int r112 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r108).leftMargin;
    L12:
        r106.layout(r112, r111, r106.getMeasuredWidth() + r112, r106.getMeasuredHeight() + r111);
        int r113 = this.f328529e;
        if (r113 <= 0) goto L15;
        float r114 = r112;
        float r115 = r111;
        this.f328531g.set((r113 / 2) + r114, (r113 / 2) + r115, (r114 + r106.getMeasuredWidth()) - (this.f328529e / 2), (r115 + r106.getMeasuredHeight()) - (this.f328529e / 2));
        return;
    L15:
        float r116 = r112;
        float r117 = r111;
        this.f328531g.set(r116, r117, r106.getMeasuredWidth() + r116, r106.getMeasuredHeight() + r117);
        return;
    L11:
        r112 = Math.max(0, this.f328525a - this.f328526b.x) + getPaddingLeft();
        goto L12
    L7:
        r109 = getPaddingTop();
        r110 = Math.max(0, this.f328525a - this.f328526b.y);
        goto L8
    }
}
