package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private int mMinimumHeight;

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.mMinimumHeight, super.getMinimumHeight());
    }

    private boolean isStacked() {
        if (getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ButtonBarLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private int getNextVisibleChildIndex(int r3) {
        int r0 = getChildCount();
    L3:
        if (r3 >= r0) goto L8;
        if (getChildAt(r3).getVisibility() == 0) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return -1;
    }

    private void setStacked(boolean r2) {
        setOrientation(r2 ? 1 : 0);
        if (r2 == false) goto L5;
        int r0 = 8388613;
    L6:
        setGravity(r0);
        View r1 = findViewById(2131387045);
        if (r1 == null) goto L12;
        if (r2 == false) goto L10;
        int r3 = 8;
    L11:
        r1.setVisibility(r3);
        goto L12
    L10:
        r3 = 4;
    L12:
        int r4 = getChildCount() - 2;
    L13:
        if (r4 < 0) goto L15;
        bringChildToFront(getChildAt(r4));
        r4 = r4 - 1;
        goto L13
    L15:
        return;
    L5:
        r0 = 80;
        goto L6
    }

    public void setAllowStacking(boolean r2) {
        if (this.mAllowStacking == r2) goto L11;
        this.mAllowStacking = r2;
        if (r2 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (getOrientation() != 1) goto L9;
        setStacked(false);
        goto L9
    }

    public ButtonBarLayout(Context r12, AttributeSet r13) {
        super(r12, r13);
        this.mLastWidthSize = -1;
        this.mMinimumHeight = 0;
        TypedArray r2 = r12.obtainStyledAttributes(r13, new int[]{2130968781});
        ViewCompat.saveAttributeDataForStyleable(this, r12, new int[]{2130968781}, r13, r2, 0, 0);
        this.mAllowStacking = r2.getBoolean(0, true);
        r2.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        int r2 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r0 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r0;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r1 = r6;
        boolean r3 = false;
    L16:
        super.onMeasure(r1, r7);
        if (this.mAllowStacking == true) goto L19;
    L26:
        if (r3 == false) goto L28;
        super.onMeasure(r6, r7);
    L28:
        int r8 = getNextVisibleChildIndex(0);
        if (r8 < 0) goto L38;
        View r9 = getChildAt(r8);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r9.getLayoutParams();
        int r5 = (((getPaddingTop() + r9.getMeasuredHeight()) + r4.topMargin) + r4.bottomMargin) + 0;
        if (isStacked() == false) goto L36;
        int r10 = getNextVisibleChildIndex(r8 + 1);
        if (r10 < 0) goto L35;
        r5 = r5 + (getChildAt(r10).getPaddingTop() + ((int) (INVOKEVIRTUAL_androidx_appcompat_widget_ButtonBarLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density * 16.0f)));
    L35:
        r2 = r5;
        goto L38
    L36:
        r2 = r5 + getPaddingBottom();
    L38:
        if (ViewCompat.getMinimumHeight(this) == r2) goto L41;
        setMinimumHeight(r2);
        return;
    L41:
        return;
    L19:
        if (isStacked() == true) goto L26;
        if ((getMeasuredWidthAndState() & (-16777216)) != 16777216) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        setStacked(true);
        r3 = true;
        goto L26
    L23:
        r11 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L15;
        r1 = View.MeasureSpec.makeMeasureSpec(r0, RtlSpacingHelper.UNDEFINED);
        r3 = true;
        goto L16
    }
}
