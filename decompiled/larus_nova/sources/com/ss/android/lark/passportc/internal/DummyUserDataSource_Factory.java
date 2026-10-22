package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DummyUserDataSource_Factory implements Factory<j> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DummyUserDataSource_Factory f438311a = null;

        static {
            f438311a = new DummyUserDataSource_Factory();
        }
    }

    public DummyUserDataSource_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    @Override // javax.inject.Provider
    public j get() {
        return newInstance();
    }

    public static DummyUserDataSource_Factory create() {
        return a.f438311a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
