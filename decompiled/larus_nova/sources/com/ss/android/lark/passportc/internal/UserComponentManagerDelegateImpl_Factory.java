package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserComponentManagerDelegateImpl_Factory implements Factory<a0> {
    private final Provider<y> userComponentManagerProvider;

    @Override // javax.inject.Provider
    public a0 get() {
        return newInstance(this.userComponentManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserComponentManagerDelegateImpl_Factory(Provider<y> r100) {
        this.userComponentManagerProvider = r100;
    }

    public static UserComponentManagerDelegateImpl_Factory create(Provider<y> r100) {
        return new UserComponentManagerDelegateImpl_Factory(r100);
    }

    public static a0 newInstance(y r100) {
        return new a0(r100);
    }
}
