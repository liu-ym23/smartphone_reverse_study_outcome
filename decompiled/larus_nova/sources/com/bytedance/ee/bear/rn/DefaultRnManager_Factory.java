package com.bytedance.ee.bear.rn;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes18.dex */
public final class DefaultRnManager_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultRnManager_Factory f236493a = null;

        static {
            f236493a = new DefaultRnManager_Factory();
        }
    }

    public DefaultRnManager_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static DefaultRnManager_Factory create() {
        return a.f236493a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
