package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DocsTaskOrderInjector_Factory implements Factory<nwb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocsTaskOrderInjector_Factory f437145a = null;

        static {
            f437145a = new DocsTaskOrderInjector_Factory();
        }
    }

    public DocsTaskOrderInjector_Factory() {
    }

    public static nwb.a newInstance() {
        return new nwb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DocsTaskOrderInjector_Factory create() {
        return a.f437145a;
    }

    @Override // javax.inject.Provider
    public nwb.a get() {
        return newInstance();
    }
}
