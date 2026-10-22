package com.bytedance.ee.bear.middleground.unbundle;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes18.dex */
public final class MockBenefitManagerAPI_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MockBenefitManagerAPI_Factory f234386a = null;

        static {
            f234386a = new MockBenefitManagerAPI_Factory();
        }
    }

    public MockBenefitManagerAPI_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static MockBenefitManagerAPI_Factory create() {
        return a.f234386a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
