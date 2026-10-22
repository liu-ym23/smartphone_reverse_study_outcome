package com.bytedance.ee.bear.office.space;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010!\u001a\u00020\n2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fJ\u0015\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001dH\u0000¢\u0006\u0002\b%J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020)J(\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0014J0\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0014J\b\u00105\u001a\u00020\u0010H\u0014J\b\u00106\u001a\u00020\u0010H\u0002J\"\u00107\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)H\u0002J\u0018\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012H\u0002J\u001a\u0010<\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\f\u0010=\u001a\u00020>*\u00020\nH\u0002J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020AH\u0002R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabLayout;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tabViews", "Ljava/util/LinkedHashMap;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "Landroid/widget/TextView;", "Lkotlin/collections/LinkedHashMap;", "selectedTab", "onTabClickListener", "Lkotlin/Function1;", "", "selectedColor", "", "normalColor", "content", "Landroid/widget/FrameLayout;", "container", "Landroid/widget/LinearLayout;", "indicator", "Landroid/view/View;", "indicatorAnimator", "Landroid/animation/ValueAnimator;", "contentAlignment", "Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabAlignment;", "bindTabs", "tabs", "", "selected", "listener", "setContentAlignment", "alignment", "setContentAlignment$office_space_productionChinaRelease", "select", "tab", "animate", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onLayout", "changed", "l", "t", "r", "b", "onDetachedFromWindow", "syncSelectedTabAfterLayout", "updateIndicator", "animateScroll", "updateIndicatorBounds", "left", "width", "scrollTabIntoView", "displayName", "", "dp", "value", "", "Companion", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceTabLayout extends HorizontalScrollView {
    public static final /* synthetic */ int k = 0;
    public final LinkedHashMap<OfficeSpaceTab, TextView> a;
    public OfficeSpaceTab b;
    public Function1<? super OfficeSpaceTab, Unit> c;
    public final int d;
    public final int e;
    public final FrameLayout f;
    public final LinearLayout g;
    public final View h;
    public ValueAnimator i;
    public OfficeSpaceTabAlignment j;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeSpaceTabAlignment.values().length];
            r0[OfficeSpaceTabAlignment.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[OfficeSpaceTabAlignment.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            a = r0;
            int[] r1 = new int[OfficeSpaceTab.values().length];
            r1[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ OfficeSpaceTabLayout a;

        public c(OfficeSpaceTabLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ OfficeSpaceTabLayout a;

        public d(OfficeSpaceTabLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ OfficeSpaceTabLayout a;

        public e(OfficeSpaceTabLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ OfficeSpaceTabLayout a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public f(OfficeSpaceTabLayout r1, int r2, int r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "animator");
            float r6 = r5.getAnimatedFraction();
            OfficeSpaceTabLayout r0 = this.a;
            int r1 = this.b;
            int r2 = r1 + ((int) ((this.c - r1) * r6));
            int r3 = this.d;
            int r4 = r3 + ((int) ((this.e - r3) * r6));
            int r7 = OfficeSpaceTabLayout.k;
            r0.e(r2, r4);
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.i = null;
        super.onDetachedFromWindow();
    }

    public OfficeSpaceTabLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final void a(OfficeSpaceTabLayout r2) {
        OfficeSpaceTab r0 = r2.b;
        if (r0 == null) goto L10;
        ValueAnimator r1 = r2.i;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        r2.i = null;
        r2.d(r0, false, false);
        return;
    }

    public final int b(float r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setContentAlignment$office_space_productionChinaRelease(OfficeSpaceTabAlignment r3) {
        Intrinsics.checkNotNullParameter(r3, "alignment");
        if (this.j != r3) goto L5;
        return;
    L5:
        this.j = r3;
        ViewGroup.LayoutParams r0 = this.g.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L8;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L14;
        int r5 = 49;
    L19:
        r1.gravity = r5;
        this.g.setLayoutParams(r1);
        requestLayout();
        post(new e(this));
        return;
    L14:
        if (r4 != 2) goto L17;
        r5 = 8388659;
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L8:
        r1 = null;
        goto L9
    }

    public OfficeSpaceTabLayout(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.a = new LinkedHashMap();
        int r8 = ContextCompat.getColor(r6, 2131106622);
        this.d = r8;
        this.e = ContextCompat.getColor(r6, 2131106620);
        FrameLayout r0 = new FrameLayout(r6);
        this.f = r0;
        LinearLayout r1 = new LinearLayout(r6);
        r1.setOrientation(0);
        r1.setGravity(16);
        this.g = r1;
        View r3 = new View(r6);
        r3.setBackgroundColor(r8);
        this.h = r3;
        this.j = OfficeSpaceTabAlignment.CENTER;
        setHorizontalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(b(24.0f));
        setFillViewport(true);
        setOverScrollMode(2);
        setClipToPadding(false);
        addView(r0, new FrameLayout.LayoutParams(-2, -1));
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 49;
        r9.topMargin = b(7.0f);
        Unit r10 = Unit.INSTANCE;
        r0.addView(r1, r9);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(0, b(2.0f));
        r11.gravity = 48;
        r0.addView(r3, r11);
    }

    public final void c(OfficeSpaceTab r4, boolean r5) {
        TextView r6 = this.a.get(r4);
        if (r6 != null) goto L5;
        return;
    L5:
        int r0 = (this.g.getLeft() + r6.getLeft()) + (r6.getWidth() / 2);
        int r7 = RangesKt.coerceAtLeast(this.f.getWidth() - getWidth(), 0);
        int r8 = RangesKt.coerceIn(r0 - (getWidth() / 2), 0, r7);
        if (r5 == false) goto L8;
        smoothScrollTo(r8, 0);
        return;
    L8:
        scrollTo(r8, 0);
    }

    public final void e(int r3, int r4) {
        ViewGroup.LayoutParams r0 = this.h.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.width = r4;
        r1.leftMargin = r3;
        r1.topMargin = RangesKt.coerceAtLeast((getHeight() - b(5.0f)) - r1.height, this.g.getBottom());
        this.h.setLayoutParams(r1);
    }

    public final void d(OfficeSpaceTab r10, boolean r11, boolean r12) {
        TextView r0 = this.a.get(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        int r6 = this.g.getLeft() + r0.getLeft();
        int r8 = r0.getWidth();
        if (r11 == true) goto L8;
    L15:
        e(r6, r8);
        c(r10, r12);
        return;
    L8:
        if (this.h.getLayoutParams().width <= 0) goto L15;
        ValueAnimator r13 = this.i;
        if (r13 == null) goto L13;
        r13.cancel();
    L13:
        ViewGroup.LayoutParams r14 = this.h.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        int r5 = r15.leftMargin;
        int r7 = r15.width;
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(200);
        r16.addUpdateListener(new f(this, r5, r6, r7, r8));
        r16.start();
        this.i = r16;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        post(new d(this));
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        post(new c(this));
        return;
    }
}
