package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.fresco.ui.common.OnFadeListener;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class FadeDrawable extends ArrayDrawable {
    public static final int TRANSITION_NONE = 2;
    public static final int TRANSITION_RUNNING = 1;
    public static final int TRANSITION_STARTING = 0;
    private final int mActualImageLayer;
    int mAlpha;
    int[] mAlphas;
    private final int mDefaultLayerAlpha;
    private final boolean mDefaultLayerIsOn;
    int mDurationMs;
    private boolean mIsFadingActualImage;
    boolean[] mIsLayerOn;
    private final Drawable[] mLayers;
    private boolean mMutateDrawables;

    @Nullable
    private OnFadeListener mOnFadeListener;
    private boolean mOnFadeListenerShowImmediately;
    int mPreventInvalidateCount;
    int[] mStartAlphas;
    long mStartTimeMs;
    int mTransitionState;

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, 0);
        this.mStartAlphas[0] = 255;
        Arrays.fill(this.mAlphas, 0);
        this.mAlphas[0] = 255;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[0] = true;
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        int r100 = 0;
    L4:
        if (r100 >= this.mLayers.length) goto L10;
        int[] r101 = this.mAlphas;
        if (this.mIsLayerOn[r100] == false) goto L8;
        int r102 = 255;
    L9:
        r101[r100] = r102;
        r100 = r100 + 1;
        goto L4
    L8:
        r102 = 0;
        goto L9
    L10:
        invalidateSelf();
    }

    private void maybeOnFadeFinished() {
        if (this.mIsFadingActualImage == true) goto L5;
        return;
    L5:
        this.mIsFadingActualImage = false;
        OnFadeListener r100 = this.mOnFadeListener;
        if (r100 == null) goto L9;
        r100.onFadeFinished();
        return;
    }

    private void maybeOnFadeStarted() {
        if (this.mIsFadingActualImage == false) goto L5;
        return;
    L5:
        int r100 = this.mActualImageLayer;
        if (r100 < 0) goto L17;
        boolean[] r101 = this.mIsLayerOn;
        if (r100 < r101.length) goto L11;
        return;
    L11:
        if (r101[r100] == true) goto L13;
        return;
    L13:
        this.mIsFadingActualImage = true;
        OnFadeListener r102 = this.mOnFadeListener;
        if (r102 == null) goto L18;
        r102.onFadeStarted();
        return;
    L18:
        return;
    }

    private void maybeOnImageShownImmediately() {
        if (this.mOnFadeListenerShowImmediately == true) goto L6;
        return;
    L6:
        if (this.mTransitionState == 2) goto L8;
        return;
    L8:
        if (this.mIsLayerOn[this.mActualImageLayer] == false) goto L15;
        OnFadeListener r100 = this.mOnFadeListener;
        if (r100 == null) goto L12;
        r100.onShownImmediately();
    L12:
        this.mOnFadeListenerShowImmediately = false;
        return;
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mPreventInvalidateCount != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    public int getTransitionState() {
        return this.mTransitionState;
    }

    public boolean isDefaultLayerIsOn() {
        return this.mDefaultLayerIsOn;
    }

    public FadeDrawable(Drawable[] r100) {
        this(r100, false, -1);
    }

    private boolean updateAlphas(float r110) {
        int r100 = 0;
        boolean r101 = true;
    L4:
        if (r100 >= this.mLayers.length) goto L24;
        boolean r102 = this.mIsLayerOn[r100];
        if (r102 == false) goto L8;
        int r103 = 1;
    L9:
        int[] r104 = this.mAlphas;
        int r105 = (int) (this.mStartAlphas[r100] + ((r103 * 255) * r110));
        r104[r100] = r105;
        if (r105 >= 0) goto L13;
        r104[r100] = 0;
    L13:
        if (r104[r100] <= 255) goto L15;
        r104[r100] = 255;
    L15:
        if (r102 == true) goto L17;
    L19:
        if (r102 == true) goto L23;
        if (r104[r100] <= 0) goto L23;
        r101 = false;
    L23:
        r100 = r100 + 1;
        goto L4
    L17:
        if (r104[r100] >= 255) goto L19;
        r101 = false;
        goto L19
    L8:
        r103 = -1;
        goto L9
    L24:
        return r101;
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        int r101 = this.mTransitionState;
        int r102 = 2;
        int r103 = 0;
        boolean r104 = true;
        if (r101 == 0) goto L15;
        if (r101 != 1) goto L25;
        if (this.mDurationMs <= 0) goto L9;
        boolean r105 = true;
    L10:
        Preconditions.checkState(r105);
        boolean r106 = updateAlphas((getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
        if (r106 == true) goto L14;
        r102 = 1;
    L14:
        this.mTransitionState = r102;
    L24:
        r104 = r106;
        goto L25
    L9:
        r105 = false;
    L25:
        Drawable[] r107 = this.mLayers;
        if (r103 >= r107.length) goto L28;
        drawDrawableWithAlpha(r100, r107[r103], (this.mAlphas[r103] * this.mAlpha) / 255);
        r103 = r103 + 1;
        goto L25
    L28:
        if (r104 == false) goto L30;
        maybeOnFadeFinished();
        maybeOnImageShownImmediately();
        return;
    L30:
        invalidateSelf();
        return;
    L15:
        System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
        this.mStartTimeMs = getCurrentTimeMs();
        if (this.mDurationMs != 0) goto L18;
        float r108 = 1.0f;
    L19:
        r106 = updateAlphas(r108);
        maybeOnFadeStarted();
        if (r106 == true) goto L23;
        r102 = 1;
    L23:
        this.mTransitionState = r102;
        goto L24
    L18:
        r108 = 0.0f;
        goto L19
    }

    public void fadeInLayer(int r100) {
        this.mTransitionState = 0;
        this.mIsLayerOn[r100] = true;
        invalidateSelf();
    }

    public void fadeOutLayer(int r100) {
        this.mTransitionState = 0;
        this.mIsLayerOn[r100] = false;
        invalidateSelf();
    }

    public void fadeToLayer(int r100) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[r100] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int r100) {
        this.mTransitionState = 0;
        int r101 = r100 + 1;
        Arrays.fill(this.mIsLayerOn, 0, r101, true);
        Arrays.fill(this.mIsLayerOn, r101, this.mLayers.length, false);
        invalidateSelf();
    }

    public void hideLayerImmediately(int r100) {
        this.mIsLayerOn[r100] = false;
        this.mAlphas[r100] = 0;
        invalidateSelf();
    }

    public boolean isLayerOn(int r100) {
        return this.mIsLayerOn[r100];
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (this.mAlpha == r100) goto L6;
        this.mAlpha = r100;
        invalidateSelf();
        return;
    }

    public void setMutateDrawables(boolean r100) {
        this.mMutateDrawables = r100;
    }

    public void setOnFadeListener(@Nullable OnFadeListener r100) {
        this.mOnFadeListener = r100;
    }

    public void setTransitionDuration(int r100) {
        this.mDurationMs = r100;
        if (this.mTransitionState != 1) goto L6;
        this.mTransitionState = 0;
        return;
    }

    public void showLayerImmediately(int r100) {
        this.mIsLayerOn[r100] = true;
        this.mAlphas[r100] = 255;
        if (r100 != this.mActualImageLayer) goto L5;
        this.mOnFadeListenerShowImmediately = true;
    L5:
        invalidateSelf();
    }

    public FadeDrawable(Drawable[] r100, boolean r101, int r102) {
        super(r100);
        boolean r103 = true;
        this.mMutateDrawables = true;
        int r104 = 0;
        if (r100.length >= 1) goto L6;
        r103 = false;
    L6:
        Preconditions.checkState(r103, "At least one layer required!");
        this.mLayers = r100;
        this.mStartAlphas = new int[r100.length];
        this.mAlphas = new int[r100.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[r100.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = r101;
        if (r101 == false) goto L9;
        r104 = 255;
    L9:
        this.mDefaultLayerAlpha = r104;
        this.mActualImageLayer = r102;
        resetInternal();
    }

    private void drawDrawableWithAlpha(Canvas r100, Drawable r101, int r102) {
        if (r101 == null) goto L9;
        if (r102 <= 0) goto L10;
        this.mPreventInvalidateCount++;
        if (this.mMutateDrawables == false) goto L7;
        r101.mutate();
    L7:
        r101.setAlpha(r102);
        this.mPreventInvalidateCount--;
        r101.draw(r100);
        return;
    L10:
        return;
    }
}
