package com.google.android.material.snackbar;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = null;
    private static final boolean USE_OFFSET_API = false;
    static final Handler handler = null;
    private final AccessibilityManager accessibilityManager;
    private Behavior behavior;
    private List<BaseCallback<B>> callbacks;
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    final SnackbarManager.Callback managerCallback;
    private final ViewGroup targetParent;
    protected final SnackbarBaseLayout view;

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public BaseCallback() {
        }

        public void onDismissed(B r100, int r101) {
        }

        public void onShown(B r100) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final BehaviorDelegate delegate;

        public Behavior() {
            this.delegate = new BehaviorDelegate(this);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r100) {
            this.delegate.setBaseTransientBottomBar(r100);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r100) {
            return this.delegate.canSwipeDismissView(r100);
        }

        public static /* synthetic */ void access$000(Behavior r100, BaseTransientBottomBar r101) {
            r100.setBaseTransientBottomBar(r101);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            this.delegate.onInterceptTouchEvent(r100, r101, r102);
            return super.onInterceptTouchEvent(r100, r101, r102);
        }
    }

    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior<?> r100) {
            r100.setStartAlphaSwipeDistance(0.1f);
            r100.setEndAlphaSwipeDistance(0.6f);
            r100.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View r100) {
            return r100 instanceof SnackbarBaseLayout;
        }

        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> r100) {
            this.managerCallback = r100.managerCallback;
        }

        public void onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            int r103 = r102.getActionMasked();
            if (r103 == 0) goto L11;
            if (r103 != 1) goto L7;
        L9:
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            return;
        L7:
            if (r103 == 3) goto L9;
            return;
        L11:
            if (r100.isPointInChildBounds(r101, (int) r102.getX(), (int) r102.getY()) == false) goto L15;
            SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            return;
        }
    }

    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View r100);

        void onViewDetachedFromWindow(View r100);
    }

    public interface OnLayoutChangeListener {
        void onLayoutChange(View r100, int r101, int r102, int r103, int r104);
    }

    public static class SnackbarBaseLayout extends FrameLayout {
        private final AccessibilityManager accessibilityManager;
        private OnAttachStateChangeListener onAttachStateChangeListener;
        private OnLayoutChangeListener onLayoutChangeListener;
        private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener r100 = this.onAttachStateChangeListener;
            if (r100 == null) goto L5;
            r100.onViewAttachedToWindow(this);
        L5:
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener r100 = this.onAttachStateChangeListener;
            if (r100 == null) goto L5;
            r100.onViewDetachedFromWindow(this);
        L5:
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        }

        public SnackbarBaseLayout(Context r100) {
            this(r100, null);
        }

        private void setClickableOrFocusableBasedOnAccessibility(boolean r100) {
            setClickable(!r100);
            setFocusable(r100);
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener r100) {
            this.onAttachStateChangeListener = r100;
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener r100) {
            this.onLayoutChangeListener = r100;
        }

        public SnackbarBaseLayout(Context r100, AttributeSet r101) {
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxWidth, com.larus.nova.R.attr.elevation, com.larus.nova.R.attr.maxActionInlineWidth});
            if (r102.hasValue(1) == false) goto L5;
            ViewCompat.setElevation(this, r102.getDimensionPixelSize(1, 0));
        L5:
            r102.recycle();
            AccessibilityManager r103 = (AccessibilityManager) r100.getSystemService("accessibility");
            this.accessibilityManager = r103;
            AccessibilityManagerCompat.TouchExplorationStateChangeListener r104 = new AnonymousClass1(this);
            this.touchExplorationStateChangeListener = r104;
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(r103, r104);
            setClickableOrFocusableBasedOnAccessibility(r103.isTouchExplorationEnabled());
        }

        public static /* synthetic */ void access$300(SnackbarBaseLayout r100, boolean r101) {
            r100.setClickableOrFocusableBasedOnAccessibility(r101);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
            super.onLayout(r100, r101, r102, r110, r111);
            OnLayoutChangeListener r103 = this.onLayoutChangeListener;
            if (r103 == null) goto L6;
            r103.onLayoutChange(this, r101, r102, r110, r111);
            return;
        }
    }

    static {
        USE_OFFSET_API = false;
        SNACKBAR_STYLE_ATTR = new int[]{com.larus.nova.R.attr.snackbarStyle};
        handler = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    private int getTranslationYBottom() {
        int r100 = this.view.getHeight();
        ViewGroup.LayoutParams r101 = this.view.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return r100;
    L5:
        return r100 + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
    }

    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray r100 = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int r101 = r100.getResourceId(0, -1);
        r100.recycle();
        if (r101 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean shouldAnimate() {
        List<AccessibilityServiceInfo> r100 = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return true;
    }

    public final void showView() {
        if (this.view.getParent() != null) goto L14;
        ViewGroup.LayoutParams r100 = this.view.getLayoutParams();
        if ((r100 instanceof CoordinatorLayout.LayoutParams) == false) goto L13;
        CoordinatorLayout.LayoutParams r101 = (CoordinatorLayout.LayoutParams) r100;
        SwipeDismissBehavior<? extends View> r102 = this.behavior;
        if (r102 != null) goto L10;
        r102 = getNewBehavior();
    L10:
        if ((r102 instanceof Behavior) == false) goto L12;
        Behavior.access$000((Behavior) r102, this);
    L12:
        r102.setListener(new AnonymousClass5(this));
        r101.setBehavior(r102);
        r101.insetEdge = 80;
    L13:
        this.targetParent.addView(this.view);
    L14:
        this.view.setOnAttachStateChangeListener(new AnonymousClass6(this));
        if (ViewCompat.isLaidOut(this.view) == true) goto L17;
        this.view.setOnLayoutChangeListener(new AnonymousClass7(this));
        return;
    L17:
        if (shouldAnimate() == false) goto L19;
        animateViewIn();
        return;
    L19:
        onViewShown();
    }

    public void animateViewIn() {
        final int r100 = getTranslationYBottom();
        if (USE_OFFSET_API == false) goto L5;
        ViewCompat.offsetTopAndBottom(this.view, r100);
    L6:
        ValueAnimator r101 = new ValueAnimator();
        r101.setIntValues(new int[]{r100, 0});
        r101.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r101.setDuration(250);
        r101.addListener(new AnonymousClass8(this));
        r101.addUpdateListener(new AnonymousClass9(this, r100));
        r101.start();
        return;
    L5:
        this.view.setTranslationY(r100);
        goto L6
    }

    public int getSnackbarBaseLayoutResId() {
        if (hasSnackbarStyleAttr() == false) goto L5;
        return com.larus.nova.R.layout.mtrl_layout_snackbar;
    L5:
        return com.larus.nova.R.layout.design_layout_snackbar;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> r100 = this.callbacks;
        if (r100 == null) goto L7;
        int r101 = r100.size() - 1;
    L5:
        if (r101 < 0) goto L9;
        ((BaseCallback) ListProtector.get(this.callbacks, r101)).onShown(this);
        r101 = r101 - 1;
        goto L5
    L9:
        return;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public static /* synthetic */ boolean access$200() {
        return USE_OFFSET_API;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    public View getView() {
        return this.view;
    }

    public static /* synthetic */ com.google.android.material.snackbar.ContentViewCallback access$100(BaseTransientBottomBar r100) {
        return r100.contentViewCallback;
    }

    private void animateViewOut(final int r100) {
        ValueAnimator r101 = new ValueAnimator();
        r101.setIntValues(new int[]{0, getTranslationYBottom()});
        r101.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r101.setDuration(250);
        r101.addListener(new AnonymousClass10(this, r100));
        r101.addUpdateListener(new AnonymousClass11(this));
        r101.start();
    }

    public B addCallback(BaseCallback<B> r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        if (this.callbacks != null) goto L7;
        this.callbacks = new ArrayList();
    L7:
        this.callbacks.add(r100);
        return this;
    }

    public void dispatchDismiss(int r100) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, r100);
    }

    public final void hideView(int r100) {
        if (shouldAnimate() == true) goto L5;
    L7:
        onViewHidden(r100);
        return;
    L5:
        if (this.view.getVisibility() != 0) goto L7;
        animateViewOut(r100);
    }

    public void onViewHidden(int r100) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> r101 = this.callbacks;
        if (r101 == null) goto L7;
        int r102 = r101.size() - 1;
    L5:
        if (r102 < 0) goto L7;
        ((BaseCallback) ListProtector.get(this.callbacks, r102)).onDismissed(this, r100);
        r102 = r102 - 1;
    L7:
        ViewParent r103 = this.view.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r103).removeView(this.view);
        return;
    }

    public B removeCallback(BaseCallback<B> r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        List<BaseCallback<B>> r101 = this.callbacks;
        if (r101 != null) goto L7;
        return this;
    L7:
        r101.remove(r100);
        return this;
    }

    public B setBehavior(Behavior r100) {
        this.behavior = r100;
        return this;
    }

    public B setDuration(int r100) {
        this.duration = r100;
        return this;
    }

    public BaseTransientBottomBar(ViewGroup r100, View r101, com.google.android.material.snackbar.ContentViewCallback r102) {
        this.managerCallback = new AnonymousClass4(this);
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        this.targetParent = r100;
        this.contentViewCallback = r102;
        Context r103 = r100.getContext();
        this.context = r103;
        ThemeEnforcement.checkAppCompatTheme(r103);
        SnackbarBaseLayout r104 = (SnackbarBaseLayout) LayoutInflater.from(r103).inflate(getSnackbarBaseLayoutResId(), r100, false);
        this.view = r104;
        r104.addView(r101);
        ViewCompat.setAccessibilityLiveRegion(r104, 1);
        ViewCompat.setImportantForAccessibility(r104, 1);
        ViewCompat.setFitsSystemWindows(r104, true);
        ViewCompat.setOnApplyWindowInsetsListener(r104, new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(r104, new AnonymousClass3(this));
        this.accessibilityManager = (AccessibilityManager) r103.getSystemService("accessibility");
        return;
    L9:
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    L11:
        throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    L13:
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }
}
