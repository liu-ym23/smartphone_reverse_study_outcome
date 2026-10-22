package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.CarUtils;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIRoundedImageView extends AppCompatImageView {
    private static final int DEFAULT_BADGE_POSITION_ANGLE = -45;
    private static final int DEFAULT_BADGE_TEXT_PADDING = 2;
    private static final int DEFAULT_BADGE_TEXT_SIZE = 12;
    float mBadgeCenterX;
    float mBadgeCenterY;
    boolean mBadgeEnable;
    private int mBadgePadding;
    private int mBadgePosAngle;
    private int mBadgeTextColor;
    private int mBadgeTextSize;
    private RectF mBordRectF;
    private int mBorderColor;
    Drawable mBorderDrawable;
    private int mBorderPadding;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Paint mClearPaint;
    private Path mClearPath;
    private Matrix mImageMatrix;
    Paint mImagePaint;
    private RectF mImageRectF;
    private boolean mIsOval;
    private boolean mIsTouchSelectModeEnabled;
    a mLkUIBadgeDrawable;
    private Path mPath;
    private float[] mRadiusii;
    private final int mSelectedBorderColor;
    private PorterDuffColorFilter mSelectedColorFilter;
    private final int mSelectedMaskColor;
    private RectF mViewRectF;

    private void init() {
        setLayerType(2, null);
        Paint r100 = new Paint();
        this.mImagePaint = r100;
        r100.setFilterBitmap(true);
        this.mImagePaint.setAntiAlias(true);
        this.mImagePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPath = new Path();
        Paint r101 = new Paint();
        this.mBorderPaint = r101;
        r101.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        if (this.mSelectedMaskColor == 0) goto L5;
        this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
    L5:
        this.mImageMatrix = new Matrix();
        Paint r102 = new Paint(1);
        this.mClearPaint = r102;
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void compute() {
        this.mViewRectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Drawable r100 = this.mBorderDrawable;
        if (r100 == null) goto L5;
        RectF r101 = this.mViewRectF;
        r100.setBounds((int) r101.left, (int) r101.top, (int) r101.right, (int) r101.bottom);
    L5:
        float r102 = (this.mBorderWidth * 1.0f) / 2.0f;
        this.mBordRectF.set(this.mViewRectF);
        this.mBordRectF.inset(r102, r102);
        this.mImageRectF.set(this.mViewRectF);
        RectF r103 = this.mImageRectF;
        float r104 = this.mBorderWidth;
        int r105 = this.mBorderPadding;
        r103.inset(r105 + r104, r104 + r105);
        if (this.mIsOval == true) goto L8;
        return;
    L8:
        if (this.mLkUIBadgeDrawable == null) goto L12;
        float r106 = this.mBordRectF.width() / 2.0f;
        float r107 = this.mBordRectF.height() / 2.0f;
        this.mBadgeCenterX = (float) (((double) (getWidth() / 2)) + (Math.cos((((double) this.mBadgePosAngle) * 6.283185307179586d) / 360.0d) * ((double) r106)));
        this.mBadgeCenterY = (float) (((double) (getHeight() / 2)) + (Math.sin((((double) this.mBadgePosAngle) * 6.283185307179586d) / 360.0d) * ((double) r107)));
        this.mBadgeCenterX = Math.min(this.mBadgeCenterX, getWidth() - (this.mLkUIBadgeDrawable.f284177j / 2));
        this.mBadgeCenterY = Math.max(this.mBadgeCenterY, this.mLkUIBadgeDrawable.f284178k / 2);
        return;
    }

    public a getBadgeDrawable() {
        if (this.mLkUIBadgeDrawable != null) goto L6;
        a.C3912a r100 = new a.C3912a(getContext());
        r100.f284185f = this.mBadgePadding;
        r100.f284181b = this.mBadgeTextSize;
        r100.f284183d = this.mBadgeTextColor;
        a r101 = new a(r100);
        this.mLkUIBadgeDrawable = r101;
        r101.setCallback(this);
        this.mBadgeEnable = true;
    L6:
        return this.mLkUIBadgeDrawable;
    }

    public float getCornerRadius() {
        return this.mRadiusii[0];
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (CarUtils.c() == false) goto L6;
        setLayerType(1, null);
        return;
    }

    public boolean isOval() {
        return this.mIsOval;
    }

    public LKUIRoundedImageView(Context r100) {
        this(r100, null);
    }

    private void drawBadge(Canvas r100) {
        if (this.mIsOval == true) goto L5;
        return;
    L5:
        if (this.mBadgeEnable == false) goto L20;
        a r101 = this.mLkUIBadgeDrawable;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.f284170c == null) goto L11;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == true) goto L22;
        r100.save();
        r100.translate(this.mBadgeCenterX, this.mBadgeCenterY);
        this.mLkUIBadgeDrawable.draw(r100);
        r100.restore();
        return;
    L22:
        return;
    L11:
        if (r101.f284172e != null) goto L15;
        if (TextUtils.isEmpty(r101.f284168a) == false) goto L15;
        r102 = true;
        goto L16
    }

    private void drawBoard(Canvas r100) {
        if (this.mBorderWidth <= 0.0f) goto L5;
    L7:
        Drawable r101 = this.mBorderDrawable;
        if (r101 == null) goto L10;
        r101.draw(r100);
        return;
    L10:
        Paint r102 = this.mBorderPaint;
        if (isSelected() == false) goto L13;
        int r103 = this.mSelectedBorderColor;
    L14:
        r102.setColor(r103);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mPath.reset();
        if (this.mIsOval == false) goto L17;
        this.mPath.addOval(this.mBordRectF, Path.Direction.CW);
    L18:
        r100.drawPath(this.mPath, this.mBorderPaint);
        return;
    L17:
        this.mPath.addRoundRect(this.mBordRectF, this.mRadiusii, Path.Direction.CW);
        goto L18
    L13:
        r103 = this.mBorderColor;
        goto L14
    L5:
        if (this.mBorderDrawable != null) goto L7;
    }

    private void drawImage(Canvas r100) {
        Drawable r101 = getDrawable();
        if (isDrawableValid(r101) == true) goto L5;
        return;
    L5:
        Rect r102 = r101.getBounds();
        if (r102.width() != 0) goto L8;
        return;
    L8:
        if (r102.height() == 0) goto L28;
        int r103 = r101.getIntrinsicWidth();
        int r104 = r101.getIntrinsicHeight();
        if (r103 > 0) goto L13;
        r103 = r102.width();
    L13:
        if (r104 > 0) goto L15;
        r104 = r102.height();
    L15:
        float r105 = r103;
        float r106 = r104;
        float r107 = Math.max((this.mImageRectF.width() * 1.0f) / r105, (this.mImageRectF.height() * 1.0f) / r106);
        this.mImageMatrix.reset();
        this.mImageMatrix.setScale(r107, r107);
        this.mImageMatrix.postTranslate((-((r105 * r107) - getWidth())) / 2.0f, (-((r107 * r106) - getHeight())) / 2.0f);
        int r108 = r100.getSaveCount();
        r100.save();
        this.mPath.reset();
        if (this.mIsOval == false) goto L18;
        this.mPath.addOval(this.mImageRectF, Path.Direction.CW);
    L19:
        Matrix r109 = this.mImageMatrix;
        if (r109 == null) goto L22;
        r100.setMatrix(r109);
    L22:
        r101.draw(r100);
        if (getCropToPadding() == false) goto L25;
        int r110 = getScrollX();
        int r111 = getScrollY();
        r100.clipRect(getPaddingLeft() + r110, getPaddingTop() + r111, ((r110 + getRight()) - getLeft()) - getPaddingRight(), ((r111 + getBottom()) - getTop()) - getPaddingRight());
    L25:
        r100.restoreToCount(r108);
        this.mClearPath.reset();
        this.mClearPath.set(this.mPath);
        this.mClearPath.toggleInverseFillType();
        r100.drawPath(this.mClearPath, this.mClearPaint);
        return;
    L18:
        this.mPath.addRoundRect(this.mImageRectF, this.mRadiusii, Path.Direction.CW);
        goto L19
    }

    private boolean isDrawableValid(Drawable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r101 = ((BitmapDrawable) r100).getBitmap();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.isRecycled() == true) goto L15;
        return true;
    L15:
        return false;
    L12:
        return true;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (r100 != this.mLkUIBadgeDrawable) goto L5;
        invalidate();
        return;
    L5:
        super.invalidateDrawable(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        compute();
        drawImage(r100);
        drawBoard(r100);
        drawBadge(r100);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (isClickable() == true) goto L7;
        setSelected(false);
        return super.onTouchEvent(r100);
    L7:
        if (this.mIsTouchSelectModeEnabled == true) goto L11;
        return super.onTouchEvent(r100);
    L11:
        if (r100.getAction() == 0) goto L13;
        setSelected(false);
    L15:
        return super.onTouchEvent(r100);
    L13:
        setSelected(true);
        goto L15
    }

    public void setBadgeEnable(boolean r100) {
        this.mBadgeEnable = r100;
        invalidate();
    }

    public void setBadgePosAngle(int r100) {
        if (this.mBadgePosAngle == r100) goto L6;
        this.mBadgePosAngle = r100;
        invalidate();
        return;
    }

    public void setBorderColor(int r100) {
        if (this.mBorderColor == r100) goto L6;
        this.mBorderColor = r100;
        invalidate();
        return;
    }

    public void setBorderDrawable(Drawable r100) {
        if (this.mBorderDrawable == r100) goto L6;
        this.mBorderDrawable = r100;
        invalidate();
        return;
    }

    public void setBorderPaddingInDp(float r100) {
        float r101 = j08.b.a(getContext(), r100);
        if (r101 == this.mBorderPadding) goto L6;
        this.mBorderPadding = (int) r101;
        invalidate();
        return;
    }

    public void setBorderWidthDP(float r100) {
        float r101 = j08.b.a(getContext(), r100);
        if (r101 == this.mBorderWidth) goto L6;
        this.mBorderWidth = r101;
        invalidate();
        return;
    }

    public void setCornerRadiusDP(float r100) {
        setCornerRadiusDP(r100, r100, r100, r100);
    }

    public void setOval(boolean r100) {
        this.mIsOval = r100;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r100) {
        if (r100 == isSelected()) goto L10;
        super.setSelected(r100);
        if (r100 == false) goto L7;
        PorterDuffColorFilter r101 = this.mSelectedColorFilter;
    L8:
        setColorFilter(r101);
        invalidate();
        return;
    L7:
        r101 = null;
        goto L8
    }

    public LKUIRoundedImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        if (this.mIsOval == true) goto L41;
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        Drawable r106 = getDrawable();
        if (r106 != null) goto L7;
        return;
    L7:
        boolean r107 = false;
        if (r104 == Integer.MIN_VALUE) goto L12;
        if (r104 == 0) goto L12;
        boolean r108 = false;
    L13:
        if (r105 == Integer.MIN_VALUE) goto L15;
        if (r105 == 0) goto L15;
    L16:
        float r109 = r106.getIntrinsicWidth();
        float r110 = r106.getIntrinsicHeight();
        float r111 = r102 / r109;
        float r112 = r103 / r110;
        if (r108 == false) goto L36;
        if (r107 == false) goto L36;
        if (r111 >= 1.0f) goto L22;
    L25:
        if (r111 < 1.0f) goto L29;
        setMeasuredDimension((int) (r110 * r112), r103);
        return;
    L29:
        if (r112 < 1.0f) goto L33;
        setMeasuredDimension(r102, (int) (r110 * r111));
        return;
    L33:
        if (r111 >= r112) goto L35;
        setMeasuredDimension(r102, (int) (r110 * r111));
        return;
    L35:
        setMeasuredDimension((int) (r109 * r112), r103);
        return;
    L22:
        if (r112 < 1.0f) goto L25;
        setMeasuredDimension((int) r109, (int) r110);
        return;
    L36:
        if (r108 == false) goto L38;
        setMeasuredDimension((int) (r109 * r112), r103);
        return;
    L38:
        if (r107 == false) goto L45;
        setMeasuredDimension(r102, (int) (r110 * r111));
        return;
    L45:
        return;
    L15:
        r107 = true;
    L12:
        r108 = true;
        goto L13
    }

    public LKUIRoundedImageView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mIsTouchSelectModeEnabled = true;
        this.mBordRectF = new RectF();
        this.mImageRectF = new RectF();
        this.mViewRectF = new RectF();
        this.mRadiusii = new float[8];
        this.mClearPath = new Path();
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.civ_badge_background, R.attr.civ_badge_icon, R.attr.civ_badge_min_size, R.attr.civ_badge_padding, R.attr.civ_badge_position_angle, R.attr.civ_badge_text, R.attr.civ_badge_text_color, R.attr.civ_badge_text_size, R.attr.civ_border_color, R.attr.civ_border_drawable, R.attr.civ_border_padding, R.attr.civ_border_width, R.attr.civ_oval, R.attr.civ_radius, R.attr.civ_radius_left_bottom, R.attr.civ_radius_left_top, R.attr.civ_radius_right_bottom, R.attr.civ_radius_right_top, R.attr.civ_selected_board_color, R.attr.civ_selected_mask_color, R.attr.civ_touch_select_enable}, r112, 0);
        this.mBorderWidth = r100.getDimensionPixelSize(11, 0);
        this.mBorderColor = r100.getColor(8, -1);
        this.mBorderPadding = r100.getDimensionPixelSize(10, 0);
        this.mBorderDrawable = r100.getDrawable(9);
        Drawable r101 = r100.getDrawable(0);
        String r102 = r100.getString(5);
        Drawable r103 = r100.getDrawable(1);
        this.mBadgeTextColor = r100.getColor(6, -1);
        this.mBadgePadding = r100.getDimensionPixelSize(3, (int) j08.b.a(r110, 2.0f));
        this.mBadgeTextSize = r100.getDimensionPixelSize(7, (int) j08.b.a(r110, 12.0f));
        this.mBadgePosAngle = r100.getInteger(4, DEFAULT_BADGE_POSITION_ANGLE);
        this.mIsTouchSelectModeEnabled = r100.getBoolean(20, true);
        this.mSelectedBorderColor = r100.getColor(18, this.mBorderColor);
        this.mSelectedMaskColor = r100.getColor(19, 0);
        int r113 = r100.getDimensionPixelSize(13, 0);
        int r114 = r100.getDimensionPixelSize(15, r113);
        int r115 = r100.getDimensionPixelSize(17, r113);
        int r116 = r100.getDimensionPixelSize(16, r113);
        int r117 = r100.getDimensionPixelSize(14, r113);
        float[] r118 = this.mRadiusii;
        float r119 = r114;
        r118[1] = r119;
        r118[0] = r119;
        float r120 = r115;
        r118[3] = r120;
        r118[2] = r120;
        float r121 = r116;
        r118[5] = r121;
        r118[4] = r121;
        float r104 = r117;
        r118[7] = r104;
        r118[6] = r104;
        this.mIsOval = r100.getBoolean(12, false);
        r100.recycle();
        if (r101 == null) goto L5;
    L7:
        this.mBadgeEnable = true;
        a.C3912a r105 = new a.C3912a(r110);
        r105.f284182c = r101;
        r105.f284185f = this.mBadgePadding;
        r105.f284184e = r103;
        r105.f284180a = r102;
        r105.f284181b = this.mBadgeTextSize;
        r105.f284183d = this.mBadgeTextColor;
        a r106 = new a(r105);
        this.mLkUIBadgeDrawable = r106;
        r106.setCallback(this);
    L8:
        init();
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
        if (r103 == null) goto L8;
        goto L7
    }

    public void setCornerRadiusDP(float r100, float r101, float r102, float r110) {
        float r103 = j08.b.a(getContext(), r100);
        float r104 = j08.b.a(getContext(), r101);
        float r105 = j08.b.a(getContext(), r102);
        float r111 = j08.b.a(getContext(), r110);
        float[] r106 = this.mRadiusii;
        if (r103 == r106[0]) goto L5;
    L10:
        r106[1] = r103;
        r106[0] = r103;
        r106[3] = r104;
        r106[2] = r104;
        r106[5] = r105;
        r106[4] = r105;
        r106[7] = r111;
        r106[6] = r111;
        this.mIsOval = false;
        invalidate();
        return;
    L5:
        if (r104 != r106[2]) goto L10;
        if (r105 != r106[4]) goto L10;
        if (r111 != r106[6]) goto L10;
    }
}
