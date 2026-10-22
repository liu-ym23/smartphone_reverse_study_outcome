package com.ss.android.lark.diskmanage.clean;

import dagger.internal.Factory;
import ebb.i;

/* JADX INFO: loaded from: classes35.dex */
public final class NoopCleanFileProvider_Factory implements Factory<i> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopCleanFileProvider_Factory f420452a = null;

        static {
            f420452a = new NoopCleanFileProvider_Factory();
        }
    }

    public NoopCleanFileProvider_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    @Override // javax.inject.Provider
    public i get() {
        return newInstance();
    }

    public static NoopCleanFileProvider_Factory create() {
        return a.f420452a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
