package com.bytedance.gamecenter.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static boolean a(Context r100, JSONObject r101, DownloadInfo r102) {
        JSONObject r103 = r101.optJSONObject(AdDownloadModel.JsonKey.DOWNLOAD_SETTINGS);
        if (r103 != null) goto L5;
        return false;
    L5:
        if (r103.optBoolean("live_download_get_install_status_parse_package_info", false) == false) goto L9;
        return AppDownloadUtils.isApkInstalled(r100, r102);
    L9:
        if (r102.getAppVersionCode() > 0) goto L13;
        int r104 = r101.optInt("version_code", 0);
        if (r104 <= 0) goto L13;
        r102.setAppVersionCode(r104);
    L13:
        String r105 = r102.getPackageName();
        int r106 = r102.getAppVersionCode();
        PackageInfo r107 = r100.getPackageManager().getPackageInfo(r105, 16384);     // Catch: PackageManager.NameNotFoundException -> L16
    L17:
        if (r107 != null) goto L20;
        return false;
    L20:
        if (r100 != null) goto L22;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == true) goto L34;
        return false;
    L34:
        if (r106 > r107.versionCode) goto L42;
        return true;
    L42:
        return false;
    L22:
        if (TextUtils.isEmpty(r105) == true) goto L30;
        PackageManager r109 = r100.getPackageManager();     // Catch: Exception -> L28
        if (r109 == null) goto L30;
        if (r109.getLaunchIntentForPackage(r105) == null) goto L30;
        r108 = true;
    L28:
        e = move-exception;
        e.printStackTrace();
    L16:
        r107 = null;
        goto L17
    }
}
