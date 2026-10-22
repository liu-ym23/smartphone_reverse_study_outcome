package com.bytedance.common.jato.dex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.common.jato.JatoFeatureReporter;
import com.bytedance.common.jato.util.DeviceInfoUtils;
import com.heytap.mcssdk.constant.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class VerifierModeSwitch {
    private static int sCurrentSdkVersion;
    private static volatile boolean sIsInit;
    private static int sTargetSdkVersion;

    public static void disableVerifier() {
        if (sIsInit == true) goto L6;
        new IllegalStateException("not init");
        return;
    L6:
        int r100 = Build.VERSION.SDK_INT;
        if (DeviceInfoUtils.getPreviewVersion() == 0) goto L9;
        boolean r101 = true;
    L11:
        if (r100 >= 35) goto L17;
        if (r101 == true) goto L14;
    L16:
        int r102 = DexTricksNativeHolder.verifyNone(sTargetSdkVersion, sCurrentSdkVersion);
    L18:
        if (r102 == 0) goto L21;
        new IllegalStateException("result: " + r102);
    L21:
        if (JatoFeatureReporter.isEnabled() == false) goto L24;
        JSONObject r103 = new JSONObject();
        JatoFeatureReporter.putExtra(r103, b.C, Integer.valueOf(r100));
        JatoFeatureReporter.putExtra(r103, "isPreview", Boolean.valueOf(r101));
        JatoFeatureReporter.reportResult("NonVerify", r102, 0, r103);
        return;
    L24:
        return;
    L14:
        if (r100 < 34) goto L16;
    L17:
        r102 = DexTricksNativeHolder.verifyNone15();
        goto L18
    L9:
        r101 = false;
        goto L11
    }

    public static void enableVerifier() {
        if (sIsInit == true) goto L6;
        new IllegalStateException("not init");
        return;
    L6:
        int r100 = Build.VERSION.SDK_INT;
        if (DeviceInfoUtils.getPreviewVersion() == 0) goto L9;
        boolean r101 = true;
    L11:
        if (r100 >= 35) goto L17;
        if (r101 == true) goto L14;
    L16:
        int r102 = DexTricksNativeHolder.verifyEnable();
    L18:
        if (r102 == 0) goto L21;
        new IllegalStateException("result: " + r102);
        return;
    L21:
        return;
    L14:
        if (r100 < 34) goto L16;
    L17:
        r102 = DexTricksNativeHolder.verifyEnable15();
        goto L18
    L9:
        r101 = false;
        goto L11
    }

    public static synchronized void init(Context r100) {
        monitor-enter(VerifierModeSwitch.class);
        if (r100 == null) goto L18;
    L21:
        th = move-exception;
        throw th;
    L6:
        if (DeviceInfoUtils.isEmulator() == true) goto L18;
        if (DeviceInfoUtils.isEmulatorTrans2Arm() == true) goto L18;
        if (sIsInit == false) goto L14;
        monitor-exit(VerifierModeSwitch.class);
        return;
    L14:
        ApplicationInfo r101 = r100.getApplicationInfo();     // Catch: Throwable -> L21
        sCurrentSdkVersion = Build.VERSION.SDK_INT;     // Catch: Throwable -> L21
        sTargetSdkVersion = r101.targetSdkVersion;     // Catch: Throwable -> L21
        sIsInit = true;     // Catch: Throwable -> L21
        monitor-exit(VerifierModeSwitch.class);
        return;
    L18:
        sIsInit = false;     // Catch: Throwable -> L21
        monitor-exit(VerifierModeSwitch.class);
    }
}
