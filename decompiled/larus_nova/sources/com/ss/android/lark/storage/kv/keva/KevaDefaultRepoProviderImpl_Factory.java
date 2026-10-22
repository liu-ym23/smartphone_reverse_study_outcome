package com.ss.android.lark.storage.kv.keva;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class KevaDefaultRepoProviderImpl_Factory implements Factory<KevaDefaultRepoProviderImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final KevaDefaultRepoProviderImpl_Factory f441048a = null;

        static {
            f441048a = new KevaDefaultRepoProviderImpl_Factory();
        }
    }

    public KevaDefaultRepoProviderImpl_Factory() {
    }

    public static KevaDefaultRepoProviderImpl newInstance() {
        return new KevaDefaultRepoProviderImpl();
    }

    @Override // javax.inject.Provider
    public KevaDefaultRepoProviderImpl get() {
        return newInstance();
    }

    public static KevaDefaultRepoProviderImpl_Factory create() {
        return a.f441048a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
