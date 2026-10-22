package com.bytedance.mira.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.mira.log.MiraLogger;

/* JADX INFO: loaded from: classes21.dex */
public class MiraDefaultBroadcast extends BroadcastReceiver {
    private static final String TAG = "DefaultBroadcast";

    public MiraDefaultBroadcast() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        MiraLogger.e(MiraLogger.TAG_RECEIVER, "DefaultBroadcast onReceive...");
    }
}
