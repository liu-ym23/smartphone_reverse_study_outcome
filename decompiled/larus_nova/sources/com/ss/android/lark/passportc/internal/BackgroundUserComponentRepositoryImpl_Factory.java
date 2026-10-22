package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class BackgroundUserComponentRepositoryImpl_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BackgroundUserComponentRepositoryImpl_Factory f438304a = null;

        static {
            f438304a = new BackgroundUserComponentRepositoryImpl_Factory();
        }
    }

    public BackgroundUserComponentRepositoryImpl_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }

    public static BackgroundUserComponentRepositoryImpl_Factory create() {
        return a.f438304a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
