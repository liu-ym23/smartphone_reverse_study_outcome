package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.AhUtilsImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadAhUtilsService implements IDownloadAhUtilsService {
    public DownloadAhUtilsService() {
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public int getSavePathRedirectedCode(DownloadSetting r100) {
        return AhUtilsImpl.getSavePathRedirectedCode(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean isUnknownSourceEnabled(Context r100) {
        return AhUtilsImpl.isUnknownSourceEnabled(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public void setOnAhAttemptListener(AhUtils.OnAhAttemptListener r100) {
        AhUtilsImpl.setOnAhAttemptListener(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public AhAttempt checkBrowserInstallConfig(JSONObject r100, DownloadSetting r101) {
        return AhUtilsImpl.checkBrowserInstallConfig(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public AhAttempt checkJumpFileManagerConfig(JSONObject r100, DownloadSetting r101) {
        return AhUtilsImpl.checkJumpFileManagerConfig(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean enableJumpUnKnownSource(Context r100, JSONObject r101) {
        return AhUtilsImpl.enableJumpUnKnownSource(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean antiHijack(Context r100, DownloadInfo r101, Intent r102, boolean r103) {
        return AhUtilsImpl.antiHijack(r100, r101, r102, r103);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService
    public boolean tryShowUnknownSource(Context r100, Intent r101, JSONObject r102, int r103, AhAttempt r104) {
        return AhUtilsImpl.tryShowUnknownSource(r100, r101, r102, r103, r104);
    }
}
