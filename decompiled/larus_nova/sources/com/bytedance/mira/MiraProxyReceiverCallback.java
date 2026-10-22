package com.bytedance.mira;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes21.dex */
public interface MiraProxyReceiverCallback {
    void onRegisterReceiver(BroadcastReceiver r100, IntentFilter r101);

    void onUnregisterReceiver(BroadcastReceiver r100);
}
