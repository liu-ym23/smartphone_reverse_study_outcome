package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/NestedScrollableHost;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "initialX", "", "initialY", "parentViewPager", "Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/ViewPager2;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "getChild", "()Landroid/view/View;", "canChildScroll", "", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedScrollableHost extends FrameLayout {
    private float initialX;
    private float initialY;
    private int touchSlop;

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

    public NestedScrollableHost(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final void handleInterceptTouchEvent(MotionEvent r110) {
        ViewPager2 r100 = getParentViewPager();
        if (r100 == null) goto L38;
        int r101 = r100.getOrientation();
        float r102 = 1.0f;
        if (canChildScroll(r101, -1.0f) == true) goto L10;
        if (canChildScroll(r101, 1.0f) == true) goto L10;
        return;
    L10:
        if (r110.getAction() != 0) goto L13;
        this.initialX = r110.getX();
        this.initialY = r110.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L13:
        if (r110.getAction() != 2) goto L40;
        float r103 = r110.getX() - this.initialX;
        float r111 = r110.getY() - this.initialY;
        if (r101 != 0) goto L17;
        boolean r104 = true;
    L18:
        float r105 = Math.abs(r103);
        if (r104 == false) goto L21;
        float r106 = 0.5f;
    L22:
        float r107 = r105 * r106;
        float r108 = Math.abs(r111);
        if (r104 == true) goto L26;
        r102 = 0.5f;
    L26:
        float r109 = r108 * r102;
        int r112 = this.touchSlop;
        if (r107 <= r112) goto L29;
    L30:
        if (r104 == true) goto L34;
        r103 = r111;
    L34:
        if (canChildScroll(r101, r103) == false) goto L36;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L36:
        getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L29:
        if (r109 > r112) goto L30;
        return;
    L21:
        r106 = 1.0f;
        goto L22
    L17:
        r104 = false;
        goto L18
    L40:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        handleInterceptTouchEvent(r100);
        return super.onInterceptTouchEvent(r100);
    }

    public NestedScrollableHost(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final boolean canChildScroll(int r100, float r101) {
        int r102 = -((int) Math.signum(r101));
        if (r100 != 0) goto L5;
        View r103 = getChild();
        if (r103 != null) goto L14;
        return false;
    L14:
        return r103.canScrollHorizontally(r102);
    L5:
        if (r100 != 1) goto L10;
        View r104 = getChild();
        if (r104 != null) goto L16;
        return false;
    L16:
        return r104.canScrollVertically(r102);
    L10:
        throw new IllegalArgumentException();
    }
}
