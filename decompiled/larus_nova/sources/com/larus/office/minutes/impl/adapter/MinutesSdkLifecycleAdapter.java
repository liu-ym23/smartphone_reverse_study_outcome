package com.larus.office.minutes.impl.adapter;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.minutes.api.IMinutesService;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/office/minutes/impl/adapter/MinutesSdkLifecycleAdapter;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "<init>", "()V", "initDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinutesSdkLifecycleAdapter implements ISdkLifecycleV2 {

    public static final class a {
    }

    static {
    }

    public MinutesSdkLifecycleAdapter() {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return DocumentType.MINUTES_NAME;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        return 1;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        FLogger.f375446a.i("MinutesSdkLifecycleAdapter", "Destroy minutes sdk");
        IMinutesService r100 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r100 == null) goto L6;
        r100.P0();
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        FLogger.f375446a.i("MinutesSdkLifecycleAdapter", "Init minutes sdk");
        IMinutesService r101 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r101 == null) goto L6;
        r101.V0(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
    }
}
