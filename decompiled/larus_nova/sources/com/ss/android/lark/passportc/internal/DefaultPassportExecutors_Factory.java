package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultPassportExecutors_Factory implements Factory<i> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultPassportExecutors_Factory f438310a = null;

        static {
            f438310a = new DefaultPassportExecutors_Factory();
        }
    }

    public DefaultPassportExecutors_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    @Override // javax.inject.Provider
    public i get() {
        return newInstance();
    }

    public static DefaultPassportExecutors_Factory create() {
        return a.f438310a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
