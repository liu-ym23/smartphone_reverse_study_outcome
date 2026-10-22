package com.bytedance.ee.bear.document.offline.offlinestorage;

import dagger.internal.Factory;
import k25.b;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeOfflineDataManagerDependencyImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeOfflineDataManagerDependencyImpl_Factory f220491a = null;

        static {
            f220491a = new OfficeOfflineDataManagerDependencyImpl_Factory();
        }
    }

    public OfficeOfflineDataManagerDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfficeOfflineDataManagerDependencyImpl_Factory create() {
        return a.f220491a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
