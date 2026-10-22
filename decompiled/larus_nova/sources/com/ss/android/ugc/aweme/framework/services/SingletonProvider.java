package com.ss.android.ugc.aweme.framework.services;

/* JADX INFO: loaded from: classes.dex */
public class SingletonProvider<T> implements ServiceProvider<T> {
    volatile T service;
    ServiceProvider<T> serviceProvider;

    @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
    public synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.service != null) goto L6;
        this.service = this.serviceProvider.get();     // Catch: Throwable -> L9
    L6:
        T r100 = this.service;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public SingletonProvider(ServiceProvider r100) {
        this.serviceProvider = r100;
    }
}
