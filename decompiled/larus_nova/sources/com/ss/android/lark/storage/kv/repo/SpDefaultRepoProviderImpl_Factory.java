package com.ss.android.lark.storage.kv.repo;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class SpDefaultRepoProviderImpl_Factory implements Factory<SpDefaultRepoProviderImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SpDefaultRepoProviderImpl_Factory f441075a = null;

        static {
            f441075a = new SpDefaultRepoProviderImpl_Factory();
        }
    }

    public SpDefaultRepoProviderImpl_Factory() {
    }

    public static SpDefaultRepoProviderImpl newInstance() {
        return new SpDefaultRepoProviderImpl();
    }

    @Override // javax.inject.Provider
    public SpDefaultRepoProviderImpl get() {
        return newInstance();
    }

    public static SpDefaultRepoProviderImpl_Factory create() {
        return a.f441075a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
