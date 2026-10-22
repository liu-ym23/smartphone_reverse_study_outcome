package com.ss.texturerender;

/* JADX INFO: loaded from: classes40.dex */
public interface ITexture extends IRef {
    int getTexTarget();

    int lock();

    int tryLock(int r100);

    void unlock();
}
