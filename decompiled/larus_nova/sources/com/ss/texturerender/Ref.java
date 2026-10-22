package com.ss.texturerender;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public class Ref implements IRef {
    private AtomicInteger mCount;

    public Ref() {
        this(0);
    }

    @Override // com.ss.texturerender.IRef
    public int addRef() {
        return this.mCount.getAndIncrement();
    }

    @Override // com.ss.texturerender.IRef
    public int decRef() {
        return this.mCount.getAndDecrement();
    }

    @Override // com.ss.texturerender.IRef
    public int refCnt() {
        return this.mCount.intValue();
    }

    public Ref(int r100) {
        this.mCount = new AtomicInteger(r100);
    }
}
