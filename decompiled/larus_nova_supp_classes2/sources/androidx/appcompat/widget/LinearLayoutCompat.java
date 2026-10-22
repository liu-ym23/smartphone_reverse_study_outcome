package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.compose.material3.MenuKt;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public int getChildrenSkipCount(View r1, int r2) {
        return 0;
    }

    public int getLocationOffset(View r1) {
        return 0;
    }

    public int getNextLocationOffset(View r1) {
        return 0;
    }

    public int measureNullChild(int r1) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int r0 = this.mOrientation;
        if (r0 != 0) goto L7;
        return new LayoutParams(-2, -2);
    L7:
        if (r0 == 1) goto L9;
        return null;
    L9:
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) goto L5;
        int r0 = getChildCount();
        int r1 = this.mBaselineAlignedChildIndex;
        if (r0 <= r1) goto L29;
        View r2 = getChildAt(r1);
        int r3 = r2.getBaseline();
        if (r3 == (-1)) goto L11;
        int r4 = this.mBaselineChildTop;
        if (this.mOrientation != 1) goto L27;
        int r5 = this.mGravity & 112;
        if (r5 == 48) goto L27;
        if (r5 != 16) goto L22;
        r4 = r4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
        goto L27
    L22:
        if (r5 != 80) goto L27;
        r4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
    L27:
        return (r4 + ((LinearLayout.LayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) + r3;
    L11:
        if (this.mBaselineAlignedChildIndex != 0) goto L14;
        return -1;
    L14:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L29:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public LinearLayoutCompat(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas r7) {
        int r0 = getVirtualChildCount();
        boolean r1 = ViewUtils.isLayoutRtl(this);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        View r3 = getVirtualChildAt(r2);
        if (r3 == null) goto L15;
        if (r3.getVisibility() == 8) goto L15;
        if (hasDividerBeforeChildAt(r2) == false) goto L15;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        if (r1 == false) goto L13;
        int r5 = r3.getRight() + ((LinearLayout.LayoutParams) r4).rightMargin;
    L14:
        drawVerticalDivider(r7, r5);
        goto L15
    L13:
        r5 = (r3.getLeft() - ((LinearLayout.LayoutParams) r4).leftMargin) - this.mDividerWidth;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        if (hasDividerBeforeChildAt(r0) == false) goto L35;
        View r6 = getVirtualChildAt(r0 - 1);
        if (r6 != null) goto L23;
        if (r1 == false) goto L22;
        int r8 = getPaddingLeft();
    L28:
        drawVerticalDivider(r7, r8);
        return;
    L22:
        int r9 = getWidth() - getPaddingRight();
        int r10 = this.mDividerWidth;
    L26:
        r8 = r9 - r10;
        goto L28
    L23:
        LayoutParams r11 = (LayoutParams) r6.getLayoutParams();
        if (r1 == false) goto L27;
        r9 = r6.getLeft() - ((LinearLayout.LayoutParams) r11).leftMargin;
        r10 = this.mDividerWidth;
        goto L26
    L27:
        r8 = r6.getRight() + ((LinearLayout.LayoutParams) r11).rightMargin;
        goto L28
    }

    public void drawDividersVertical(Canvas r6) {
        int r0 = getVirtualChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = getVirtualChildAt(r1);
        if (r2 == null) goto L11;
        if (r2.getVisibility() == 8) goto L11;
        if (hasDividerBeforeChildAt(r1) == false) goto L11;
        drawHorizontalDivider(r6, (r2.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) r2.getLayoutParams())).topMargin) - this.mDividerHeight);
    L11:
        r1 = r1 + 1;
        goto L3
    L13:
        if (hasDividerBeforeChildAt(r0) == false) goto L25;
        View r3 = getVirtualChildAt(r0 - 1);
        if (r3 != null) goto L17;
        int r4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
    L18:
        drawHorizontalDivider(r6, r4);
        return;
    L17:
        r4 = r3.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) r3.getLayoutParams())).bottomMargin;
        goto L18
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public View getVirtualChildAt(int r1) {
        return getChildAt(r1);
    }

    public boolean hasDividerBeforeChildAt(int r5) {
        if (r5 != 0) goto L9;
        if ((this.mShowDividers & 1) == 0) goto L25;
        return true;
    L25:
        return false;
    L9:
        if (r5 != getChildCount()) goto L15;
        if ((this.mShowDividers & 4) == 0) goto L26;
        return true;
    L26:
        return false;
    L15:
        if ((this.mShowDividers & 2) == 0) goto L22;
        int r6 = r5 - 1;
    L17:
        if (r6 < 0) goto L28;
        if (getChildAt(r6).getVisibility() != 8) goto L20;
        r6 = r6 - 1;
        goto L17
    L20:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        if (this.mDivider != null) goto L6;
        return;
    L6:
        if (this.mOrientation != 1) goto L8;
        drawDividersVertical(r3);
        return;
    L8:
        drawDividersHorizontal(r3);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void setBaselineAligned(boolean r1) {
        this.mBaselineAligned = r1;
    }

    public void setBaselineAlignedChildIndex(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= getChildCount()) goto L8;
        this.mBaselineAlignedChildIndex = r3;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r3) {
        if (r3 != this.mDivider) goto L5;
        return;
    L5:
        this.mDivider = r3;
        boolean r0 = false;
        if (r3 == null) goto L8;
        this.mDividerWidth = r3.getIntrinsicWidth();
        this.mDividerHeight = r3.getIntrinsicHeight();
    L9:
        if (r3 != null) goto L11;
        r0 = true;
    L11:
        setWillNotDraw(r0);
        requestLayout();
        return;
    L8:
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
        goto L9
    }

    public void setDividerPadding(int r1) {
        this.mDividerPadding = r1;
    }

    public void setGravity(int r2) {
        if (this.mGravity != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | 8388611;
    L8:
        if ((r2 & 112) != 0) goto L10;
        r2 = r2 | 48;
    L10:
        this.mGravity = r2;
        requestLayout();
    }

    public void setHorizontalGravity(int r3) {
        int r4 = r3 & 8388615;
        int r1 = this.mGravity;
        if ((8388615 & r1) == r4) goto L6;
        this.mGravity = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r1) {
        this.mUseLargestChild = r1;
    }

    public void setOrientation(int r2) {
        if (this.mOrientation == r2) goto L6;
        this.mOrientation = r2;
        requestLayout();
        return;
    }

    public void setShowDividers(int r2) {
        if (r2 == this.mShowDividers) goto L5;
        requestLayout();
    L5:
        this.mShowDividers = r2;
    }

    public void setVerticalGravity(int r3) {
        int r4 = r3 & 112;
        int r0 = this.mGravity;
        if ((r0 & 112) == r4) goto L6;
        this.mGravity = r4 | (r0 & (-113));
        requestLayout();
        return;
    }

    public void setWeightSum(float r2) {
        this.mWeightSum = Math.max(MenuKt.ClosedAlphaTarget, r2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new LayoutParams(r2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public LinearLayoutCompat(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    private void forceUniformHeight(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (((LinearLayout.LayoutParams) r8).height != (-1)) goto L9;
        int r9 = ((LinearLayout.LayoutParams) r8).width;
        ((LinearLayout.LayoutParams) r8).width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        ((LinearLayout.LayoutParams) r8).width = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getVirtualChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LayoutParams r8 = (LayoutParams) r3.getLayoutParams();
        if (((LinearLayout.LayoutParams) r8).width != (-1)) goto L9;
        int r9 = ((LinearLayout.LayoutParams) r8).height;
        ((LinearLayout.LayoutParams) r8).height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        ((LinearLayout.LayoutParams) r8).height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    public void drawHorizontalDivider(Canvas r5, int r6) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, r6, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + r6);
        this.mDivider.draw(r5);
    }

    public void drawVerticalDivider(Canvas r6, int r7) {
        this.mDivider.setBounds(r7, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + r7, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(r6);
    }

    void measureHorizontal(int r38, int r39) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r38);
        int r13 = View.MeasureSpec.getMode(r39);
        if (this.mMaxAscent != null) goto L5;
    L6:
        this.mMaxAscent = new int[4];
        this.mMaxDescent = new int[4];
    L7:
        int[] r15 = this.mMaxAscent;
        int[] r6 = this.mMaxDescent;
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r6[3] = -1;
        r6[2] = -1;
        r6[1] = -1;
        r6[0] = -1;
        boolean r4 = this.mBaselineAligned;
        boolean r3 = this.mUseLargestChild;
        int r2 = 1073741824;
        if (r12 != 1073741824) goto L10;
        boolean r19 = true;
    L11:
        float r0 = MenuKt.ClosedAlphaTarget;
        int r1 = 0;
        int r14 = 0;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        boolean r24 = false;
        int r25 = 0;
        boolean r26 = true;
        boolean r27 = false;
    L12:
        int[] r28 = r6;
        if (r1 >= r11) goto L88;
        View r7 = getVirtualChildAt(r1);
        if (r7 != null) goto L19;
        this.mTotalLength += measureNullChild(r1);
    L17:
        int r5 = r1;
        boolean r32 = r3;
        boolean r36 = r4;
    L87:
        r1 = r5 + 1;
        r6 = r28;
        r3 = r32;
        r4 = r36;
        r2 = 1073741824;
        goto L12
    L19:
        if (r7.getVisibility() != 8) goto L22;
        r1 = r1 + getChildrenSkipCount(r7, r1);
        goto L17
    L22:
        if (hasDividerBeforeChildAt(r1) == false) goto L24;
        this.mTotalLength += this.mDividerWidth;
    L24:
        LayoutParams r10 = (LayoutParams) r7.getLayoutParams();
        float r8 = ((LinearLayout.LayoutParams) r10).weight;
        float r31 = r0 + r8;
        if (r12 != r2) goto L37;
        if (((LinearLayout.LayoutParams) r10).width != 0) goto L37;
        if (r8 <= MenuKt.ClosedAlphaTarget) goto L37;
        if (r19 == false) goto L32;
        this.mTotalLength += ((LinearLayout.LayoutParams) r10).leftMargin + ((LinearLayout.LayoutParams) r10).rightMargin;
    L33:
        if (r4 == false) goto L35;
        int r9 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r7.measure(r9, r9);
        int r34 = r1;
        r32 = r3;
        r36 = r4;
        View r16 = r7;
    L55:
        int r17 = 1073741824;
    L56:
        if (r13 != r17) goto L58;
    L60:
        boolean r18 = false;
    L61:
        int r20 = ((LinearLayout.LayoutParams) r10).topMargin + ((LinearLayout.LayoutParams) r10).bottomMargin;
        int r29 = r16.getMeasuredHeight() + r20;
        r25 = View.combineMeasuredStates(r25, r16.getMeasuredState());
        if (r36 == false) goto L69;
        int r30 = r16.getBaseline();
        if (r30 == (-1)) goto L69;
        int r33 = ((LinearLayout.LayoutParams) r10).gravity;
        if (r33 >= 0) goto L68;
        r33 = this.mGravity;
    L68:
        int r35 = (((r33 & 112) >> 4) & (-2)) >> 1;
        r15[r35] = Math.max(r15[r35], r30);
        r28[r35] = Math.max(r28[r35], r29 - r30);
    L69:
        r21 = Math.max(r21, r29);
        if (r26 == true) goto L72;
    L74:
        r26 = false;
    L76:
        if (((LinearLayout.LayoutParams) r10).weight <= MenuKt.ClosedAlphaTarget) goto L81;
        if (r18 == true) goto L80;
        r20 = r29;
    L80:
        r23 = Math.max(r23, r20);
    L86:
        int r110 = r34;
        r5 = getChildrenSkipCount(r16, r110) + r110;
        r0 = r31;
        goto L87
    L81:
        int r111 = r23;
        if (r18 == true) goto L85;
        r20 = r29;
    L85:
        r22 = Math.max(r22, r20);
        r23 = r111;
        goto L86
    L72:
        if (((LinearLayout.LayoutParams) r10).height != (-1)) goto L74;
        r26 = true;
        goto L76
    L58:
        if (((LinearLayout.LayoutParams) r10).height != (-1)) goto L60;
        r18 = true;
        r27 = true;
        goto L61
    L35:
        r34 = r1;
        r32 = r3;
        r36 = r4;
        r16 = r7;
        r17 = 1073741824;
        r24 = true;
        goto L56
    L32:
        int r37 = this.mTotalLength;
        this.mTotalLength = Math.max(r37, (((LinearLayout.LayoutParams) r10).leftMargin + r37) + ((LinearLayout.LayoutParams) r10).rightMargin);
    L37:
        if (((LinearLayout.LayoutParams) r10).width == 0) goto L39;
    L41:
        int r40 = RtlSpacingHelper.UNDEFINED;
    L43:
        if (r31 != MenuKt.ClosedAlphaTarget) goto L45;
        int r210 = this.mTotalLength;
    L46:
        r34 = r1;
        int r310 = r40;
        r32 = r3;
        r36 = r4;
        measureChildBeforeLayout(r7, r34, r38, r210, r39, 0);
        if (r310 == Integer.MIN_VALUE) goto L49;
        ((LinearLayout.LayoutParams) r10).width = r310;
    L49:
        int r41 = r7.getMeasuredWidth();
        if (r19 == false) goto L52;
        r16 = r7;
        this.mTotalLength = this.mTotalLength + (((((LinearLayout.LayoutParams) r10).leftMargin + r41) + ((LinearLayout.LayoutParams) r10).rightMargin) + getNextLocationOffset(r16));
    L53:
        if (r32 == false) goto L55;
        r14 = Math.max(r41, r14);
        goto L55
    L52:
        r16 = r7;
        int r42 = this.mTotalLength;
        this.mTotalLength = Math.max(r42, (((r42 + r41) + ((LinearLayout.LayoutParams) r10).leftMargin) + ((LinearLayout.LayoutParams) r10).rightMargin) + getNextLocationOffset(r16));
        goto L53
    L45:
        r210 = 0;
        goto L46
    L39:
        if (r8 <= MenuKt.ClosedAlphaTarget) goto L41;
        ((LinearLayout.LayoutParams) r10).width = -2;
        r40 = 0;
        goto L43
    L88:
        boolean r311 = r3;
        boolean r312 = r4;
        int r43 = r21;
        int r44 = r22;
        int r112 = r23;
        int r45 = r25;
        if (this.mTotalLength > 0) goto L91;
    L93:
        int r46 = r15[1];
        if (r46 == (-1)) goto L96;
    L103:
        int r47 = Math.max(r43, Math.max(r15[3], Math.max(r15[0], Math.max(r46, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L104:
        if (r311 == true) goto L106;
    L122:
        int r211 = r47;
        int r48 = this.mTotalLength + (getPaddingLeft() + getPaddingRight());
        this.mTotalLength = r48;
        int r49 = View.resolveSizeAndState(Math.max(r48, getSuggestedMinimumWidth()), r38, 0);
        int r50 = (16777215 & r49) - this.mTotalLength;
        if (r24 == true) goto L144;
        if (r50 != 0) goto L126;
    L128:
        int r51 = Math.max(r44, r112);
        if (r311 == true) goto L131;
    L143:
        int r212 = r11;
        int r52 = r211;
    L214:
        if (r26 == false) goto L216;
    L218:
        r51 = r52;
    L219:
        setMeasuredDimension(r49 | (r45 & (-16777216)), View.resolveSizeAndState(Math.max(r51 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r39, r45 << 16));
        if (r27 == false) goto L237;
        forceUniformHeight(r212, r38);
        return;
    L237:
        return;
    L216:
        if (r13 == 1073741824) goto L218;
    L131:
        if (r12 == 1073741824) goto L143;
        int r113 = 0;
    L133:
        if (r113 >= r11) goto L143;
        View r53 = getVirtualChildAt(r113);
        if (r53 == null) goto L142;
        if (r53.getVisibility() == 8) goto L142;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r53.getLayoutParams())).weight <= MenuKt.ClosedAlphaTarget) goto L142;
        r53.measure(View.MeasureSpec.makeMeasureSpec(r14, 1073741824), View.MeasureSpec.makeMeasureSpec(r53.getMeasuredHeight(), 1073741824));
    L142:
        r113 = r113 + 1;
        goto L133
    L126:
        if (r0 <= MenuKt.ClosedAlphaTarget) goto L128;
    L144:
        float r54 = this.mWeightSum;
        if (r54 <= MenuKt.ClosedAlphaTarget) goto L147;
        r0 = r54;
    L147:
        r15[3] = -1;
        r15[2] = -1;
        r15[1] = -1;
        r15[0] = -1;
        r28[3] = -1;
        r28[2] = -1;
        r28[1] = -1;
        r28[0] = -1;
        this.mTotalLength = 0;
        int r55 = r44;
        int r56 = r45;
        int r57 = -1;
        int r114 = 0;
    L148:
        if (r114 >= r11) goto L202;
        View r115 = getVirtualChildAt(r114);
        if (r115 != null) goto L152;
    L200:
        int r58 = r50;
        r11 = r11;
    L201:
        r114 = r114 + 1;
        r50 = r58;
        r11 = r11;
        goto L148
    L152:
        if (r115.getVisibility() == 8) goto L200;
        LayoutParams r59 = (LayoutParams) r115.getLayoutParams();
        float r60 = ((LinearLayout.LayoutParams) r59).weight;
        if (r60 <= MenuKt.ClosedAlphaTarget) goto L171;
        int r61 = (int) ((r50 * r60) / r0);
        float r62 = r0 - r60;
        int r63 = r50 - r61;
        int r64 = ViewGroup.getChildMeasureSpec(r39, ((getPaddingTop() + getPaddingBottom()) + ((LinearLayout.LayoutParams) r59).topMargin) + ((LinearLayout.LayoutParams) r59).bottomMargin, ((LinearLayout.LayoutParams) r59).height);
        if (((LinearLayout.LayoutParams) r59).width != 0) goto L165;
        int r65 = 1073741824;
        if (r12 != 1073741824) goto L166;
        if (r61 > 0) goto L164;
        r61 = 0;
    L164:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r61, 1073741824), r64);
    L170:
        r56 = View.combineMeasuredStates(r56, r115.getMeasuredState() & (-16777216));
        r0 = r62;
        r58 = r63;
    L172:
        if (r19 == false) goto L174;
        this.mTotalLength += ((r115.getMeasuredWidth() + ((LinearLayout.LayoutParams) r59).leftMargin) + ((LinearLayout.LayoutParams) r59).rightMargin) + getNextLocationOffset(r115);
    L176:
        if (r13 != 1073741824) goto L178;
    L180:
        boolean r66 = false;
    L181:
        int r67 = ((LinearLayout.LayoutParams) r59).topMargin + ((LinearLayout.LayoutParams) r59).bottomMargin;
        int r116 = r115.getMeasuredHeight() + r67;
        r57 = Math.max(r57, r116);
        if (r66 == true) goto L185;
        r67 = r116;
    L185:
        int r68 = Math.max(r55, r67);
        if (r26 == false) goto L190;
        int r69 = -1;
        if (((LinearLayout.LayoutParams) r59).height != (-1)) goto L191;
        boolean r70 = true;
    L192:
        if (r312 == false) goto L199;
        int r117 = r115.getBaseline();
        if (r117 == r69) goto L199;
        int r71 = ((LinearLayout.LayoutParams) r59).gravity;
        if (r71 >= 0) goto L198;
        r71 = this.mGravity;
    L198:
        int r72 = (((r71 & 112) >> 4) & (-2)) >> 1;
        r15[r72] = Math.max(r15[r72], r117);
        r28[r72] = Math.max(r28[r72], r116 - r117);
    L199:
        r26 = r70;
        r55 = r68;
        r0 = r0;
    L191:
        r70 = false;
        goto L192
    L190:
        r69 = -1;
        goto L191
    L178:
        if (((LinearLayout.LayoutParams) r59).height != (-1)) goto L180;
        r66 = true;
        goto L181
    L174:
        int r73 = this.mTotalLength;
        this.mTotalLength = Math.max(r73, (((r115.getMeasuredWidth() + r73) + ((LinearLayout.LayoutParams) r59).leftMargin) + ((LinearLayout.LayoutParams) r59).rightMargin) + getNextLocationOffset(r115));
    L166:
        int r74 = r115.getMeasuredWidth() + r61;
        if (r74 >= 0) goto L169;
        r74 = 0;
    L169:
        r115.measure(View.MeasureSpec.makeMeasureSpec(r74, r65), r64);
        goto L170
    L165:
        r65 = 1073741824;
        goto L166
    L171:
        r58 = r50;
        goto L172
    L202:
        r212 = r11;
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int r75 = r15[1];
        if (r75 == (-1)) goto L205;
    L212:
        int r76 = Math.max(r57, Math.max(r15[3], Math.max(r15[0], Math.max(r75, r15[2]))) + Math.max(r28[3], Math.max(r28[0], Math.max(r28[1], r28[2]))));
    L213:
        r52 = r76;
        r51 = r55;
        r45 = r56;
        goto L214
    L205:
        if (r15[0] != (-1)) goto L212;
        if (r15[2] != (-1)) goto L212;
        if (r15[3] != (-1)) goto L212;
        r76 = r57;
        goto L213
    L106:
        if (r12 == Integer.MIN_VALUE) goto L108;
        if (r12 != 0) goto L122;
    L108:
        this.mTotalLength = 0;
        int r77 = 0;
    L109:
        if (r77 >= r11) goto L122;
        View r78 = getVirtualChildAt(r77);
        if (r78 != null) goto L114;
        this.mTotalLength += measureNullChild(r77);
    L121:
        r77 = r77 + 1;
        r47 = r47;
        goto L109
    L114:
        if (r78.getVisibility() != 8) goto L117;
        r77 = r77 + getChildrenSkipCount(r78, r77);
        goto L121
    L117:
        LayoutParams r79 = (LayoutParams) r78.getLayoutParams();
        if (r19 == false) goto L120;
        this.mTotalLength += ((((LinearLayout.LayoutParams) r79).leftMargin + r14) + ((LinearLayout.LayoutParams) r79).rightMargin) + getNextLocationOffset(r78);
        goto L121
    L120:
        int r80 = this.mTotalLength;
        this.mTotalLength = Math.max(r80, (((r80 + r14) + ((LinearLayout.LayoutParams) r79).leftMargin) + ((LinearLayout.LayoutParams) r79).rightMargin) + getNextLocationOffset(r78));
        goto L121
    L96:
        if (r15[0] != (-1)) goto L103;
        if (r15[2] != (-1)) goto L103;
        if (r15[3] != (-1)) goto L103;
        r47 = r43;
        goto L104
    L91:
        if (hasDividerBeforeChildAt(r11) == false) goto L93;
        this.mTotalLength += this.mDividerWidth;
        goto L93
    L10:
        r19 = false;
        goto L11
    L5:
        if (this.mMaxDescent != null) goto L7;
        goto L6
    }

    void measureVertical(int r34, int r35) {
        this.mTotalLength = 0;
        int r11 = getVirtualChildCount();
        int r12 = View.MeasureSpec.getMode(r34);
        int r13 = View.MeasureSpec.getMode(r35);
        int r14 = this.mBaselineAlignedChildIndex;
        boolean r15 = this.mUseLargestChild;
        float r0 = MenuKt.ClosedAlphaTarget;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r18 = false;
        boolean r19 = true;
        boolean r20 = false;
    L3:
        int r10 = 8;
        int r22 = r4;
        if (r6 >= r11) goto L72;
        View r7 = getVirtualChildAt(r6);
        if (r7 != null) goto L8;
        this.mTotalLength += measureNullChild(r6);
        int r26 = r11;
        int r24 = r13;
        r4 = r22;
    L71:
        r6 = r6 + 1;
        r13 = r24;
        r11 = r26;
        goto L3
    L8:
        int r25 = r1;
        if (r7.getVisibility() != 8) goto L12;
        r6 = r6 + getChildrenSkipCount(r7, r6);
        r26 = r11;
        r4 = r22;
        r1 = r25;
        r24 = r13;
        goto L71
    L12:
        if (hasDividerBeforeChildAt(r6) == false) goto L14;
        this.mTotalLength += this.mDividerHeight;
    L14:
        LayoutParams r16 = (LayoutParams) r7.getLayoutParams();
        float r8 = ((LinearLayout.LayoutParams) r16).weight;
        float r27 = r0 + r8;
        if (r13 == 1073741824) goto L17;
    L21:
        int r28 = r2;
        if (((LinearLayout.LayoutParams) r16).height == 0) goto L24;
    L26:
        int r9 = RtlSpacingHelper.UNDEFINED;
    L28:
        if (r27 != MenuKt.ClosedAlphaTarget) goto L30;
        int r23 = this.mTotalLength;
    L31:
        int r17 = r25;
        int r30 = r9;
        int r29 = r28;
        int r21 = r3;
        r26 = r11;
        r24 = r13;
        int r110 = r22;
        int r31 = r5;
        int r111 = r6;
        measureChildBeforeLayout(r7, r6, r34, 0, r35, r23);
        if (r30 == Integer.MIN_VALUE) goto L34;
        ((LinearLayout.LayoutParams) r16).height = r30;
    L34:
        int r32 = r7.getMeasuredHeight();
        int r33 = this.mTotalLength;
        View r36 = r7;
        this.mTotalLength = Math.max(r33, (((r33 + r32) + ((LinearLayout.LayoutParams) r16).topMargin) + ((LinearLayout.LayoutParams) r16).bottomMargin) + getNextLocationOffset(r36));
        if (r15 == false) goto L37;
        int r37 = Math.max(r32, r21);
    L38:
        if (r14 >= 0) goto L40;
    L42:
        if (r111 >= r14) goto L49;
        if (((LinearLayout.LayoutParams) r16).weight <= MenuKt.ClosedAlphaTarget) goto L49;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L49:
        if (r12 != 1073741824) goto L51;
    L53:
        boolean r38 = false;
    L54:
        int r39 = ((LinearLayout.LayoutParams) r16).leftMargin + ((LinearLayout.LayoutParams) r16).rightMargin;
        int r40 = r36.getMeasuredWidth() + r39;
        int r41 = Math.max(r29, r40);
        int r42 = View.combineMeasuredStates(r17, r36.getMeasuredState());
        if (r19 == true) goto L57;
    L59:
        r19 = false;
    L61:
        if (((LinearLayout.LayoutParams) r16).weight <= MenuKt.ClosedAlphaTarget) goto L66;
        if (r38 == true) goto L65;
        r39 = r40;
    L65:
        r4 = Math.max(r110, r39);
        int r43 = r31;
    L70:
        int r44 = getChildrenSkipCount(r36, r111) + r111;
        r3 = r37;
        r0 = r27;
        r5 = r43;
        r1 = r42;
        r6 = r44;
        r2 = r41;
        goto L71
    L66:
        if (r38 == true) goto L69;
        r39 = r40;
    L69:
        r43 = Math.max(r31, r39);
        r4 = r110;
        goto L70
    L57:
        if (((LinearLayout.LayoutParams) r16).width != (-1)) goto L59;
        r19 = true;
        goto L61
    L51:
        if (((LinearLayout.LayoutParams) r16).width != (-1)) goto L53;
        r38 = true;
        r20 = true;
        goto L54
    L40:
        if (r14 != (r111 + 1)) goto L42;
        this.mBaselineChildTop = this.mTotalLength;
        goto L42
    L37:
        r37 = r21;
        goto L38
    L30:
        r23 = 0;
        goto L31
    L24:
        if (r8 <= MenuKt.ClosedAlphaTarget) goto L26;
        ((LinearLayout.LayoutParams) r16).height = -2;
        r9 = 0;
        goto L28
    L17:
        if (((LinearLayout.LayoutParams) r16).height != 0) goto L21;
        if (r8 <= MenuKt.ClosedAlphaTarget) goto L21;
        int r45 = this.mTotalLength;
        this.mTotalLength = Math.max(r45, (((LinearLayout.LayoutParams) r16).topMargin + r45) + ((LinearLayout.LayoutParams) r16).bottomMargin);
        r37 = r3;
        r36 = r7;
        r31 = r5;
        r17 = r25;
        r29 = r2;
        r18 = true;
        r26 = r11;
        r24 = r13;
        r110 = r22;
        r111 = r6;
        goto L38
    L72:
        int r46 = r1;
        int r47 = r3;
        int r48 = r5;
        int r210 = r11;
        int r211 = r13;
        int r49 = r2;
        if (this.mTotalLength <= 0) goto L77;
        int r50 = r210;
        if (hasDividerBeforeChildAt(r50) == false) goto L79;
        this.mTotalLength += this.mDividerHeight;
    L79:
        if (r15 == true) goto L81;
    L93:
        int r51 = this.mTotalLength + (getPaddingTop() + getPaddingBottom());
        this.mTotalLength = r51;
        int r52 = View.resolveSizeAndState(Math.max(r51, getSuggestedMinimumHeight()), r35, 0);
        int r53 = (16777215 & r52) - this.mTotalLength;
        if (r18 == true) goto L115;
        if (r53 != 0) goto L97;
    L99:
        int r54 = Math.max(r48, r22);
        if (r15 == true) goto L102;
    L114:
        int r55 = r46;
    L160:
        if (r19 == false) goto L162;
    L164:
        r54 = r49;
    L165:
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r54 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r34, r55), r52);
        if (r20 == false) goto L186;
        forceUniformWidth(r50, r35);
        return;
    L186:
        return;
    L162:
        if (r12 == 1073741824) goto L164;
    L102:
        if (r211 == 1073741824) goto L114;
        int r56 = 0;
    L104:
        if (r56 >= r50) goto L114;
        View r57 = getVirtualChildAt(r56);
        if (r57 == null) goto L113;
        if (r57.getVisibility() == 8) goto L113;
        if (((LinearLayout.LayoutParams) ((LayoutParams) r57.getLayoutParams())).weight <= MenuKt.ClosedAlphaTarget) goto L113;
        r57.measure(View.MeasureSpec.makeMeasureSpec(r57.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r47, 1073741824));
    L113:
        r56 = r56 + 1;
        goto L104
    L97:
        if (r0 <= MenuKt.ClosedAlphaTarget) goto L99;
    L115:
        float r112 = this.mWeightSum;
        if (r112 <= MenuKt.ClosedAlphaTarget) goto L118;
        r0 = r112;
    L118:
        this.mTotalLength = 0;
        int r113 = r53;
        int r58 = r48;
        r55 = r46;
        int r59 = 0;
    L119:
        if (r59 >= r50) goto L159;
        View r114 = getVirtualChildAt(r59);
        if (r114.getVisibility() != 8) goto L123;
        int r212 = r113;
    L158:
        r59 = r59 + 1;
        r113 = r212;
        goto L119
    L123:
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        float r116 = ((LinearLayout.LayoutParams) r115).weight;
        if (r116 <= MenuKt.ClosedAlphaTarget) goto L140;
        int r117 = (int) ((r113 * r116) / r0);
        float r60 = r0 - r116;
        r212 = r113 - r117;
        int r61 = ViewGroup.getChildMeasureSpec(r34, ((getPaddingLeft() + getPaddingRight()) + ((LinearLayout.LayoutParams) r115).leftMargin) + ((LinearLayout.LayoutParams) r115).rightMargin, ((LinearLayout.LayoutParams) r115).width);
        if (((LinearLayout.LayoutParams) r115).height != 0) goto L134;
        int r118 = 1073741824;
        if (r211 != 1073741824) goto L135;
        if (r117 > 0) goto L133;
        r117 = 0;
    L133:
        r114.measure(r61, View.MeasureSpec.makeMeasureSpec(r117, 1073741824));
    L139:
        r55 = View.combineMeasuredStates(r55, r114.getMeasuredState() & (-256));
        r0 = r60;
    L141:
        int r119 = ((LinearLayout.LayoutParams) r115).leftMargin + ((LinearLayout.LayoutParams) r115).rightMargin;
        int r120 = r114.getMeasuredWidth() + r119;
        r49 = Math.max(r49, r120);
        float r121 = r0;
        if (r12 == 1073741824) goto L146;
        int r213 = r55;
        int r62 = -1;
        if (((LinearLayout.LayoutParams) r115).width != (-1)) goto L147;
        boolean r63 = true;
    L148:
        if (r63 == true) goto L151;
        r119 = r120;
    L151:
        int r64 = Math.max(r58, r119);
        if (r19 == true) goto L154;
    L156:
        boolean r65 = false;
    L157:
        int r122 = this.mTotalLength;
        this.mTotalLength = Math.max(r122, (((r114.getMeasuredHeight() + r122) + ((LinearLayout.LayoutParams) r115).topMargin) + ((LinearLayout.LayoutParams) r115).bottomMargin) + getNextLocationOffset(r114));
        r19 = r65;
        r55 = r213;
        r58 = r64;
        r0 = r121;
        goto L158
    L154:
        if (((LinearLayout.LayoutParams) r115).width != r62) goto L156;
        r65 = true;
    L147:
        r63 = false;
        goto L148
    L146:
        r213 = r55;
        r62 = -1;
    L135:
        int r123 = r114.getMeasuredHeight() + r117;
        if (r123 >= 0) goto L138;
        r123 = 0;
    L138:
        r114.measure(r61, View.MeasureSpec.makeMeasureSpec(r123, r118));
        goto L139
    L134:
        r118 = 1073741824;
        goto L135
    L140:
        r212 = r113;
        goto L141
    L159:
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        r54 = r58;
        goto L160
    L81:
        if (r211 == Integer.MIN_VALUE) goto L83;
        if (r211 != 0) goto L93;
    L83:
        this.mTotalLength = 0;
        int r66 = 0;
    L84:
        if (r66 >= r50) goto L93;
        View r67 = getVirtualChildAt(r66);
        if (r67 != null) goto L89;
        this.mTotalLength += measureNullChild(r66);
    L92:
        r66 = r66 + 1;
        r10 = 8;
        goto L84
    L89:
        if (r67.getVisibility() != r10) goto L91;
        r66 = r66 + getChildrenSkipCount(r67, r66);
        goto L92
    L91:
        LayoutParams r124 = (LayoutParams) r67.getLayoutParams();
        int r125 = this.mTotalLength;
        this.mTotalLength = Math.max(r125, (((r125 + r47) + ((LinearLayout.LayoutParams) r124).topMargin) + ((LinearLayout.LayoutParams) r124).bottomMargin) + getNextLocationOffset(r67));
        goto L92
    L77:
        r50 = r210;
        goto L79
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        if (this.mOrientation != 1) goto L5;
        measureVertical(r3, r4);
        return;
    L5:
        measureHorizontal(r3, r4);
    }

    public LinearLayoutCompat(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r13, r14, new int[]{R.attr.gravity, R.attr.orientation, R.attr.baselineAligned, R.attr.baselineAlignedChildIndex, R.attr.weightSum, 2130969758, 2130969768, 2130972748, 2130974062}, r15, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r13, new int[]{R.attr.gravity, R.attr.orientation, R.attr.baselineAligned, R.attr.baselineAlignedChildIndex, R.attr.weightSum, 2130969758, 2130969768, 2130972748, 2130974062}, r14, r4.getWrappedTypeArray(), r15, 0);
        int r16 = r4.getInt(1, -1);
        if (r16 < 0) goto L5;
        setOrientation(r16);
    L5:
        int r17 = r4.getInt(0, -1);
        if (r17 < 0) goto L8;
        setGravity(r17);
    L8:
        boolean r18 = r4.getBoolean(2, true);
        if (r18 == true) goto L11;
        setBaselineAligned(r18);
    L11:
        this.mWeightSum = r4.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = r4.getInt(3, -1);
        this.mUseLargestChild = r4.getBoolean(7, false);
        setDividerDrawable(r4.getDrawable(5));
        this.mShowDividers = r4.getInt(8, 0);
        this.mDividerPadding = r4.getDimensionPixelSize(6, 0);
        r4.recycle();
    }

    public void layoutHorizontal(int r25, int r26, int r27, int r28) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r7 = getPaddingTop();
        int r1 = r28 - r26;
        int r8 = r1 - getPaddingBottom();
        int r9 = (r1 - r7) - getPaddingBottom();
        int r10 = getVirtualChildCount();
        int r2 = this.mGravity;
        int r11 = r2 & 112;
        boolean r12 = this.mBaselineAligned;
        int[] r13 = this.mMaxAscent;
        int[] r14 = this.mMaxDescent;
        int r3 = GravityCompat.getAbsoluteGravity(8388615 & r2, ViewCompat.getLayoutDirection(this));
        if (r3 != 1) goto L5;
        int r4 = getPaddingLeft() + (((r27 - r25) - this.mTotalLength) / 2);
    L10:
        if (r0 == false) goto L12;
        int r16 = r10 - 1;
        int r17 = -1;
    L13:
        int r5 = 0;
    L14:
        if (r5 >= r10) goto L52;
        int r6 = r16 + (r17 * r5);
        View r15 = getVirtualChildAt(r6);
        if (r15 != null) goto L19;
        r4 = r4 + measureNullChild(r6);
    L50:
        int r19 = r10;
    L51:
        r5 = r5 + 1;
        r10 = r19;
        r11 = r11;
        r7 = r7;
        goto L14
    L19:
        if (r15.getVisibility() == 8) goto L50;
        int r18 = r15.getMeasuredWidth();
        int r20 = r15.getMeasuredHeight();
        LayoutParams r21 = (LayoutParams) r15.getLayoutParams();
        int r110 = r5;
        if (r12 == false) goto L25;
        r19 = r10;
        if (((LinearLayout.LayoutParams) r21).height == (-1)) goto L26;
        int r111 = r15.getBaseline();
    L27:
        int r22 = ((LinearLayout.LayoutParams) r21).gravity;
        if (r22 >= 0) goto L30;
        r22 = r11;
    L30:
        int r23 = r22 & 112;
        if (r23 != 16) goto L33;
        int r24 = ((((r9 - r20) / 2) + r7) + ((LinearLayout.LayoutParams) r21).topMargin) - ((LinearLayout.LayoutParams) r21).bottomMargin;
    L46:
        if (hasDividerBeforeChildAt(r6) == false) goto L48;
        r4 = r4 + this.mDividerWidth;
    L48:
        int r112 = ((LinearLayout.LayoutParams) r21).leftMargin + r4;
        setChildFrame(r15, r112 + getLocationOffset(r15), r24, r18, r20);
        int r113 = r112 + ((r18 + ((LinearLayout.LayoutParams) r21).rightMargin) + getNextLocationOffset(r15));
        r5 = r110 + getChildrenSkipCount(r15, r6);
        r4 = r113;
        goto L51
    L33:
        if (r23 != 48) goto L35;
        r24 = ((LinearLayout.LayoutParams) r21).topMargin + r7;
        if (r111 == (-1)) goto L46;
        r24 = r24 + (r13[1] - r111);
        goto L46
    L35:
        if (r23 == 80) goto L37;
        r24 = r7;
        goto L46
    L37:
        r24 = (r8 - r20) - ((LinearLayout.LayoutParams) r21).bottomMargin;
        if (r111 == (-1)) goto L46;
        r24 = r24 - (r14[2] - (r15.getMeasuredHeight() - r111));
    L26:
        r111 = -1;
        goto L27
    L25:
        r19 = r10;
        goto L26
    L52:
        return;
    L12:
        r16 = 0;
        r17 = 1;
        goto L13
    L5:
        if (r3 == 5) goto L7;
        r4 = getPaddingLeft();
        goto L10
    L7:
        r4 = ((getPaddingLeft() + r27) - r25) - this.mTotalLength;
        goto L10
    }

    public void layoutVertical(int r18, int r19, int r20, int r21) {
        int r7 = getPaddingLeft();
        int r0 = r20 - r18;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r10 = getVirtualChildCount();
        int r1 = this.mGravity;
        int r2 = r1 & 112;
        int r11 = r1 & 8388615;
        if (r2 != 16) goto L5;
        int r3 = getPaddingTop() + (((r21 - r19) - this.mTotalLength) / 2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L32;
        View r13 = getVirtualChildAt(r12);
        if (r13 != null) goto L15;
        r3 = r3 + measureNullChild(r12);
    L31:
        r12 = r12 + 1;
        goto L10
    L15:
        if (r13.getVisibility() == 8) goto L31;
        int r4 = r13.getMeasuredWidth();
        int r15 = r13.getMeasuredHeight();
        LayoutParams r5 = (LayoutParams) r13.getLayoutParams();
        int r6 = ((LinearLayout.LayoutParams) r5).gravity;
        if (r6 >= 0) goto L19;
        r6 = r11;
    L19:
        int r14 = GravityCompat.getAbsoluteGravity(r6, ViewCompat.getLayoutDirection(this)) & 7;
        if (r14 != 1) goto L22;
        int r16 = (((r9 - r4) / 2) + r7) + ((LinearLayout.LayoutParams) r5).leftMargin;
        int r17 = ((LinearLayout.LayoutParams) r5).rightMargin;
    L26:
        int r22 = r16 - r17;
    L27:
        int r23 = r22;
        if (hasDividerBeforeChildAt(r12) == false) goto L30;
        r3 = r3 + this.mDividerHeight;
    L30:
        int r110 = r3 + ((LinearLayout.LayoutParams) r5).topMargin;
        setChildFrame(r13, r23, r110 + getLocationOffset(r13), r4, r15);
        int r111 = r110 + ((r15 + ((LinearLayout.LayoutParams) r5).bottomMargin) + getNextLocationOffset(r13));
        r12 = r12 + getChildrenSkipCount(r13, r12);
        r3 = r111;
        goto L31
    L22:
        if (r14 == 5) goto L24;
        r22 = ((LinearLayout.LayoutParams) r5).leftMargin + r7;
        goto L27
    L24:
        r16 = r8 - r4;
        r17 = ((LinearLayout.LayoutParams) r5).rightMargin;
        goto L26
    L32:
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = getPaddingTop();
        goto L9
    L7:
        r3 = ((getPaddingTop() + r21) - r19) - this.mTotalLength;
        goto L9
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mOrientation != 1) goto L5;
        layoutVertical(r3, r4, r5, r6);
        return;
    L5:
        layoutHorizontal(r3, r4, r5, r6);
    }

    public void measureChildBeforeLayout(View r7, int r8, int r9, int r10, int r11, int r12) {
        measureChildWithMargins(r7, r9, r10, r11, r12);
    }
}
