package com.bytedance.crypto.cloudsync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes15.dex */
public class CloudSyncBroadcastReceiver extends BroadcastReceiver {
    public static final String PERMISSION = "slardaros.intent.permission";
    private static final String TAG = "CloudSyncBroadcastReceiver";
    public static final String WHITELIST_ACTION = "com.bytedance.security.CLOUD_SYNC_APP_WHITELIST";

    public CloudSyncBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        String r102 = r101.getAction();
        LogUtils.i(TAG, "Receive broadcast action:" + r102);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return;
    L9:
        if (r102.equals(WHITELIST_ACTION) == false) goto L15;
        String r103 = r101.getStringExtra("data");
        LogUtils.d(TAG, "WHITELIST_ACTION data:" + r103);
        String r104 = r100.getFilesDir().getAbsolutePath() + "/cloud_sync_white_list.xml";
        LogUtils.d(TAG, "WHITELIST_ACTION filePath:" + r104);
        CloudConfig.getInstance().updateWhiteListApps(r104, r103);
        return;
    L15:
        return;
    L12:
        LogUtils.e(TAG, "context or intent is null");
    }
}
