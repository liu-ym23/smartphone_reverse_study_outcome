package com.ss.android.lark.batterymonitor.screen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import cxa.a;

/* JADX INFO: loaded from: classes34.dex */
public class ScreenBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScreenBroadcastReceiver f409786a;

    public ScreenBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (TextUtils.equals(r101.getAction(), "android.intent.action.SCREEN_OFF") == false) goto L6;
        Log.i("BatteryMonitor", "ScreenBroadcast onReceive called. action:ACTION_SCREEN_OFF.");
        int r102 = a.f465743f;
        a.C5604a.f465748a.f(1);
        return;
    L6:
        if (TextUtils.equals(r101.getAction(), "android.intent.action.SCREEN_ON") == false) goto L8;
        Log.i("BatteryMonitor", "ScreenBroadcast onReceive called. action:ACTION_SCREEN_ON.");
        int r103 = a.f465743f;
        a.C5604a.f465748a.f(0);
        return;
    L8:
        Log.i("BatteryMonitor", "ScreenBroadcast onReceive called. But not screen on or off.");
    }
}
