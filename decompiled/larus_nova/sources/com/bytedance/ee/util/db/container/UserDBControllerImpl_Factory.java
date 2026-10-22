package com.bytedance.ee.util.db.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes19.dex */
public final class UserDBControllerImpl_Factory implements Factory<a> {
    private final Provider<m> passportUserServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportUserServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserDBControllerImpl_Factory(Provider<m> r100) {
        this.passportUserServiceProvider = r100;
    }

    public static UserDBControllerImpl_Factory create(Provider<m> r100) {
        return new UserDBControllerImpl_Factory(r100);
    }

    public static a newInstance(m r100) {
        return new a(r100);
    }
}
