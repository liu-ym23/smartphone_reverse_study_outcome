package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance;
    float alphaStartSwipeDistance;
    private final ViewDragHelper.Callback dragCallback;
    float dragDismissThreshold;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View r100);

        void onDragStateChanged(int r100);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        final /* synthetic */ SwipeDismissBehavior this$0;
        private final View view;

        @Override // java.lang.Runnable
        public void run() {
            com_google_android_material_behavior_SwipeDismissBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_android_material_behavior_SwipeDismissBehavior$SettleRunnable__run$___twin___() {
            ViewDragHelper r100 = this.this$0.viewDragHelper;
            if (r100 == null) goto L8;
            if (r100.continueSettling(true) == false) goto L8;
            ViewCompat.postOnAnimation(this.view, this);
            return;
        L8:
            if (this.dismiss == false) goto L14;
            OnDismissListener r101 = this.this$0.listener;
            if (r101 == null) goto L15;
            r101.onDismiss(this.view);
            return;
        L15:
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_android_material_behavior_SwipeDismissBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(SettleRunnable r100) {
            r100.com_google_android_material_behavior_SwipeDismissBehavior$SettleRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SettleRunnable(SwipeDismissBehavior r100, View r101, boolean r102) {
            this.this$0 = r100;
            this.view = r101;
            this.dismiss = r102;
        }
    }

    public static float fraction(float r100, float r101, float r102) {
        return (r102 - r100) / (r101 - r100);
    }

    public boolean canSwipeDismissView(View r100) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper r100 = this.viewDragHelper;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getViewDragState();
    }

    public SwipeDismissBehavior() {
        this.sensitivity = 0.0f;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = 0.0f;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new AnonymousClass1(this);
    }

    private void ensureViewDragHelper(ViewGroup r100) {
        if (this.viewDragHelper == null) goto L5;
        return;
    L5:
        if (this.sensitivitySet == false) goto L7;
        ViewDragHelper r101 = ViewDragHelper.create(r100, this.sensitivity, this.dragCallback);
    L8:
        this.viewDragHelper = r101;
        return;
    L7:
        r101 = ViewDragHelper.create(r100, this.dragCallback);
        goto L8
    }

    public void setDragDismissDistance(float r100) {
        this.dragDismissThreshold = clamp(0.0f, r100, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float r100) {
        this.alphaEndSwipeDistance = clamp(0.0f, r100, 1.0f);
    }

    public void setListener(OnDismissListener r100) {
        this.listener = r100;
    }

    public void setSensitivity(float r100) {
        this.sensitivity = r100;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float r100) {
        this.alphaStartSwipeDistance = clamp(0.0f, r100, 1.0f);
    }

    public void setSwipeDirection(int r100) {
        this.swipeDirection = r100;
    }

    public static float clamp(float r100, float r101, float r102) {
        return Math.min(Math.max(r100, r101), r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        boolean r103 = this.interceptingEvents;
        int r104 = r102.getActionMasked();
        if (r104 != 0) goto L5;
        r103 = r100.isPointInChildBounds(r101, (int) r102.getX(), (int) r102.getY());
        this.interceptingEvents = r103;
    L11:
        if (r103 == false) goto L14;
        ensureViewDragHelper(r100);
        return this.viewDragHelper.shouldInterceptTouchEvent(r102);
    L14:
        return false;
    L5:
        if (r104 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r104 == 3) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        ViewDragHelper r103 = this.viewDragHelper;
        if (r103 == null) goto L6;
        r103.processTouchEvent(r102);
        return true;
    L6:
        return false;
    }

    public static int clamp(int r100, int r101, int r102) {
        return Math.min(Math.max(r100, r101), r102);
    }
}
