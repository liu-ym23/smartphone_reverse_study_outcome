package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class RustOnlineResponseObserver_Factory implements Factory<x> {
    private final Provider<l0c.c> userFlowMonitorProvider;

    @Override // javax.inject.Provider
    public x get() {
        return newInstance(this.userFlowMonitorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustOnlineResponseObserver_Factory(Provider<l0c.c> r100) {
        this.userFlowMonitorProvider = r100;
    }

    public static RustOnlineResponseObserver_Factory create(Provider<l0c.c> r100) {
        return new RustOnlineResponseObserver_Factory(r100);
    }

    public static x newInstance(l0c.c r100) {
        return new x(r100);
    }
}
