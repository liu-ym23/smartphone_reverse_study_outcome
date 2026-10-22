package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes23.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float r100, Matrix r101, Matrix r102) {
        r101.getValues(this.tempStartValues);
        r102.getValues(this.tempEndValues);
        int r103 = 0;
    L4:
        if (r103 >= 9) goto L6;
        float[] r104 = this.tempEndValues;
        float r105 = r104[r103];
        float r106 = this.tempStartValues[r103];
        r104[r103] = r106 + ((r105 - r106) * r100);
        r103 = r103 + 1;
        goto L4
    L6:
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Matrix evaluate(float r100, Matrix r101, Matrix r102) {
        return evaluate2(r100, r101, r102);
    }
}
