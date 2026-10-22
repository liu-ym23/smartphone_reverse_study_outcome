package com.larus.office.card.urlpreview;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeHtmlFileDownloadServiceNoop;", "Lcom/larus/office/card/urlpreview/IOfficeHtmlFileDownloadService;", "<init>", "()V", "download", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "fileName", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeHtmlFileDownloadServiceNoop implements IOfficeHtmlFileDownloadService {
    public OfficeHtmlFileDownloadServiceNoop() {
    }

    @Override // com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService
    public final boolean a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        return false;
    }
}
