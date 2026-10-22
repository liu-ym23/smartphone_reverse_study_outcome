package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public interface IShakeManager extends IManager {
    void setConfig(JSONObject r100);

    void startScanTask(Object r100);

    void startShakeUpload(Object r100, String r101, JSONObject r102, UploadCallback r103);

    void stopScanTask();
}
