package com.facebook.keyframes;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: loaded from: classes23.dex */
public class KFPath {
    private final float[] mLastPoint;
    private final Path mPath;

    public KFPath() {
        this(new Path(), new float[]{0.0f, 0.0f});
    }

    public boolean isEmpty() {
        return this.mPath.isEmpty();
    }

    public void reset() {
        this.mPath.reset();
        adjustLastPoint(0.0f, 0.0f);
    }

    public float[] getLastPoint() {
        return this.mLastPoint;
    }

    public Path getPath() {
        return this.mPath;
    }

    public void transform(Matrix r100) {
        this.mPath.transform(r100);
        r100.mapPoints(this.mLastPoint);
    }

    public KFPath(Path r100, float[] r101) {
        this.mPath = r100;
        this.mLastPoint = r101;
    }

    private void adjustLastPoint(float r100, float r101) {
        float[] r102 = this.mLastPoint;
        r102[0] = r100;
        r102[1] = r101;
    }

    private void rAdjustLastPoint(float r100, float r101) {
        float[] r102 = this.mLastPoint;
        r102[0] = r102[0] + r100;
        r102[1] = r102[1] + r101;
    }

    public void lineTo(float r100, float r101) {
        this.mPath.lineTo(r100, r101);
        adjustLastPoint(r100, r101);
    }

    public void moveTo(float r100, float r101) {
        this.mPath.moveTo(r100, r101);
        adjustLastPoint(r100, r101);
    }

    public void rLineTo(float r100, float r101) {
        this.mPath.rLineTo(r100, r101);
        rAdjustLastPoint(r100, r101);
    }

    public void rMoveTo(float r100, float r101) {
        this.mPath.rMoveTo(r100, r101);
        rAdjustLastPoint(r100, r101);
    }

    public void quadTo(float r100, float r101, float r102, float r103) {
        this.mPath.quadTo(r100, r101, r102, r103);
        adjustLastPoint(r102, r103);
    }

    public void rQuadTo(float r100, float r101, float r102, float r103) {
        this.mPath.rQuadTo(r100, r101, r102, r103);
        rAdjustLastPoint(r102, r103);
    }

    public void cubicTo(float r100, float r101, float r110, float r111, float r112, float r113) {
        this.mPath.cubicTo(r100, r101, r110, r111, r112, r113);
        adjustLastPoint(r112, r113);
    }

    public void rCubicTo(float r100, float r101, float r110, float r111, float r112, float r113) {
        this.mPath.rCubicTo(r100, r101, r110, r111, r112, r113);
        rAdjustLastPoint(r112, r113);
    }
}
