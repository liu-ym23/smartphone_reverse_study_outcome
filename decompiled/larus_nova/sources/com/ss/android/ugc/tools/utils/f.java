package com.ss.android.ugc.tools.utils;

import android.os.Environment;
import android.text.TextUtils;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes40.dex */
public final class f {
    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (FileAdapterUtils.b(r100) == false) goto L14;
        if (FileAdapterUtils.b(r100) == false) goto L18;
        FileAdapterUtils.c();
        boolean r101 = BdMediaFileSystem.isUriExists(FileAdapterUtils.f454856e.a(), UriProtector.parse(r100));     // Catch: Exception -> L15
        FileAdapterUtils.f454855d.put(r100, Boolean.valueOf(r101));     // Catch: Exception -> L15
        return r101;
    L19:
        return false;
    L18:
        return false;
    L14:
        return new PolarisFileWrapper(r100).exists();
    }

    public static void b(File r100) {
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.isDirectory() == false) goto L27;
        File[] r101 = r100.listFiles();     // Catch: Exception -> L18
        if (r101 != null) goto L9;
        return;
    L9:
        int r102 = r101.length;     // Catch: Exception -> L18
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        File r104 = r101[r103];     // Catch: Exception -> L18
        if (r104.isDirectory() == false) goto L14;
        b(r104);     // Catch: Exception -> L18
    L15:
        r103 = r103 + 1;     // Catch: Exception -> L18
        goto L10
    L14:
        r104.delete();     // Catch: Exception -> L18
        goto L15
    L16:
        r100.delete();     // Catch: Exception -> L18
        return;
    }

    public static void c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        boolean r101 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L6
    L7:
        if (r101 == false) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L16;
        r102.delete();
        return;
    L16:
        return;
    L17:
        return;
    L6:
        r101 = false;
        goto L7
    }
}
