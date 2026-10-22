package com.tencent.open.web.security;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes35.dex */
public class SecureJsInterface extends com.tencent.open.b.C5542b {
    public static boolean isPWDEdit;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461877a;

    @Override // com.tencent.open.b.C5542b
    public boolean customCallback() {
        return true;
    }

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        JniInterface.clearAllPWD();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
        throw new RuntimeException(e);
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        String r100 = JniInterface.getPWDKeyToMD5(null);     // Catch: Exception -> L6
        SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + r100);
        return r100;
    L6:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
        throw new RuntimeException(e);
    }

    public SecureJsInterface() {
    }

    public void curPosFromJS(String r100) {
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + r100);
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L5
    L7:
        if (r101 < 0) goto L16;
        boolean r102 = a.f461879b;
        if (r102 == true) goto L11;
        String r103 = a.f461878a;
        this.f461877a = r103;
        JniInterface.insetTextToArray(r101, r103, r103.length());
        SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f461877a);
        return;
    L11:
        if (Boolean.valueOf(JniInterface.BackSpaceChar(r102, r101)).booleanValue() == false) goto L19;
        a.f461879b = false;
        return;
    L19:
        return;
    L16:
        throw new RuntimeException("position is illegal.");
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
        r101 = -1;
        goto L7
    }

    public void isPasswordEdit(String r100) {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + r100);
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L5
    L8:
        if (r101 == 0) goto L13;
        if (r101 == 1) goto L13;
        throw new RuntimeException("is pswd edit flag is illegal.");
    L13:
        if (r101 != 0) goto L15;
        isPWDEdit = false;
        return;
    L15:
        if (r101 != 1) goto L21;
        isPWDEdit = true;
        return;
    L21:
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
        r101 = -1;
        goto L8
    }
}
