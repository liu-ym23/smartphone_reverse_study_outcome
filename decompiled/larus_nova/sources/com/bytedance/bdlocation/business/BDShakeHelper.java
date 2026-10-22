package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BDShakeHelper {
    private static IShakeManager mShakeManager;

    public BDShakeHelper() {
    }

    private static IShakeManager getShakeManager() {
        if (mShakeManager != null) goto L8;
        mShakeManager = BDLocationExtrasService.getShakeManager();
        if (BDLocationConfig.getShakeConfig() == null) goto L8;
        mShakeManager.setConfig(BDLocationConfig.getShakeConfig());
    L8:
        return mShakeManager;
    }

    public static void stopScanTask() {
        getShakeManager().stopScanTask();
    }

    public static void startScanTask(Object r100) {
        getShakeManager().startScanTask(r100);
    }

    public static void startShakeUpload(Object r100, String r101, JSONObject r102, ShakeUploadCallback r103) {
        getShakeManager().startShakeUpload(r100, r101, r102, r103);
    }
}
