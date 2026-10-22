package com.suite.lark.platform.component.storage.di;

import android.app.Application;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class GlobalStorageModule_ProvideGlobalKVStorageFactory implements Factory<a> {
    private final Provider<Application> appProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideGlobalKVStorage(this.appProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalStorageModule_ProvideGlobalKVStorageFactory(Provider<Application> r100) {
        this.appProvider = r100;
    }

    public static GlobalStorageModule_ProvideGlobalKVStorageFactory create(Provider<Application> r100) {
        return new GlobalStorageModule_ProvideGlobalKVStorageFactory(r100);
    }

    public static a provideGlobalKVStorage(Application r100) {
        int r101 = woc.a.f560539a;
        Intrinsics.checkNotNullParameter(r100, "app");
        return (a) Preconditions.checkNotNullFromProvides(LarkKVStorage.e(r100, "lark"));
    }
}
