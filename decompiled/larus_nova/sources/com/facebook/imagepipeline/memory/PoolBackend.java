package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes23.dex */
interface PoolBackend<T> {
    T get(int r100);

    int getSize(T r100);

    T pop();

    void put(T r100);
}
