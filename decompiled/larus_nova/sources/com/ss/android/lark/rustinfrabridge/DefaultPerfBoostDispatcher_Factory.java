package com.ss.android.lark.rustinfrabridge;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class DefaultPerfBoostDispatcher_Factory implements Factory<c3c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultPerfBoostDispatcher_Factory f439677a = null;

        static {
            f439677a = new DefaultPerfBoostDispatcher_Factory();
        }
    }

    public DefaultPerfBoostDispatcher_Factory() {
    }

    public static c3c.a newInstance() {
        return new c3c.a();
    }

    @Override // javax.inject.Provider
    public c3c.a get() {
        return newInstance();
    }

    public static DefaultPerfBoostDispatcher_Factory create() {
        return a.f439677a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
