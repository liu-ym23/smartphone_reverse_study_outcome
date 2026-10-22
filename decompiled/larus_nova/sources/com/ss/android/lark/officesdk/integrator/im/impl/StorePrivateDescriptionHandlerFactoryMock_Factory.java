package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class StorePrivateDescriptionHandlerFactoryMock_Factory implements Factory<q> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StorePrivateDescriptionHandlerFactoryMock_Factory f433292a = null;

        static {
            f433292a = new StorePrivateDescriptionHandlerFactoryMock_Factory();
        }
    }

    public StorePrivateDescriptionHandlerFactoryMock_Factory() {
    }

    public static q newInstance() {
        return new q();
    }

    @Override // javax.inject.Provider
    public q get() {
        return newInstance();
    }

    public static StorePrivateDescriptionHandlerFactoryMock_Factory create() {
        return a.f433292a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
