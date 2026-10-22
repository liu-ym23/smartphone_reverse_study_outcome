package com.ss.android.lark.lark_env;

import dagger.internal.Factory;
import fpb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class GlobalEnvironmentServiceImpl_Factory implements Factory<a> {
    private final Provider<izb.a> environmentDependencyProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.environmentDependencyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalEnvironmentServiceImpl_Factory(Provider<izb.a> r100) {
        this.environmentDependencyProvider = r100;
    }

    public static GlobalEnvironmentServiceImpl_Factory create(Provider<izb.a> r100) {
        return new GlobalEnvironmentServiceImpl_Factory(r100);
    }

    public static a newInstance(izb.a r100) {
        return new a(r100);
    }
}
