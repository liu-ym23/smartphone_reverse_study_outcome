package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.material3.MenuKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = null;
    private static final CardViewImpl IMPL = null;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        CardViewApi21Impl r0 = new CardViewApi21Impl();
        IMPL = r0;
        r0.initStatic();
    }

    @Override // android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public CardView(Context r2) {
        this(r2, null);
    }

    public void setCardBackgroundColor(int r3) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(r3));
    }

    public void setCardElevation(float r3) {
        IMPL.setElevation(this.mCardViewDelegate, r3);
    }

    public void setMaxCardElevation(float r3) {
        IMPL.setMaxElevation(this.mCardViewDelegate, r3);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        this.mUserSetMinHeight = r1;
        super.setMinimumHeight(r1);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        this.mUserSetMinWidth = r1;
        super.setMinimumWidth(r1);
    }

    public void setPreventCornerOverlap(boolean r2) {
        if (r2 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r2;
        IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        return;
    }

    public void setRadius(float r3) {
        IMPL.setRadius(this.mCardViewDelegate, r3);
    }

    public void setUseCompatPadding(boolean r2) {
        if (this.mCompatPadding == r2) goto L6;
        this.mCompatPadding = r2;
        IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        return;
    }

    public void setCardBackgroundColor(ColorStateList r3) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, r3);
    }

    public CardView(Context r2, AttributeSet r3) {
        this(r2, r3, 2130969159);
    }

    public static /* synthetic */ void access$101(CardView r0, int r1) {
        super.setMinimumWidth(r1);
    }

    public static /* synthetic */ void access$201(CardView r0, int r1) {
        super.setMinimumHeight(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        CardViewImpl r0 = IMPL;
        if ((r0 instanceof CardViewApi21Impl) == true) goto L15;
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L8;
        if (r1 == 1073741824) goto L8;
    L9:
        int r2 = View.MeasureSpec.getMode(r8);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 == 1073741824) goto L13;
    L14:
        super.onMeasure(r7, r8);
        return;
    L13:
        r8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(r8)), r2);
    L8:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(r7)), r1);
        goto L9
    L15:
        super.onMeasure(r7, r8);
    }

    public CardView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Rect r0 = new Rect();
        this.mContentPadding = r0;
        this.mShadowBounds = new Rect();
        CardViewDelegate r3 = new AnonymousClass1(this);
        this.mCardViewDelegate = r3;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{R.attr.minWidth, R.attr.minHeight, 2130969153, 2130969154, 2130969155, 2130969156, 2130969157, 2130969158, 2130969626, 2130969627, 2130969628, 2130969629, 2130969630}, r12, 2131952003);
        if (r13.hasValue(2) == false) goto L6;
        ColorStateList r14 = r13.getColorStateList(2);
    L5:
        ColorStateList r5 = r14;
        float r6 = r13.getDimension(3, MenuKt.ClosedAlphaTarget);
        float r7 = r13.getDimension(4, MenuKt.ClosedAlphaTarget);
        float r15 = r13.getDimension(5, MenuKt.ClosedAlphaTarget);
        this.mCompatPadding = r13.getBoolean(7, false);
        this.mPreventCornerOverlap = r13.getBoolean(6, true);
        int r1 = r13.getDimensionPixelSize(8, 0);
        r0.left = r13.getDimensionPixelSize(10, r1);
        r0.top = r13.getDimensionPixelSize(12, r1);
        r0.right = r13.getDimensionPixelSize(11, r1);
        r0.bottom = r13.getDimensionPixelSize(9, r1);
        if (r7 <= r15) goto L14;
        float r8 = r7;
    L15:
        this.mUserSetMinWidth = r13.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = r13.getDimensionPixelSize(1, 0);
        r13.recycle();
        IMPL.initialize(r3, r10, r5, r6, r7, r8);
        return;
    L14:
        r8 = r15;
        goto L15
    L6:
        TypedArray r2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r9 = r2.getColor(0, 0);
        r2.recycle();
        float[] r4 = new float[3];
        Color.colorToHSV(r9, r4);
        if (r4[2] <= 0.5f) goto L9;
        int r16 = getResources().getColor(2131100770);
    L10:
        r14 = ColorStateList.valueOf(r16);
        goto L5
    L9:
        r16 = getResources().getColor(2131100769);
        goto L10
    }

    public void setContentPadding(int r2, int r3, int r4, int r5) {
        this.mContentPadding.set(r2, r3, r4, r5);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public static /* synthetic */ void access$001(CardView r0, int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
    }
}
