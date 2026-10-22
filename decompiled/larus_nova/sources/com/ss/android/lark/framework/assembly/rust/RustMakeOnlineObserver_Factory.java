package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class RustMakeOnlineObserver_Factory implements Factory<w> {
    private final Provider<c3c.d.b> perfBoostDispatcherProvider;

    @Override // javax.inject.Provider
    public w get() {
        return newInstance(this.perfBoostDispatcherProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustMakeOnlineObserver_Factory(Provider<c3c.d.b> r100) {
        this.perfBoostDispatcherProvider = r100;
    }

    public static RustMakeOnlineObserver_Factory create(Provider<c3c.d.b> r100) {
        return new RustMakeOnlineObserver_Factory(r100);
    }

    public static w newInstance(c3c.d.b r100) {
        return new w(r100);
    }
}
