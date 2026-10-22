package com.danikula.videocache;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyCacheException extends Exception {
    public ProxyCacheException(String r100) {
        super(r100 + ". Version: 1.2.0");
    }

    public ProxyCacheException(Throwable r100) {
        super("No explanation error. Version: 1.2.0", r100);
    }

    public ProxyCacheException(String r100, Throwable r101) {
        super(r100 + ". Version: 1.2.0", r101);
    }
}
