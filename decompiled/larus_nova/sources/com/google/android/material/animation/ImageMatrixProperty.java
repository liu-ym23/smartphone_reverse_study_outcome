package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes23.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(ImageView r100) {
        this.matrix.set(r100.getImageMatrix());
        return this.matrix;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Matrix get(ImageView r100) {
        return get2(r100);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ImageView r100, Matrix r101) {
        set2(r100, r101);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ImageView r100, Matrix r101) {
        r100.setImageMatrix(r101);
    }
}
