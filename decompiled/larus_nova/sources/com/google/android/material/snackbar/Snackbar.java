package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = null;
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
        public void onDismissed2(Snackbar r100, int r101) {
        }

        /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
        public void onShown2(Snackbar r100) {
        }

        public Callback() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onShown(Snackbar r100) {
            onShown2(r100);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onDismissed(Snackbar r100, int r101) {
            onDismissed2(r100, r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context r100) {
            super(r100);
        }

        public SnackbarLayout(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
            int r102 = getChildCount();
            int r103 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L8;
            View r105 = getChildAt(r104);
            if (r105.getLayoutParams().width != (-1)) goto L7;
            r105.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r105.getMeasuredHeight(), 1073741824));
        L7:
            r104 = r104 + 1;
            goto L3
        }
    }

    static {
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{R.attr.snackbarButtonStyle};
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        if (this.hasAction == false) goto L8;
        if (this.accessibilityManager.isTouchExplorationEnabled() == false) goto L8;
        return -2;
    L8:
        return super.getDuration();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    private static ViewGroup findSuitableParent(View r100) {
        ViewGroup r101 = null;
    L4:
        if ((r100 instanceof CoordinatorLayout) == true) goto L6;
        if ((r100 instanceof FrameLayout) == true) goto L10;
    L14:
        if (r100 == null) goto L19;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L18;
        r100 = (View) r102;
        goto L19
    L18:
        r100 = null;
    L19:
        if (r100 != null) goto L4;
        return r101;
    L10:
        if (r100.getId() == 16908290) goto L12;
        r101 = (ViewGroup) r100;
        goto L14
    L12:
        return (ViewGroup) r100;
    L6:
        return (ViewGroup) r100;
    }

    public static boolean hasSnackbarButtonStyleAttr(Context r100) {
        TypedArray r101 = r100.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int r102 = r101.getResourceId(0, -1);
        r101.recycle();
        if (r102 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public Snackbar setActionTextColor(int r100) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r100);
        return this;
    }

    public Snackbar setCallback(Callback r100) {
        BaseTransientBottomBar.BaseCallback<Snackbar> r101 = this.callback;
        if (r101 == null) goto L5;
        removeCallback(r101);
    L5:
        if (r100 == null) goto L7;
        addCallback(r100);
    L7:
        this.callback = r100;
        return this;
    }

    public Snackbar setText(CharSequence r100) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(r100);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList r100) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r100);
        return this;
    }

    public Snackbar setText(int r100) {
        return setText(getContext().getText(r100));
    }

    public Snackbar setAction(CharSequence r100, final View.OnClickListener r101) {
        Button r102 = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L7;
        this.hasAction = true;
        r102.setVisibility(0);
        r102.setText(r100);
        r102.setOnClickListener(new AnonymousClass1(this, r101));
    L8:
        return this;
    L7:
        r102.setVisibility(8);
        r102.setOnClickListener(null);
        this.hasAction = false;
        goto L8
    }

    public Snackbar setAction(int r100, View.OnClickListener r101) {
        return setAction(getContext().getText(r100), r101);
    }

    private Snackbar(ViewGroup r100, View r101, ContentViewCallback r102) {
        super(r100, r101, r102);
        this.accessibilityManager = (AccessibilityManager) r100.getContext().getSystemService("accessibility");
    }

    public static Snackbar make(View r100, CharSequence r101, int r102) {
        ViewGroup r103 = findSuitableParent(r100);
        if (r103 == null) goto L11;
        LayoutInflater r104 = LayoutInflater.from(r103.getContext());
        if (hasSnackbarButtonStyleAttr(r103.getContext()) == false) goto L7;
        int r105 = R.layout.mtrl_layout_snackbar_include;
    L8:
        SnackbarContentLayout r106 = (SnackbarContentLayout) r104.inflate(r105, r103, false);
        Snackbar r107 = new Snackbar(r103, r106, r106);
        r107.setText(r101);
        r107.setDuration(r102);
        return r107;
    L7:
        r105 = R.layout.design_layout_snackbar_include;
        goto L8
    L11:
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public static Snackbar make(View r100, int r101, int r102) {
        return make(r100, r100.getResources().getText(r101), r102);
    }
}
