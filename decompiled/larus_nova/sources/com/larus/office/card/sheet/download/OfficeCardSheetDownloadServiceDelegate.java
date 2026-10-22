package com.larus.office.card.sheet.download;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/larus/office/card/sheet/download/OfficeCardSheetDownloadServiceDelegate;", "Lcom/larus/office/card/sheet/download/IOfficeCardSheetDownloadService;", "<init>", "()V", "showDownloadPanel", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "downloadParams", "Lcom/larus/office/card/sheet/OfficeCardSheetDownloadParams;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardSheetDownloadServiceDelegate implements IOfficeCardSheetDownloadService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfficeCardSheetDownloadServiceDelegate f361619b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOfficeCardSheetDownloadService f361620a;

    static {
        f361619b = new OfficeCardSheetDownloadServiceDelegate();
    }

    @Override // com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService
    public final void a(Fragment r100, com.larus.office.card.sheet.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "downloadParams");
        this.f361620a.a(r100, r101);
    }

    private OfficeCardSheetDownloadServiceDelegate() {
        IOfficeCardSheetDownloadService r100 = (IOfficeCardSheetDownloadService) ServiceManager.get().getService(IOfficeCardSheetDownloadService.class);
        if (r100 != null) goto L5;
        r100 = new OfficeCardSheetDownloadServiceNoop();
    L5:
        this.f361620a = r100;
    }
}
