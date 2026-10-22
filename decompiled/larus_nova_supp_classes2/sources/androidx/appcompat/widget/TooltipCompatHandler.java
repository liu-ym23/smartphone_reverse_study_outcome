package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r1) {
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    public void hide() {
        if (sActiveHandler != this) goto L8;
        sActiveHandler = null;
        TooltipPopup r0 = this.mPopup;
        if (r0 == null) goto L8;
        r0.hide();
        this.mPopup = null;
        clearAnchorPos();
        this.mAnchor.removeOnAttachStateChangeListener(this);
    L8:
        if (sPendingHandler != this) goto L10;
        setPendingHandler(null);
    L10:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    private void clearAnchorPos() {
        this.mAnchorX = Integer.MAX_VALUE;
        this.mAnchorY = Integer.MAX_VALUE;
    }

    private static void setPendingHandler(TooltipCompatHandler r1) {
        TooltipCompatHandler r0 = sPendingHandler;
        if (r0 == null) goto L5;
        r0.cancelPendingShow();
    L5:
        sPendingHandler = r1;
        if (r1 == null) goto L9;
        r1.scheduleShow();
        return;
    }

    private boolean updateAnchorPos(MotionEvent r4) {
        int r0 = (int) r4.getX();
        int r5 = (int) r4.getY();
        if (Math.abs(r0 - this.mAnchorX) <= this.mHoverSlop) goto L5;
    L8:
        this.mAnchorX = r0;
        this.mAnchorY = r5;
        return true;
    L5:
        if (Math.abs(r5 - this.mAnchorY) > this.mHoverSlop) goto L8;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r2) {
        this.mAnchorX = r2.getWidth() / 2;
        this.mAnchorY = r2.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        hide();
    }

    public void show(boolean r8) {
        if (ViewCompat.isAttachedToWindow(this.mAnchor) == true) goto L5;
        return;
    L5:
        setPendingHandler(null);
        TooltipCompatHandler r0 = sActiveHandler;
        if (r0 == null) goto L8;
        r0.hide();
    L8:
        sActiveHandler = this;
        this.mFromTouch = r8;
        TooltipPopup r1 = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = r1;
        r1.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch == false) goto L12;
        long r2 = LONG_CLICK_HIDE_TIMEOUT_MS;
    L16:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, r2);
        return;
    L12:
        if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) != 1) goto L14;
        long r3 = ViewConfiguration.getLongPressTimeout();
        long r4 = HOVER_HIDE_TIMEOUT_SHORT_MS;
    L15:
        r2 = r4 - r3;
        goto L16
    L14:
        r3 = ViewConfiguration.getLongPressTimeout();
        r4 = HOVER_HIDE_TIMEOUT_MS;
        goto L15
    }

    private TooltipCompatHandler(View r2, CharSequence r3) {
        this.mShowRunnable = new AnonymousClass1(this);
        this.mHideRunnable = new AnonymousClass2(this);
        this.mAnchor = r2;
        this.mTooltipText = r3;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(r2.getContext()));
        clearAnchorPos();
        r2.setOnLongClickListener(this);
        r2.setOnHoverListener(this);
    }

    public static void setTooltipText(View r2, CharSequence r3) {
        TooltipCompatHandler r0 = sPendingHandler;
        if (r0 == null) goto L8;
        if (r0.mAnchor != r2) goto L8;
        setPendingHandler(null);
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L15;
        TooltipCompatHandler r4 = sActiveHandler;
        if (r4 != null) goto L12;
    L14:
        r2.setOnLongClickListener(null);
        r2.setLongClickable(false);
        r2.setOnHoverListener(null);
        return;
    L12:
        if (r4.mAnchor != r2) goto L14;
        r4.hide();
        goto L14
    L15:
        new TooltipCompatHandler(r2, r3);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View r3, MotionEvent r4) {
        if (this.mPopup != null) goto L5;
    L7:
        AccessibilityManager r5 = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
        if (r5.isEnabled() == true) goto L10;
    L12:
        int r6 = r4.getAction();
        if (r6 == 7) goto L19;
        if (r6 != 10) goto L25;
        clearAnchorPos();
        hide();
    L25:
        return false;
    L19:
        if (this.mAnchor.isEnabled() == false) goto L25;
        if (this.mPopup != null) goto L25;
        if (updateAnchorPos(r4) == false) goto L25;
        setPendingHandler(this);
        goto L25
    L10:
        if (r5.isTouchExplorationEnabled() == false) goto L12;
        return false;
    L5:
        if (this.mFromTouch == false) goto L7;
        return false;
    }
}
