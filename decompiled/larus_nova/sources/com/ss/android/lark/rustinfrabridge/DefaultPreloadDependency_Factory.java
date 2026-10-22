package com.ss.android.lark.rustinfrabridge;

import c3c.b;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class DefaultPreloadDependency_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultPreloadDependency_Factory f439678a = null;

        static {
            f439678a = new DefaultPreloadDependency_Factory();
        }
    }

    public DefaultPreloadDependency_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static DefaultPreloadDependency_Factory create() {
        return a.f439678a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
