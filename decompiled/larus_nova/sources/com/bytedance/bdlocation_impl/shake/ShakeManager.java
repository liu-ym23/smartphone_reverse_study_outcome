package com.bytedance.bdlocation_impl.shake;

import android.content.Context;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.callback.UploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ShakeManager implements IShakeManager {
    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void stopScanTask() {
        BDShakeConfig.stopScanTask();
    }

    public ShakeManager(Context r100) {
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void setConfig(JSONObject r100) {
        BDShakeConfig.setShakeParams(r100);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startScanTask(Object r100) {
        BDShakeConfig.startScanTask(r100);
    }

    @Override // com.bytedance.bdlocation.api.IShakeManager
    public void startShakeUpload(Object r100, String r101, JSONObject r102, UploadCallback r103) {
        BDShakeConfig.startShakeUpload(r100, r101, r102, (ShakeUploadCallback) r103);
    }
}
