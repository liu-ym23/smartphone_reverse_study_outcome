package com.suite.lark.platform.component.widget_biz_billingtips;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class BillingTipsDependencyDefaultImpl_Factory implements Factory<com.suite.lark.platform.component.widget_biz_billingtips.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BillingTipsDependencyDefaultImpl_Factory f460786a = null;

        static {
            f460786a = new BillingTipsDependencyDefaultImpl_Factory();
        }
    }

    public BillingTipsDependencyDefaultImpl_Factory() {
    }

    public static com.suite.lark.platform.component.widget_biz_billingtips.a newInstance() {
        return new com.suite.lark.platform.component.widget_biz_billingtips.a();
    }

    @Override // javax.inject.Provider
    public com.suite.lark.platform.component.widget_biz_billingtips.a get() {
        return newInstance();
    }

    public static BillingTipsDependencyDefaultImpl_Factory create() {
        return a.f460786a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
