package com.obric.sva.sdk.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.FileKt;
import com.obric.sva.sdk.utils.LogUtils;

/* JADX INFO: loaded from: classes34.dex */
public class DebugBroadcastReceiver extends BroadcastReceiver {
    private static final String CLEAN_ALL_DUMP_COMMAND = "clean_all_dump";
    private static final String CLOSE_DUMP_COMMAND = "close_voice_request_dump";
    private static final String COMMAND_KEY = "command";
    private static final String DISABLE_WAKEUP = "disable_wakeup";
    private static final String ENABLE_WAKEUP = "enable_wakeup";
    private static final String OPEN_DUMP_COMMAND = "open_voice_request_dump";
    private static final String SET_MAX_DUMP_COUNT_COMMAND = "max_dump_count";
    private static final String TAG = "DebugBroadcastReceiver";

    public DebugBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        String r102 = r101.getStringExtra("command");
        if (OPEN_DUMP_COMMAND.equals(r102) == false) goto L6;
        Global.DEBUG_HOTWORD_DUMP = true;
    L21:
        String r103 = r101.getStringExtra(SET_MAX_DUMP_COUNT_COMMAND);
        if (r103 != null) goto L32;
    L26:
        if (r102 == null) goto L28;
        LogUtils.d(TAG, "Received data: ".concat(r102), new Object[0]);
        return;
    L28:
        LogUtils.d(TAG, "No data received", new Object[0]);
        return;
    L32:
        int r104 = CastIntegerProtector.parseInt(r103);     // Catch: Throwable -> L25
        LogUtils.d(TAG, "======== set max dump count " + r104, new Object[0]);     // Catch: Throwable -> L25
        Global.DEBUG_VOICE_REQUEST_COUNT = Math.min(r104, 200);     // Catch: Throwable -> L25
        goto L26
    L6:
        if (CLOSE_DUMP_COMMAND.equals(r102) == false) goto L9;
        Global.DEBUG_HOTWORD_DUMP = false;
        goto L21
    L9:
        if (CLEAN_ALL_DUMP_COMMAND.equals(r102) == false) goto L16;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        FileKt.deleteContents(new PolarisFileWrapper(Global.getInstance().PATH_VOICE_REQUESTS));     // Catch: Throwable -> L14
        goto L21
    L16:
        if (DISABLE_WAKEUP.equals(r102) == false) goto L19;
        LogUtils.d(TAG, "set Wakeup disabled", new Object[0]);
        Global.sWakeupStatus = false;
        goto L21
    L19:
        if (ENABLE_WAKEUP.equals(r102) == false) goto L21;
        LogUtils.d(TAG, "set Wakeup enable", new Object[0]);
        Global.sWakeupStatus = true;
        goto L21
    }
}
