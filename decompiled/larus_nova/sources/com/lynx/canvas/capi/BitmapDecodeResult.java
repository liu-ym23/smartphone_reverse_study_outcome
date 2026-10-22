package com.lynx.canvas.capi;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public class BitmapDecodeResult {
    private final ByteBuffer mBuffer;
    private final int mHeight;
    private final int mWidth;

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public BitmapDecodeResult(ByteBuffer r100, int r101, int r102) {
        this.mBuffer = r100;
        this.mWidth = r101;
        this.mHeight = r102;
    }
}
