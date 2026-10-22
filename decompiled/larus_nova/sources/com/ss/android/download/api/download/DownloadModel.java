package com.ss.android.download.api.download;

import com.ss.android.ad.applinksdk.model.BizLineType;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.QuickAppModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadModel {
    boolean autoInstallWithoutNotification();

    boolean distinctDir();

    boolean enablePause();

    void forceHideNotification();

    void forceHideToast();

    void forceWifi();

    String getAppIcon();

    List<String> getBackupUrls();

    BizLineType getBizLineType();

    int getCallScene();

    List<String> getClickTrackUrl();

    String getComplianceData();

    DeepLink getDeepLink();

    IDownloadFileUriProvider getDownloadFileUriProvider();

    JSONObject getDownloadSettings();

    String getDownloadUrl();

    int getExecutorGroup();

    long getExpectFileLength();

    JSONObject getExtra();

    long getExtraValue();

    String getFileName();

    String getFilePath();

    int getFunnelType();

    Map<String, String> getHeaders();

    long getId();

    String getLogExtra();

    String getMd5();

    String getMimeType();

    int getModelType();

    String getName();

    String getNotificationJumpUrl();

    String getPackageName();

    QuickAppModel getQuickAppModel();

    String getSdkMonitorScene();

    String getStartToast();

    long getThrottleNetSpeed();

    int getVersionCode();

    String getVersionName();

    boolean ignoreIntercept();

    boolean isAd();

    boolean isAutoInstall();

    boolean isInExternalPublicDir();

    boolean isNeedWifi();

    boolean isShowNotification();

    boolean isShowToast();

    boolean isVisibleInDownloadsUi();

    boolean needIndependentProcess();

    DownloadModel setFilePath(String r100);

    boolean shouldDownloadWithPatchApply();
}
