package com.ss.android.lark.widget.photo.preview.video.pip;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class PipUserContainerImpl_Factory implements Factory<PipUserContainerImpl> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public PipUserContainerImpl get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PipUserContainerImpl_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static PipUserContainerImpl_Factory create(Provider<m> r100) {
        return new PipUserContainerImpl_Factory(r100);
    }

    public static PipUserContainerImpl newInstance(m r100) {
        return new PipUserContainerImpl(r100);
    }
}
