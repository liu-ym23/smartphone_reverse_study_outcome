package com.bytedance.ee.android.file.picker.lib.v2.icon;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import vm4.a;
import vm4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class FileIconLoaderManager_Factory implements Factory<b> {
    private final Provider<a> mDefaultLoaderProvider;
    private final Provider<Map<String, Provider<a>>> mLoadersProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.mDefaultLoaderProvider, this.mLoadersProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FileIconLoaderManager_Factory(Provider<a> r100, Provider<Map<String, Provider<a>>> r101) {
        this.mDefaultLoaderProvider = r100;
        this.mLoadersProvider = r101;
    }

    public static FileIconLoaderManager_Factory create(Provider<a> r100, Provider<Map<String, Provider<a>>> r101) {
        return new FileIconLoaderManager_Factory(r100, r101);
    }

    public static b newInstance(Provider<a> r100, Map<String, Provider<a>> r101) {
        return new b(r100, r101);
    }
}
