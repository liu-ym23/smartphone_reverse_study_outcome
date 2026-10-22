package com.bytedance.sysoptimizer;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ReceiverRegisterCrashOptimizer {
    private static Application sApplication;
    private static DoRegisterHandlerCallback sDoRegisterHandlerCallback;
    public static ReceiverLogInterface sReceiverLogInterface;
    private static BroadcastReceiverRegisterCallback sReceiverRegisterHandler;

    public ReceiverRegisterCrashOptimizer() {
    }

    public static void doHWReceiverFix() {
        if (sApplication != null) goto L5;
        return;
    L5:
        HWReceiverCrashOptimizer.fix(sApplication);
    }

    public static boolean doRegisterHandler() {
        DoRegisterHandlerCallback r0 = sDoRegisterHandlerCallback;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.shouldDoRegisterHandler();
    }

    public static boolean fixedOpen() {
        if (sApplication == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static BroadcastReceiverRegisterCallback getReceiverRegisterHandler() {
        return sReceiverRegisterHandler;
    }

    public static void fix(Application r0) {
        sApplication = r0;
    }

    public static void setBroadcastReceiverRegisterHandler(BroadcastReceiverRegisterCallback r0) {
        sReceiverRegisterHandler = r0;
    }

    public static void setDoRegisterHandlerCallback(DoRegisterHandlerCallback r0) {
        sDoRegisterHandlerCallback = r0;
    }

    public static Intent registerReceiver(BroadcastReceiver r1, IntentFilter r2) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBaseContext().registerReceiver(r1, r2);
    }

    public static Intent registerReceiver(BroadcastReceiver r1, IntentFilter r2, int r3) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBaseContext().registerReceiver(r1, r2, r3);
    }

    public static Intent registerReceiver(BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBaseContext().registerReceiver(r1, r2, r3, r4);
    }

    public static Intent registerReceiver(BroadcastReceiver r6, IntentFilter r7, String r8, Handler r9, int r10) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBaseContext().registerReceiver(r6, r7, r8, r9, r10);
    }
}
