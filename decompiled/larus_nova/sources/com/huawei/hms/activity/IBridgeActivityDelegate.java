package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes23.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity r100);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int r100, int r101, Intent r102);

    void onBridgeConfigurationChanged();

    void onKeyUp(int r100, KeyEvent r101);
}
