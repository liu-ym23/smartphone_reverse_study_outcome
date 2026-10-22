package com.ss.android.lark.integrator.im.card;

import dagger.internal.Factory;
import omb.g;

/* JADX INFO: loaded from: classes36.dex */
public final class UniversalCardJsServiceImpl_Factory implements Factory<g> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UniversalCardJsServiceImpl_Factory f427922a = null;

        static {
            f427922a = new UniversalCardJsServiceImpl_Factory();
        }
    }

    public UniversalCardJsServiceImpl_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static UniversalCardJsServiceImpl_Factory create() {
        return a.f427922a;
    }

    @Override // javax.inject.Provider
    public g get() {
        return newInstance();
    }
}
