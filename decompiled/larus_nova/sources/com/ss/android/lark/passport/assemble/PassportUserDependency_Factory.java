package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportUserDependency_Factory implements Factory<j> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PassportUserDependency_Factory f437686a = null;

        static {
            f437686a = new PassportUserDependency_Factory();
        }
    }

    public PassportUserDependency_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    @Override // javax.inject.Provider
    public j get() {
        return newInstance();
    }

    public static PassportUserDependency_Factory create() {
        return a.f437686a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
