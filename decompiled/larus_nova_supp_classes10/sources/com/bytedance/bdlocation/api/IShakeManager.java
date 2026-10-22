package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface IShakeManager extends IManager {
    void setConfig(JSONObject r1);

    void startScanTask(Object r1);

    void startShakeUpload(Object r1, String r2, JSONObject r3, UploadCallback r4);

    void stopScanTask();
}
