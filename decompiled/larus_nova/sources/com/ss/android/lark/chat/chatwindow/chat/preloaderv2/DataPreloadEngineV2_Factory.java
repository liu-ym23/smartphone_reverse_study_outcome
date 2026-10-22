package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class DataPreloadEngineV2_Factory implements Factory<DataPreloadEngineV2> {
    private final Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> loadersProvider;
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public DataPreloadEngineV2 get() {
        return newInstance(this.passportProvider.get(), this.loadersProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DataPreloadEngineV2_Factory(Provider<m> r100, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r101) {
        this.passportProvider = r100;
        this.loadersProvider = r101;
    }

    public static DataPreloadEngineV2_Factory create(Provider<m> r100, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r101) {
        return new DataPreloadEngineV2_Factory(r100, r101);
    }

    public static DataPreloadEngineV2 newInstance(m r100, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r101) {
        return new DataPreloadEngineV2(r100, r101);
    }
}
