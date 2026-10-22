package com.larus.office.card.urlpreview;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewActionInterceptorProviderImpl;", "Lcom/larus/office/card/urlpreview/IOfficeUrlPreviewActionInterceptorProvider;", "<init>", "()V", "createInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUrlPreviewActionInterceptorProviderImpl implements IOfficeUrlPreviewActionInterceptorProvider {
    public OfficeUrlPreviewActionInterceptorProviderImpl() {
    }

    @Override // com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider
    public final q97.a a() {
        return new OfficeUrlPreviewActionInterceptor();
    }
}
