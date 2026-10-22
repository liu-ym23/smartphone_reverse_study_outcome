package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class AJCodecBuffer implements Cloneable {
    public ByteBuffer data;
    public int index;
    public long pts;
    public int size;

    public AJCodecBuffer() {
    }

    public AJCodecBuffer clone() {
        AJCodecBuffer r100 = (AJCodecBuffer) super.clone();     // Catch: Throwable -> L4
    L6:
        r100.size = this.size;
        r100.pts = this.pts;
        r100.index = this.index;
        ByteBuffer r101 = ByteBuffer.allocateDirect(this.size);
        r101.put(this.data);
        r100.data = r101;
        return r100;
    L4:
        th = move-exception;
        th.printStackTrace();
        r100 = null;
        goto L6
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8708clone() throws CloneNotSupportedException {
        return clone();
    }
}
