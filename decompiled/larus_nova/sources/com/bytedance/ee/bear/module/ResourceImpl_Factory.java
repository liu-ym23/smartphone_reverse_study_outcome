package com.bytedance.ee.bear.module;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes18.dex */
public final class ResourceImpl_Factory implements Factory<com.bytedance.ee.bear.module.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ResourceImpl_Factory f234492a = null;

        static {
            f234492a = new ResourceImpl_Factory();
        }
    }

    public ResourceImpl_Factory() {
    }

    public static com.bytedance.ee.bear.module.a newInstance() {
        return new com.bytedance.ee.bear.module.a();
    }

    @Override // javax.inject.Provider
    public com.bytedance.ee.bear.module.a get() {
        return newInstance();
    }

    public static ResourceImpl_Factory create() {
        return a.f234492a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
