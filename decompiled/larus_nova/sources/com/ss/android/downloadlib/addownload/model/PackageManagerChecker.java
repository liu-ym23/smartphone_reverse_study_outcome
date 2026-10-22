package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PackageManagerChecker {
    private static volatile PackageManagerChecker sInstance;

    public static PackageManagerChecker getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(InstalledAppManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PackageManagerChecker();     // Catch: Throwable -> L11
    L9:
        monitor-exit(InstalledAppManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PackageManagerChecker() {
    }

    public void checkVersionCode(int r100, int r101, NativeDownloadModel r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        DownloadSetting r103 = DownloadSetting.obtain(r102.getDownloadId());
        if (r103.optInt(DownloadSettingKeys.REPORT_API_HIJACK, 0) != 0) goto L7;
        return;
    L7:
        int r104 = r101 - r100;
        if (r100 > 0) goto L10;
        return;
    L10:
        if (r104 <= r103.optInt(DownloadSettingKeys.CHECK_API_HIJACK_VERSION_CODE_DIFF, 500)) goto L21;
        JSONObject r105 = new JSONObject();
        r105.put(EventConstants.ExtraJson.KEY_VERSION_CODE_DIFF, r104);     // Catch: JSONException -> L14
        r105.put(EventConstants.ExtraJson.KEY_INSTALLED_VERSION_CODE, r101);     // Catch: JSONException -> L14
        r105.put(EventConstants.ExtraJson.KEY_HIJACK_TYPE, 1);     // Catch: JSONException -> L14
    L16:
        AdEventHandler.getInstance().sendEvent(EventConstants.Label.API_HIJACK, r105, r102);
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
