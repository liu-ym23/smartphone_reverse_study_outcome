package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class MockLarkDeviceIdApiImpl_Factory implements Factory<MockLarkDeviceIdApiImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MockLarkDeviceIdApiImpl_Factory f433160a = null;

        static {
            f433160a = new MockLarkDeviceIdApiImpl_Factory();
        }
    }

    public MockLarkDeviceIdApiImpl_Factory() {
    }

    public static MockLarkDeviceIdApiImpl newInstance() {
        return new MockLarkDeviceIdApiImpl();
    }

    @Override // javax.inject.Provider
    public MockLarkDeviceIdApiImpl get() {
        return newInstance();
    }

    public static MockLarkDeviceIdApiImpl_Factory create() {
        return a.f433160a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
