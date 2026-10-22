package com.ss.android.downloadlib.addownload.pause;

import android.content.Context;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MistakeClickInterceptor implements IPauseInterceptor {
    public MistakeClickInterceptor() {
    }

    private boolean enable(int r100) {
        if (DownloadSetting.obtain(r100).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_MISTAKE_CLICK_INTERVAL_SWITCH, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    private long getMistakeClickInterval(int r100) {
        return DownloadSetting.obtain(r100).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_MISTAKE_CLICK_INTERVAL, 300);
    }

    @Override // com.ss.android.downloadlib.addownload.pause.IPauseInterceptor
    public boolean interceptor(NativeDownloadModel r100, int r101, IPauseCallback r102, boolean r103, Context r104, DownloadInfo r105) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (enable(r100.getDownloadId()) == true) goto L8;
        return false;
    L8:
        long r106 = r100.getClickDownloadTime();
        if ((System.currentTimeMillis() - r106) > getMistakeClickInterval(r100.getDownloadId())) goto L17;
        JSONObject r107 = new JSONObject();
        r107.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "mistake_click");     // Catch: JSONException -> L13
    L15:
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.PAUSE_OPTIMISE, r107, r100);
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L17:
        return false;
    }
}
