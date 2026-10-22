package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ReserveWifiStatusImpl implements IReserveWifiStatusListener {
    public ReserveWifiStatusImpl() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo r100, int r101, int r102) {
        NativeDownloadModel r103 = ModelManager.getInstance().getNativeModelByInfo(r100);
        JSONObject r104 = new JSONObject();
        r104.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_SOURCE, Integer.valueOf(r102));     // Catch: JSONException -> L5
        r104.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_STATUS, Integer.valueOf(r101));     // Catch: JSONException -> L5
    L7:
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI, r104, r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
