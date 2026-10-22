package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes41.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public PushServiceReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        Intent r102 = new Intent(r100, PushMessageHandler.class);
        r102.putExtras(r101);
        r102.setAction(r101.getAction());
        PushMessageHandler.a(r100, r102);
    }
}
