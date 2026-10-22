package com.suite.lark.platform.component.storage.file;

import dagger.internal.Factory;
import javax.inject.Provider;
import jkc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class UserScopeFileCipherAccessCompat_Factory implements Factory<b> {
    private final Provider<c> cipherManagerProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.cipherManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeFileCipherAccessCompat_Factory(Provider<c> r100) {
        this.cipherManagerProvider = r100;
    }

    public static UserScopeFileCipherAccessCompat_Factory create(Provider<c> r100) {
        return new UserScopeFileCipherAccessCompat_Factory(r100);
    }

    public static b newInstance(c r100) {
        return new b(r100);
    }
}
