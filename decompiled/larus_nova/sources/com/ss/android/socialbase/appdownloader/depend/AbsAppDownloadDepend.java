package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AbsAppDownloadDepend implements IAppDownloadDepend, IBizCallback {
    public AbsAppDownloadDepend() {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowBootReceiver() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowNetwork(Context r100) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context r100) {
        return null;
    }

    public boolean isForbiddenInstallForInvalidatePackageName() {
        return false;
    }

    public boolean needClearWhenTaskReset() {
        return true;
    }

    public boolean isForbiddenInstallForInvalidatePackageName(DownloadInfo r100) {
        return isForbiddenInstallForInvalidatePackageName();
    }

    public boolean getAllowNetwork(int r100, Context r101) {
        return getAllowNetwork(r101);
    }

    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(int r100, Context r101) {
        return getThemedAlertDlgBuilder(r101);
    }
}
