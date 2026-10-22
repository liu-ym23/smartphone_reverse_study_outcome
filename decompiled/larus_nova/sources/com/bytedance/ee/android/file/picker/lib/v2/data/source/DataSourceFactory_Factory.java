package com.bytedance.ee.android.file.picker.lib.v2.data.source;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import um4.a;
import um4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class DataSourceFactory_Factory implements Factory<b> {
    private final Provider<Map<String, Provider<a>>> mDataSourceProvidersProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.mDataSourceProvidersProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DataSourceFactory_Factory(Provider<Map<String, Provider<a>>> r100) {
        this.mDataSourceProvidersProvider = r100;
    }

    public static DataSourceFactory_Factory create(Provider<Map<String, Provider<a>>> r100) {
        return new DataSourceFactory_Factory(r100);
    }

    public static b newInstance(Map<String, Provider<a>> r100) {
        return new b(r100);
    }
}
