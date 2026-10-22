package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class DoubleColorBallAnimationView extends View {
    private boolean autoProgress;
    private int cycleBias;
    private boolean dataReady;
    private long mAnimateStartTime;
    private boolean mAnimating;
    private final float mBaseHorizon;
    private final float mBaseP;
    private float mBaseR;
    private float mBaseX;
    private int mColor1;
    private int mColor2;
    private final long mDelay;
    private float mDistance;
    private final float mDuration;
    private final float mMaxScale;
    private final float mMinScale;
    private Paint mPaint;
    private int mSide;
    private float mSideCenter;
    private final PorterDuffXfermode mode;
    private float progress;

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
        init(r100);
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        init(r100);
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mMaxScale = 0.25f;
        this.mMinScale = 0.375f;
        this.mBaseHorizon = 0.16f;
        this.mBaseP = 0.32f;
        this.mDuration = 400.0f;
        this.mDelay = 17;
        this.mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.autoProgress = false;
        this.dataReady = false;
        this.cycleBias = 0;
        this.mAnimating = false;
        this.mAnimateStartTime = -1;
        this.mSide = -1;
        init(r100);
    }

    private void checkData() {
        this.mAnimateStartTime = -1;
        if (this.mSide > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.default_loading_side));
    L5:
        int r100 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.mSide <= r100) goto L10;
        if (r100 <= 0) goto L10;
        setProgressBarInfo(r100);
    L10:
        if (this.mPaint != null) goto L12;
        this.mPaint = createPaint();
    L12:
        this.dataReady = true;
    }

    private Paint createPaint() {
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setDither(true);
        r100.setStyle(Paint.Style.FILL);
        return r100;
    }

    private float getRealProgress(float r100) {
        if (r100 >= 0.5d) goto L7;
        return (2.0f * r100) * r100;
    L7:
        return ((r100 * 2.0f) * (2.0f - r100)) - 1.0f;
    }

    private void init(Context r100) {
        this.mColor1 = getContext().getResources().getColor(R.color.aweme_open_loading_color1);
        this.mColor2 = getContext().getResources().getColor(R.color.aweme_open_loading_color2);
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isAnimating() == true) goto L7;
        if (this.autoProgress == false) goto L7;
        return;
    L7:
        if (this.dataReady == false) goto L32;
        boolean r100 = false;
        if (this.autoProgress == false) goto L18;
        long r101 = System.nanoTime() / 1000000;
        if (this.mAnimateStartTime >= 0) goto L14;
        this.mAnimateStartTime = r101;
    L14:
        float r102 = (r101 - this.mAnimateStartTime) / 400.0f;
        this.progress = r102;
        int r103 = (int) r102;
        if (((this.cycleBias + r103) & 1) != 1) goto L17;
        r100 = true;
    L17:
        this.progress = r102 - r103;
    L18:
        float r104 = getRealProgress(this.progress);
        float r105 = this.mSide;
        int r106 = r110.saveLayer(0.0f, 0.0f, r105, r105, this.mPaint, 31);
        float r107 = (this.mDistance * r104) + this.mBaseX;
        double r108 = r104;
        float r109 = r104 * 2.0f;
        if (r108 < 0.5d) goto L22;
        r109 = 2.0f - r109;
    L22:
        float r111 = this.mBaseR;
        float r112 = ((0.25f * r109) * r111) + r111;
        Paint r113 = this.mPaint;
        if (r100 == false) goto L25;
        int r114 = this.mColor2;
    L26:
        r113.setColor(r114);
        r110.drawCircle(r107, this.mSideCenter, r112, this.mPaint);
        float r115 = this.mSide - r107;
        float r116 = this.mBaseR;
        float r117 = r116 - ((r109 * 0.375f) * r116);
        Paint r118 = this.mPaint;
        if (r100 == false) goto L29;
        int r119 = this.mColor1;
    L30:
        r118.setColor(r119);
        this.mPaint.setXfermode(this.mode);
        r110.drawCircle(r115, this.mSideCenter, r117, this.mPaint);
        this.mPaint.setXfermode(null);
        r110.restoreToCount(r106);
        postInvalidateDelayed(17);
        return;
    L29:
        r119 = this.mColor2;
        goto L30
    L25:
        r114 = this.mColor1;
        goto L26
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = Math.min(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (this.mSide <= r102) goto L7;
        if (r102 <= 0) goto L8;
        setProgressBarInfo(r102);
        return;
    L8:
        return;
    }

    public void setCycleBias(int r100) {
        this.cycleBias = r100;
    }

    public void setProgress(float r100) {
        if (this.dataReady == true) goto L5;
        checkData();
    L5:
        this.progress = r100;
        this.mAnimating = false;
        this.autoProgress = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        this.mSide = r100;
        float r101 = r100;
        this.mSideCenter = r101 / 2.0f;
        float r102 = (r100 >> 1) * 0.32f;
        this.mBaseR = r102;
        float r103 = (0.16f * r101) + r102;
        this.mBaseX = r103;
        this.mDistance = r101 - (r103 * 2.0f);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        startAnimate();
        return;
    L5:
        stopAnimate();
    }

    public void startAnimate() {
        checkData();
        this.mAnimating = true;
        this.autoProgress = true;
        postInvalidate();
    }

    public void stopAnimate() {
        this.mAnimating = false;
        this.dataReady = false;
        this.progress = 0.0f;
    }
}
