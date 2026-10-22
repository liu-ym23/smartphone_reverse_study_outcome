package com.ss.android.lark.auditsdk.screen;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditSdkScreenAuditReporter_Factory implements Factory<com.ss.android.lark.auditsdk.screen.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AuditSdkScreenAuditReporter_Factory f409564a = null;

        static {
            f409564a = new AuditSdkScreenAuditReporter_Factory();
        }
    }

    public AuditSdkScreenAuditReporter_Factory() {
    }

    public static com.ss.android.lark.auditsdk.screen.a newInstance() {
        return new com.ss.android.lark.auditsdk.screen.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.auditsdk.screen.a get() {
        return newInstance();
    }

    public static AuditSdkScreenAuditReporter_Factory create() {
        return a.f409564a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
