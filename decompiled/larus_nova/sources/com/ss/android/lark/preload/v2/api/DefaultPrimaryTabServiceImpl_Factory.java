package com.ss.android.lark.preload.v2.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultPrimaryTabServiceImpl_Factory implements Factory<f1c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultPrimaryTabServiceImpl_Factory f438809a = null;

        static {
            f438809a = new DefaultPrimaryTabServiceImpl_Factory();
        }
    }

    public DefaultPrimaryTabServiceImpl_Factory() {
    }

    public static f1c.a newInstance() {
        return new f1c.a();
    }

    @Override // javax.inject.Provider
    public f1c.a get() {
        return newInstance();
    }

    public static DefaultPrimaryTabServiceImpl_Factory create() {
        return a.f438809a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
