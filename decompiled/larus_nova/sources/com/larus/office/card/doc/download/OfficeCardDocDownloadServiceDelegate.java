package com.larus.office.card.doc.download;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/larus/office/card/doc/download/OfficeCardDocDownloadServiceDelegate;", "Lcom/larus/office/card/doc/download/IOfficeCardDocDownloadService;", "<init>", "()V", "showDownloadPanel", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "resourceId", "", "resourceVersion", "", "showFrom", "currentPage", "artifactMetaId", "subType", "bizExtra", "", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardDocDownloadServiceDelegate implements IOfficeCardDocDownloadService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfficeCardDocDownloadServiceDelegate f361398b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOfficeCardDocDownloadService f361399a;

    static {
        f361398b = new OfficeCardDocDownloadServiceDelegate();
    }

    @Override // com.larus.office.card.doc.download.IOfficeCardDocDownloadService
    public final void a(Fragment r110, String r111, int r112, String r113, String r114, String r115, String r116, Map<String, ? extends Object> r117) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "resourceId");
        Intrinsics.checkNotNullParameter(r113, "showFrom");
        this.f361399a.a(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    private OfficeCardDocDownloadServiceDelegate() {
        IOfficeCardDocDownloadService r100 = (IOfficeCardDocDownloadService) ServiceManager.get().getService(IOfficeCardDocDownloadService.class);
        if (r100 != null) goto L5;
        r100 = new OfficeCardDocDownloadServiceNoop();
    L5:
        this.f361399a = r100;
    }
}
