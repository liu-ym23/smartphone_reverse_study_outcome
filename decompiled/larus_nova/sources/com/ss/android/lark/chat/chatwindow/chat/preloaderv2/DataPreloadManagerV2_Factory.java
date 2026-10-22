package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class DataPreloadManagerV2_Factory implements Factory<DataPreloadManagerV2> {
    private final Provider<c> engineProvider;
    private final Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> keyProvidersProvider;
    private final Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> loadersProvider;
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public DataPreloadManagerV2 get() {
        return newInstance(this.engineProvider.get(), this.loadersProvider.get(), this.keyProvidersProvider.get(), this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DataPreloadManagerV2_Factory(Provider<c> r100, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r101, Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> r102, Provider<m> r103) {
        this.engineProvider = r100;
        this.loadersProvider = r101;
        this.keyProvidersProvider = r102;
        this.passportProvider = r103;
    }

    public static DataPreloadManagerV2_Factory create(Provider<c> r100, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r101, Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> r102, Provider<m> r103) {
        return new DataPreloadManagerV2_Factory(r100, r101, r102, r103);
    }

    public static DataPreloadManagerV2 newInstance(c r100, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r101, Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> r102, m r103) {
        return new DataPreloadManagerV2(r100, r101, r102, r103);
    }
}
