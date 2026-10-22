package com.bytedance.ee.bear.middleground.permission.apply;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficePermissionPageFactory_Factory implements Factory<OfficePermissionPageFactory> {

    public static final class a {
        public static final OfficePermissionPageFactory_Factory a = null;

        static {
            a = new OfficePermissionPageFactory_Factory();
        }
    }

    public OfficePermissionPageFactory_Factory() {
    }

    public static OfficePermissionPageFactory newInstance() {
        return new OfficePermissionPageFactory();
    }

    public OfficePermissionPageFactory get() {
        return newInstance();
    }

    public static OfficePermissionPageFactory_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m275get() {
        return get();
    }
}
