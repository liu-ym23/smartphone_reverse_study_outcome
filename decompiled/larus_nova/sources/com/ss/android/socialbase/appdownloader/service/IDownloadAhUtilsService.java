package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadAhUtilsService {

    public static class DefaultDownloadAhUtilsService implements IDownloadAhUtilsService {
        public DefaultDownloadAhUtilsService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean antiHijack(Context r100, DownloadInfo r101, Intent r102, boolean r103) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean enableJumpUnKnownSource(Context r100, JSONObject r101) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public int getSavePathRedirectedCode(DownloadSetting r100) {
            return -1;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean isUnknownSourceEnabled(Context r100) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public void setOnAhAttemptListener(AhUtils.OnAhAttemptListener r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public boolean tryShowUnknownSource(Context r100, Intent r101, JSONObject r102, int r103, AhAttempt r104) {
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public AhAttempt checkBrowserInstallConfig(JSONObject r100, DownloadSetting r101) {
            return new AhAttempt();
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
        public AhAttempt checkJumpFileManagerConfig(JSONObject r100, DownloadSetting r101) {
            return new AhAttempt();
        }
    }

    boolean antiHijack(Context r100, DownloadInfo r101, Intent r102, boolean r103);

    AhAttempt checkBrowserInstallConfig(JSONObject r100, DownloadSetting r101);

    AhAttempt checkJumpFileManagerConfig(JSONObject r100, DownloadSetting r101);

    boolean enableJumpUnKnownSource(Context r100, JSONObject r101);

    int getSavePathRedirectedCode(DownloadSetting r100);

    boolean isUnknownSourceEnabled(Context r100);

    void setOnAhAttemptListener(AhUtils.OnAhAttemptListener r100);

    boolean tryShowUnknownSource(Context r100, Intent r101, JSONObject r102, int r103, AhAttempt r104);
}
