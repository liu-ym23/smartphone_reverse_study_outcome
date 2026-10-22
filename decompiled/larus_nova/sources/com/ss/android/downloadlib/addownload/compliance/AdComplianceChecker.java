package com.ss.android.downloadlib.addownload.compliance;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006JD\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/downloadlib/addownload/compliance/AdComplianceChecker;", "", "()V", "TAG", "", "getDialogDownloadStatus", "", "downloadStatus", "needShowComplianceDialogInFeed", "needBeginDownload", "", "isNormalScene", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/download/api/download/DownloadModel;", "controller", "Lcom/ss/android/download/api/download/DownloadController;", "eventConfig", "Lcom/ss/android/download/api/download/DownloadEventConfig;", "downloadInfo", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "needCheckComplianceDialog", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdComplianceChecker {
    public static final AdComplianceChecker INSTANCE = null;
    public static final String TAG = "AdComplianceChecker";

    private AdComplianceChecker() {
    }

    public final int getDialogDownloadStatus(int r100) {
        if (r100 != (-4)) goto L5;
        return 1;
    L5:
        if (r100 != (-3)) goto L7;
        return 4;
    L7:
        if (r100 == (-2)) goto L22;
        if (r100 != 0) goto L10;
        return 1;
    L10:
        if (r100 == 1) goto L21;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L21;
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L21;
        if (r100 == 8) goto L21;
        if (r100 == 11) goto L21;
        return 1;
    L21:
        return 2;
    L22:
        return 3;
    }

    static {
        INSTANCE = new AdComplianceChecker();
    }

    public final int needShowComplianceDialogInFeed(boolean r100, boolean r101, DownloadModel r102, DownloadController r103, DownloadEventConfig r104, DownloadInfo r110, boolean r111) {
        if (r111 == false) goto L38;
        if (r104 == null) goto L6;
        String r112 = r104.getRefer();
    L7:
        if (r112 == null) goto L12;
        if (r104.getRefer().equals("download_center") == true) goto L38;
    L12:
        if (DownloadSettingUtils.getSetting(r102).optInt(DownloadSettingKeys.KEY_ENABLE_COMPLIANCE_DIALOG_SPECIAL_SHOW, 0) == 1) goto L14;
    L26:
        if (r100 == false) goto L38;
        if (r101 == false) goto L38;
        if (r102.isAd() == false) goto L38;
        if (r104 == null) goto L38;
        if (r104.hasShowPkgInfo() == true) goto L38;
        if ((r103 instanceof AdDownloadController) == false) goto L38;
        if (((AdDownloadController) r103).isEnableShowComplianceDialogInFeed() == false) goto L38;
        return 1;
    L14:
        if ((r103 instanceof AdDownloadController) == false) goto L26;
        if (((AdDownloadController) r103).isEnableSpecialShowComplianceDialog() == false) goto L26;
        if (r110 != null) goto L19;
        return 2;
    L19:
        if (r110.getStatus() == (-3)) goto L21;
        return 2;
    L21:
        if (DownloadUtils.isDownloadSuccessAndFileNotExist(r110.getStatus(), r110.getSavePath(), r110.getName()) == true) goto L40;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "needShowComplianceDialogInFeed", "不处于下载中状态，不进行处理");
        goto L26
    L40:
        return 2;
    L6:
        r112 = null;
    L38:
        return 0;
    }
}
