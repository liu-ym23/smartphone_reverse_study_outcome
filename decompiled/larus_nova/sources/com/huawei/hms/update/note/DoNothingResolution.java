package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class DoNothingResolution implements IBridgeActivityDelegate {
    public DoNothingResolution() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityDestroy>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeConfigurationChanged>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityCreate>");
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("DoNothingResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        r100.setResult(30);
        r100.finish();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onKeyUp>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityResult>");
        return false;
    }
}
