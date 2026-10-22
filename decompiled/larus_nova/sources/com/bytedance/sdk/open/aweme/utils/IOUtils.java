package com.bytedance.sdk.open.aweme.utils;

import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes22.dex */
public class IOUtils {
    public IOUtils() {
    }

    public static int copy(InputStream r100, OutputStream r101) throws IOException {
        long r102 = copyLarge(r100, r101);
        if (r102 <= SieveCacheKt.NodeLinkMask) goto L5;
        return -1;
    L5:
        return (int) r102;
    }

    public static long copyLarge(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
        long r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if (r104 <= 0) goto L6;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
        goto L3
    L6:
        return r103;
    }

    public static String fromInputStream(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L8
        byte[] r102 = new byte[1024];     // Catch: Exception -> L8
    L3:
        int r103 = r100.read(r102);     // Catch: Exception -> L8
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Exception -> L8
        goto L3
    L6:
        return r101.toString("UTF-8");
    L8:
        return "";
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static boolean writeStringToFile(String r100, String r101, String r102) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);
        if (r103.exists() == true) goto L9;
        r103.createNewFile();
    L9:
        BufferedWriter r104 = new BufferedWriter(new PolarisFileWriterWrapper(r103));
        r104.write(r101);
        r104.flush();
        r104.close();
        return true;
    }
}
