package com.ss.android.lark.chat.core.dependency;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import w4b.a0;

/* JADX INFO: loaded from: classes35.dex */
public final class PassportDependencyV2_Factory implements Factory<a0> {
    private final Provider<m> userServiceProvider;

    @Override // javax.inject.Provider
    public a0 get() {
        return newInstance(this.userServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PassportDependencyV2_Factory(Provider<m> r100) {
        this.userServiceProvider = r100;
    }

    public static PassportDependencyV2_Factory create(Provider<m> r100) {
        return new PassportDependencyV2_Factory(r100);
    }

    public static a0 newInstance(m r100) {
        return new a0(r100);
    }
}
