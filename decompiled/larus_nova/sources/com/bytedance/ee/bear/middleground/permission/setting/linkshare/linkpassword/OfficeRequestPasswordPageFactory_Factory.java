package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeRequestPasswordPageFactory_Factory implements Factory<ii5.d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeRequestPasswordPageFactory_Factory f234150a = null;

        static {
            f234150a = new OfficeRequestPasswordPageFactory_Factory();
        }
    }

    public OfficeRequestPasswordPageFactory_Factory() {
    }

    public static ii5.d newInstance() {
        return new ii5.d();
    }

    @Override // javax.inject.Provider
    public ii5.d get() {
        return newInstance();
    }

    public static OfficeRequestPasswordPageFactory_Factory create() {
        return a.f234150a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
