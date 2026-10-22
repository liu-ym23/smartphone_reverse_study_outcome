package com.bytedance.geckox.listener;

import android.util.Pair;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeckoUpdateListener {

    /* JADX INFO: loaded from: classes19.dex */
    public static class GeckoParams {
        public String accessKey;
        public String channel;
        public long version;

        public GeckoParams(String r100, String r101, long r102) {
            this.accessKey = r100;
            this.channel = r101;
            this.version = r102;
        }
    }

    public GeckoUpdateListener() {
    }

    public void onActivateFail(UpdatePackage r100, Throwable r101) {
    }

    public void onActivateSuccess(UpdatePackage r100) {
    }

    public void onChannelAccess(GeckoParams r100) {
    }

    public void onCheckRequestIntercept(int r100, Map<String, List<Pair<String, Long>>> r101, Throwable r102) {
    }

    public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
    }

    public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
    }

    public void onClean(String r100) {
    }

    public void onCleanRes(GeckoParams r100) {
    }

    public void onDownloadFail(UpdatePackage r100, Throwable r101) {
    }

    public void onDownloadProgress(UpdatePackage r100, long r101, long r102) {
    }

    public void onDownloadSuccess(UpdatePackage r100) {
    }

    public void onLocalNewestVersion(LocalPackageModel r100) {
    }

    public void onUpdateFailed(UpdatePackage r100, Throwable r101) {
    }

    public void onUpdateFailed(String r100, Throwable r101) {
    }

    public void onUpdateFinish() {
    }

    public void onUpdateStart(UpdatePackage r100) {
    }

    public void onUpdateSuccess(UpdatePackage r100, long r101) {
    }

    public void onUpdateSuccess(String r100, long r101) {
    }

    public void onUpdating(String r100) {
    }
}
