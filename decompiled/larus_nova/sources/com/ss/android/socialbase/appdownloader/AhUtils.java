package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.depend.AppGlobalListenerAdaptor;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAhUtilsService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AhUtils {

    public interface OnAhAttemptListener {
        void onAhAttemptResult(DownloadInfo r100, AhAttempt r101);
    }

    public interface Plan {
        public static final String CUSTOM_INSTALLER_MI = "plan_h";
        public static final String CUSTOM_SAVE_PATH = "plan_d";
        public static final String JUMP_BROWSER_INSTALLER = "plan_g";
        public static final String JUMP_FILE_MANAGER = "plan_a";
        public static final String JUMP_FILE_MANAGER2 = "plan_e";
        public static final String JUMP_FILE_MANAGER3 = "plan_f";
        public static final String JUMP_FILE_MANAGER4 = "plan_j";
        public static final String JUMP_FILE_MANAGER_CUSTOM = "plan_b";
        public static final String JUMP_UNKNOWN_SOURCE = "plan_c";
        public static final String JUMP_UNKNOWN_SOURCE_HW = "plan_i";
    }

    public AhUtils() {
    }

    public static int getSavePathRedirectedCode(DownloadSetting r100) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).getSavePathRedirectedCode(r100);
    }

    public static boolean isUnknownSourceEnabled(Context r100) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).isUnknownSourceEnabled(r100);
    }

    public static void setOnAhAttemptListener(OnAhAttemptListener r100) {
        ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).setOnAhAttemptListener(AppGlobalListenerAdaptor.addListener(r100));
    }

    public static AhAttempt checkBrowserInstallConfig(JSONObject r100, DownloadSetting r101) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).checkBrowserInstallConfig(r100, r101);
    }

    public static AhAttempt checkJumpFileManagerConfig(JSONObject r100, DownloadSetting r101) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).checkJumpFileManagerConfig(r100, r101);
    }

    public static boolean enableJumpUnKnownSource(Context r100, JSONObject r101) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).enableJumpUnKnownSource(r100, r101);
    }

    public static boolean antiHijack(Context r100, DownloadInfo r101, Intent r102, boolean r103) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).antiHijack(r100, r101, r102, r103);
    }

    public static boolean tryShowUnknownSource(Context r100, Intent r101, JSONObject r102, int r110, AhAttempt r111) {
        return ((IDownloadAhUtilsService) AppDownloadServiceManager.getService(IDownloadAhUtilsService.class)).tryShowUnknownSource(r100, r101, r102, r110, r111);
    }
}
