package com.huawei.hms.opendevice;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes23.dex */
public abstract class m {
    public static String a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        StringBuilder r102 = new StringBuilder();
        BufferedReader r103 = null;
        InputStreamReader r104 = new InputStreamReader(new PolarisFileInputStreamWrapper(r101), "UTF-8");     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        BufferedReader r105 = new BufferedReader(r104);     // Catch: Throwable -> L14 IOException -> L27 FileNotFoundException -> L28
    L33:
        String r106 = r105.readLine();     // Catch: Throwable -> L10 IOException -> L12 FileNotFoundException -> L13
        if (r106 == null) goto L9;
        r102.append(r106);     // Catch: Throwable -> L10 IOException -> L12 FileNotFoundException -> L13
    L9:
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r105);
    L24:
        return r102.toString();
    L13:
        r103 = r105;
    L12:
        r103 = r105;
    L10:
        th = th;
        r103 = r105;
    L25:
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r103);
        throw th;
    L21:
        HMSLog.e("StreamUtil", "file not exist.");     // Catch: Throwable -> L14
    L22:
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r103);
    L19:
        HMSLog.e("StreamUtil", "read value IOException.");     // Catch: Throwable -> L14
        goto L22
    L14:
        th = th;
    L20:
        r104 = null;
    L18:
        r104 = null;
    L16:
        th = th;
        r104 = null;
        goto L25
    }

    public static void a(File r100) throws IOException {
        if (r100.exists() == false) goto L6;
        return;
    L6:
        if (r100.getParentFile() != null) goto L8;
        HMSLog.e("StreamUtil", "parent file is null.");
        throw new IOException("parent file is null");
    L8:
        if (r100.getParentFile().exists() == true) goto L15;
        if (r100.getParentFile().mkdirs() == true) goto L15;
        HMSLog.e("StreamUtil", "make parent dirs failed.");
        throw new IOException("make parent dirs failed");
    L15:
        if (r100.createNewFile() == false) goto L17;
        return;
    L17:
        HMSLog.e("StreamUtil", "create file failed.");
        throw new IOException("create file failed");
    }
}
