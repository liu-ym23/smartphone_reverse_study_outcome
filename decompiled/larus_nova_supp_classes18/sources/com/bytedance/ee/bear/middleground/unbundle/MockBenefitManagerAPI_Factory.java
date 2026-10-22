package com.bytedance.ee.bear.middleground.unbundle;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MockBenefitManagerAPI_Factory implements Factory<d> {

    public static final class a {
        public static final MockBenefitManagerAPI_Factory a = null;

        static {
            a = new MockBenefitManagerAPI_Factory();
        }
    }

    public MockBenefitManagerAPI_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static MockBenefitManagerAPI_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m301get() {
        return get();
    }
}
