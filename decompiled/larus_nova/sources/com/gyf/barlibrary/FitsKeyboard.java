package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes23.dex */
public class FitsKeyboard implements ViewTreeObserver.OnGlobalLayoutListener {
    private final int mActionBarHeight;
    private Activity mActivity;
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private ImmersionBar mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private final int mStatusBarHeight;
    private int mTempKeyboardHeight;
    private Window mWindow;

    public void cancel() {
        if (this.mIsAddListener == false) goto L6;
        this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.mIsAddListener = false;
        return;
    }

    public void disable() {
        if (this.mIsAddListener == true) goto L5;
        return;
    L5:
        if (this.mChildView == null) goto L7;
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        return;
    L7:
        this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImmersionBar r100 = this.mImmersionBar;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getBarParams() != null) goto L7;
        return;
    L7:
        if (this.mImmersionBar.getBarParams().keyboardEnable == false) goto L42;
        int r101 = ImmersionBar.getNavigationBarHeight(this.mActivity);
        Rect r102 = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(r102);
        int r103 = this.mContentView.getHeight() - r102.bottom;
        if (r103 == this.mTempKeyboardHeight) goto L43;
        this.mTempKeyboardHeight = r103;
        boolean r104 = true;
        int r105 = 0;
        if (ImmersionBar.checkFitsSystemWindows(INVOKEVIRTUAL_com_gyf_barlibrary_FitsKeyboard_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.mWindow).findViewById(R.id.content)) == false) goto L13;
        r103 = r103 - r101;
        if (r103 > r101) goto L33;
        r104 = false;
    L33:
        if (r103 < 0) goto L37;
        r105 = r103;
    L37:
        if (this.mImmersionBar.getBarParams().onKeyboardListener == null) goto L44;
        this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(r104, r105);
        return;
    L44:
        return;
    L13:
        if (this.mChildView != null) goto L15;
        int r106 = this.mImmersionBar.getPaddingBottom();
        r103 = r103 - r101;
        if (r103 <= r101) goto L27;
        r106 = r103 + r101;
    L28:
        this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), r106);
        goto L33
    L27:
        r104 = false;
        goto L28
    L15:
        if (this.mImmersionBar.getBarParams().isSupportActionBar == false) goto L18;
        r103 = r103 + (this.mActionBarHeight + this.mStatusBarHeight);
    L18:
        if (this.mImmersionBar.getBarParams().fits == false) goto L20;
        r103 = r103 + this.mStatusBarHeight;
    L20:
        if (r103 <= r101) goto L22;
        int r107 = this.mPaddingBottom + r103;
    L23:
        this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, r107);
        goto L33
    L22:
        r107 = 0;
        r104 = false;
        goto L23
    L43:
        return;
    }

    public static View INVOKEVIRTUAL_com_gyf_barlibrary_FitsKeyboard_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public void enable(int r100) {
        this.mWindow.setSoftInputMode(r100);
        if (this.mIsAddListener == true) goto L6;
        this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.mIsAddListener = true;
        return;
    }

    public FitsKeyboard(ImmersionBar r100, Activity r101, Window r102) {
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mImmersionBar = r100;
        this.mActivity = r101;
        this.mWindow = r102;
        View r103 = INVOKEVIRTUAL_com_gyf_barlibrary_FitsKeyboard_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102);
        this.mDecorView = r103;
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.content);
        View r105 = r104.getChildAt(0);
        this.mChildView = r105;
        if (r105 != null) goto L5;
    L10:
        View r106 = this.mChildView;
        View r107 = r104;
        if (r106 == null) goto L13;
        r107 = r106;
    L13:
        this.mContentView = r107;
        BarConfig r108 = new BarConfig(this.mActivity);
        this.mStatusBarHeight = r108.getStatusBarHeight();
        this.mActionBarHeight = r108.getActionBarHeight();
        return;
    L5:
        if ((r105 instanceof DrawerLayout) == false) goto L7;
        this.mChildView = ((DrawerLayout) r105).getChildAt(0);
    L7:
        View r109 = this.mChildView;
        if (r109 == null) goto L10;
        this.mPaddingLeft = r109.getPaddingLeft();
        this.mPaddingTop = this.mChildView.getPaddingTop();
        this.mPaddingRight = this.mChildView.getPaddingRight();
        this.mPaddingBottom = this.mChildView.getPaddingBottom();
        goto L10
    }
}
