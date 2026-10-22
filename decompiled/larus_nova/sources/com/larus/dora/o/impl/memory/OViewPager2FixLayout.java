package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/o/impl/memory/OViewPager2FixLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "pagingTouchSlop", "initialX", "", "initialY", "viewPagerEnableScroll", "", "childClaimed", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "e", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OViewPager2FixLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f338781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f338782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f338783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f338784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f338785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338786f;

    public OViewPager2FixLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OViewPager2FixLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ViewPager2 getParentViewPager() {
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 == null) goto L13;
        if ((r101 instanceof ViewPager2) == true) goto L13;
        Object r102 = r101.getParent();
        if ((r102 instanceof View) == false) goto L5;
        r101 = (View) r102;
        goto L6
    L5:
        r101 = null;
    L13:
        if ((r101 instanceof ViewPager2) == true) goto L15;
        return null;
    L15:
        return (ViewPager2) r101;
    L16:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        ViewPager2 r101 = getParentViewPager();
        if (r101 == null) goto L43;
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L39;
        if (r102 != 1) goto L9;
    L38:
        this.f338785e = false;
        this.f338786f = false;
        goto L43
    L9:
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L38;
    L14:
        if (this.f338785e == true) goto L43;
        float r103 = Math.abs(r100.getX() - this.f338783c);
        float r104 = Math.abs(r100.getY() - this.f338784d);
        if (r101.getOrientation() != 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        float r106 = r103;
    L23:
        if (r105 == false) goto L26;
        r103 = r104;
    L26:
        if (r103 >= this.f338781a) goto L43;
        if (this.f338786f == true) goto L43;
        if (r106 <= this.f338782b) goto L43;
        if ((r106 * 0.5f) <= r103) goto L43;
        this.f338785e = true;
        ViewParent r107 = getParent();
        if (r107 == null) goto L43;
        r107.requestDisallowInterceptTouchEvent(false);
        goto L43
    L22:
        r106 = r104;
        goto L23
    L19:
        r105 = false;
        goto L20
    L39:
        this.f338783c = r100.getX();
        this.f338784d = r100.getY();
        this.f338785e = false;
        this.f338786f = false;
        ViewParent r108 = getParent();
        if (r108 == null) goto L43;
        r108.requestDisallowInterceptTouchEvent(true);
    L43:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (r100 == false) goto L4;
        this.f338786f = true;
    L4:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public OViewPager2FixLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f338781a = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f338782b = ViewConfiguration.get(r100).getScaledPagingTouchSlop();
    }

    public /* synthetic */ OViewPager2FixLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
