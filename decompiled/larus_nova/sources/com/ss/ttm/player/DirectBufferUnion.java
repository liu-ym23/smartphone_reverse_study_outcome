package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
class DirectBufferUnion {
    ByteBuffer buffer;
    long freeTimePoint;
    int size;

    public void resetFreeTimePoint() {
        this.freeTimePoint = System.currentTimeMillis();
    }

    public DirectBufferUnion(ByteBuffer r100, int r101) {
        this.buffer = r100;
        this.size = r101;
    }
}
