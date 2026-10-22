package com.ss.android.medialib.camera;

import android.graphics.Bitmap;
import bfc.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class ImageFrame {
    public static final int BMP = 2;
    public static final int JPEG = 1;
    public static final int NV21 = -3;
    public static final int PNG = 0;
    public static final int UNKNOW = -1;
    public static final int YUV_888 = -2;
    public Bitmap bitmap;
    public ByteBuffer byteBuffer;
    public int format;
    public int height;
    public byte[] mBuf;
    public b mPlane;
    public int rotate;
    public int width;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public byte[] getBuf() {
        return this.mBuf;
    }

    public int getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    public b getPlane() {
        return this.mPlane;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBuf(byte[] r100) {
        this.mBuf = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public ImageFrame(Bitmap r100, int r101) {
        this.bitmap = r100;
        this.format = r101;
    }

    public ImageFrame(b r100, int r101, int r102, int r103) {
        this.mPlane = r100;
        this.format = r101;
        this.width = r102;
        this.height = r103;
    }

    public ImageFrame(byte[] r100, int r101, int r102, int r103) {
        this.mBuf = r100;
        this.format = r101;
        this.width = r102;
        this.height = r103;
    }

    public ImageFrame(ByteBuffer r100, int r101, int r102, int r103, int r104) {
        this.byteBuffer = r100;
        this.width = r101;
        this.height = r102;
        this.format = r103;
        this.rotate = r104;
    }

    public static ImageFrame create(ByteBuffer r100, int r101, int r102, int r110, int r111) {
        return new ImageFrame(r100, r101, r102, r110, r111);
    }
}
