package com.ss.android.lark.officesdk.applog.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class AppLogModule_ProvideOfficeSDKAppLogFactory implements Factory<gtb.a> {
    private final a module;

    @Override // javax.inject.Provider
    public gtb.a get() {
        return provideOfficeSDKAppLog(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppLogModule_ProvideOfficeSDKAppLogFactory(a r100) {
        this.module = r100;
    }

    public static AppLogModule_ProvideOfficeSDKAppLogFactory create(a r100) {
        return new AppLogModule_ProvideOfficeSDKAppLogFactory(r100);
    }

    public static gtb.a provideOfficeSDKAppLog(a r100) {
        r100.getClass();
        return (gtb.a) Preconditions.checkNotNullFromProvides(new b());
    }
}
