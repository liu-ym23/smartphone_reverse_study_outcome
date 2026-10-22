package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadShortInfo {
    public int callScene;
    public long currentBytes;
    public String downloadUrl;
    public JSONObject extra;
    public int failStatus;
    public String fileName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public long f408261id;
    public boolean onlyWifi;
    public long realCurrentBytes;
    public long realDownloadTime;
    public int realPercent;
    public int status;
    public long totalBytes;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f408261id), Integer.valueOf(this.status), Long.valueOf(this.totalBytes), this.fileName});
    }

    public DownloadShortInfo() {
        this.f408261id = -1;
        this.status = -1;
        this.totalBytes = -1;
        this.currentBytes = -1;
        this.failStatus = 0;
        this.realDownloadTime = 0;
        this.realPercent = 0;
        this.realCurrentBytes = -1;
        this.callScene = 0;
    }

    public boolean equals(Object r110) {
        if ((r110 instanceof DownloadShortInfo) == false) goto L37;
        if (r110 == null) goto L37;
        DownloadShortInfo r111 = (DownloadShortInfo) r110;
        if (this.f408261id != r111.f408261id) goto L8;
        boolean r100 = true;
    L10:
        if (this.status != r111.status) goto L12;
        boolean r101 = true;
    L14:
        if (this.totalBytes != r111.totalBytes) goto L16;
        boolean r102 = true;
    L18:
        if (TextUtils.isEmpty(this.fileName) == false) goto L22;
        if (TextUtils.isEmpty(r111.fileName) == false) goto L22;
    L27:
        boolean r112 = true;
    L29:
        if (r100 == false) goto L34;
        if (r101 == false) goto L34;
        if (r102 == false) goto L34;
        if (r112 == false) goto L34;
        return true;
    L34:
        return false;
    L22:
        if (TextUtils.isEmpty(this.fileName) == false) goto L24;
    L28:
        r112 = false;
        goto L29
    L24:
        if (TextUtils.isEmpty(r111.fileName) == true) goto L28;
        if (this.fileName.equals(r111.fileName) == false) goto L28;
    L16:
        r102 = false;
        goto L18
    L12:
        r101 = false;
        goto L14
    L8:
        r100 = false;
    L37:
        return super.equals(r110);
    }

    public void updateFromNativeDownloadModel(NativeDownloadModel r100) {
        this.callScene = r100.getCallScene();
        this.extra = r100.getExtra();
        this.downloadUrl = r100.getDownloadUrl();
    }

    public void updateFromNewDownloadInfo(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f408261id = r100.getId();
        this.status = r100.getStatus();
        this.currentBytes = r100.getCurBytes();
        this.totalBytes = r100.getTotalBytes();
        this.fileName = r100.getTargetFilePath();
        BaseException r101 = r100.getFailedException();
        if (r101 == null) goto L7;
        this.failStatus = r101.getErrorCode();
    L8:
        this.onlyWifi = r100.isOnlyWifi();
        this.realDownloadTime = r100.getRealDownloadTime();
        this.realCurrentBytes = r100.getCurBytes();
        return;
    L7:
        this.failStatus = 0;
        goto L8
    }
}
