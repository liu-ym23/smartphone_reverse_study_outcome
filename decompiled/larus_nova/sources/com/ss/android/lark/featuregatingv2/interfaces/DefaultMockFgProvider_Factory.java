package com.ss.android.lark.featuregatingv2.interfaces;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class DefaultMockFgProvider_Factory implements Factory<jdb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultMockFgProvider_Factory f420733a = null;

        static {
            f420733a = new DefaultMockFgProvider_Factory();
        }
    }

    public DefaultMockFgProvider_Factory() {
    }

    public static jdb.a newInstance() {
        return new jdb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DefaultMockFgProvider_Factory create() {
        return a.f420733a;
    }

    @Override // javax.inject.Provider
    public jdb.a get() {
        return newInstance();
    }
}
