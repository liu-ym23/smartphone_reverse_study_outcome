package com.huawei.hms.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SHA256 {
    public SHA256() {
    }

    public static byte[] digest(File r100) {
        BufferedInputStream r101 = null;
        MessageDigest r102 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L17 Throwable -> L26
        BufferedInputStream r103 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Throwable -> L17 Throwable -> L26
        byte[] r104 = new byte[4096];     // Catch: Throwable -> L14 Throwable -> L16
        int r105 = 0;
    L6:
        int r106 = r103.read(r104);     // Catch: Throwable -> L14 Throwable -> L16
        if (r106 == (-1)) goto L9;
        r105 = r105 + r106;     // Catch: Throwable -> L14 Throwable -> L16
        r102.update(r104, 0, r106);     // Catch: Throwable -> L14 Throwable -> L16
        goto L6
    L9:
        if (r105 <= 0) goto L13;
        byte[] r107 = r102.digest();     // Catch: Throwable -> L14 Throwable -> L16
        IOUtils.closeQuietly(r103);
        return r107;
    L13:
        IOUtils.closeQuietly(r103);
    L22:
        return new byte[0];
    L16:
        r101 = r103;
    L14:
        th = th;
    L24:
        IOUtils.closeQuietly(r103);
        throw th;
    L17:
        th = th;
        r103 = r101;
    L19:
        HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");     // Catch: Throwable -> L17
        IOUtils.closeQuietly(r101);
        goto L22
    }

    public static byte[] digest(byte[] r100) {
        return MessageDigest.getInstance("SHA-256").digest(r100);
    L4:
        e = move-exception;
        HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
        return new byte[0];
    }
}
