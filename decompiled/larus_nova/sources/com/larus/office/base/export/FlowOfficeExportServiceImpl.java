package com.larus.office.base.export;

import android.content.Context;
import com.larus.office.card.doc.download.g;
import com.larus.office.card.sheet.download.e;
import com.larus.platform.api.IFlowOfficeExportService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u008b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102*\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\u0013H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016JN\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2*\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/office/base/export/FlowOfficeExportServiceImpl;", "Lcom/larus/platform/api/IFlowOfficeExportService;", "<init>", "()V", "startDocExport", "", SubInfo.KEY_FORMAT, "", "type", "token", "eventSource", "passback", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "docTitle", "resourceType", "", "resourceVersion", "callback", "Lkotlin/Function4;", "", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function4;)V", "cancelDocExport", "resourceId", "startSheetExport", "fileName", "cancelSheetExport", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowOfficeExportServiceImpl implements IFlowOfficeExportService {
    public FlowOfficeExportServiceImpl() {
    }

    @Override // com.larus.platform.api.IFlowOfficeExportService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        IOfficeDocExportDelegate r101 = (IOfficeDocExportDelegate) ServiceManager.get().getService(IOfficeDocExportDelegate.class);
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowOfficeExportService
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        IOfficeSheetExportDelegate r101 = (IOfficeSheetExportDelegate) ServiceManager.get().getService(IOfficeSheetExportDelegate.class);
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.larus.platform.api.IFlowOfficeExportService
    public final void b(String r100, String r101, Context r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r103, "callback");
        IOfficeSheetExportDelegate r104 = (IOfficeSheetExportDelegate) ServiceManager.get().getService(IOfficeSheetExportDelegate.class);
        if (r104 != null) goto L6;
        r103.invoke(Boolean.FALSE, null, null, "Sheet export delegate is null");
        return;
    L6:
        r104.b(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.IFlowOfficeExportService
    public final void d(String r110, String r111, String r112, String r113, Context r114, String r115, Integer r116, Integer r117, g r118) {
        Intrinsics.checkNotNullParameter(r110, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "token");
        Intrinsics.checkNotNullParameter("41", "eventSource");
        Intrinsics.checkNotNullParameter(r118, "callback");
        IOfficeDocExportDelegate r100 = (IOfficeDocExportDelegate) ServiceManager.get().getService(IOfficeDocExportDelegate.class);
        if (r100 != null) goto L6;
        r118.invoke(Boolean.FALSE, null, null, "Doc export delegate is null");
        return;
    L6:
        r100.b(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
