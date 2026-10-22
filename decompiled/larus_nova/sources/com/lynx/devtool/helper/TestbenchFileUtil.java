package com.lynx.devtool.helper;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public class TestbenchFileUtil {
    private static final int READ_BUFFER = 4096;

    public TestbenchFileUtil() {
    }

    public static String getBase64StringFile(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: IOException -> L10 FileNotFoundException -> L13
        byte[] r103 = new byte[4096];     // Catch: IOException -> L10 FileNotFoundException -> L13
    L4:
        int r104 = r102.read(r103);     // Catch: IOException -> L10 FileNotFoundException -> L13
        if (r104 == (-1)) goto L9;
        r101.write(r103, 0, r104);     // Catch: IOException -> L10 FileNotFoundException -> L13
    L9:
        return Base64.encodeToString(r101.toByteArray(), 0);
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    L10:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
