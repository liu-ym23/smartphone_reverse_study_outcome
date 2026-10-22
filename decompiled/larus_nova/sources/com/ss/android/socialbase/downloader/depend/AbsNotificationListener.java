package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsNotificationListener extends AbsDownloadListener implements IDownloadExtListener {
    public abstract AbsNotificationItem createNotificationItem();

    public AbsNotificationListener() {
    }

    private void addNotificationItem(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.canShowNotification() == false) goto L13;
        AbsNotificationItem r101 = DownloadNotificationManager.getInstance().getNotificationItem(r100.getId());
        if (r101 != null) goto L9;
        AbsNotificationItem r102 = createNotificationItem();
        DownloadNotificationManager.getInstance().addNotification(r102);
        return;
    L9:
        r101.updateNotificationItem(r100);
        return;
    }

    private void updateNotificationProgress(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.canShowNotification() == true) goto L6;
        return;
    L6:
        if (r100.getStatus() != 4) goto L15;
        AbsNotificationItem r101 = DownloadNotificationManager.getInstance().getNotificationItem(r100.getId());
        if (r101 != null) goto L11;
        r101 = createNotificationItem();
    L11:
        r101.refreshProgress(r100.getCurBytes(), r100.getTotalBytes());
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo r100) {
        super.onPause(r100);
        updateNotification(-2, r100, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo r100) {
        super.onPrepare(r100);
        addNotificationItem(r100);
        updateNotification(1, r100, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo r100) {
        super.onProgress(r100);
        updateNotificationProgress(r100);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo r100) {
        super.onStart(r100);
        updateNotification(2, r100, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        updateNotification(-3, r100, null, false);
    }

    public void onWaitingDownloadCompleteHandler(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isAutoInstallWithoutNotification() == true) goto L9;
        updateNotification(11, r100, null, true);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        updateNotification(-1, r100, r101, false);
    }

    private void updateNotification(int r100, DownloadInfo r101, BaseException r102, boolean r103) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.canShowNotification() == true) goto L7;
        return;
    L7:
        if (r100 == 4) goto L19;
        AbsNotificationItem r104 = DownloadNotificationManager.getInstance().getNotificationItem(r101.getId());
        if (r104 != null) goto L12;
        r104 = createNotificationItem();
    L12:
        r104.setTotalBytes(r101.getTotalBytes());
        if (r100 != (-3)) goto L15;
        r104.setCurBytes(r101.getTotalBytes());
    L16:
        r104.refreshStatus(r100, r102, r103);
        return;
    L15:
        r104.setCurBytes(r101.getCurBytes());
        goto L16
    }
}
