package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyUserComponentProviders_Factory implements Factory<l> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyUserComponentProviders_Factory f438312a = null;

        static {
            f438312a = new EmptyUserComponentProviders_Factory();
        }
    }

    public EmptyUserComponentProviders_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    @Override // javax.inject.Provider
    public l get() {
        return newInstance();
    }

    public static EmptyUserComponentProviders_Factory create() {
        return a.f438312a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
