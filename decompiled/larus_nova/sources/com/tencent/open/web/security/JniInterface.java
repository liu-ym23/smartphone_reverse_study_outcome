package com.tencent.open.web.security;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;

/* JADX INFO: loaded from: classes35.dex */
public class JniInterface {
    public static boolean isJniOk;

    public JniInterface() {
    }

    public static native boolean BackSpaceChar(boolean r100, int r101);

    public static native boolean clearAllPWD();

    public static native String d1(String r100);

    public static native String d2(String r100);

    public static native String getPWDKeyToMD5(String r100);

    public static native boolean insetTextToArray(int r100, String r101, int r102);

    public static void loadSo() {
        if (isJniOk == false) goto L17;
        return;
    L17:
        Context r100 = g.a();     // Catch: Throwable -> L13
        if (r100 != null) goto L8;
        SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        if (new PolarisFileWrapper(r100.getFilesDir().toString() + HTTP.URL_DEFAULT + AuthAgent.SECURE_LIB_NAME).exists() == false) goto L10;
        System.load(r100.getFilesDir().toString() + HTTP.URL_DEFAULT + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
        isJniOk = true;     // Catch: Throwable -> L13
        StringBuilder r101 = new StringBuilder("-->load lib success:");     // Catch: Throwable -> L13
        r101.append(AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
        SLog.i("openSDK_LOG.JniInterface", r101.toString());     // Catch: Throwable -> L13
        goto L16
    L10:
        SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
    }
}
