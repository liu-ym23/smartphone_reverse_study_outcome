package com.ss.android.lark.integrator.security.compliance.screen_audit;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKScreenAuditReporter_Factory implements Factory<com.ss.android.lark.integrator.security.compliance.screen_audit.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKScreenAuditReporter_Factory f428099a = null;

        static {
            f428099a = new OfficeSDKScreenAuditReporter_Factory();
        }
    }

    public OfficeSDKScreenAuditReporter_Factory() {
    }

    public static com.ss.android.lark.integrator.security.compliance.screen_audit.a newInstance() {
        return new com.ss.android.lark.integrator.security.compliance.screen_audit.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.integrator.security.compliance.screen_audit.a get() {
        return newInstance();
    }

    public static OfficeSDKScreenAuditReporter_Factory create() {
        return a.f428099a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
