package com.suite.lark.platform.feature.forward.doubao.assembly;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardDoubaoApiImpl_Factory implements Factory<ForwardDoubaoApiImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ForwardDoubaoApiImpl_Factory f461285a = null;

        static {
            f461285a = new ForwardDoubaoApiImpl_Factory();
        }
    }

    public ForwardDoubaoApiImpl_Factory() {
    }

    public static ForwardDoubaoApiImpl newInstance() {
        return new ForwardDoubaoApiImpl();
    }

    @Override // javax.inject.Provider
    public ForwardDoubaoApiImpl get() {
        return newInstance();
    }

    public static ForwardDoubaoApiImpl_Factory create() {
        return a.f461285a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
