package com.bytedance.ee.bear.document.offline.offlinestorage;

import dagger.internal.Factory;
import k25.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfflineDataManagerDependencyImpl_Factory implements Factory<j0> {

    public static final class a {
        public static final OfflineDataManagerDependencyImpl_Factory a = null;

        static {
            a = new OfflineDataManagerDependencyImpl_Factory();
        }
    }

    public OfflineDataManagerDependencyImpl_Factory() {
    }

    public static j0 newInstance() {
        return new j0();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m226get();
    }

    public static OfflineDataManagerDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j0 m226get() {
        return newInstance();
    }
}
