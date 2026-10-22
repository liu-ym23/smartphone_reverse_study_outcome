package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ProcessSynchronizerV3_Factory implements Factory<ProcessSynchronizerV3> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKVProvider;

    @Override // javax.inject.Provider
    public ProcessSynchronizerV3 get() {
        return newInstance(this.userKVProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ProcessSynchronizerV3_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        this.userKVProvider = r100;
    }

    public static ProcessSynchronizerV3_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        return new ProcessSynchronizerV3_Factory(r100);
    }

    public static ProcessSynchronizerV3 newInstance(com.ss.android.lark.storage.kv.storage.a r100) {
        return new ProcessSynchronizerV3(r100);
    }
}
