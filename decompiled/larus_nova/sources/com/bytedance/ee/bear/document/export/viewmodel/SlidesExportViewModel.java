package com.bytedance.ee.bear.document.export.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/export/viewmodel/SlidesExportViewModel;", "Lcom/bytedance/ee/bear/document/export/viewmodel/BaseExportViewModel;", "Lcom/bytedance/ee/bear/document/export/viewmodel/SlidesExportViewModel$SlidesExportDelegate;", "<init>", "()V", "getToken", "", "SlidesExportDelegate", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesExportViewModel extends BaseExportViewModel<a> {

    public interface a extends BaseExportViewModel.a {
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel
    public String getToken() {
        a r100 = (a) this.delegate;
        if (r100 == null) goto L5;
        String r101 = r100.getToken();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public SlidesExportViewModel() {
    }
}
