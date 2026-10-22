package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonServiceLazyLoader extends KryptonService {
    public abstract <T extends KryptonService> T createServiceInstance(Class<T> r100);

    public KryptonServiceLazyLoader() {
    }
}
