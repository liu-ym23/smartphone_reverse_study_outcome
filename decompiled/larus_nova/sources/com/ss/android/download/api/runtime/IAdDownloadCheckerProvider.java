package com.ss.android.download.api.runtime;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "", "checkBasicMode", "", "installInterceptChecker", "byUser", "isAppBackground", "isOpenUpgradeChecker", "packageChannelNeedHandleChecker", "downloadInfo", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdDownloadCheckerProvider {
    boolean checkBasicMode();

    boolean installInterceptChecker(boolean r100);

    boolean isAppBackground();

    boolean isOpenUpgradeChecker();

    boolean packageChannelNeedHandleChecker(DownloadInfo r100);
}
