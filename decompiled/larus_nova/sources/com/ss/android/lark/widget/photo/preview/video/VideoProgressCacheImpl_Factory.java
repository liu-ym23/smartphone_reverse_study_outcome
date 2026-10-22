package com.ss.android.lark.widget.photo.preview.video;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import ucc.c;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoProgressCacheImpl_Factory implements Factory<c> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VideoProgressCacheImpl_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static VideoProgressCacheImpl_Factory create(Provider<m> r100) {
        return new VideoProgressCacheImpl_Factory(r100);
    }

    public static c newInstance(m r100) {
        return new c(r100);
    }
}
