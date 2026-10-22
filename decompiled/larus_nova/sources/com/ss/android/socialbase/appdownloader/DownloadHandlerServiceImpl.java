package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.appdownloader.view.MultiProcessDownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadHandlerServiceImpl {
    public DownloadHandlerServiceImpl() {
    }

    private static void cancelReserveWifi(Context r100, DownloadInfo r101) {
        if (DownloadUtils.isWifi(r100.getApplicationContext()) == true) goto L5;
        return;
    L5:
        if (r101.isPauseReserveOnWifi() == false) goto L9;
        r101.stopPauseReserveOnWifi();
        return;
    }

    private static boolean handleIntent(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        String r102 = r101.getAction();
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        int r103 = r101.getIntExtra(Constants.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, 0);
        IAppDownloadEventHandler r104 = AppDownloader.getInstance().getAppDownloadEventHandler();
        IDownloadNotificationEventListener r105 = Downloader.getInstance(r100).getDownloadNotificationEventListener(r103);
        boolean r106 = true;
        if (r101.getBooleanExtra(Constants.EXTRA_FROM_NOTIFICATION, false) == true) goto L11;
    L13:
        DownloadInfo r107 = Downloader.getInstance(r100).getDownloadInfo(r103);
        if (r107 != null) goto L17;
        return false;
    L17:
        if (r102.equals(Constants.ACTION_CLICK_CONTENT) == false) goto L20;
        handleClickNonBtnAreaWhenUnSuccess(r100, r107, r104, r105);
    L49:
        return false;
    L20:
        if (r102.equals(Constants.ACTION_OPEN) == false) goto L23;
        handleActionClickWithoutType(r100, r107, r104, r105);
        goto L49
    L23:
        if (r102.equals(Constants.ACTION_CLICK_BTN) == false) goto L40;
        if (r107.getStatus() != 0) goto L27;
        return false;
    L27:
        handleActionClickWithoutType(r100, r107, r104, r105);
        if (r107.isDownloadOverStatus() == false) goto L49;
        if (DownloadSetting.obtain(r103).optInt("no_hide_notification", 0) != 0) goto L49;
        if (DownloadSetting.obtain(r103).optInt("enable_notification_ui") >= 2) goto L34;
    L36:
        r106 = false;
    L37:
        if (r106 == true) goto L49;
        DownloadNotificationManager.getInstance().hideNotification(r103);
        DownloadNotificationManager.getInstance().cancelNotification(r103);
        goto L49
    L34:
        if (r107.getStatus() != (-1)) goto L36;
    L40:
        if (r102.equals(Constants.ACTION_DELETE) == false) goto L43;
        handleDelete(r100, r107, r104, r105);
        goto L49
    L43:
        if (r102.equals(Constants.ACTION_HIDE) == false) goto L46;
        DownloadNotificationManager.getInstance().hideNotification(r103);
        goto L49
    L46:
        if (r102.equals("android.intent.action.MEDIA_MOUNTED") == false) goto L49;
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass1());
        return true;
    L11:
        if (DownloadSetting.obtain(r103).optInt(DownloadSettingKeys.NOTIFICATION_OPT_2) != 1) goto L13;
        DownloadNotificationManager.getInstance().cancelNotification(r103);
        goto L13
    }

    public static void onStartCommand(Context r100, Intent r101) {
        handleIntent(r100, r101);
    }

    private static void handleClickNotificationInstall(Context r100, final IAppDownloadEventHandler r101, final DownloadInfo r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        final IDownloadNotificationEventListener r103 = Downloader.getInstance(r100).getDownloadNotificationEventListener(r102.getId());
        if (r101 != null) goto L8;
        if (r103 != null) goto L8;
        return;
    L8:
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass2(r102, r101, r103));
    }

    public static void handleActionClickWithoutType(Context r100, DownloadInfo r101, IAppDownloadEventHandler r110, IDownloadNotificationEventListener r111) {
        int r102 = r101.getId();
        INotificationClickCallback r103 = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(r102);
        boolean r104 = false;
        if ("application/vnd.android.package-archive".equals(r101.getMimeType()) == false) goto L14;
        if (r103 == null) goto L14;
        if (AppDownloadUtils.isApkInstalled(r100, r101, false) == false) goto L14;
        if (r103.onClickWhenInstalled(r101) == false) goto L14;
        if (AppInstallStatsReporter.isEnabled(r101.getMonitorScene()) == false) goto L44;
        AppInstallStatsReporter.addStats(r102, "DownloadHandlerServiceImpl_handleActionClickWithoutType", "Run");
        return;
    L44:
        return;
    L14:
        switch(r101.getStatus()) {
            case -4: goto L38;
            case -3: goto L29;
            case -2: goto L22;
            case -1: goto L38;
            case 0: goto L51;
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            default: goto L51;
        };
    L16:
        r101.setPauseByNotification(true);
        Downloader.getInstance(r100).pause(r102);
        cancelReserveWifi(r100, r101);
        if (r110 == null) goto L19;
        r110.handleDownloadEvent(r102, 5, "", r101.getStatus(), r101.getDownloadTime());
    L19:
        if (r111 == null) goto L45;
        r111.onNotificationEvent(5, r101, "", "");
        return;
    L45:
        return;
    L29:
        openDownload(DownloadComponentManager.getAppContext(), r102, true, r101.getMonitorScene());
        handleClickNotificationInstall(r100, r110, r101);
        if (DownloadSetting.obtain(r102).optInt(DownloadSettingKeys.NOTIFICATION_CLICK_INSTALL_AUTO_CANCEL, 1) != 0) goto L34;
        AbsNotificationItem r105 = DownloadNotificationManager.getInstance().getNotificationItem(r102);
        if (r105 == null) goto L34;
        r105.recordClickInstall();
        r105.refreshStatus(-3, null, false, true);
    L35:
        if (r104 == false) goto L49;
        DownloadNotificationManager.getInstance().hideNotification(r102);
        return;
    L49:
        return;
    L34:
        r104 = true;
        goto L35
    L51:
        return;
    L22:
        if (((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).canResume(r102) == false) goto L24;
        Downloader.getInstance(r100).resume(r102);
    L25:
        if (r110 == null) goto L27;
        r110.handleDownloadEvent(r102, 6, "", r101.getStatus(), r101.getDownloadTime());
    L27:
        if (r111 == null) goto L47;
        r111.onNotificationEvent(6, r101, "", "");
        return;
    L47:
        return;
    L24:
        AppDownloadUtils.createDownloadTask(r101, true, false);
        goto L25
    L38:
        if (DownloadSetting.obtain(r102).optInt("enable_notification_ui") >= 2) goto L40;
    L42:
        Downloader.getInstance(r100).restart(r102);
        return;
    L40:
        if (r101.isOnlyWifi() == false) goto L42;
        r101.setOnlyWifi(false);
        goto L42
    }

    private static void handleClickNonBtnAreaWhenUnSuccess(Context r100, DownloadInfo r101, IAppDownloadEventHandler r102, IDownloadNotificationEventListener r110) {
        int r103 = r101.getId();
        INotificationClickCallback r104 = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(r103);
        if (r104 != null) goto L20;
    L8:
        boolean r105 = false;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L13;
        Intent r106 = new Intent(r100, MultiProcessDownloadTaskDeleteActivity.class);
    L14:
        r106.putExtra(Constants.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, r103);
        r106.addFlags(268435456);
        r100.startActivity(r106);
        DownloadNotificationManager.getInstance().hideNotification(r103);
        r101.updateDownloadTime();
        if (r102 == null) goto L17;
        r102.handleDownloadEvent(r103, 7, "", r101.getStatus(), r101.getDownloadTime());
    L17:
        if (r110 == null) goto L23;
        r110.onNotificationEvent(7, r101, "", "");
        return;
    L23:
        return;
    L13:
        r106 = new Intent(r100, DownloadTaskDeleteActivity.class);
        goto L14
    L20:
        r105 = r104.onClickWhenUnSuccess(r101);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    private static void handleDelete(Context r100, DownloadInfo r101, IAppDownloadEventHandler r102, IDownloadNotificationEventListener r110) {
        int r103 = r101.getId();
        if (DownloadUtils.optimizeMultiProcess() == false) goto L5;
        Intent r104 = new Intent(r100, MultiProcessDownloadTaskDeleteActivity.class);
    L6:
        r104.putExtra(Constants.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, r103);
        r104.addFlags(268435456);
        r100.startActivity(r104);
        DownloadNotificationManager.getInstance().hideNotification(r103);
        r101.updateDownloadTime();
        if (r102 == null) goto L9;
        r102.handleDownloadEvent(r103, 7, "", r101.getStatus(), r101.getDownloadTime());
    L9:
        if (r110 == null) goto L12;
        r110.onNotificationEvent(7, r101, "", "");
        return;
    L12:
        return;
    L5:
        r104 = new Intent(r100, DownloadTaskDeleteActivity.class);
        goto L6
    }

    private static void openDownload(Context r100, int r101, boolean r102, String r103) {
        if (r102 == false) goto L12;
        INotificationClickCallback r104 = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getNotificationClickCallback(r101);
        if (r104 == null) goto L12;
        DownloadInfo r105 = Downloader.getInstance(r100).getDownloadInfo(r101);     // Catch: Throwable -> L10
        if (r105 == null) goto L12;
        boolean r106 = r104.onClickWhenSuccess(r105);     // Catch: Throwable -> L10
    L14:
        if (r106 == false) goto L20;
        if (AppInstallStatsReporter.isEnabled(r103) == false) goto L28;
        AppInstallStatsReporter.addStats(r101, "DownloadHandlerServiceImpl_openDownload1", "Run");
        return;
    L28:
        return;
    L20:
        if (AppInstallStatsReporter.isEnabled(r103) == false) goto L23;
        AppInstallStatsReporter.addStats(r101, "DownloadHandlerServiceImpl_openDownload2", "Run");
    L23:
        if (AppDownloadUtils.startViewIntent(r100, r101, true) != 0) goto L29;
        Toast.makeText(r100, "Open Fail!", 0).show();
        return;
    L29:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        r106 = false;
        goto L14
    }
}
