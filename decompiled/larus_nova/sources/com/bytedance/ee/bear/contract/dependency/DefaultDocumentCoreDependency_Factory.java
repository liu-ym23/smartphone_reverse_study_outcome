package com.bytedance.ee.bear.contract.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class DefaultDocumentCoreDependency_Factory implements Factory<nw4.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultDocumentCoreDependency_Factory f216965a = null;

        static {
            f216965a = new DefaultDocumentCoreDependency_Factory();
        }
    }

    public DefaultDocumentCoreDependency_Factory() {
    }

    public static nw4.a newInstance() {
        return new nw4.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DefaultDocumentCoreDependency_Factory create() {
        return a.f216965a;
    }

    @Override // javax.inject.Provider
    public nw4.a get() {
        return newInstance();
    }
}
