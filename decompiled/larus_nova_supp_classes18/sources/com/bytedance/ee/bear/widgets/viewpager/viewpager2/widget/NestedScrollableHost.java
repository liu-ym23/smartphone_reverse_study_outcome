package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "initialX", "", "initialY", "parentViewPager", "Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Lcom/bytedance/ee/bear/widgets/viewpager/viewpager2/widget/ViewPager2;", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "canChildScroll", "", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        Object r0 = getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L13;
        if ((r1 instanceof ViewPager2) == true) goto L13;
        Object r2 = r1.getParent();
        if ((r2 instanceof View) == false) goto L5;
        r1 = (View) r2;
        goto L6
    L5:
        r1 = null;
    L13:
        if ((r1 instanceof ViewPager2) == true) goto L15;
        return null;
    L15:
        return (ViewPager2) r1;
    L16:
        r1 = null;
        goto L6
    }

    public NestedScrollableHost(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final void handleInterceptTouchEvent(MotionEvent r10) {
        ViewPager2 r0 = getParentViewPager();
        if (r0 == null) goto L38;
        int r1 = r0.getOrientation();
        float r2 = 1.0f;
        if (canChildScroll(r1, -1.0f) == true) goto L10;
        if (canChildScroll(r1, 1.0f) == true) goto L10;
        return;
    L10:
        if (r10.getAction() != 0) goto L13;
        this.initialX = r10.getX();
        this.initialY = r10.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L13:
        if (r10.getAction() != 2) goto L40;
        float r3 = r10.getX() - this.initialX;
        float r11 = r10.getY() - this.initialY;
        if (r1 != 0) goto L17;
        boolean r5 = true;
    L18:
        float r6 = Math.abs(r3);
        if (r5 == false) goto L21;
        float r8 = 0.5f;
    L22:
        float r7 = r6 * r8;
        float r9 = Math.abs(r11);
        if (r5 == true) goto L26;
        r2 = 0.5f;
    L26:
        float r12 = r9 * r2;
        int r4 = this.touchSlop;
        if (r7 <= r4) goto L29;
    L30:
        if (r5 == true) goto L34;
        r3 = r11;
    L34:
        if (canChildScroll(r1, r3) == false) goto L36;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L36:
        getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L29:
        if (r12 > r4) goto L30;
        return;
    L21:
        r8 = 1.0f;
        goto L22
    L17:
        r5 = false;
        goto L18
    L40:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        handleInterceptTouchEvent(r2);
        return super.onInterceptTouchEvent(r2);
    }

    public NestedScrollableHost(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final boolean canChildScroll(int r3, float r4) {
        int r5 = -((int) Math.signum(r4));
        if (r3 != 0) goto L5;
        View r6 = getChild();
        if (r6 != null) goto L14;
        return false;
    L14:
        return r6.canScrollHorizontally(r5);
    L5:
        if (r3 != 1) goto L10;
        View r7 = getChild();
        if (r7 != null) goto L16;
        return false;
    L16:
        return r7.canScrollVertically(r5);
    L10:
        throw new IllegalArgumentException();
    }
}
