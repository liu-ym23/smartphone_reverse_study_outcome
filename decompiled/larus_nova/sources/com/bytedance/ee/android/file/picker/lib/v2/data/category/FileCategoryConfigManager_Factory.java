package com.bytedance.ee.android.file.picker.lib.v2.data.category;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import sm4.a;
import sm4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class FileCategoryConfigManager_Factory implements Factory<b> {
    private final Provider<a> mDefaultProvider;
    private final Provider<Map<String, Provider<a>>> mMapProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.mDefaultProvider, this.mMapProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FileCategoryConfigManager_Factory(Provider<a> r100, Provider<Map<String, Provider<a>>> r101) {
        this.mDefaultProvider = r100;
        this.mMapProvider = r101;
    }

    public static FileCategoryConfigManager_Factory create(Provider<a> r100, Provider<Map<String, Provider<a>>> r101) {
        return new FileCategoryConfigManager_Factory(r100, r101);
    }

    public static b newInstance(Provider<a> r100, Map<String, Provider<a>> r101) {
        return new b(r100, r101);
    }
}
