package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004#$%&B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR*\u0010\u0017\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "", "iconResId", "", "setStartDotDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "value", FaceService.girlLabel, "I", "getMaxVisibleDots", "()I", "setMaxVisibleDots", "(I)V", "maxVisibleDots", "G", "getSizeStyle", "setSizeStyle", "sizeStyle", FaceService.neutralLabel, "getSelectedDotColor", "setSelectedDotColor", "selectedDotColor", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCarouselIndicator extends OBaseIndicator {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f401235J = 0;
    public final ArrayDeque<IndicatorDotView> A;
    public boolean B;
    public boolean C;
    public boolean D;
    public IndicatorImageDotView E;
    public int F;
    public int G;
    public int H;
    public final ArgbEvaluator I;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public IndicatorGroupLayout f401236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f401237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IndicatorAnimator f401238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<c> f401239z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f401240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f401241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401242c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f401240a), Float.valueOf(r101.f401240a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f401241b), Float.valueOf(r101.f401241b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f401242c), Float.valueOf(r101.f401242c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((Float.floatToIntBits(this.f401240a) * 31) + Float.floatToIntBits(this.f401241b)) * 31) + Float.floatToIntBits(this.f401242c);
        }

        public final String toString() {
            return "DotLayoutProfile(width=" + this.f401240a + ", height=" + this.f401241b + ", spacing=" + this.f401242c + ')';
        }

        public b(float r100, float r101, float r102) {
            this.f401240a = r100;
            this.f401241b = r101;
            this.f401242c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f401243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f401244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.obric.oui.indicator.e f401245c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f401243a, r101.f401243a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f401244b, r101.f401244b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f401245c, r101.f401245c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f401243a.hashCode() * 31) + this.f401244b.hashCode()) * 31) + this.f401245c.hashCode();
        }

        public final String toString() {
            return "RenderSlot(binding=" + this.f401243a + ", view=" + this.f401244b + ", indicator=" + this.f401245c + ')';
        }

        public c(d r100, View r101, com.obric.oui.indicator.e r102) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "indicator");
            this.f401243a = r100;
            this.f401244b = r101;
            this.f401245c = r102;
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f401246a = null;

            static {
                f401246a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f401247a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.f401247a == ((b) r100).f401247a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f401247a;
            }

            public final String toString() {
                return "Page(pageIndex=" + this.f401247a + ')';
            }

            public b(int r100) {
                this.f401247a = r100;
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f401248a = null;

            static {
                f401248a = new c();
            }

            public c() {
            }
        }

        public d() {
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401249a = null;

        static {
            int[] r100 = new int[IndicatorDotVisualState.values().length];
            r100[IndicatorDotVisualState.EDGE.ordinal()] = 1;
            r100[IndicatorDotVisualState.HIDDEN.ordinal()] = 2;
            r100[IndicatorDotVisualState.ACTIVE.ordinal()] = 3;
            f401249a = r100;
        }
    }

    static {
    }

    public OCarouselIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OCarouselIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void A() {
        if (((ArrayList) this.f401239z).isEmpty() == false) goto L5;
        return;
    L5:
        IntRange r100 = CollectionsKt.getIndices(this.f401239z);
        int r101 = (int) getDotsSpacing();
        Iterator<T> r102 = this.f401239z.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L28;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        c r106 = (c) r104;
        Intrinsics.checkNotNullParameter(r100, "visibleRange");
        if (r100.getFirst() != r100.getLast()) goto L17;
        if (r103 != r100.getFirst()) goto L17;
        com.obric.oui.indicator.a r107 = new com.obric.oui.indicator.a(0, 0);
    L23:
        int r108 = r107.f401250a;
        if (r108 != r107.f401251b) goto L26;
        r106.f401245c.setHorizontalMargin(r108);
    L27:
        r103 = r105;
        goto L7
    L26:
        r106.f401245c.setStartMargin(r108);
        r106.f401245c.setEndMargin(r107.f401251b);
    L17:
        if (r103 != r100.getFirst()) goto L20;
        r107 = new com.obric.oui.indicator.a(0, r101);
        goto L23
    L20:
        if (r103 != r100.getLast()) goto L22;
        r107 = new com.obric.oui.indicator.a(r101, 0);
        goto L23
    L22:
        r107 = new com.obric.oui.indicator.a(r101, r101);
        goto L23
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final j b() {
        return new j(this);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OBaseIndicator.a getCustom() {
        return new OBaseIndicator.a(pla.d.q(this, 6), pla.d.q(this, 6), pla.d.q(this, 4), new int[]{R.attr.oui_dotsClickable, R.attr.oui_dotsColor, R.attr.oui_dotsCornerRadius, R.attr.oui_dotsHeight, R.attr.oui_dotsSpacing, R.attr.oui_dotsStrokeColor, R.attr.oui_dotsStrokeWidth, R.attr.oui_dotsWidth, R.attr.oui_dotsWidthFactor, R.attr.oui_layoutHeight, R.attr.oui_maxVisibleDots, R.attr.oui_selectedDotColor, R.attr.oui_sizeStyle, R.attr.oui_type});
    }

    public final void o() {
        int r100 = this.G;
        b r101 = new b(getCustom().f401199a, getCustom().f401200b, getCustom().f401201c);
        if (r100 != 1) goto L6;
        r101 = new b(pla.d.d(getContext(), 4.0f), pla.d.d(getContext(), 4.0f), pla.d.d(getContext(), 2.0f));
    L6:
        if (this.B == true) goto L9;
        setDotsWidth(r101.f401240a);
    L9:
        if (this.C == true) goto L12;
        setDotsHeight(r101.f401241b);
    L12:
        if (this.D == true) goto L15;
        setDotsSpacing(r101.f401242c);
        return;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void c() {
        OBaseIndicator.c r100 = getPager();
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        Iterator r102 = ((ArrayList) this.f401239z).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r((c) r102.next(), r101);
        goto L8
    L10:
        return;
    L5:
        r101 = r100.getCurrentItem();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void d() {
        z();
        OBaseIndicator.c r100 = getPager();
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        Iterator r102 = ((ArrayList) this.f401239z).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        c r103 = (c) r102.next();
        y(r103.f401244b, true);
        r(r103, r101);
        goto L8
    L10:
        Iterator<IndicatorDotView> r104 = this.A.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        y(r104.next(), true);
        goto L12
    L14:
        IndicatorImageDotView r105 = this.E;
        if (r105 == null) goto L21;
        y(r105, true);
        return;
    L21:
        return;
    L5:
        r101 = r100.getCurrentItem();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void e() {
        z();
        A();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void f() {
        z();
        OBaseIndicator.c r100 = getPager();
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        IndicatorAnimator.RenderReason r102 = IndicatorAnimator.RenderReason.REFRESH_DOTS;
        f r103 = x(g(), r101);
        IndicatorAnimator r104 = this.f401238y;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r104 = null;
    L9:
        r104.a(r102, r103);
        return;
    L5:
        r101 = r100.getCurrentItem();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void k() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r100 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r101 = this.f401236w;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r101 = null;
    L11:
        r101.setBgColor(ContextCompat.getColor(getContext(), R.color.carousel_indicator_bg_color));
        IndicatorGroupLayout r102 = this.f401236w;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r102 = null;
    L14:
        r102.setCornerRadius(pla.d.n(this, 100));
        IndicatorGroupLayout r103 = this.f401236w;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r103 = null;
    L17:
        r103.setDrawBackground(true);
    L26:
        if (getType() == 1) goto L28;
    L30:
        IndicatorGroupLayout r104 = this.f401236w;
        if (r104 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r104 = null;
    L33:
        r104.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
    L34:
        z();
        IndicatorGroupLayout r105 = this.f401236w;
        if (r105 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r105 = null;
    L37:
        IndicatorGroupLayout r106 = this.f401236w;
        if (r106 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L41:
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        r107.height = getLayoutHeight();
        r105.setLayoutParams(r107);
        requestLayout();
        return;
    L40:
        r100 = r106;
        goto L41
    L28:
        if (this.G != 1) goto L30;
        p();
        goto L34
    L18:
        IndicatorGroupLayout r108 = this.f401236w;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r108 = null;
    L21:
        r108.setBgColor(ContextCompat.getColor(getContext(), R.color.Transparent));
        IndicatorGroupLayout r109 = this.f401236w;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r109 = null;
    L24:
        r109.setDrawBackground(false);
        goto L26
    }

    public final void p() {
        int r100 = pla.d.b(getContext(), 4.0f);
        int r101 = pla.d.b(getContext(), 4.0f);
        IndicatorGroupLayout r102 = this.f401236w;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r102 = null;
    L5:
        r102.setPadding(r100, r101, r100, r101);
    }

    public final void z() {
        IndicatorGroupLayout r100 = null;
        if (getType() == 1) goto L5;
    L4:
        Integer r101 = null;
    L14:
        IndicatorGroupLayout r102 = this.f401236w;
        if (r102 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r102 = null;
    L18:
        if (Intrinsics.areEqual(r102.getFixedContentWidthPx(), r101) == false) goto L20;
        return;
    L20:
        IndicatorGroupLayout r103 = this.f401236w;
        if (r103 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L24:
        r100.setFixedContentWidthPx(r101);
        return;
    L23:
        r100 = r103;
        goto L24
    L5:
        int r104 = g();
        if (r104 <= 0) goto L4;
        int r105 = this.F;
        if (r104 <= r105) goto L4;
        int r106 = RangesKt.coerceAtLeast(r105, 0);
        if (r106 != 0) goto L13;
        wma.b.h("OCarouselIndicator", Intrinsics.stringPlus("Skip PIC stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(this.F)));
        goto L4
    L13:
        r101 = Integer.valueOf(MathKt.roundToInt((r106 * getDotsWidth()) + (((r106 - 1) * getDotsSpacing()) * 2.0f)));
        goto L14
    }

    public final int getMaxVisibleDots() {
        return this.F;
    }

    public final int getSelectedDotColor() {
        return this.H;
    }

    public final int getSizeStyle() {
        return this.G;
    }

    public static float s(IndicatorDotVisualState r100) {
        int r101 = e.f401249a[r100.ordinal()];
        if (r101 != 2) goto L5;
        return 0.0f;
    L5:
        if (r101 == 3) goto L7;
        return 0.35f;
    L7:
        return 1.0f;
    }

    public static float t(IndicatorDotVisualState r100) {
        int r101 = e.f401249a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0.5f;
    L5:
        if (r101 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    public final void setMaxVisibleDots(int r100) {
        if (this.F == r100) goto L6;
        this.F = r100;
        h();
        return;
    }

    public final void setSelectedDotColor(int r100) {
        if (getType() != 1) goto L5;
        this.H = -218103809;
        i();
        return;
    L5:
        if (this.H == r100) goto L9;
        this.H = r100;
        i();
        return;
    }

    public final void setSizeStyle(int r100) {
        if (this.G == r100) goto L6;
        this.G = r100;
        o();
        h();
        return;
    }

    public final void setStartDotDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Drawable.ConstantState r101 = r100.getConstantState();
        if (r101 != null) goto L6;
        wma.b.h("OCarouselIndicator", "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L6:
        Drawable r102 = r101.newDrawable(getResources()).mutate();
        this.E = new IndicatorImageDotView(getContext(), r102);
        h();
    }

    public final IndicatorImageDotView v(d r100) {
        if ((r100 instanceof d.b) == false) goto L8;
        if (((d.b) r100).f401247a == 0) goto L15;
        return null;
    L15:
        return this.E;
    L8:
        if (Intrinsics.areEqual(r100, d.a.f401246a) == false) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r101 = Intrinsics.areEqual(r100, d.c.f401248a);
        goto L11
    }

    public final void setStartDotDrawable(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
        if (r101 != null) goto L7;
        return;
    L7:
        setStartDotDrawable(r101);
    }

    public static void n(View r100, IndicatorDotVisualState r101) {
        boolean r102 = false;
        if (r101 != IndicatorDotVisualState.HIDDEN) goto L5;
        int r103 = 4;
    L6:
        float r104 = t(r101);
        float r105 = s(r101);
        if (r100.getVisibility() == r103) goto L9;
    L23:
        r100.animate().setListener(null).cancel();
        r100.setVisibility(r103);
        r100.setScaleX(r104);
        r100.setScaleY(r104);
        r100.setAlpha(r105);
        return;
    L9:
        if (r100.getScaleX() != r104) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L23;
        if (r100.getScaleY() != r104) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L23;
        if (r100.getAlpha() != r105) goto L21;
        r102 = true;
    L21:
        if (r102 == false) goto L23;
        return;
    L16:
        r107 = false;
        goto L17
    L11:
        r106 = false;
        goto L12
    L5:
        r103 = 0;
        goto L6
    }

    public static List u(int r100, IntRange r101) {
        if (r100 <= 0) goto L27;
        if (r101.isEmpty() == true) goto L27;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r102.add(new d.b(((IntIterator) r103).nextInt()));
        goto L8
    L11:
        if (r101.isEmpty() == false) goto L13;
        int r104 = 0;
    L14:
        if (r100 > r104) goto L16;
        return r102;
    L16:
        List r105 = CollectionsKt.createListBuilder(r102.size() + 2);
        if (r101.getFirst() <= 0) goto L19;
        d r106 = new d.b(r101.getFirst() - 1);
    L20:
        r105.add(r106);
        r105.addAll(r102);
        if (r101.getLast() >= (r100 - 1)) goto L23;
        d r107 = new d.b(r101.getLast() + 1);
    L24:
        r105.add(r107);
        return CollectionsKt.build(r105);
    L23:
        r107 = d.c.f401248a;
        goto L24
    L19:
        r106 = d.a.f401246a;
        goto L20
    L13:
        r104 = (r101.getLast() - r101.getFirst()) + 1;
    L27:
        return CollectionsKt.emptyList();
    }

    public static IndicatorDotVisualState w(c r100, f r101) {
        d r102 = r100.f401243a;
        boolean r103 = true;
        if ((r102 instanceof d.b) == false) goto L32;
        int r104 = ((d.b) r102).f401247a;
        IntRange r105 = r101.f401261c;
        int r106 = r105.getFirst();
        if (r104 > r105.getLast()) goto L8;
        if (r106 > r104) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L12;
        return IndicatorDotVisualState.HIDDEN;
    L12:
        if (r104 != r101.f401260b) goto L15;
        return IndicatorDotVisualState.ACTIVE;
    L15:
        if (r104 == r105.getFirst()) goto L17;
    L19:
        boolean r108 = false;
    L21:
        if (r104 == r105.getLast()) goto L23;
    L25:
        r103 = false;
    L26:
        if (r108 == true) goto L43;
        if (r103 == true) goto L43;
        return IndicatorDotVisualState.NORMAL;
    L43:
        return IndicatorDotVisualState.EDGE;
    L23:
        if (r105.getLast() >= (r101.f401259a - 1)) goto L25;
    L17:
        if (r105.getFirst() <= 0) goto L19;
        r108 = true;
    L8:
        r107 = false;
        goto L9
    L32:
        if (Intrinsics.areEqual(r102, d.a.f401246a) == true) goto L35;
        r103 = Intrinsics.areEqual(r102, d.c.f401248a);
    L35:
        if (r103 == false) goto L39;
        return IndicatorDotVisualState.HIDDEN;
    L39:
        throw new NoWhenBranchMatchedException();
    }

    public final void r(c r100, int r101) {
        com.obric.oui.indicator.e r102 = r100.f401245c;
        d r103 = r100.f401243a;
        if ((r103 instanceof d.b) == false) goto L9;
        if (((d.b) r103).f401247a != r101) goto L7;
        int r104 = this.H;
    L14:
        r102.setDotColor(r104);
        r100.f401245c.setCornerRadius(getDotsCornerRadius());
        r100.f401245c.setStrokeWidth(getDotsStrokeWidth());
        r100.f401245c.setStrokeColor(getDotsStrokeColor());
        r100.f401245c.invalidate();
        return;
    L7:
        r104 = getDotsColor();
        goto L14
    L9:
        if (Intrinsics.areEqual(r103, d.a.f401246a) == false) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L17;
        r104 = getDotsColor();
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    L11:
        r105 = Intrinsics.areEqual(r103, d.c.f401248a);
        goto L12
    }

    public final f x(int r100, int r101) {
        int r102 = Math.min(r100, this.F);
        if (r100 > r102) goto L5;
        IntRange r103 = RangesKt.until(0, r100);
    L7:
        return new f(r100, r101, r103);
    L5:
        int r104 = r101 - (r102 / 2);
        int r105 = RangesKt.coerceIn(r104, 0, r100 - r102);
        r103 = RangesKt.until(r105, r102 + r105);
        goto L7
    }

    public final void y(View r100, boolean r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        LinearLayout.LayoutParams r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r104 == null) goto L9;
        r103 = new LinearLayout.LayoutParams(r104);
    L9:
        if (r103 != null) goto L11;
        r103 = new LinearLayout.LayoutParams((int) getDotsWidth(), (int) getDotsHeight());
    L11:
        r103.width = (int) getDotsWidth();
        r103.height = (int) getDotsHeight();
        if (r101 == true) goto L14;
        r103.setMargins(0, 0, 0, 0);
    L14:
        r100.setLayoutParams(r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public OCarouselIndicator(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f401239z = new ArrayList();
        this.A = new ArrayDeque();
        DecelerateInterpolator r112 = new DecelerateInterpolator();
        this.F = Integer.MAX_VALUE;
        this.H = ContextCompat.getColor(r100, R.color.oui_text_1);
        this.I = new ArgbEvaluator();
        LinearLayout r101 = null;
        IndicatorGroupLayout r102 = new IndicatorGroupLayout(getContext(), null, 6, 0);
        r102.setGravity(17);
        this.f401236w = r102;
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setOrientation(0);
        r103.setGravity(17);
        this.f401237x = r103;
        if (getType() != 1) goto L14;
        IndicatorGroupLayout r104 = this.f401236w;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r104 = null;
    L7:
        r104.setBgColor(ContextCompat.getColor(getContext(), R.color.carousel_indicator_bg_color));
        IndicatorGroupLayout r105 = this.f401236w;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r105 = null;
    L10:
        r105.setCornerRadius(pla.d.n(this, 100));
        IndicatorGroupLayout r106 = this.f401236w;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r106 = null;
    L13:
        r106.setDrawBackground(true);
    L18:
        IndicatorGroupLayout r107 = this.f401236w;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r107 = null;
    L21:
        r107.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r108 = this.f401236w;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r108 = null;
    L24:
        LinearLayout r109 = this.f401237x;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r109 = null;
    L27:
        r108.addView(r109, new LinearLayout.LayoutParams(-2, -2));
        IndicatorGroupLayout r113 = this.f401236w;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r113 = null;
    L30:
        addView(r113, new LinearLayout.LayoutParams(-2, getLayoutHeight()));
        LinearLayout r114 = this.f401237x;
        if (r114 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
    L34:
        this.f401238y = new IndicatorAnimator(r101, r112, new k(this));
        if (r110 == null) goto L37;
        TypedArray r115 = getContext().obtainStyledAttributes(r110, getCustom().f401202d, 0, 0);
        this.B = r115.hasValue(7);
        this.C = r115.hasValue(3);
        this.D = r115.hasValue(4);
        setSelectedDotColor(r115.getColor(11, getSelectedDotColor()));
        setMaxVisibleDots(r115.getInt(10, getMaxVisibleDots()));
        setSizeStyle(r115.getInt(12, 0));
        r115.recycle();
    L37:
        o();
        if (getType() == 1) goto L40;
    L42:
        this.f401179b = true;
        return;
    L40:
        if (this.G != 1) goto L42;
        p();
        goto L42
    L33:
        r101 = r114;
        goto L34
    L14:
        IndicatorGroupLayout r116 = this.f401236w;
        if (r116 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r116 = null;
    L17:
        r116.setDrawBackground(false);
        goto L18
    }

    public final void m(int r100, int r101, f r102) {
        if (r102.a(r100) == true) goto L5;
        return;
    L5:
        Iterator r103 = ((ArrayList) this.f401239z).iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Object r104 = r103.next();
        d r105 = ((c) r104).f401243a;
        boolean r106 = true;
        if ((r105 instanceof d.b) == false) goto L14;
        if (((d.b) r105).f401247a == r100) goto L19;
    L18:
        r106 = false;
    L19:
        if (r106 == false) goto L7;
    L24:
        c r107 = (c) r104;
        if (r107 != null) goto L27;
        return;
    L27:
        r107.f401245c.setDotColor(r101);
        r107.f401245c.invalidate();
        return;
    L14:
        if (Intrinsics.areEqual(r105, d.a.f401246a) == true) goto L17;
        r106 = Intrinsics.areEqual(r105, d.c.f401248a);
    L17:
        if (r106 == true) goto L18;
        throw new NoWhenBranchMatchedException();
    L23:
        r104 = null;
        goto L24
    }

    public final void q(f r110, f r111, float r112) {
        OBaseIndicator.c r100 = getPager();
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        Iterator r102 = ((ArrayList) this.f401239z).iterator();
    L8:
        if (r102.hasNext() == false) goto L38;
        c r103 = (c) r102.next();
        View r104 = r103.f401244b;
        IndicatorDotVisualState r105 = w(r103, r110);
        IndicatorDotVisualState r106 = w(r103, r111);
        if (r105 != r106) goto L12;
        n(r104, r105);
    L37:
        r(r103, r101);
        goto L8
    L12:
        float r107 = t(r105);
        float r108 = t(r106);
        float r109 = s(r105);
        float r113 = r107 + ((r108 - r107) * r112);
        float r114 = r109 + ((s(r106) - r109) * r112);
        if (r112 >= 1.0f) goto L15;
    L17:
        int r115 = 0;
    L19:
        if (r104.getVisibility() != r115) goto L36;
        boolean r116 = true;
        if (r104.getScaleX() != r113) goto L23;
        boolean r117 = true;
    L24:
        if (r117 == false) goto L36;
        if (r104.getScaleY() != r113) goto L28;
        boolean r118 = true;
    L29:
        if (r118 == false) goto L36;
        if (r104.getAlpha() == r114) goto L34;
        r116 = false;
    L34:
        if (r116 == false) goto L36;
    L28:
        r118 = false;
        goto L29
    L23:
        r117 = false;
    L36:
        r104.animate().setListener(null).cancel();
        r104.setVisibility(r115);
        r104.setScaleX(r113);
        r104.setScaleY(r113);
        r104.setAlpha(r114);
        goto L37
    L15:
        if (r106 != IndicatorDotVisualState.HIDDEN) goto L17;
        r115 = 4;
        goto L19
    L38:
        return;
    L5:
        r101 = r100.getCurrentItem();
        goto L6
    }

    public /* synthetic */ OCarouselIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
