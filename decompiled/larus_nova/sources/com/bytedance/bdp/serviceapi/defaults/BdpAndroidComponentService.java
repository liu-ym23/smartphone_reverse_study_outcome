package com.bytedance.bdp.serviceapi.defaults;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpAndroidComponentService extends IBdpService {
    Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102);

    void startActivity(Context r100, Intent r101, Bundle r102);

    ComponentName startService(Context r100, Intent r101);

    void unregisterReceiver(Context r100, BroadcastReceiver r101);
}
