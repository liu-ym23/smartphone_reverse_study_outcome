package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts;
    public int size;

    public AJMediaCodecFrame() {
        this.pts = -269488145;
    }

    public AJMediaCodecFrame clone() {
        return (AJMediaCodecFrame) super.clone();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8709clone() throws CloneNotSupportedException {
        return clone();
    }
}
