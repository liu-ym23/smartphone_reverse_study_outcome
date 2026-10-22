package com.ss.android.cert.manager.utils;

import android.content.Context;
import android.hardware.Camera;
import androidx.core.content.ContextCompat;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes34.dex */
public class SystemInfoTools {
    public SystemInfoTools() {
    }

    public static boolean isCameraValid() {
        boolean r100 = false;
        ICertCompliance r101 = CertManager.getInstance().getCertCompliance();     // Catch: Throwable -> L28 Exception -> L30
        if (r101 == null) goto L27;
        Camera r102 = r101.openCamera();     // Catch: Throwable -> L28 Exception -> L30
        r102.setParameters(r102.getParameters());     // Catch: Throwable -> L28 Exception -> L30
        boolean r103 = true;
        Field r104 = r102.getClass().getDeclaredField("mHasPermission");     // Catch: Exception -> L16 Throwable -> L28
        if (r104 == null) goto L15;
        r104.setAccessible(true);     // Catch: Exception -> L16 Throwable -> L28
        Object r105 = r104.get(r102);     // Catch: Exception -> L16 Throwable -> L28
        if (r105 == null) goto L14;
        if (((Boolean) r105).booleanValue() == false) goto L14;
        r100 = true;
    L14:
        r103 = r100;
    L15:
        r100 = r103;
    L19:
        ICertCompliance r106 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L24
        if (r106 == null) goto L23;
        r106.releaseCamera(r102);     // Catch: Exception -> L24
    L38:
        return r100;
    L23:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L24
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28 Exception -> L30
        r100 = true;
        goto L19
    L27:
        throw new NullPointerException("cert compliance is null");     // Catch: Throwable -> L28 Exception -> L30
    L24:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        if (0 == 0) goto L38;
        ICertCompliance r107 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L24
        if (r107 == null) goto L37;
        r107.releaseCamera(null);     // Catch: Exception -> L24
        goto L38
    L37:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L24
    L28:
        th = move-exception;
        if (0 != 0) goto L52;
    L48:
        throw th;
    L52:
        ICertCompliance r108 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L46
        if (r108 == null) goto L43;
        r108.releaseCamera(null);     // Catch: Exception -> L46
        goto L48
    L43:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static boolean isCameraValid(Context r100) {
        if (ContextCompat.checkSelfPermission(r100, "android.permission.CAMERA") != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
