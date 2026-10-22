package com.ss.android.lark.integrator.im.impl.chat;

import com.ss.android.lark.biz.im.api.t;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import smb.a;
import smb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory implements Factory<t> {
    private final b module;

    @Override // javax.inject.Provider
    public t get() {
        return provideDoubaoMergeForwardService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory(b r100) {
        this.module = r100;
    }

    public static DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory create(b r100) {
        return new DoubaoMessagePayloadModule_ProvideDoubaoMergeForwardServiceFactory(r100);
    }

    public static t provideDoubaoMergeForwardService(b r100) {
        r100.getClass();
        return (t) Preconditions.checkNotNullFromProvides(new a());
    }
}
