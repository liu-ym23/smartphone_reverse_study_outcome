package com.bytedance.android.ui.base.widget.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.android.ui.base.widget.icon.IconTextView;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u0010\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "Lcom/bytedance/android/ui/base/widget/icon/IconTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alwaysClickable", "", "getAlwaysClickable", "()Z", "setAlwaysClickable", "(Z)V", "isBgAdded", "onLayout", "", "changed", ScrollPosition.POSITION_LEFT, ScrollPosition.POSITION_TOP, ScrollPosition.POSITION_RIGHT, ScrollPosition.POSITION_BOTTOM, "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setBgColor", "color", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CornersButton extends IconTextView {
    private boolean alwaysClickable;
    private boolean isBgAdded;

    public CornersButton(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public CornersButton(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public final boolean getAlwaysClickable() {
        return this.alwaysClickable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (isEnabled() == true) goto L11;
        if (this.alwaysClickable == false) goto L11;
        if (r3.getActionMasked() != 1) goto L9;
        performClick();
    L9:
        super/*android.widget.TextView*/.onTouchEvent(r3);
        return true;
    L11:
        return super/*android.widget.TextView*/.onTouchEvent(r3);
    }

    public final void setAlwaysClickable(boolean r1) {
        this.alwaysClickable = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBgColor(int r2) {
        if ((getBackground() instanceof BackgroundDrawable) == false) goto L9;
        Drawable r0 = getBackground();
        if (r0 == null) goto L8;
        ((BackgroundDrawable) r0).setBgColor(r2).invalidate();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CornersButton(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        if (r4 == null) goto L5;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{R.attr.checked, 2130968787, 2130969003, 2130969004, 2130969005, 2130969006, 2130969007, 2130969008, 2130969013, 2130969018, 2130969019, 2130969020, 2130969022, 2130970300, 2130970301, 2130970303, 2130970304, 2130970309, 2130970310, 2130970311, 2130970312});
        this.alwaysClickable = r6.getBoolean(1, this.alwaysClickable);
        r6.recycle();
    L5:
        setBackground(new BackgroundDrawable(r3, r4, false));
    }

    public /* synthetic */ CornersButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.isBgAdded == false) goto L5;
        return;
    L5:
        if ((getBackground() instanceof BackgroundDrawable) == true) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L25;
        this.isBgAdded = true;
        Drawable r6 = getBackground();
        if (r6 == null) goto L22;
        BackgroundDrawable r7 = (BackgroundDrawable) r6;
        float r8 = 0;
        if (r7.getCornerRadiusTL() <= r8) goto L13;
    L20:
        r7.invalidate();
        return;
    L13:
        if (r7.getCornerRadiusTR() > r8) goto L20;
        if (r7.getCornerRadiusBL() > r8) goto L20;
        if (r7.getCornerRadiusBR() > r8) goto L20;
        r7.setCornerRadius(getHeight() / 2).invalidate();
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    }
}
