package com.bytedance.ee.bear.middleground.permission.apply;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficePermissionPageFactory_Factory implements Factory<OfficePermissionPageFactory> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficePermissionPageFactory_Factory f232955a = null;

        static {
            f232955a = new OfficePermissionPageFactory_Factory();
        }
    }

    public OfficePermissionPageFactory_Factory() {
    }

    public static OfficePermissionPageFactory newInstance() {
        return new OfficePermissionPageFactory();
    }

    @Override // javax.inject.Provider
    public OfficePermissionPageFactory get() {
        return newInstance();
    }

    public static OfficePermissionPageFactory_Factory create() {
        return a.f232955a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
