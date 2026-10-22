package com.suite.lark.platform.component.storage.di;

import com.ss.android.lark.storage.file.FileStorage;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class GlobalStorageModule_ProvideGlobalFileStorageFactory implements Factory<FileStorage> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GlobalStorageModule_ProvideGlobalFileStorageFactory f460623a = null;

        static {
            f460623a = new GlobalStorageModule_ProvideGlobalFileStorageFactory();
        }
    }

    public GlobalStorageModule_ProvideGlobalFileStorageFactory() {
    }

    public static FileStorage provideGlobalFileStorage() {
        int r100 = woc.a.f560539a;
        return (FileStorage) Preconditions.checkNotNullFromProvides(LarkFileStorage.b());
    }

    @Override // javax.inject.Provider
    public FileStorage get() {
        return provideGlobalFileStorage();
    }

    public static GlobalStorageModule_ProvideGlobalFileStorageFactory create() {
        return a.f460623a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
