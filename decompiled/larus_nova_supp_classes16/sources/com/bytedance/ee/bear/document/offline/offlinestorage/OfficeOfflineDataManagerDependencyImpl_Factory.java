package com.bytedance.ee.bear.document.offline.offlinestorage;

import dagger.internal.Factory;
import k25.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeOfflineDataManagerDependencyImpl_Factory implements Factory<b> {

    public static final class a {
        public static final OfficeOfflineDataManagerDependencyImpl_Factory a = null;

        static {
            a = new OfficeOfflineDataManagerDependencyImpl_Factory();
        }
    }

    public OfficeOfflineDataManagerDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m225get();
    }

    public static OfficeOfflineDataManagerDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m225get() {
        return newInstance();
    }
}
