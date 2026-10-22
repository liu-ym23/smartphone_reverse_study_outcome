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
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010!\u001a\u00020\n2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fJ\u0015\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001dH\u0000¢\u0006\u0002\b%J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020)J(\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0014J0\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0014J\b\u00105\u001a\u00020\u0010H\u0014J\b\u00106\u001a\u00020\u0010H\u0002J\"\u00107\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)H\u0002J\u0018\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012H\u0002J\u001a\u0010<\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\f\u0010=\u001a\u00020>*\u00020\nH\u0002J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020AH\u0002R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabLayout;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tabViews", "Ljava/util/LinkedHashMap;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "Landroid/widget/TextView;", "Lkotlin/collections/LinkedHashMap;", "selectedTab", "onTabClickListener", "Lkotlin/Function1;", "", "selectedColor", "", "normalColor", "content", "Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "indicator", "Landroid/view/View;", "indicatorAnimator", "Landroid/animation/ValueAnimator;", "contentAlignment", "Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabAlignment;", "bindTabs", "tabs", "", "selected", "listener", "setContentAlignment", "alignment", "setContentAlignment$office_space_productionChinaRelease", "select", "tab", "animate", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onDetachedFromWindow", "syncSelectedTabAfterLayout", "updateIndicator", "animateScroll", "updateIndicatorBounds", "left", "width", "scrollTabIntoView", CommonConstant.KEY_DISPLAY_NAME, "", "dp", "value", "", "Companion", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f236079k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<OfficeSpaceTab, TextView> f236080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OfficeSpaceTab f236081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super OfficeSpaceTab, Unit> f236082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f236083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f236084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f236085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f236086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f236087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f236088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OfficeSpaceTabAlignment f236089j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236090a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f236091b = null;

        static {
            int[] r100 = new int[OfficeSpaceTabAlignment.values().length];
            r100[OfficeSpaceTabAlignment.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[OfficeSpaceTabAlignment.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f236090a = r100;
            int[] r101 = new int[OfficeSpaceTab.values().length];
            r101[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f236091b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceTabLayout f236092a;

        public c(OfficeSpaceTabLayout r100) {
            this.f236092a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.f236092a);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceTabLayout f236093a;

        public d(OfficeSpaceTabLayout r100) {
            this.f236093a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.f236093a);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceTabLayout f236094a;

        public e(OfficeSpaceTabLayout r100) {
            this.f236094a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceTabLayout.a(this.f236094a);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceTabLayout f236095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f236096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f236097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f236098d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f236099e;

        public f(OfficeSpaceTabLayout r100, int r101, int r102, int r103, int r104) {
            this.f236095a = r100;
            this.f236096b = r101;
            this.f236097c = r102;
            this.f236098d = r103;
            this.f236099e = r104;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            float r101 = r100.getAnimatedFraction();
            OfficeSpaceTabLayout r102 = this.f236095a;
            int r103 = this.f236096b;
            int r104 = r103 + ((int) ((this.f236097c - r103) * r101));
            int r105 = this.f236098d;
            int r106 = r105 + ((int) ((this.f236099e - r105) * r101));
            int r107 = OfficeSpaceTabLayout.f236079k;
            r102.e(r104, r106);
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f236088i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f236088i = null;
        super.onDetachedFromWindow();
    }

    public OfficeSpaceTabLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final void a(OfficeSpaceTabLayout r100) {
        OfficeSpaceTab r101 = r100.f236081b;
        if (r101 == null) goto L10;
        ValueAnimator r102 = r100.f236088i;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        r100.f236088i = null;
        r100.d(r101, false, false);
        return;
    }

    public final int b(float r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setContentAlignment$office_space_productionChinaRelease(OfficeSpaceTabAlignment r100) {
        Intrinsics.checkNotNullParameter(r100, "alignment");
        if (this.f236089j != r100) goto L5;
        return;
    L5:
        this.f236089j = r100;
        ViewGroup.LayoutParams r101 = this.f236086g.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L8;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = b.f236090a[r100.ordinal()];
        if (r103 != 1) goto L14;
        int r104 = 49;
    L19:
        r102.gravity = r104;
        this.f236086g.setLayoutParams(r102);
        requestLayout();
        post(new e(this));
        return;
    L14:
        if (r103 != 2) goto L17;
        r104 = 8388659;
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L8:
        r102 = null;
        goto L9
    }

    public OfficeSpaceTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f236080a = new LinkedHashMap();
        int r102 = ContextCompat.getColor(r100, R.color.text_title);
        this.f236083d = r102;
        this.f236084e = ContextCompat.getColor(r100, R.color.text_placeholder);
        FrameLayout r103 = new FrameLayout(r100);
        this.f236085f = r103;
        LinearLayout r104 = new LinearLayout(r100);
        r104.setOrientation(0);
        r104.setGravity(16);
        this.f236086g = r104;
        View r105 = new View(r100);
        r105.setBackgroundColor(r102);
        this.f236087h = r105;
        this.f236089j = OfficeSpaceTabAlignment.CENTER;
        setHorizontalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(b(24.0f));
        setFillViewport(true);
        setOverScrollMode(2);
        setClipToPadding(false);
        addView(r103, new FrameLayout.LayoutParams(-2, -1));
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 49;
        r106.topMargin = b(7.0f);
        Unit r107 = Unit.INSTANCE;
        r103.addView(r104, r106);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(0, b(2.0f));
        r108.gravity = 48;
        r103.addView(r105, r108);
    }

    public final void c(OfficeSpaceTab r100, boolean r101) {
        TextView r102 = this.f236080a.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = (this.f236086g.getLeft() + r102.getLeft()) + (r102.getWidth() / 2);
        int r104 = RangesKt.coerceAtLeast(this.f236085f.getWidth() - getWidth(), 0);
        int r105 = RangesKt.coerceIn(r103 - (getWidth() / 2), 0, r104);
        if (r101 == false) goto L8;
        smoothScrollTo(r105, 0);
        return;
    L8:
        scrollTo(r105, 0);
    }

    public final void e(int r100, int r101) {
        ViewGroup.LayoutParams r102 = this.f236087h.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        r103.width = r101;
        r103.leftMargin = r100;
        r103.topMargin = RangesKt.coerceAtLeast((getHeight() - b(5.0f)) - r103.height, this.f236086g.getBottom());
        this.f236087h.setLayoutParams(r103);
    }

    public final void d(OfficeSpaceTab r110, boolean r111, boolean r112) {
        TextView r100 = this.f236080a.get(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.f236086g.getLeft() + r100.getLeft();
        int r102 = r100.getWidth();
        if (r111 == true) goto L8;
    L15:
        e(r101, r102);
        c(r110, r112);
        return;
    L8:
        if (this.f236087h.getLayoutParams().width <= 0) goto L15;
        ValueAnimator r113 = this.f236088i;
        if (r113 == null) goto L13;
        r113.cancel();
    L13:
        ViewGroup.LayoutParams r114 = this.f236087h.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        int r103 = r115.leftMargin;
        int r104 = r115.width;
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r116.setDuration(200);
        r116.addUpdateListener(new f(this, r103, r101, r104, r102));
        r116.start();
        this.f236088i = r116;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        post(new d(this));
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L6;
        post(new c(this));
        return;
    }
}
