package com.bytedance.android.ui.ec.widget.popup;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BubbleLayout extends LinearLayout {
    public static final int BOTTOM = 3;
    public static float CORNER_RADIUS = 0.0f;
    public static int DEFAULT_HEIGHT = 0;
    public static int DEFAULT_STROKE_WIDTH = 0;
    public static int DEFAULT_WIDTH = 0;
    public static final int LEFT = 1;
    public static int LEG_HALF_BASE = 0;
    public static float MIN_ARROW_DISTANCE = 0.0f;
    public static final int NONE = 4;
    public static int PADDING = 0;
    public static final int RIGHT = 2;
    public static float STROKE_WIDTH;
    public static final int TOP = 0;
    private int mArrowLongSize;
    private int mArrowVerticalSize;
    private int mBgColor;
    private Bitmap mBitmap;
    private final Path mBorderBubbleArrowPath;
    private int mBorderColor;
    private Matrix mBorderMatrix;
    private RectF mBorderRoundRect;
    private int mBorderWidth;
    private float mBubbleArrowOffset;
    private final Path mBubbleArrowPath;
    private int mBubbleOrientation;
    private Canvas mCanvas;
    private Context mContext;
    private Paint mFillPaint;
    private float mHeight;
    private int mHorizontalPadding;
    private float mMeasuredHeight;
    private boolean mNeedPath;
    private boolean mNeedPressFade;
    private final Path mPath;
    private RectF mRoundRect;
    private Boolean mRounderArrow;
    private int mShadowLayerColor;
    private float mShadowLayerYOffset;
    private float mWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    public static /* synthetic */ void a(ValueAnimator r0) {
        lambda$animFadeOut$1(r0);
    }

    private void animFadeOut() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f});
        r0.setDuration(100);
        r0.start();
        r0.addUpdateListener(new a());
    }

    public static /* synthetic */ void b(ValueAnimator r0) {
        lambda$animFadeIn$0(r0);
    }

    private static /* synthetic */ void lambda$animFadeIn$0(ValueAnimator r0) {
    }

    private static /* synthetic */ void lambda$animFadeOut$1(ValueAnimator r0) {
    }

    public float getBubbleOffset() {
        float r0 = Math.max(this.mBubbleArrowOffset, MIN_ARROW_DISTANCE);
        int r1 = this.mBubbleOrientation;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L13;
        return 0.0f;
    L15:
        return Math.min(r0, this.mHeight - MIN_ARROW_DISTANCE);
    L13:
        return Math.min(r0, this.mWidth - MIN_ARROW_DISTANCE);
    }

    public int getHeightWithArrow() {
        return (int) (DEFAULT_HEIGHT + dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
    }

    private void animFadeIn() {
        clearAnimation();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        r0.setDuration(100);
        r0.start();
        r0.addUpdateListener(new b());
    }

    public int getHorizontalPadding() {
        return this.mHorizontalPadding;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubbleLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private void renderBubbleArrowPath(Context r12) {
        this.mBubbleArrowPath.moveTo(0.0f, 0.0f);
        this.mBubbleArrowPath.lineTo(dip2Px(r12, this.mArrowVerticalSize), -dip2Px(r12, this.mArrowLongSize / 2.0f));
        this.mBubbleArrowPath.lineTo(dip2Px(r12, this.mArrowVerticalSize), dip2Px(r12, this.mArrowLongSize / 2.0f));
        this.mBubbleArrowPath.close();
        this.mBorderBubbleArrowPath.moveTo(0.0f, 0.0f);
        this.mBorderBubbleArrowPath.lineTo((float) (((double) dip2Px(r12, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))), (float) (((double) (-dip2Px(r12, this.mArrowLongSize / 2.0f))) - (((double) this.mBorderWidth) * Math.sqrt(2.0d))));
        this.mBorderBubbleArrowPath.lineTo((float) (((double) dip2Px(r12, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))), (float) (((double) dip2Px(r12, this.mArrowVerticalSize)) + (((double) this.mBorderWidth) * Math.sqrt(2.0d))));
        this.mBorderBubbleArrowPath.close();
    }

    private void renderRounderBubbleArrowPath(Context r23) {
        Float r2 = Float.valueOf(this.mArrowLongSize / 2.0f);
        this.mBubbleArrowPath.moveTo(dip2Px(r23, this.mArrowVerticalSize), dip2Px(r23, r2.floatValue()));
        this.mBubbleArrowPath.cubicTo(dip2Px(r23, this.mArrowVerticalSize), dip2Px(r23, r2.floatValue() / 2.0f), 0.0f, dip2Px(r23, r2.floatValue() / 4.0f), 0.0f, 0.0f);
        this.mBubbleArrowPath.cubicTo(0.0f, -dip2Px(r23, r2.floatValue() / 4.0f), dip2Px(r23, this.mArrowVerticalSize), -dip2Px(r23, r2.floatValue() / 2.0f), dip2Px(r23, this.mArrowVerticalSize), -dip2Px(r23, r2.floatValue()));
        this.mBubbleArrowPath.close();
        this.mBorderBubbleArrowPath.moveTo(dip2Px(r23, this.mArrowVerticalSize), dip2Px(r23, r2.floatValue()));
        this.mBorderBubbleArrowPath.cubicTo(dip2Px(r23, this.mArrowVerticalSize), dip2Px(r23, r2.floatValue() / 2.0f), 0.0f, dip2Px(r23, (r2.floatValue() * 5.0f) / 16.0f), 0.0f, 0.0f);
        this.mBorderBubbleArrowPath.cubicTo(0.0f, -dip2Px(r23, r2.floatValue() / 4.0f), dip2Px(r23, this.mArrowVerticalSize), -dip2Px(r23, r2.floatValue() / 2.0f), dip2Px(r23, this.mArrowVerticalSize), -dip2Px(r23, r2.floatValue()));
        this.mBorderBubbleArrowPath.close();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r7) {
        if (this.mRounderArrow.booleanValue() == false) goto L5;
        renderRounderBubbleArrowPath(this.mContext);
    L7:
        if (this.mBitmap != null) goto L12;
        Bitmap r0 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.mBitmap = r0;
        if (r0.getDensity() == r7.getDensity()) goto L11;
        this.mBitmap.setDensity(r7.getDensity());
    L11:
        this.mCanvas = new Canvas(this.mBitmap);
    L12:
        Matrix r1 = renderBubbleArrowMatrix(this.mWidth, this.mHeight);
        this.mFillPaint.setColor(this.mBorderColor);
        this.mFillPaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setStrokeWidth(this.mBorderWidth);
        if (this.mNeedPath == false) goto L15;
        this.mPath.reset();
        Path r2 = this.mPath;
        RectF r3 = this.mBorderRoundRect;
        float r4 = CORNER_RADIUS;
        int r5 = this.mBorderWidth;
        r2.addRoundRect(r3, (r5 / 2) + r4, r4 + (r5 / 2), Path.Direction.CW);
        this.mPath.addPath(this.mBorderBubbleArrowPath, this.mBorderMatrix);
        this.mCanvas.drawPath(this.mPath, this.mFillPaint);
    L15:
        this.mFillPaint.setColor(this.mBgColor);
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mPath.reset();
        Path r6 = this.mPath;
        RectF r8 = this.mRoundRect;
        float r9 = CORNER_RADIUS;
        r6.addRoundRect(r8, r9, r9, Path.Direction.CW);
        this.mPath.addPath(this.mBubbleArrowPath, r1);
        this.mCanvas.drawPath(this.mPath, this.mFillPaint);
        r7.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        return;
    L5:
        renderBubbleArrowPath(this.mContext);
        goto L7
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        int r0 = r3.getAction();
        if (r0 == 0) goto L13;
        if (r0 == 1) goto L10;
        if (r0 == 3) goto L10;
    L16:
        return super.onTouchEvent(r3);
    L10:
        if (this.mNeedPressFade == false) goto L16;
        animFadeIn();
        goto L16
    L13:
        if (this.mNeedPressFade == false) goto L16;
        animFadeOut();
        goto L16
    }

    public void setArrowLongSize(int r1) {
        this.mArrowLongSize = r1;
    }

    public void setArrowVerticalSize(int r1) {
        this.mArrowVerticalSize = r1;
    }

    public void setBgColor(int r1) {
        this.mBgColor = r1;
    }

    public void setBorderColor(int r1) {
        this.mBorderColor = r1;
    }

    public void setBubbleOrientation(int r1) {
        this.mBubbleOrientation = r1;
    }

    public void setHorizontalPadding(int r1) {
        this.mHorizontalPadding = r1;
    }

    public void setNeedPath(boolean r1) {
        this.mNeedPath = r1;
    }

    public void setNeedPressFade(boolean r1) {
        this.mNeedPressFade = r1;
    }

    public void setShadowLayerColor(int r1) {
        this.mShadowLayerColor = r1;
    }

    public void setShadowLayerYOffset(int r1) {
        this.mShadowLayerYOffset = r1;
    }

    public BubbleLayout(Context r2, Boolean r3) {
        this(r2, r3, null);
    }

    public static float dip2Px(Context r0, float r1) {
        return (r1 * INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubbleLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources()).density) + 0.5f;
    }

    private Matrix renderBubbleArrowMatrix(float r13, float r14) {
        float r0 = Math.max(this.mBubbleArrowOffset, MIN_ARROW_DISTANCE);
        float r1 = Math.min(r0, r14 - MIN_ARROW_DISTANCE);
        Matrix r2 = new Matrix();
        this.mBorderMatrix = new Matrix();
        int r3 = this.mBubbleOrientation;
        if (r3 != 0) goto L5;
        r13 = Math.min(r0, r13 - MIN_ARROW_DISTANCE);
        r2.postRotate(90.0f);
        r2.postTranslate(0.0f, dip2Px(this.mContext, this.mShadowLayerYOffset / 2.0f));
        this.mBorderMatrix.postRotate(90.0f);
        Matrix r15 = this.mBorderMatrix;
        int r4 = this.mBorderWidth;
        r15.postTranslate(((r4 * 3) / 2) + r13, r4 + 0.0f);
        setPadding(0, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)), 0, 0);
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)), this.mWidth, this.mHeight);
        this.mFillPaint.setShadowLayer(8.0f, 0.0f, -this.mShadowLayerYOffset, this.mShadowLayerColor);
        r14 = 0.0f;
    L14:
        RectF r5 = this.mRoundRect;
        float r6 = r5.left;
        int r7 = this.mBorderWidth;
        r5.left = r6 + ((r7 * 3) / 2);
        r5.top += (r7 * 3) / 2;
        r5.right += (r7 * 3) / 2;
        r5.bottom += (r7 * 3) / 2;
        RectF r8 = new RectF();
        this.mBorderRoundRect = r8;
        RectF r9 = this.mRoundRect;
        float r10 = r9.left;
        int r11 = this.mBorderWidth;
        r8.left = r10 - (r11 / 2);
        r8.top = r9.top - (r11 / 2);
        r8.right = r9.right + (r11 / 2);
        r8.bottom = r9.bottom + (r11 / 2);
        r2.postTranslate(r13 + ((r11 * 3) / 2), r14 + ((r11 * 3) / 2));
        return r2;
    L5:
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L11;
        if (r3 == 3) goto L10;
        r14 = r1;
    L9:
        r13 = 0.0f;
        goto L14
    L10:
        r13 = Math.min(r0, r13 - MIN_ARROW_DISTANCE);
        r2.postRotate(270.0f);
        r2.postTranslate(0.0f, -dip2Px(this.mContext, this.mShadowLayerYOffset / 2.0f));
        this.mBorderMatrix.postRotate(270.0f);
        Matrix r12 = this.mBorderMatrix;
        int r16 = this.mBorderWidth;
        r12.postTranslate(((r16 * 3) / 2) + r13, (r16 * 2) + r14);
        setPadding(0, 0, 0, (int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - ((int) dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f))));
        this.mFillPaint.setShadowLayer(8.0f, 0.0f, this.mShadowLayerYOffset, this.mShadowLayerColor);
        goto L14
    L11:
        r14 = Math.min(r0, r14 - MIN_ARROW_DISTANCE);
        r2.postRotate(180.0f);
        this.mBorderMatrix.postRotate(180.0f);
        Matrix r17 = this.mBorderMatrix;
        int r18 = this.mBorderWidth;
        r17.postTranslate((r18 * 2) + r13, ((r18 * 3) / 2) + r14);
        setPadding(0, 0, PADDING, 0);
        setGravity(17);
        this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth - PADDING, this.mHeight);
        goto L14
    L12:
        r14 = Math.min(r0, r14 - MIN_ARROW_DISTANCE);
        setPadding(PADDING, 0, 0, 0);
        setGravity(17);
        Matrix r19 = this.mBorderMatrix;
        int r20 = this.mBorderWidth;
        r19.postTranslate(r20 + 0.0f, ((r20 * 3) / 2) + r14);
        this.mRoundRect = new RectF(PADDING, 0.0f, this.mWidth, this.mHeight);
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r0 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r1 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (this.mMeasuredHeight != 0.0f) goto L5;
        this.mMeasuredHeight = getMeasuredHeight();
    L5:
        int r2 = (int) (this.mMeasuredHeight + dip2Px(this.mContext, this.mArrowVerticalSize + (this.mShadowLayerYOffset / 2.0f)));
        int r3 = (int) (getMeasuredWidth() + (dip2Px(this.mContext, this.mHorizontalPadding) * 2.0f));
        int r4 = this.mBorderWidth;
        int r5 = r3 + (r4 * 3);
        int r6 = r2 + (r4 * 3);
        if (r0 != Integer.MIN_VALUE) goto L9;
        if (r1 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r5, r6);
    L13:
        this.mWidth = getMeasuredWidth() - (this.mBorderWidth * 3);
        this.mHeight = getMeasuredHeight() - (this.mBorderWidth * 3);
        return;
    L9:
        if (r0 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r5, r11);
        goto L13
    L11:
        if (r1 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r10, r6);
        goto L13
    }

    public void setBubbleParams(int r1, float r2) {
        this.mBubbleArrowOffset = r2;
        this.mBubbleOrientation = r1;
    }

    public BubbleLayout(Context r2, Boolean r3, AttributeSet r4) {
        this(r2, r3, r4, 0);
    }

    private void init(Context r2, Boolean r3, AttributeSet r4) {
        this.mContext = r2;
        int r5 = (int) dip2Px(r2, 0.5f);
        this.mBorderWidth = r5;
        if (r5 >= 2) goto L5;
        this.mBorderWidth = 2;
    L5:
        PADDING = (int) dip2Px(r2, 7.0f);
        LEG_HALF_BASE = (int) dip2Px(r2, 6.0f);
        STROKE_WIDTH = 8.0f;
        DEFAULT_STROKE_WIDTH = (int) dip2Px(r2, 8.0f);
        CORNER_RADIUS = dip2Px(r2, 8.0f);
        MIN_ARROW_DISTANCE = PADDING + LEG_HALF_BASE;
        DEFAULT_WIDTH = (int) dip2Px(r2, 50.0f);
        DEFAULT_HEIGHT = (int) dip2Px(r2, 37.0f);
        Paint r6 = new Paint();
        this.mFillPaint = r6;
        r6.setStyle(Paint.Style.FILL);
        this.mFillPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mFillPaint.setAntiAlias(true);
        this.mFillPaint.setStrokeWidth(STROKE_WIDTH);
        this.mFillPaint.setStrokeJoin(Paint.Join.MITER);
        this.mBgColor = ColorProtector.parseColor("#CC000000");
        this.mBorderColor = ColorProtector.parseColor("#1DFFFFFF");
        this.mShadowLayerColor = ColorProtector.parseColor("#40C8C8C8");
        this.mFillPaint.setColor(this.mBgColor);
        this.mRounderArrow = r3;
        setLayerType(1, this.mFillPaint);
        setBackgroundColor(0);
        setClipChildren(false);
    }

    public BubbleLayout(Context r1, Boolean r2, AttributeSet r3, int r4) {
        super(r1, r3, r4);
        this.mFillPaint = null;
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        this.mHorizontalPadding = 4;
        this.mArrowLongSize = 14;
        this.mArrowVerticalSize = 7;
        this.mShadowLayerYOffset = 8.0f;
        this.mBorderBubbleArrowPath = new Path();
        this.mRounderArrow = Boolean.FALSE;
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedPath = true;
        init(r1, r2, r3);
    }
}
