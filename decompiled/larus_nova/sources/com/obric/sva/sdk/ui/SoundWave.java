package com.obric.sva.sdk.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes34.dex */
public class SoundWave extends View {
    private static final String TAG = null;
    public static final int TOTALNUM = 4;
    private final long ANIMATE_DURATION;
    private final long DOT_ANIMATE_DURATION;
    private final PathInterpolator SPRING_PATH;
    private final HashMap<Integer, ObjectAnimator> mAnimatorHashMap;
    AnimatorSet mAnimatorSet;
    private final ArrayList<Float> mData;
    private final HashMap<Integer, ObjectAnimator> mDotAnimatorHashMap;
    AnimatorSet mDotAnimatorSet;
    private boolean mIsAlreadyInit;
    private boolean mIsDotAnim;
    private final ArrayList<RectF> mList;
    private int mMiddle;
    private final Paint[] mPaint;
    private final Random mRandom;
    private float mRound;
    private final float[] mScaleData;
    private final float[] mScales;
    private int mStart;

    static {
        TAG = "SoundWave";
    }

    public float getCurrent0Scale() {
        return this.mScaleData[0];
    }

    public float getCurrent0Volume() {
        return ((Float) ListProtector.get(this.mData, 0)).floatValue();
    }

    public float getCurrent1Scale() {
        return this.mScaleData[1];
    }

    public float getCurrent1Volume() {
        return ((Float) ListProtector.get(this.mData, 1)).floatValue();
    }

    public float getCurrent2Scale() {
        return this.mScaleData[2];
    }

    public float getCurrent2Volume() {
        return ((Float) ListProtector.get(this.mData, 2)).floatValue();
    }

    public float getCurrent3Scale() {
        return this.mScaleData[3];
    }

    public float getCurrent3Volume() {
        return ((Float) ListProtector.get(this.mData, 3)).floatValue();
    }

    public void startDotAnimation() {
        AnimatorSet r100 = this.mAnimatorSet;
        if (r100 != null) goto L5;
    L7:
        AnimatorSet r101 = this.mDotAnimatorSet;
        if (r101 != null) goto L10;
    L12:
        setCurrent0Scale(1.0f);
        setCurrent1Scale(1.0f);
        setCurrent2Scale(1.0f);
        setCurrent3Scale(1.0f);
        this.mDotAnimatorSet.start();
        return;
    L10:
        if (r101.isRunning() == false) goto L12;
        this.mDotAnimatorSet.cancel();
        goto L12
    L5:
        if (r100.isRunning() == false) goto L7;
        this.mAnimatorSet.cancel();
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.mIsAlreadyInit == true) goto L5;
        this.mMiddle = getMeasuredHeight() / 2;
        this.mStart = getMeasuredWidth() / 4;
        this.mIsAlreadyInit = true;
    L5:
        int r101 = 0;
        if (this.mIsDotAnim == false) goto L9;
    L7:
        if (r101 >= 4) goto L11;
        float r102 = this.mStart * r101;
        float r103 = this.mRound;
        r100.drawCircle(r102 + (3.0f * r103), this.mMiddle, r103 * this.mScaleData[r101], this.mPaint[r101]);
        r101 = r101 + 1;
        goto L7
    L11:
        return;
    L9:
        if (r101 >= 4) goto L14;
        ((RectF) ListProtector.get(this.mList, r101)).set((this.mStart * r101) + (this.mRound * 2.0f), this.mMiddle - ((Float) ListProtector.get(this.mData, r101)).floatValue(), (this.mStart * r101) + ((this.mRound * 2.0f) * 2.0f), this.mMiddle + ((Float) ListProtector.get(this.mData, r101)).floatValue());
        RectF r104 = (RectF) ListProtector.get(this.mList, r101);
        float r105 = this.mRound;
        r100.drawRoundRect(r104, r105, r105, this.mPaint[r101]);
        r101 = r101 + 1;
        goto L9
    }

    public void setCurrent0Scale(float r100) {
        this.mScaleData[0] = r100;
        postInvalidateOnAnimation();
    }

    public void setCurrent0Volume(float r100) {
        ListProtector.set(this.mData, 0, Float.valueOf(r100));
        postInvalidateOnAnimation();
    }

    public void setCurrent1Scale(float r100) {
        this.mScaleData[1] = r100;
        postInvalidateOnAnimation();
    }

    public void setCurrent1Volume(float r100) {
        ListProtector.set(this.mData, 1, Float.valueOf(r100));
        postInvalidateOnAnimation();
    }

    public void setCurrent2Scale(float r100) {
        this.mScaleData[2] = r100;
        postInvalidateOnAnimation();
    }

    public void setCurrent2Volume(float r100) {
        ListProtector.set(this.mData, 2, Float.valueOf(r100));
        postInvalidateOnAnimation();
    }

    public void setCurrent3Scale(float r100) {
        this.mScaleData[3] = r100;
        postInvalidateOnAnimation();
    }

    public void setCurrent3Volume(float r100) {
        ListProtector.set(this.mData, 3, Float.valueOf(r100));
        postInvalidateOnAnimation();
    }

    public void setData(float[] r110) {
        if (r110.length == 4) goto L5;
        return;
    L5:
        AnimatorSet r100 = this.mAnimatorSet;
        if (r100 != null) goto L8;
    L10:
        int r101 = 0;
        boolean r102 = true;
    L11:
        if (r101 >= 4) goto L19;
        float r103 = r110[r101];
        if (r103 >= 0.0f) goto L15;
        r103 = -r103;
    L15:
        float r104 = Math.max(this.mRound, (r103 * this.mScales[r101]) % this.mMiddle);
        r110[r101] = r104;
        if (r104 == this.mRound) goto L18;
        r102 = false;
    L18:
        r101 = r101 + 1;
        goto L11
    L19:
        if (r102 == true) goto L21;
        AnimatorSet r105 = this.mDotAnimatorSet;
        if (r105 != null) goto L27;
    L29:
        Arrays.sort(r110);
        float r106 = r110[3];
        r110[3] = r110[1];
        r110[1] = r106;
        this.mAnimatorSet = new AnimatorSet();
        int r107 = 0;
    L30:
        if (r107 >= 4) goto L32;
        float r108 = r110[r107];
        ObjectAnimator r109 = this.mAnimatorHashMap.get(Integer.valueOf(r107));
        long r111 = this.mRandom.nextInt(120);
        r109.setDuration(240 - r111);
        r109.setFloatValues(new float[]{r108});
        this.mAnimatorSet.play(r109).after(r111);
        r107 = r107 + 1;
        goto L30
    L32:
        this.mAnimatorSet.start();
        return;
    L27:
        if (r105.isRunning() == false) goto L29;
        this.mDotAnimatorSet.cancel();
        goto L29
    L21:
        if (this.mDotAnimatorSet.isRunning() == true) goto L38;
        startDotAnimation();
        return;
    L38:
        return;
    L8:
        if (r100.isRunning() == false) goto L10;
        this.mAnimatorSet.cancel();
        goto L10
    }

    public SoundWave(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.mPaint = new Paint[4];
        this.ANIMATE_DURATION = 240;
        this.DOT_ANIMATE_DURATION = 480;
        this.mList = new ArrayList();
        this.mData = new ArrayList();
        this.mScaleData = new float[4];
        this.mScales = new float[]{1.4f, 2.0f, 2.0f, 1.4f};
        this.SPRING_PATH = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mAnimatorHashMap = new HashMap(4);
        this.mDotAnimatorHashMap = new HashMap(4);
        this.mRandom = new Random(System.currentTimeMillis());
        this.mRound = 10.0f;
        int r100 = 0;
        this.mIsDotAnim = false;
        this.mRound = Utils.dp2Px(r110, 4.0f);
        int r112 = 0;
    L3:
        if (r112 >= 4) goto L5;
        Paint r101 = new Paint();
        r101.setColor(new int[]{-1654465, -14878215, -8426753, -16742913}[r112]);
        r101.setStyle(Paint.Style.FILL);
        r101.setAntiAlias(true);
        this.mPaint[r112] = r101;
        this.mList.add(new RectF());
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "current" + r112 + "Volume", new float[]{this.mRound});
        r102.setDuration(240);
        r102.setRepeatMode(2);
        r102.setRepeatCount(1);
        r102.setInterpolator(new DecelerateInterpolator());
        this.mAnimatorHashMap.put(Integer.valueOf(r112), r102);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "current" + r112 + "Scale", new float[]{1.0f, 0.3f});
        r103.setDuration(480);
        r103.setRepeatMode(2);
        r103.setRepeatCount(1);
        r103.setInterpolator(new LinearInterpolator());
        this.mDotAnimatorHashMap.put(Integer.valueOf(r112), r103);
        this.mData.add(Float.valueOf(this.mRound));
        r112 = r112 + 1;
        goto L3
    L5:
        this.mDotAnimatorSet = new AnimatorSet();
    L6:
        if (r100 >= 4) goto L8;
        this.mDotAnimatorSet.play(this.mDotAnimatorHashMap.get(Integer.valueOf(r100))).after((((long) r100) * 480) / 2);
        r100 = r100 + 1;
        goto L6
    L8:
        this.mDotAnimatorSet.addListener(new AnonymousClass1(this));
    }

    public static /* synthetic */ boolean access$002(SoundWave r100, boolean r101) {
        r100.mIsDotAnim = r101;
        return r101;
    }
}
