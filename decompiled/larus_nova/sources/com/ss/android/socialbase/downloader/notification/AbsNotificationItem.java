package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsNotificationItem {
    private AtomicInteger clickInstallTimes;
    private long curBytes;
    private String description;
    private long firstShowTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f449587id;
    protected Notification notification;
    private boolean ongoing;
    private int status;
    private String title;
    private long totalBytes;

    public abstract void updateNotification(BaseException r100, boolean r101);

    public void cancel() {
        if (this.f449587id != 0) goto L5;
        return;
    L5:
        DownloadNotificationManager.getInstance().cancel(this.f449587id);
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes.get();
    }

    public long getFirstShowTime() {
        if (this.firstShowTime != 0) goto L6;
        this.firstShowTime = System.currentTimeMillis();
    L6:
        return this.firstShowTime;
    }

    public void recordClickInstall() {
        this.clickInstallTimes.incrementAndGet();
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.f449587id;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void notify(Notification r100) {
        if (this.f449587id == 0) goto L8;
        if (r100 == null) goto L9;
        DownloadNotificationManager.getInstance().notifyByService(this.f449587id, this.status, r100);
        return;
    L9:
        return;
    }

    public void setCurBytes(long r100) {
        this.curBytes = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setId(int r100) {
        this.f449587id = r100;
    }

    public void setOngoing(boolean r100) {
        this.ongoing = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTotalBytes(long r100) {
        this.totalBytes = r100;
    }

    public void updateNotificationItem(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f449587id = r100.getId();
        this.title = r100.getTitle();
    }

    public AbsNotificationItem(int r100, String r101) {
        this.status = 0;
        this.clickInstallTimes = new AtomicInteger(0);
        this.f449587id = r100;
        this.title = r101;
    }

    public void refreshProgress(long r100, long r101) {
        this.curBytes = r100;
        this.totalBytes = r101;
        this.status = 4;
        updateNotification(null, false);
    }

    public void refreshStatus(int r100, BaseException r101, boolean r102) {
        refreshStatus(r100, r101, r102, false);
    }

    public void refreshStatus(int r100, BaseException r101, boolean r102, boolean r103) {
        if (r103 == false) goto L4;
    L6:
        this.status = r100;
        updateNotification(r101, r102);
        return;
    L4:
        if (this.status != r100) goto L6;
    }
}
