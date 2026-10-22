package com.bytedance.ee.bear.module;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ResourceImpl_Factory implements Factory<com.bytedance.ee.bear.module.a> {

    public static final class a {
        public static final ResourceImpl_Factory a = null;

        static {
            a = new ResourceImpl_Factory();
        }
    }

    public ResourceImpl_Factory() {
    }

    public static com.bytedance.ee.bear.module.a newInstance() {
        return new com.bytedance.ee.bear.module.a();
    }

    public com.bytedance.ee.bear.module.a get() {
        return newInstance();
    }

    public static ResourceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m305get() {
        return get();
    }
}
