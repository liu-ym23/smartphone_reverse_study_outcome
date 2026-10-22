package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/RecyclerViewContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "hoverTapSlop", "initialX", "", "initialY", "parentInterceptTouchEvent", "", "needParentInterceptNow", "childIntercept", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "getChild", "()Landroid/view/View;", "forceParentInterceptTouchEvent", "", "force", "canChildScroll", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecyclerViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f304861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f304862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f304863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f304865e;

    public static final class a {
    }

    static {
    }

    private final View getChild() {
        if (getChildCount() > 0) goto L7;
        return null;
    L7:
        return getChildAt(0);
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

    public RecyclerViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f304861a = r101;
        this.f304862b = r101 / 2;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        ViewPager2 r100 = getParentViewPager();
        if (r100 == null) goto L53;
        int r101 = r100.getOrientation();
        int r102 = r110.getAction();
        if (r102 != 0) goto L7;
        this.f304863c = r110.getX();
        this.f304864d = r110.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L7:
        if (r102 != 1) goto L9;
    L50:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L53
    L9:
        if (r102 != 2) goto L11;
        float r103 = r110.getX() - this.f304863c;
        float r104 = r110.getY() - this.f304864d;
        if (r101 != 0) goto L16;
        boolean r105 = true;
    L17:
        float r106 = Math.abs(r103);
        float r107 = 1.0f;
        if (r105 == false) goto L20;
        float r111 = 0.5f;
    L21:
        float r108 = r106 * r111;
        float r112 = Math.abs(r104);
        if (r105 == true) goto L25;
        r107 = 0.5f;
    L25:
        float r113 = r112 * r107;
        FLogger r109 = FLogger.f375446a;
        r109.d("NestedScrollableContainer", "requestDisallowInterceptTouchEvent scaledDx=" + r108 + ", scaledDy=" + r113 + ", touchSlop=" + this.f304861a + ", hoverTapSlop=" + this.f304862b);
        if (r113 <= (r108 * 2)) goto L28;
        boolean r114 = true;
    L29:
        if (r105 != r114) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L31:
        if (r105 == true) goto L34;
        r103 = r104;
    L34:
        int r115 = -((int) Math.signum(r103));
        if (r101 == 0) goto L41;
        if (r101 != 1) goto L44;
        View r116 = getChild();
        if (r116 == null) goto L44;
        boolean r117 = r116.canScrollVertically(r115);
    L45:
        if (r117 == false) goto L48;
        r109.i("NestedScrollableContainer", "requestDisallowInterceptTouchEvent true");
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        if (this.f304865e == true) goto L53;
        getParent().requestDisallowInterceptTouchEvent(false);
    L44:
        r117 = false;
        goto L45
    L41:
        View r118 = getChild();
        if (r118 == null) goto L44;
        r117 = r118.canScrollHorizontally(r115);
        goto L45
    L28:
        r114 = false;
        goto L29
    L20:
        r111 = 1.0f;
        goto L21
    L16:
        r105 = false;
        goto L17
    L11:
        if (r102 == 3) goto L50;
    L53:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        this.f304865e = r100;
    }

    public RecyclerViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f304861a = r102;
        this.f304862b = r102 / 2;
    }
}
