package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277264a = "c";

    public static String a(String r100, Context r101) {
        Logger.d(f277264a, "Io getConfigContent, fileName: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        InputStream r103 = null;
    L17:
        th = move-exception;
        IoUtils.closeSecure(r102);
        IoUtils.closeSecure(r103);
        throw th;
    L7:
        if (new PolarisFileWrapper(r100).isDirectory() == false) goto L10;
    L8:
        IoUtils.closeSecure(r102);
        IoUtils.closeSecure(r103);
        return "";
    L10:
        r103 = r101.getAssets().open(r100);     // Catch: Throwable -> L17 IOException -> L19
        byte[] r104 = new byte[8192];     // Catch: Throwable -> L17 IOException -> L19
    L11:
        int r105 = r103.read(r104);     // Catch: Throwable -> L17 IOException -> L19
        if (r105 == (-1)) goto L14;
        r102.write(r104, 0, r105);     // Catch: Throwable -> L17 IOException -> L19
        goto L11
    L14:
        r102.flush();     // Catch: Throwable -> L17 IOException -> L19
        String r106 = r102.toString("UTF-8");     // Catch: Throwable -> L17 IOException -> L19
        IoUtils.closeSecure(r102);
        IoUtils.closeSecure(r103);
        return r106;
    L21:
        Logger.w(f277264a, "local config file is not exist.filename is {%s}", new Object[]{r100});     // Catch: Throwable -> L17
        goto L8
    }
}
