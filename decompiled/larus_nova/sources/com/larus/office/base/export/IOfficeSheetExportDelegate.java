package com.larus.office.base.export;

import android.content.Context;
import com.larus.office.card.sheet.download.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2*\u0010\t\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00030\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/larus/office/base/export/IOfficeSheetExportDelegate;", "", "startSheetExport", "", "token", "", "fileName", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lkotlin/Function4;", "", "Landroid/net/Uri;", "", "cancelSheetExport", "resourceId", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSheetExportDelegate {
    void b(String r100, String r101, Context r102, e r103);

    void c(String r100);
}
