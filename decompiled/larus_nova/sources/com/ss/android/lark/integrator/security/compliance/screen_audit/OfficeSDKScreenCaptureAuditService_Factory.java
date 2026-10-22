package com.ss.android.lark.integrator.security.compliance.screen_audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKScreenCaptureAuditService_Factory implements Factory<OfficeSDKScreenCaptureAuditService> {
    private final Provider<a> reporterProvider;

    @Override // javax.inject.Provider
    public OfficeSDKScreenCaptureAuditService get() {
        return newInstance(this.reporterProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKScreenCaptureAuditService_Factory(Provider<a> r100) {
        this.reporterProvider = r100;
    }

    public static OfficeSDKScreenCaptureAuditService_Factory create(Provider<a> r100) {
        return new OfficeSDKScreenCaptureAuditService_Factory(r100);
    }

    public static OfficeSDKScreenCaptureAuditService newInstance(a r100) {
        return new OfficeSDKScreenCaptureAuditService(r100);
    }
}
