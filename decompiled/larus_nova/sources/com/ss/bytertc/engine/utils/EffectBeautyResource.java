package com.ss.bytertc.engine.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes40.dex */
public class EffectBeautyResource {
    public EffectBeautyResource() {
    }

    public static String GetEffectComposeMakeupPath() {
        Context r100 = RtcContextUtils.getApplicationContext();
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "basic_beauty");
        copyAssetFolder(r100, "basic_beauty", r101.getAbsolutePath());
        return r101.getAbsolutePath();
    }

    private static boolean copyAssetFile(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);     // Catch: IOException -> L15
        if (r103.exists() == false) goto L6;
        return true;
    L6:
        InputStream r104 = r100.getAssets().open(r101);     // Catch: IOException -> L15
        if (r104 != null) goto L9;
        return false;
    L9:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: IOException -> L15
        byte[] r106 = new byte[1024];     // Catch: IOException -> L15
    L10:
        int r107 = r104.read(r106);     // Catch: IOException -> L15
        if (r107 == (-1)) goto L13;
        r105.write(r106, 0, r107);     // Catch: IOException -> L15
        goto L10
    L13:
        r104.close();     // Catch: IOException -> L15
        r105.close();     // Catch: IOException -> L15
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean copyAssetFolder(Context r100, String r110, String r111) {
        String[] r101 = r100.getAssets().list(r110);     // Catch: IOException -> L15
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length == 0) goto L20;
        boolean r102 = new PolarisFileWrapper(r111).mkdirs();     // Catch: IOException -> L15
        int r103 = r101.length;     // Catch: IOException -> L15
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L14;
        String r105 = r101[r104];     // Catch: IOException -> L15
        StringBuilder r106 = new StringBuilder();     // Catch: IOException -> L15
        r106.append(r110);     // Catch: IOException -> L15
        String r107 = File.separator;     // Catch: IOException -> L15
        r106.append(r107);     // Catch: IOException -> L15
        r106.append(r105);     // Catch: IOException -> L15
        r102 = r102 & copyAssetFolder(r100, r106.toString(), r111 + r107 + r105);
        r104 = r104 + 1;
        goto L10
    L14:
        return r102;
    L20:
        return copyAssetFile(r100, r110, r111);
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
