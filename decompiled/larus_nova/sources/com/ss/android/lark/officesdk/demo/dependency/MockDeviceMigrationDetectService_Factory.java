package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class MockDeviceMigrationDetectService_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MockDeviceMigrationDetectService_Factory f433159a = null;

        static {
            f433159a = new MockDeviceMigrationDetectService_Factory();
        }
    }

    public MockDeviceMigrationDetectService_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static MockDeviceMigrationDetectService_Factory create() {
        return a.f433159a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
