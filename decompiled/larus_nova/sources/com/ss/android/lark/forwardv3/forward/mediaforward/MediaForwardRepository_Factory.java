package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class MediaForwardRepository_Factory implements Factory<h> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public h get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MediaForwardRepository_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static MediaForwardRepository_Factory create(Provider<l> r100) {
        return new MediaForwardRepository_Factory(r100);
    }

    public static h newInstance(l r100) {
        return new h(r100);
    }
}
