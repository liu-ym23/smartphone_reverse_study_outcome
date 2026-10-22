package com.ss.lark.android.encryption.userscope;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes40.dex */
public final class StreamParamManagerUserScope_Factory implements Factory<StreamParamManagerUserScope> {
    private final Provider<l> userClientProvider;

    @Override // javax.inject.Provider
    public StreamParamManagerUserScope get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StreamParamManagerUserScope_Factory(Provider<l> r100) {
        this.userClientProvider = r100;
    }

    public static StreamParamManagerUserScope_Factory create(Provider<l> r100) {
        return new StreamParamManagerUserScope_Factory(r100);
    }

    public static StreamParamManagerUserScope newInstance(l r100) {
        return new StreamParamManagerUserScope(r100);
    }
}
