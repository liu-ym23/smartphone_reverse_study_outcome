package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class MockGlobalDeviceServiceImpl_Factory implements Factory<e> {
    private final Provider<epb.a> mLarkDeviceIdApiProvider;

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        e r100 = newInstance();
        r100.f433165a = this.mLarkDeviceIdApiProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MockGlobalDeviceServiceImpl_Factory(Provider<epb.a> r100) {
        this.mLarkDeviceIdApiProvider = r100;
    }

    public static MockGlobalDeviceServiceImpl_Factory create(Provider<epb.a> r100) {
        return new MockGlobalDeviceServiceImpl_Factory(r100);
    }
}
