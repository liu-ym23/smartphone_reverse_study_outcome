package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.awemeopen.apps.photo.viewmodel.SlidesDetailSizeVM;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0015\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J4\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010(\u001a\u00020%2\u0006\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\n\u0010+\u001a\u0004\u0018\u00010*H\u0002J \u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0016J@\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\tH\u0016JH\u00108\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0016J8\u0010=\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010>\u001a\u0002022\u0006\u00101\u001a\u0002022\u0006\u0010?\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0016J(\u0010@\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\tH\u0016J \u0010B\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0016JI\u0010C\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u000eJ\u0010\u0010H\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/google/android/material/appbar/SlidesDetailAppbarBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activePointerId", "", "appBarUpOffsetDev", "getAppBarUpOffsetDev", "()I", "horizontalDegreeFraction", "", "isBeingDragged", "", "isFlinging", "lastMotionX", "lastMotionY", "offsetAnimator", "Landroid/animation/ValueAnimator;", "shouldBlockNestedScroll", "sizeVM", "Lcom/bytedance/awemeopen/apps/photo/viewmodel/SlidesDetailSizeVM;", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "adjustAppBarOffset", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/google/android/material/appbar/AppBarLayout;", "animateOffsetWithDuration", "offset", "duration", "", "listener", "Landroid/animation/Animator$AnimatorListener;", "getDuration", "getFlingRunnableField", "Ljava/lang/reflect/Field;", "getScrollerField", "onInterceptTouchEvent", "parent", "ev", "Landroid/view/MotionEvent;", "onNestedPreScroll", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "dx", "dy", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "directTargetChild", "nestedScrollAxes", "onStopNestedScroll", "abl", "onTouchEvent", "scrollUpTo", "force", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/appbar/AppBarLayout;IZLjava/lang/Long;Landroid/animation/Animator$AnimatorListener;)V", "setHorizontalDegreeFraction", "fraction", "stopAppbarLayoutFling", "appBarLayout", "Companion", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlidesDetailAppbarBehavior extends AppBarLayout.Behavior {
    public static final Companion Companion = null;
    private static final int INVALID_POINTER = -1;
    private static final int TYPE_FLING = 1;
    private int activePointerId;
    private float horizontalDegreeFraction;
    private boolean isBeingDragged;
    private boolean isFlinging;
    private int lastMotionX;
    private int lastMotionY;
    private ValueAnimator offsetAnimator;
    private boolean shouldBlockNestedScroll;
    private SlidesDetailSizeVM sizeVM;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/android/material/appbar/SlidesDetailAppbarBehavior$Companion;", "", "()V", "INVALID_POINTER", "", "TYPE_FLING", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(SlidesDetailAppbarBehavior r100, CoordinatorLayout r101, AppBarLayout r102, ValueAnimator r103) {
        animateOffsetWithDuration$lambda$4(r100, r101, r102, r103);
    }

    private final Field getFlingRunnableField() throws NoSuchFieldException {
        Class r100 = SlidesDetailAppbarBehavior.class.getSuperclass();     // Catch: NoSuchFieldException -> L10
        if (r100 == null) goto L6;
        Class r101 = r100.getSuperclass();     // Catch: NoSuchFieldException -> L10
    L7:
        if (r101 == null) goto L21;
        return r101.getDeclaredField("mFlingRunnable");
    L21:
        return null;
    L6:
        r101 = null;
    L10:
        Class r102 = SlidesDetailAppbarBehavior.class.getSuperclass();
        if (r102 == null) goto L15;
        Class r103 = r102.getSuperclass();
        if (r103 == null) goto L15;
        Class r104 = r103.getSuperclass();
    L16:
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.getDeclaredField("flingRunnable");
    L15:
        r104 = null;
        goto L16
    }

    private final Field getScrollerField() throws NoSuchFieldException {
        Class r100 = SlidesDetailAppbarBehavior.class.getSuperclass();     // Catch: NoSuchFieldException -> L10
        if (r100 == null) goto L6;
        Class r101 = r100.getSuperclass();     // Catch: NoSuchFieldException -> L10
    L7:
        if (r101 == null) goto L21;
        return r101.getDeclaredField("mScroller");
    L21:
        return null;
    L6:
        r101 = null;
    L10:
        Class r102 = SlidesDetailAppbarBehavior.class.getSuperclass();
        if (r102 == null) goto L15;
        Class r103 = r102.getSuperclass();
        if (r103 == null) goto L15;
        Class r104 = r103.getSuperclass();
    L16:
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.getDeclaredField("scroller");
    L15:
        r104 = null;
        goto L16
    }

    private final int getAppBarUpOffsetDev() {
        SlidesDetailSizeVM r100 = this.sizeVM;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAppBarUpOffsetDev();
    }

    public SlidesDetailAppbarBehavior() {
        this.activePointerId = -1;
        this.horizontalDegreeFraction = -1.0f;
    }

    public final void setHorizontalDegreeFraction(float r100) {
        this.horizontalDegreeFraction = r100;
    }

    public final void stopAppbarLayoutFling(AppBarLayout r100) {
        if (r100 != null) goto L19;
        return;
    L19:
        Field r101 = getFlingRunnableField();     // Catch: Throwable -> L18
        if (r101 != null) goto L7;
        return;
    L7:
        Field r102 = getScrollerField();     // Catch: Throwable -> L18
        if (r102 != null) goto L10;
        return;
    L10:
        r101.setAccessible(true);     // Catch: Throwable -> L18
        r102.setAccessible(true);     // Catch: Throwable -> L18
        Runnable r103 = (Runnable) r101.get(this);     // Catch: Throwable -> L18
        OverScroller r104 = (OverScroller) r102.get(this);     // Catch: Throwable -> L18
        if (r103 == null) goto L13;
        r100.removeCallbacks(r103);     // Catch: Throwable -> L18
        r101.set(this, null);     // Catch: Throwable -> L18
    L13:
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.isFinished() == true) goto L22;
        r104.abortAnimation();     // Catch: Throwable -> L18
        return;
    L22:
        return;
    }

    public SlidesDetailAppbarBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.activePointerId = -1;
        this.horizontalDegreeFraction = -1.0f;
        SlidesDetailSizeVM.Companion.getClass();
        this.sizeVM = SlidesDetailSizeVM.a.a(r100);
        this.touchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    private final long getDuration(int r100, AppBarLayout r101) {
        float r102 = Math.abs(r100) / r101.getHeight();
        float r103 = 1 + r102;
        if (r102 <= 0.5f) goto L5;
        int r104 = 180;
    L7:
        return (long) (r103 * r104);
    L5:
        r104 = 150;
        goto L7
    }

    public final void adjustAppBarOffset(CoordinatorLayout r110, AppBarLayout r111) {
        if (r110 == null) goto L9;
        if (r111 == null) goto L11;
        int r100 = getTopBottomOffsetForScrollingSibling();
        int r101 = Math.min(-r111.getUpNestedPreScrollRange(), 0);
        if (r100 >= r101) goto L10;
        animateOffsetWithDuration$default(this, r110, r111, r101, getDuration(r101 - r100, r111), null, 16, null);
        return;
    L10:
        return;
    L11:
        return;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout r100, AppBarLayout r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "ev");
        this.shouldBlockNestedScroll = false;
        if (this.isFlinging == false) goto L5;
        this.shouldBlockNestedScroll = true;
    L5:
        int r103 = r102.getActionMasked();
        if (r103 != 0) goto L8;
        stopAppbarLayoutFling(r101);
        this.activePointerId = -1;
        int r104 = (int) r102.getX();
        int r105 = (int) r102.getY();
        if (canDragView(r101) == true) goto L39;
    L41:
        boolean r106 = false;
    L42:
        this.isBeingDragged = r106;
        if (r106 == false) goto L53;
        this.lastMotionX = r104;
        this.lastMotionY = r105;
        this.activePointerId = r102.getPointerId(0);
        if (this.velocityTracker != null) goto L47;
        this.velocityTracker = VelocityTracker.obtain();
    L47:
        OverScroller r107 = this.scroller;
        if (r107 == null) goto L53;
        if (r107.isFinished() == true) goto L53;
        this.scroller.abortAnimation();
        return true;
    L53:
        VelocityTracker r108 = this.velocityTracker;
        if (r108 == null) goto L56;
        r108.addMovement(r102);
    L56:
        return false;
    L39:
        if (r100.isPointInChildBounds(r101, r104, r105) == false) goto L41;
        r106 = true;
        goto L42
    L8:
        if (r103 != 2) goto L53;
        if (this.isBeingDragged == false) goto L53;
        int r109 = this.activePointerId;
        if (r109 != (-1)) goto L15;
        return false;
    L15:
        int r110 = r102.findPointerIndex(r109);
        if (r110 != (-1)) goto L18;
        return false;
    L18:
        int r111 = (int) r102.getX(r110);
        int r112 = (int) r102.getY(r110);
        int r113 = Math.abs(r111 - this.lastMotionX);
        int r114 = Math.abs(r112 - this.lastMotionY);
        float r115 = this.horizontalDegreeFraction;
        if (r115 <= 0.0f) goto L24;
        if ((r113 * r115) <= r114) goto L30;
    L22:
        boolean r116 = true;
    L31:
        if (r116 == true) goto L53;
        if (r114 <= this.touchSlop) goto L53;
        this.lastMotionX = r111;
        this.lastMotionY = r112;
        return true;
    L30:
        r116 = false;
        goto L31
    L24:
        if (r112 <= this.lastMotionY) goto L30;
        if ((r113 * 0.5f) <= r114) goto L30;
        if (getTopBottomOffsetForScrollingSibling() != 0) goto L30;
        goto L30
    }

    public boolean onTouchEvent(CoordinatorLayout r110, AppBarLayout r111, MotionEvent r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, "ev");
        int r100 = r112.getActionMasked();
        if (r100 != 1) goto L5;
        VelocityTracker r101 = this.velocityTracker;
        if (r101 == null) goto L33;
        r101.addMovement(r112);
        r101.computeCurrentVelocity(1000);
        float r102 = r101.getYVelocity(this.activePointerId);
        if (r102 >= 0.0f) goto L31;
        fling(r110, r111, RangesKt.coerceAtMost((-getScrollRangeForDragFling(r111)) + getAppBarUpOffsetDev(), 0), 0, r102);
    L32:
        boolean r113 = true;
    L34:
        VelocityTracker r114 = this.velocityTracker;
        if (r114 == null) goto L38;
        r114.addMovement(r112);
    L38:
        if (this.isBeingDragged == true) goto L43;
        if (r113 == true) goto L44;
        return false;
    L44:
        return true;
    L43:
        return true;
    L31:
        fling(r110, r111, -getScrollRangeForDragFling(r111), 0, r102);
    L33:
        r113 = false;
        goto L34
    L5:
        if (r100 != 2) goto L7;
        int r103 = r112.findPointerIndex(this.activePointerId);
        if (r103 != (-1)) goto L22;
        return false;
    L22:
        this.lastMotionX = (int) r112.getX(r103);
        int r104 = (int) r112.getY(r103);
        int r105 = this.lastMotionY - r104;
        this.lastMotionY = r104;
        if (r105 <= 0) goto L25;
        scroll(r110, r111, r105, RangesKt.coerceAtMost(getMaxDragOffset(r111) + getAppBarUpOffsetDev(), 0), 0);
        goto L33
    L25:
        scroll(r110, r111, r105, getMaxDragOffset(r111), 0);
        goto L33
    L7:
        if (r100 != 3) goto L9;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r115 = this.velocityTracker;
        if (r115 == null) goto L33;
        r115.recycle();
        this.velocityTracker = null;
        goto L33
    L9:
        if (r100 != 6) goto L33;
        if (r112.getActionIndex() != 0) goto L14;
        int r116 = 1;
    L15:
        this.activePointerId = r112.getPointerId(r116);
        this.lastMotionX = (int) (r112.getY(r116) + 0.5f);
        this.lastMotionY = (int) (r112.getY(r116) + 0.5f);
        goto L33
    L14:
        r116 = 0;
        goto L15
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        return onInterceptTouchEvent(r100, (AppBarLayout) r101, r102);
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        return onTouchEvent(r100, (AppBarLayout) r101, r102);
    }

    private static final void animateOffsetWithDuration$lambda$4(SlidesDetailAppbarBehavior r100, CoordinatorLayout r101, AppBarLayout r102, ValueAnimator r103) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "$coordinatorLayout");
        Intrinsics.checkNotNullParameter(r102, "$child");
        Object r104 = r103.getAnimatedValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");
        r100.setHeaderTopBottomOffset(r101, r102, ((Integer) r104).intValue());
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, "abl");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101, r102, r103);
        this.isFlinging = false;
        this.shouldBlockNestedScroll = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, android.animation.ValueAnimator] */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, android.animation.ValueAnimator] */
    private final void animateOffsetWithDuration(final CoordinatorLayout r100, final AppBarLayout r101, int r102, long r103, final Animator.AnimatorListener r110) {
        int r104 = getTopBottomOffsetForScrollingSibling();
        if (r104 != r102) goto L10;
        ValueAnimator r105 = this.offsetAnimator;
        if (r105 != null) goto L7;
        return;
    L7:
        if (r105.isRunning() == false) goto L20;
        r105.cancel();
        return;
    L20:
        return;
    L10:
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        ?? r107 = this.offsetAnimator;
        r106.element = r107;
        if (r107 == 0) goto L13;
        ValueAnimator r108 = (ValueAnimator) r107;
        r107.cancel();
    L14:
        ((ValueAnimator) r106.element).setDuration(RangesKt.coerceAtMost(r103, 400));
        ((ValueAnimator) r106.element).setIntValues(new int[]{r104, r102});
        if (r110 == null) goto L17;
        ((ValueAnimator) r106.element).addListener(new AnonymousClass3(r110, r106));
    L17:
        ((ValueAnimator) r106.element).start();
        return;
    L13:
        ?? r109 = new ValueAnimator();
        r106.element = r109;
        ValueAnimator r111 = (ValueAnimator) r109;
        r109.setInterpolator(new DecelerateInterpolator());
        ((ValueAnimator) r106.element).addUpdateListener(new a(this, r100, r101));
        this.offsetAnimator = (ValueAnimator) r106.element;
        goto L14
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        stopAppbarLayoutFling(r101);
        return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
    }

    public final void scrollUpTo(CoordinatorLayout r100, AppBarLayout r101, int r110, boolean r111, Long r112, Animator.AnimatorListener r113) {
        if (r100 == null) goto L15;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r111 == false) goto L8;
        int r114 = Math.min(r110, 0);
    L9:
        int r102 = r114;
        if (r112 == null) goto L12;
        long r115 = r112.longValue();
    L13:
        animateOffsetWithDuration(r100, r101, r102, r115, r113);
        return;
    L12:
        r115 = getDuration(r102, r101);
        goto L13
    L8:
        r114 = Math.min(Math.max(r110, Math.min(-r101.getUpNestedPreScrollRange(), 0)), 0);
        goto L9
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        if (r106 != 1) goto L6;
        this.isFlinging = true;
    L6:
        if (this.shouldBlockNestedScroll == false) goto L8;
        return;
    L8:
        super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void animateOffsetWithDuration$default(SlidesDetailAppbarBehavior r100, CoordinatorLayout r101, AppBarLayout r102, int r110, long r111, Animator.AnimatorListener r112, int r113, Object r114) {
        if ((r113 & 16) == 0) goto L5;
        r112 = null;
    L5:
        r100.animateOffsetWithDuration(r101, r102, r110, r111, r112);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (this.shouldBlockNestedScroll == false) goto L5;
        return;
    L5:
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ void scrollUpTo$default(SlidesDetailAppbarBehavior r100, CoordinatorLayout r101, AppBarLayout r102, int r110, boolean r111, Long r112, Animator.AnimatorListener r113, int r114, Object r115) {
        if ((r114 & 8) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r114 & 16) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r114 & 32) == 0) goto L13;
        Animator.AnimatorListener r105 = null;
    L14:
        r100.scrollUpTo(r101, r102, r110, r103, r104, r105);
        return;
    L13:
        r105 = r113;
        goto L14
    L9:
        r104 = r112;
        goto L11
    L5:
        r103 = r111;
        goto L7
    }
}
