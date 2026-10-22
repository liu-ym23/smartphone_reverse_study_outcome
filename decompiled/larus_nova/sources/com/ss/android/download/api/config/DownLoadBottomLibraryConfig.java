package com.ss.android.download.api.config;

import com.ss.android.socialbase.appdownloader.depend.IAppDownloadFileUriProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;", "", "authority", "", "getAuthority", "()Ljava/lang/String;", "downBuilder", "Lcom/ss/android/socialbase/downloader/downloader/DownloaderBuilder;", "getDownBuilder", "()Lcom/ss/android/socialbase/downloader/downloader/DownloaderBuilder;", "downloadCertManager", "Lcom/ss/android/download/api/config/IDownloadCertManager;", "getDownloadCertManager", "()Lcom/ss/android/download/api/config/IDownloadCertManager;", "fileUriProvider", "Lcom/ss/android/socialbase/appdownloader/depend/IAppDownloadFileUriProvider;", "getFileUriProvider", "()Lcom/ss/android/socialbase/appdownloader/depend/IAppDownloadFileUriProvider;", "level", "", "getLevel", "()Ljava/lang/Integer;", "monitorListener", "Lcom/ss/android/socialbase/appdownloader/depend/IAppDownloadMonitorListener;", "getMonitorListener", "()Lcom/ss/android/socialbase/appdownloader/depend/IAppDownloadMonitorListener;", "useReflectParseRes", "", "getUseReflectParseRes", "()Ljava/lang/Boolean;", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface DownLoadBottomLibraryConfig {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static DownloaderBuilder getDownBuilder(DownLoadBottomLibraryConfig r100) {
            return null;
        }

        public static IDownloadCertManager getDownloadCertManager(DownLoadBottomLibraryConfig r100) {
            return null;
        }

        public static IAppDownloadFileUriProvider getFileUriProvider(DownLoadBottomLibraryConfig r100) {
            return null;
        }

        public static IAppDownloadMonitorListener getMonitorListener(DownLoadBottomLibraryConfig r100) {
            return null;
        }

        public static Boolean getUseReflectParseRes(DownLoadBottomLibraryConfig r100) {
            return null;
        }

        public static Integer getLevel(DownLoadBottomLibraryConfig r100) {
            return 4;
        }
    }

    String getAuthority();

    DownloaderBuilder getDownBuilder();

    IDownloadCertManager getDownloadCertManager();

    IAppDownloadFileUriProvider getFileUriProvider();

    Integer getLevel();

    IAppDownloadMonitorListener getMonitorListener();

    Boolean getUseReflectParseRes();
}
