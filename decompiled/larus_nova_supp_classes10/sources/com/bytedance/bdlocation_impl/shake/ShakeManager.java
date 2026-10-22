package com.bytedance.bdlocation_impl.shake;

import android.content.Context;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ShakeManager implements IShakeManager {
    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
        BDShakeConfig.stopScanTask();
    }

    public ShakeManager(Context r1) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r1) {
        BDShakeConfig.setShakeParams(r1);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r1) {
        BDShakeConfig.startScanTask(r1);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r1, String r2, JSONObject r3, UploadCallback r4) {
        BDShakeConfig.startShakeUpload(r1, r2, r3, (ShakeUploadCallback) r4);
    }
}
