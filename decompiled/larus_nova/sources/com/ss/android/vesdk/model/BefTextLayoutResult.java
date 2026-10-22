package com.ss.android.vesdk.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ss.android.ttve.nativePort.e;

/* JADX INFO: loaded from: classes40.dex */
public class BefTextLayoutResult {
    Bitmap bitmap;
    int height;
    int lineCount;
    int width;

    public BefTextLayoutResult() {
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public int getWidth() {
        return this.width;
    }

    public static BefTextLayoutResult readFromByteArray(byte[][] r100) {
        byte[] r101 = r100[0];
        e r102 = new e(r101);
        BefTextLayoutResult r103 = new BefTextLayoutResult();
        if (r101.length == 0) goto L5;
        Bitmap r104 = BitmapFactory.decodeByteArray(r101, 0, r101.length);
    L6:
        r103.setBitmap(r104);
        r103.setWidth(r102.c());
        r103.setHeight(r102.c());
        r103.setLineCount(r102.c());
        return r103;
    L5:
        r104 = null;
        goto L6
    }

    public void setBitmap(Bitmap r100) {
        this.bitmap = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setLineCount(int r100) {
        this.lineCount = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
