package com.bytedance.bmf_mods.common;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes44.dex */
public class BmfUtils {
    public BmfUtils() {
    }

    public static String fileMd5(File r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L16 IOException -> L18
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L10
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r104 = r101.read(r103);     // Catch: Throwable -> L10
        if (r104 == (-1)) goto L7;
        r102.update(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L7:
        String r105 = new BigInteger(1, r102.digest()).toString(16);     // Catch: Throwable -> L10
        r101.close();     // Catch: Throwable -> L16 IOException -> L18
        return r105;
    L10:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L16 IOException -> L18
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16 IOException -> L18
    L16:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
