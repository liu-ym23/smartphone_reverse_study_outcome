package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    public static void startScanTask(Object r1) {
        getShakeManager().startScanTask(r1);
    }

    public static void startShakeUpload(Object r1, String r2, JSONObject r3, ShakeUploadCallback r4) {
        getShakeManager().startShakeUpload(r1, r2, r3, r4);
    }
}
