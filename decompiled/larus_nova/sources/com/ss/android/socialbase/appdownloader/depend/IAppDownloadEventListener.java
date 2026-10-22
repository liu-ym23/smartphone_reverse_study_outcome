package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppDownloadEventListener {
    public static final int APP_EV_CLICK_CONTINUE = 6;
    public static final int APP_EV_CLICK_DELETE = 7;
    public static final int APP_EV_CLICK_INSTALL = 3;
    public static final int APP_EV_CLICK_OPEN = 2;
    public static final int APP_EV_CLICK_PAUSE = 5;
    public static final int APP_EV_DOWNLOAD_CANCELED = 10;
    public static final int APP_EV_DOWNLOAD_FINISH = 1;
    public static final int APP_EV_INSTALL_FINISH = 4;
    public static final int APP_EV_INSTALL_PACKAGE_NAME_ERROR = 8;
    public static final int APP_EV_INSTALL_SUCCESS = 9;

    String getNotifyProcessName();

    boolean installIntercept(boolean r100);

    void onAppDownloadCancel(DownloadInfo r100);

    void onAppDownloadEvent(int r100, String r101, int r102, long r103);

    void onAppInstallError(int r100, String r101, String r102, String r103);

    void onAppInstalled(Context r100, String r101);
}
