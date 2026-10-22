package com.ss.android.lark.passportc.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DummyPassportLogger_Factory implements Factory<m0c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DummyPassportLogger_Factory f438531a = null;

        static {
            f438531a = new DummyPassportLogger_Factory();
        }
    }

    public DummyPassportLogger_Factory() {
    }

    public static m0c.a newInstance() {
        return new m0c.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DummyPassportLogger_Factory create() {
        return a.f438531a;
    }

    @Override // javax.inject.Provider
    public m0c.a get() {
        return newInstance();
    }
}
