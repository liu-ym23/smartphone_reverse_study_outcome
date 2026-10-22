package com.ss.bytertc.engine.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class RTCI420Buffer {
    private ByteBuffer dataU;
    private ByteBuffer dataV;
    private ByteBuffer dataY;
    private int height;
    private int width;

    public RTCI420Buffer() {
        this.width = 0;
        this.height = 0;
        this.dataY = null;
        this.dataU = null;
        this.dataV = null;
    }

    public ByteBuffer getDataU() {
        return this.dataU;
    }

    public ByteBuffer getDataV() {
        return this.dataV;
    }

    public ByteBuffer getDataY() {
        return this.dataY;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDataU(ByteBuffer r100) {
        this.dataU = r100;
    }

    public void setDataV(ByteBuffer r100) {
        this.dataV = r100;
    }

    public void setDataY(ByteBuffer r100) {
        this.dataY = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
