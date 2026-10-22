package com.ss.android.lark.integrator.security.compliance.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class BehaviorAuditService_Factory implements Factory<com.ss.android.lark.integrator.security.compliance.export.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BehaviorAuditService_Factory f428066a = null;

        static {
            f428066a = new BehaviorAuditService_Factory();
        }
    }

    public BehaviorAuditService_Factory() {
    }

    public static com.ss.android.lark.integrator.security.compliance.export.a newInstance() {
        return new com.ss.android.lark.integrator.security.compliance.export.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.integrator.security.compliance.export.a get() {
        return newInstance();
    }

    public static BehaviorAuditService_Factory create() {
        return a.f428066a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
