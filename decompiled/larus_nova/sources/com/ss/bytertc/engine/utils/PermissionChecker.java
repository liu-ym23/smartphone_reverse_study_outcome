package com.ss.bytertc.engine.utils;

import androidx.core.content.ContextCompat;
import com.ss.bytertc.base.utils.RtcContextUtils;

/* JADX INFO: loaded from: classes40.dex */
public class PermissionChecker {
    public PermissionChecker() {
    }

    public static boolean checkAudioPermission() {
        if (ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.CAMERA") != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
