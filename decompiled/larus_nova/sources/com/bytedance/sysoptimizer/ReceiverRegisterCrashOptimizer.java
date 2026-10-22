package com.bytedance.sysoptimizer;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class ReceiverRegisterCrashOptimizer {
    private static Application sApplication;
    private static DoRegisterHandlerCallback sDoRegisterHandlerCallback;
    public static ReceiverLogInterface sReceiverLogInterface;
    private static BroadcastReceiverRegisterCallback sReceiverRegisterHandler;

    /* JADX INFO: loaded from: classes22.dex */
    public interface BroadcastReceiverRegisterCallback {
        boolean needHookFilter(IntentFilter r100);

        void prePostMessage(Message r100);
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface DoRegisterHandlerCallback {
        boolean shouldDoRegisterHandler();
    }

    public ReceiverRegisterCrashOptimizer() {
    }

    public static void doHWReceiverFix() {
        if (sApplication != null) goto L5;
        return;
    L5:
        HWReceiverCrashOptimizer.fix(sApplication);
    }

    public static boolean doRegisterHandler() {
        DoRegisterHandlerCallback r100 = sDoRegisterHandlerCallback;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.shouldDoRegisterHandler();
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

    public static void fix(Application r100) {
        sApplication = r100;
    }

    public static void setBroadcastReceiverRegisterHandler(BroadcastReceiverRegisterCallback r100) {
        sReceiverRegisterHandler = r100;
    }

    public static void setDoRegisterHandlerCallback(DoRegisterHandlerCallback r100) {
        sDoRegisterHandlerCallback = r100;
    }

    public static Intent registerReceiver(BroadcastReceiver r100, IntentFilter r101) {
        Application r102 = sApplication;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getBaseContext().registerReceiver(r100, r101);
    }

    public static Intent registerReceiver(BroadcastReceiver r100, IntentFilter r101, int r102) {
        Application r103 = sApplication;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getBaseContext().registerReceiver(r100, r101, r102);
    }

    public static Intent registerReceiver(BroadcastReceiver r100, IntentFilter r101, String r102, Handler r103) {
        Application r104 = sApplication;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.getBaseContext().registerReceiver(r100, r101, r102, r103);
    }

    public static Intent registerReceiver(BroadcastReceiver r100, IntentFilter r101, String r102, Handler r103, int r110) {
        Application r104 = sApplication;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.getBaseContext().registerReceiver(r100, r101, r102, r103, r110);
    }
}
