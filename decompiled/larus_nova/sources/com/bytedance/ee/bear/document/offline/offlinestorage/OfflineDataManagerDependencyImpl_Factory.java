package com.bytedance.ee.bear.document.offline.offlinestorage;

import dagger.internal.Factory;
import k25.j0;

/* JADX INFO: loaded from: classes16.dex */
public final class OfflineDataManagerDependencyImpl_Factory implements Factory<j0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfflineDataManagerDependencyImpl_Factory f220492a = null;

        static {
            f220492a = new OfflineDataManagerDependencyImpl_Factory();
        }
    }

    public OfflineDataManagerDependencyImpl_Factory() {
    }

    public static j0 newInstance() {
        return new j0();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OfflineDataManagerDependencyImpl_Factory create() {
        return a.f220492a;
    }

    @Override // javax.inject.Provider
    public j0 get() {
        return newInstance();
    }
}
