package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class UserComponentRepositoryImpl_Factory implements Factory<c0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UserComponentRepositoryImpl_Factory f438406a = null;

        static {
            f438406a = new UserComponentRepositoryImpl_Factory();
        }
    }

    public UserComponentRepositoryImpl_Factory() {
    }

    public static c0 newInstance() {
        return new c0();
    }

    @Override // javax.inject.Provider
    public c0 get() {
        return newInstance();
    }

    public static UserComponentRepositoryImpl_Factory create() {
        return a.f438406a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
