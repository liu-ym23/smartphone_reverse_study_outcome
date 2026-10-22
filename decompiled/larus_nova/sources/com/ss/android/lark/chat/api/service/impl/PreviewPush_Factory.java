package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewPush_Factory implements Factory<PreviewPush> {
    private final Provider<a2b.f> previewServiceProvider;
    private final Provider<a2b.d> pushRepoProvider;

    @Override // javax.inject.Provider
    public PreviewPush get() {
        return newInstance(this.pushRepoProvider.get(), this.previewServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PreviewPush_Factory(Provider<a2b.d> r100, Provider<a2b.f> r101) {
        this.pushRepoProvider = r100;
        this.previewServiceProvider = r101;
    }

    public static PreviewPush_Factory create(Provider<a2b.d> r100, Provider<a2b.f> r101) {
        return new PreviewPush_Factory(r100, r101);
    }

    public static PreviewPush newInstance(a2b.d r100, a2b.f r101) {
        return new PreviewPush(r100, r101);
    }
}
