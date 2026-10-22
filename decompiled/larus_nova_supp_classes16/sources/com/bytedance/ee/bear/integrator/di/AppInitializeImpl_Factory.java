package com.bytedance.ee.bear.integrator.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AppInitializeImpl_Factory implements Factory<c> {

    public static final class a {
        public static final AppInitializeImpl_Factory a = null;

        static {
            a = new AppInitializeImpl_Factory();
        }
    }

    public AppInitializeImpl_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static AppInitializeImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m407get() {
        return get();
    }
}
