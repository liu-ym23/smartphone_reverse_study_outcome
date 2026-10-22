package com.larus.slides.sdk.impl.proxy;

import com.larus.office.base.service.ISdkLifecycleV2;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/slides/sdk/impl/proxy/SlidesLifecycleAdapter;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "<init>", "()V", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesLifecycleAdapter implements ISdkLifecycleV2 {
    public SlidesLifecycleAdapter() {
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final String lifecycleCategory() {
        return "slides";
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final int lifecycleOrder() {
        return 2;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void destroyDocSdk() {
        ISlidesSdkServiceV2 r100 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r100 == null) goto L6;
        r100.destroyDocSdk();
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void initDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        ISlidesSdkServiceV2 r101 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.initDocSdk(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void postInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        ISlidesSdkServiceV2 r101 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.postInitDocSdk(r100);
        return;
    }

    @Override // com.larus.office.base.service.ISdkLifecycleV2
    public final void preInitDocSdk(OfficeSDKUserApi r100) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
        ISlidesSdkServiceV2 r101 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.preInitDocSdk(r100);
        return;
    }
}
