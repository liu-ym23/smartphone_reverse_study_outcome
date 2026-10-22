package com.ss.texturerender.effect.vr;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class TouchScaler implements ScaleGestureDetector.OnScaleGestureListener {
    public static final float MAX_SCALE = 4.0f;
    public static final float MIN_SCALE = 0.2f;
    private final String LOG_TAG;
    private float curMaxScale;
    private float curMinScale;
    private int mTexType;
    private Matrix matrix;
    private float[] values;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector r100) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector r100) {
    }

    public void start() {
    }

    public float getScale() {
        this.matrix.getValues(this.values);
        return this.values[0];
    }

    public void stop() {
        this.matrix = new Matrix();
    }

    public TouchScaler(int r100) {
        this.curMaxScale = 4.0f;
        this.curMinScale = 0.2f;
        this.matrix = new Matrix();
        this.values = new float[9];
        this.mTexType = -1;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector r100) {
        float r101 = r100.getScaleFactor();
        float r102 = getScale();
        float r103 = this.curMaxScale;
        if (r102 > r103) goto L5;
    L6:
        float r104 = this.curMinScale;
        if (r102 >= r104) goto L11;
        if (r101 <= 1.0f) goto L11;
    L14:
        this.matrix.postScale(r101, r101, r100.getFocusX(), r100.getFocusY());
    L15:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "scaleFactor:" + r101 + ",curScale:" + r102);
        return true;
    L11:
        if (r102 >= r103) goto L15;
        if (r102 <= r104) goto L15;
    L5:
        if (r101 < 1.0f) goto L14;
        goto L6
    }

    public void setMaxScale(float r100) {
        this.curMaxScale = Math.min(4.0f, Math.max(1.0f, r100));
    }

    public void setMinScale(float r100) {
        this.curMinScale = Math.max(0.2f, Math.min(1.0f, r100));
    }
}
