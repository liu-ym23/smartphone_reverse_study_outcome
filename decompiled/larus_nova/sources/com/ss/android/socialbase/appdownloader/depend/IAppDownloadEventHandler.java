package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppDownloadEventHandler {
    public static final int EV_CLICK_CONTINUE = 6;
    public static final int EV_CLICK_DELETE = 7;
    public static final int EV_CLICK_INSTALL = 3;
    public static final int EV_CLICK_OPEN = 2;
    public static final int EV_CLICK_PAUSE = 5;
    public static final int EV_DOWNLOAD_CANCEL = 7;
    public static final int EV_DOWNLOAD_FINISH = 1;
    public static final int EV_INSTALL_FINISH = 4;
    public static final int EV_INSTALL_PACKAGE_NAME_ERROR = 8;

    void handleAppInstallError(int r100, int r101, String r102, String r103, String r104);

    void handleAppInstalled(Context r100, String r101);

    void handleDownloadCancel(DownloadInfo r100);

    void handleDownloadEvent(int r100, int r101, String r102, int r103, long r104);

    boolean installIntercept(int r100, boolean r101);

    boolean isForbidInvalidatePackageInstall();
}
