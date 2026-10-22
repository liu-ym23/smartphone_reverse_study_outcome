package com.bytedance.ee.docsdk.impl.export;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J<\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/IFileExportService;", "", "cancelAllExports", "", "cancelExport", "", "token", "", "exportFile", "filePath", "type", "fileExtension", "eventSource", "", "callback", "Lcom/bytedance/ee/docsdk/impl/export/IDownloadResult;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IFileExportService {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void exportFile$default(IFileExportService r100, String r101, String r102, String r110, String r111, int r112, IDownloadResult r113, int r114, Object r115) {
            if (r115 != null) goto L9;
            if ((r114 & 32) == 0) goto L6;
            r113 = null;
        L6:
            r100.exportFile(r101, r102, r110, r111, r112, r113);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exportFile");
        }
    }

    void cancelAllExports();

    boolean cancelExport(String r100);

    void exportFile(String r100, String r101, String r102, String r103, int r104, IDownloadResult r105);
}
