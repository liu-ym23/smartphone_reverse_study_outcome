package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ResendMessagePipelinesV2_Factory implements Factory<b> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ResendMessagePipelinesV2_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static ResendMessagePipelinesV2_Factory create(Provider<l> r100) {
        return new ResendMessagePipelinesV2_Factory(r100);
    }

    public static b newInstance(l r100) {
        return new b(r100);
    }
}
