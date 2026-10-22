package com.dtf.toyger.base.algorithm;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public class TGDepthFrame {
    public ByteBuffer byteBuffer;
    public byte[] data;
    public int height;
    public int rotation;
    public int width;

    public void recycle() {
        this.data = null;
        this.byteBuffer = null;
    }

    public TGDepthFrame deepCopy() {
        TGDepthFrame r100 = new TGDepthFrame(null, this.width, this.height, this.rotation);
        r100.width = this.width;
        r100.height = this.height;
        r100.rotation = this.rotation;
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
        return "TGDepthFrame{data=***, width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + '}';
    }

    public TGDepthFrame() {
    }

    public TGDepthFrame(TGDepthFrame r100) {
        if (r100 == null) goto L9;
        byte[] r101 = r100.data;
        if (r101 == null) goto L7;
        this.data = (byte[]) r101.clone();
    L7:
        this.width = r100.width;
        this.height = r100.height;
        this.rotation = r100.rotation;
        this.byteBuffer = r100.byteBuffer;
        return;
    }

    public void assign(TGDepthFrame r100) {
        this.width = r100.width;
        this.height = r100.height;
        this.rotation = r100.rotation;
        byte[] r101 = r100.data;
        if (r101 == null) goto L6;
        this.data = Arrays.copyOf(r101, r101.length);
        return;
    }

    public TGDepthFrame(ByteBuffer r100, int r101, int r102, int r103) {
        this.byteBuffer = r100;
        this.width = r101;
        this.height = r102;
        this.rotation = r103;
    }

    public TGDepthFrame(byte[] r100, int r101, int r102, int r103) {
        this.data = r100;
        this.width = r101;
        this.height = r102;
        this.rotation = r103;
    }

    public TGDepthFrame(byte r100, int r101, int r102, int r103) {
    }
}
