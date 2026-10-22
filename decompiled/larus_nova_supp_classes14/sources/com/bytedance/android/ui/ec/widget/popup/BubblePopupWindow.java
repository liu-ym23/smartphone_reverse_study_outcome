package com.bytedance.android.ui.ec.widget.popup;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BubblePopupWindow extends PopupWindow {
    private final Activity activity;
    protected BubbleLayout bubbleView;
    private Runnable dismissListener;
    private long inAnimTime;
    private boolean isHideVirtualKey;
    private OnClickBubbleListener listener;
    public long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBubbleOffset;
    private final Runnable mDismissRunnable;
    private int mGravity;
    private boolean mIsAlreadyDismiss;
    private boolean mNeedOverShoot;
    private boolean mNeedPath;
    private boolean mNeedPressFade;
    private boolean mShowInAnim;
    private boolean mShowOutAnim;
    private TextView mTextView;
    private int mXOffset;
    private int mYOffset;
    private long outAnimTime;
    private AnimatorSet set;

    public interface OnClickBubbleListener {
        void clickBubble();
    }

    public static /* synthetic */ void a(BubblePopupWindow r0, View r1) {
        r0.lambda$setBubbleView$0(r1);
    }

    public static /* synthetic */ void access$001(PopupWindow r0) {
        super.dismiss();
    }

    public static /* synthetic */ void access$002(PopupWindow r0, View r1, int r2, int r3, int r4) {
        super.showAsDropDown(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$003(PopupWindow r0, View r1, int r2, int r3, int r4) {
        super.showAtLocation(r1, r2, r3, r4);
    }

    public int getOrientation(int r3) {
        if (r3 != 3) goto L5;
        return 2;
    L5:
        if (r3 != 48) goto L7;
        return 3;
    L7:
        if (r3 == 80) goto L9;
        return 1;
    L9:
        return 0;
    }

    private void defaultView() {
        TextView r0 = new TextView(this.activity);
        this.mTextView = r0;
        r0.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        this.mTextView.setTextSize(13.0f);
        this.mTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mTextView.setMaxLines(2);
        this.mTextView.setGravity(17);
        setBubbleView(this.mTextView, Boolean.FALSE);
        this.isHideVirtualKey = true;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private void hideStatusBar() {
        if (this.isHideVirtualKey == true) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.mIsAlreadyDismiss == true) goto L12;
        animatorEasyInOut(false, this.mGravity);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L8;
        r0.removeAllViews();
    L8:
        if (isShowing() == false) goto L12;
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);     // Catch: Exception -> L11
    L12:
        Runnable r1 = this.dismissListener;
        if (r1 == null) goto L18;
        r1.run();
        return;
    }

    public int getHeightWithArrow() {
        BubbleLayout r0 = this.bubbleView;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getHeightWithArrow();
    }

    public void onDestroy() {
        AnimatorSet r0 = this.set;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
        this.set.cancel();
        this.set = null;
    L6:
        if (this.activity.isFinishing() == false) goto L8;
        return;
    L8:
        if (isShowing() == false) goto L16;
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    public long getInAnimTime() {
        return this.inAnimTime;
    }

    public BubblePopupWindow(Activity r3) {
        this(r3, true, false);
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        access$001(r0);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(BubblePopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public static /* synthetic */ int access$000(BubblePopupWindow r0) {
        return r0.mGravity;
    }

    public static /* synthetic */ AnimatorSet access$200(BubblePopupWindow r0) {
        return r0.set;
    }

    public static /* synthetic */ long access$300(BubblePopupWindow r2) {
        return r2.inAnimTime;
    }

    public static /* synthetic */ long access$400(BubblePopupWindow r2) {
        return r2.outAnimTime;
    }

    public static /* synthetic */ boolean access$500(BubblePopupWindow r0) {
        return r0.mNeedOverShoot;
    }

    private /* synthetic */ void lambda$setBubbleView$0(View r1) {
        OnClickBubbleListener r2 = this.listener;
        if (r2 == null) goto L5;
        r2.clickBubble();
    L5:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);
    }

    private void setBubbleOffset(int r1) {
        this.mBubbleOffset = r1;
    }

    public void setArrowLongSize(int r2) {
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setArrowLongSize(r2);
        return;
    }

    public void setArrowVerticalSize(int r2) {
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setArrowVerticalSize(r2);
        return;
    }

    public void setAutoDismissDelayMillis(long r1) {
        this.mAutoDismissDelayMillis = r1;
    }

    public void setBgColor(int r2) {
        this.mBgColor = r2;
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setBgColor(r2);
        return;
    }

    public void setHorizontalPadding(int r2) {
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setHorizontalPadding(r2);
        return;
    }

    public void setInAnimTime(long r1) {
        this.inAnimTime = r1;
    }

    public void setNeedPath(boolean r2) {
        this.mNeedPath = r2;
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setNeedPath(r2);
        return;
    }

    public void setOutAnimTime(long r1) {
        this.outAnimTime = r1;
    }

    public void setShadowLayerColor(int r2) {
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setShadowLayerColor(r2);
        return;
    }

    public void setShadowLayerYOffset(int r2) {
        BubbleLayout r0 = this.bubbleView;
        if (r0 == null) goto L6;
        r0.setShadowLayerYOffset(r2);
        return;
    }

    public void setShowOutAnim(boolean r1) {
        this.mShowOutAnim = r1;
    }

    public void setXOffset(int r1) {
        this.mXOffset = r1;
    }

    public void setYOffset(int r1) {
        this.mYOffset = r1;
    }

    public void show(View r3) {
        show(r3, 80, true);
    }

    private void animatorEasyInOut(final boolean r3, final int r4) {
        final BubbleLayout r0 = this.bubbleView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
    L10:
        if (r3 == false) goto L12;
    L15:
        if (r3 == true) goto L17;
        this.mIsAlreadyDismiss = true;
    L17:
        AnimatorSet r1 = this.set;
        if (r1 != null) goto L20;
        this.set = new AnimatorSet();
    L21:
        r0.post(new AnonymousClass2(this, r4, r0, r3));
        return;
    L20:
        r1.removeAllListeners();
        this.set.cancel();
        goto L21
    L12:
        if (this.mShowOutAnim == true) goto L15;
        r0.setVisibility(8);
        return;
    L7:
        if (this.mShowInAnim == true) goto L10;
        r0.setVisibility(0);
    }

    public void setBubbleView(View r3, Boolean r4) {
        BubbleLayout r0 = new BubbleLayout(this.activity, r4);
        this.bubbleView = r0;
        r0.setBackgroundColor(0);
        this.bubbleView.removeAllViews();
        this.bubbleView.addView(r3);
        this.bubbleView.setGravity(17);
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-2, -2);
        this.bubbleView.setLayoutParams(r5);
        this.bubbleView.setVisibility(8);
        int r6 = this.mBgColor;
        if (r6 == 0) goto L5;
        this.bubbleView.setBgColor(r6);
    L5:
        this.bubbleView.setNeedPath(this.mNeedPath);
        this.bubbleView.setNeedPressFade(this.mNeedPressFade);
        this.bubbleView.setOnClickListener(new c(this));
        setContentView(this.bubbleView);
    }

    public BubblePopupWindow(Activity r4, boolean r5, boolean r6) {
        super(r4);
        this.mBubbleOffset = 0;
        this.mShowInAnim = true;
        this.mShowOutAnim = true;
        this.mNeedPath = true;
        this.mAutoDismissDelayMillis = 7000;
        this.mDismissRunnable = new AnonymousClass1(this);
        this.inAnimTime = 800;
        this.outAnimTime = 200;
        this.activity = r4;
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (r5 == false) goto L6;
        defaultView();
        return;
    }

    public static /* synthetic */ void access$100(BubblePopupWindow r0, boolean r1, int r2) {
        r0.animatorEasyInOut(r1, r2);
    }

    public void show(View r10, int r11, boolean r12) {
        if (this.activity.isFinishing() == true) goto L59;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getWindowToken() == null) goto L62;
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r11;
        if (isShowing() == true) goto L57;
        int r0 = getOrientation(r11);
        getContentView().measure(0, 0);
        if (r12 == false) goto L21;
        BubbleLayout r5 = this.bubbleView;
        if (r5 == null) goto L15;
        int r6 = r5.getHorizontalPadding();
    L16:
        if (r11 == 80) goto L20;
        if (r11 == 48) goto L20;
        int r7 = (getContentView().getMeasuredHeight() + (r6 * 2)) / 2;
    L22:
        BubbleLayout r8 = this.bubbleView;
        if (r8 == null) goto L25;
        r8.setBubbleParams(r0, r7 + this.mBubbleOffset);
    L25:
        int[] r1 = new int[2];
        r10.getLocationInWindow(r1);
        int r9 = getContentView().getHeight();
        if (r9 != 0) goto L30;
        BubbleLayout r13 = this.bubbleView;
        if (r13 == null) goto L30;
        r9 = r13.getHeightWithArrow();
    L30:
        int r14 = getContentView().getMeasuredWidth() + (this.bubbleView.getHorizontalPadding() * 2);
        if (r11 != 3) goto L33;
        if (r12 == false) goto L51;
        int r15 = (r10.getMeasuredHeight() - r9) / 2;
    L52:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r10, 0, (r1[0] + this.mXOffset) - r14, (r1[1] + this.mYOffset) + r15);
        animatorEasyInOut(true, r11);
    L53:
        this.mIsAlreadyDismiss = false;
        if (this.mAutoDismissDelayMillis <= 0) goto L56;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);
    L56:
        hideStatusBar();
        return;
    L51:
        r15 = 0;
        goto L52
    L33:
        if (r11 == 5) goto L45;
        if (r11 == 48) goto L41;
        if (r11 != 80) goto L53;
        if (r12 == false) goto L39;
        int r16 = (r10.getMeasuredWidth() - r14) / 2;
    L40:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r10, this.mXOffset + r16, this.mYOffset);
        animatorEasyInOut(true, r11);
        goto L53
    L39:
        r16 = 0;
        goto L40
    L41:
        if (r12 == false) goto L43;
        int r17 = (r10.getMeasuredWidth() - r14) / 2;
    L44:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r10, 0, (r1[0] + this.mXOffset) + r17, (r1[1] - r9) + this.mYOffset);
        animatorEasyInOut(true, r11);
        goto L53
    L43:
        r17 = 0;
        goto L44
    L45:
        if (r12 == false) goto L47;
        int r18 = (r10.getMeasuredHeight() - r9) / 2;
    L48:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r10, 0, (r1[0] + this.mXOffset) + r10.getWidth(), (r1[1] + this.mYOffset) + r18);
        animatorEasyInOut(true, r11);
        goto L53
    L47:
        r18 = 0;
    L20:
        r7 = (getContentView().getMeasuredWidth() + (r6 * 2)) / 2;
        goto L22
    L15:
        r6 = 0;
        goto L16
    L21:
        r7 = 0;
        goto L22
    L57:
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);
        return;
    L62:
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(BubblePopupWindow r2, View r3, int r4, int r5) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r0) == false) goto L5;
        return;
    L5:
        r2.showAsDropDown(r3, r4, r5);
        PopupWindowLancet.trackAfterShow(r2, r0, r3);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r1, int r2, int r3, int r4) {
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r1, r2, r3, r4);     // Catch: Exception -> L4
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r1, int r2, int r3, int r4) {
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r1, r2, r3, r4);     // Catch: Exception -> L4
        return;
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r2, View r3, int r4, int r5, int r6) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r0) == false) goto L5;
        return;
    L5:
        access$002(r2, r3, r4, r5, r6);
        PopupWindowLancet.trackAfterShow(r2, r0, r3);
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r7, View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r8, r0, r9, r10, r11) == false) goto L14;
        return;
    L14:
        access$003(r7, r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(r7, r0, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        access$003(r7, r8, r9, r10, r11);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(BubblePopupWindow r7, View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r8, r0, r9, r10, r11) == false) goto L14;
        return;
    L14:
        r7.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(r7, r0, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r8, r9, r10, r11);
    }

    public void show(View r1, int r2, int r3, int r4, int r5) {
        setXOffset(r3);
        setYOffset(r4);
        setBubbleOffset(r2);
        show(r1, r5, true);
    }
}
