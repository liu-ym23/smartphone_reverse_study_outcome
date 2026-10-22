package com.ss.android.lark.batterymonitor.charge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import ywa.a;

/* JADX INFO: loaded from: classes34.dex */
public class ChargeBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ChargeBroadcastReceiver f409785a;

    public ChargeBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (TextUtils.equals(r101.getAction(), "android.intent.action.ACTION_POWER_CONNECTED") == false) goto L6;
        int r102 = a.f569362c;
        a.C8395a.f569364a.d(0);
        Log.i("BatteryMonitor", "ChargeBroadcast onReceive called. Current charge is plug in.");
        return;
    L6:
        if (TextUtils.equals(r101.getAction(), "android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L8;
        int r103 = a.f569362c;
        a.C8395a.f569364a.d(1);
        Log.i("BatteryMonitor", "ChargeBroadcast onReceive called. action is ACTION_POWER_DISCONNECTED, Current charge is plug off.");
        return;
    L8:
        Log.i("BatteryMonitor", "ChargeBroadcast onReceive called. But not plug in or plug off.");
    }
}
