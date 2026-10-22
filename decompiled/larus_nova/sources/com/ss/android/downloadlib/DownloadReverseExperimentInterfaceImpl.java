package com.ss.android.downloadlib;

import com.ss.android.download.api.DownloadReverseExperimentInterface;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
class DownloadReverseExperimentInterfaceImpl implements DownloadReverseExperimentInterface {
    public DownloadReverseExperimentInterfaceImpl() {
    }

    @Override // com.ss.android.download.api.DownloadReverseExperimentInterface
    public DownloadReverseExperimentInterface setReverseExperimentValue(JSONObject r100) {
        GlobalInfo.setDownloadReverseExperimentValue(r100);
        return this;
    }
}
