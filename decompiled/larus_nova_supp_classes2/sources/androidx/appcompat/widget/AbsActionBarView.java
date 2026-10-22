package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material3.MenuKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;
        final /* synthetic */ AbsActionBarView this$0;

        public VisibilityAnimListener(AbsActionBarView r1) {
            this.this$0 = r1;
            this.mCanceled = false;
        }

        public void onAnimationCancel(View r1) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View r2) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            AbsActionBarView r3 = this.this$0;
            r3.mVisibilityAnim = null;
            AbsActionBarView.access$101(r3, this.mFinalVisibility);
        }

        public void onAnimationStart(View r2) {
            AbsActionBarView.access$001(this.this$0, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat r2, int r3) {
            this.this$0.mVisibilityAnim = r2;
            this.mFinalVisibility = r3;
            return this;
        }
    }

    public static int next(int r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return r0 - r1;
    L5:
        return r0 + r1;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) goto L7;
        return this.mVisAnimListener.mFinalVisibility;
    L7:
        return getVisibility();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowReserved() == false) goto L7;
        return true;
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.showOverflowMenu();
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public AbsActionBarView(Context r2) {
        this(r2, null);
    }

    public void animateToVisibility(int r3) {
        setupAnimatorToVisibility(r3, 200).start();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        TypedArray r0 = getContext().obtainStyledAttributes(null, new int[]{2130968899, 2130968904, 2130968905, 2130969620, 2130969621, 2130969622, 2130969623, 2130969624, 2130969625, 2130969710, 2130969757, 2130969758, 2130969940, 2130970198, 2130970208, 2130970261, 2130970262, 2130970280, 2130970332, 2130970410, 2130972601, 2130972815, 2130973585, 2130973620, 2130973621, 2130974326, 2130974330, 2130974574, 2130974592}, 2130968715, 0);
        setContentHeight(r0.getLayoutDimension(13, 0));
        r0.recycle();
        ActionMenuPresenter r1 = this.mActionMenuPresenter;
        if (r1 == null) goto L6;
        r1.onConfigurationChanged(r6);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r7 = super.onHoverEvent(r6);
        if (r0 != 9) goto L12;
        if (r7 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r0 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r0 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r6 = super.onTouchEvent(r5);
        if (r0 != 0) goto L11;
        if (r6 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r0 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r0 != 3) goto L15;
        goto L14
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (r2 == getVisibility()) goto L9;
        ViewPropertyAnimatorCompat r0 = this.mVisibilityAnim;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        super.setVisibility(r2);
        return;
    }

    public AbsActionBarView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void access$001(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    public static /* synthetic */ void access$101(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r3, long r4) {
        ViewPropertyAnimatorCompat r0 = this.mVisibilityAnim;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r3 == 0) goto L8;
        ViewPropertyAnimatorCompat r1 = ViewCompat.animate(this).alpha(MenuKt.ClosedAlphaTarget);
        r1.setDuration(r4);
        r1.setListener(this.mVisAnimListener.withFinalVisibility(r1, r3));
        return r1;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(MenuKt.ClosedAlphaTarget);
    L10:
        ViewPropertyAnimatorCompat r2 = ViewCompat.animate(this).alpha(1.0f);
        r2.setDuration(r4);
        r2.setListener(this.mVisAnimListener.withFinalVisibility(r2, r3));
        return r2;
    }

    public AbsActionBarView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue r6 = new TypedValue();
        if (r3.getTheme().resolveAttribute(2130968712, r6, true) == true) goto L5;
    L7:
        this.mPopupContext = r3;
        return;
    L5:
        if (r6.resourceId == 0) goto L7;
        this.mPopupContext = new ContextThemeWrapper(r3, r6.resourceId);
    }

    public int measureChildView(View r2, int r3, int r4, int r5) {
        r2.measure(View.MeasureSpec.makeMeasureSpec(r3, RtlSpacingHelper.UNDEFINED), r4);
        return Math.max(0, (r3 - r2.getMeasuredWidth()) - r5);
    }

    public int positionChild(View r3, int r4, int r5, int r6, boolean r7) {
        int r0 = r3.getMeasuredWidth();
        int r1 = r3.getMeasuredHeight();
        int r8 = r5 + ((r6 - r1) / 2);
        if (r7 == false) goto L5;
        r3.layout(r4 - r0, r8, r4, r1 + r8);
    L6:
        if (r7 == true) goto L8;
        return r0;
    L8:
        return -r0;
    L5:
        r3.layout(r4, r8, r4 + r0, r1 + r8);
        goto L6
    }
}
