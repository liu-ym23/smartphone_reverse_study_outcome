package com.dtf.toyger.base.algorithm;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public class TGFrame {
    public static final int MODE_BGR = 2;
    public static final int MODE_BGRA = 1;
    public static final int MODE_DEPTH = 7;
    public static final int MODE_GRAY_16 = 6;
    public static final int MODE_GRAY_8 = 5;
    public static final int MODE_IRIS = 6;
    public static final int MODE_NV21 = 0;
    public static final int MODE_RGB = 4;
    public static final int MODE_RGBA = 3;
    public static final int TYPE_DARK = 1;
    public static final int TYPE_DEPTH = 2;
    public static final int TYPE_GRAY_NANO = 5;
    public static final int TYPE_IR = 3;
    public static final int TYPE_LIGHT = 0;
    public static final int TYPE_NANO = 4;
    public ByteBuffer byteBuffer;
    public byte[] data;
    public int frameMode;
    public int frameType;
    public int height;
    public int index;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    public String f273696md5;
    public String meta;
    public int rotation;
    public int width;

    public void recycle() {
        this.data = null;
        this.byteBuffer = null;
    }

    public TGFrame deepCopy() {
        TGFrame r100 = new TGFrame(null, this.width, this.height, this.rotation, this.frameMode, this.frameType);
        r100.width = this.width;
        r100.height = this.height;
        r100.rotation = this.rotation;
        r100.frameMode = this.frameMode;
        r100.frameType = this.frameType;
        byte[] r101 = this.data;
        if (r101 != null) goto L5;
    L7:
        ByteBuffer r102 = this.byteBuffer;
        if (r102 == null) goto L10;
        ByteBuffer r103 = ByteBuffer.allocate(r102.capacity());
        this.byteBuffer.rewind();
        r103.put(this.byteBuffer);
        this.byteBuffer.rewind();
        r103.rewind();
        r100.data = r103.array();
    L10:
        return r100;
    L5:
        if (r101.length == 0) goto L7;
        r100.data = Arrays.copyOf(r101, r101.length);
        goto L10
    }

    public String toString() {
        return "TGFrame{data=***, width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + ", frameMode=" + this.frameMode + ", frameType=" + this.frameType + '}';
    }

    public TGFrame() {
    }

    public TGFrame(TGFrame r100) {
        if (r100 == null) goto L9;
        byte[] r101 = r100.data;
        if (r101 == null) goto L7;
        this.data = (byte[]) r101.clone();
    L7:
        this.width = r100.width;
        this.height = r100.height;
        this.rotation = r100.rotation;
        this.frameMode = r100.frameMode;
        this.frameType = r100.frameType;
        this.byteBuffer = r100.byteBuffer;
        return;
    }

    public TGFrame(ByteBuffer r100, int r101, int r102, int r103, int r104, int r105) {
        this.byteBuffer = r100;
        this.width = r101;
        this.height = r102;
        this.rotation = r103;
        this.frameMode = r104;
        this.frameType = r105;
    }

    public TGFrame(byte[] r100, int r101, int r102, int r103, int r104, int r105) {
        this.data = r100;
        this.width = r101;
        this.height = r102;
        this.rotation = r103;
        this.frameMode = r104;
        this.frameType = r105;
    }
}
