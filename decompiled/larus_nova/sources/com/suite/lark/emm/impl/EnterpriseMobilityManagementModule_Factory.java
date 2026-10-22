package com.suite.lark.emm.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes40.dex */
public final class EnterpriseMobilityManagementModule_Factory implements Factory<com.suite.lark.emm.impl.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnterpriseMobilityManagementModule_Factory f460434a = null;

        static {
            f460434a = new EnterpriseMobilityManagementModule_Factory();
        }
    }

    public EnterpriseMobilityManagementModule_Factory() {
    }

    public static com.suite.lark.emm.impl.a newInstance() {
        return new com.suite.lark.emm.impl.a();
    }

    @Override // javax.inject.Provider
    public com.suite.lark.emm.impl.a get() {
        return newInstance();
    }

    public static EnterpriseMobilityManagementModule_Factory create() {
        return a.f460434a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
