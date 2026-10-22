package com.ss.android.lark.integrator.im.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class OpenFeishuFileSecurityDelegateImpl_Factory implements Factory<i> {
    private final Provider<jza.c> internalFileSecurityServiceProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.internalFileSecurityServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OpenFeishuFileSecurityDelegateImpl_Factory(Provider<jza.c> r100) {
        this.internalFileSecurityServiceProvider = r100;
    }

    public static OpenFeishuFileSecurityDelegateImpl_Factory create(Provider<jza.c> r100) {
        return new OpenFeishuFileSecurityDelegateImpl_Factory(r100);
    }

    public static i newInstance(jza.c r100) {
        return new i(r100);
    }
}
