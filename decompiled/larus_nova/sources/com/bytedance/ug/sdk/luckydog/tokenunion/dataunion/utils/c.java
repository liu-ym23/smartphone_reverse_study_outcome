package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static String a(String r100) {
        String r101 = "/luckydog/" + r100 + ".dat";
        um7.e.b("getTokenPath(); token path = " + r101);
        return r101;
    }

    public static boolean c(Context r210) {
        if (TextUtils.isEmpty("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty("android.permission.WRITE_EXTERNAL_STORAGE") == true) goto L28;
        int r100 = Process.myPid();
        int r101 = Process.myUid();
        ArrayList r102 = new ArrayList();
        Object[] r103 = {"android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(r100), Integer.valueOf(r101)};
        f06.b r110 = new f06.b("auto_cert_com_bytedance_ug_sdk_luckydog_tokenunion_dataunion_utils_DataUnionFileUtils_android_content_Context_checkPermission");
        g06.a r104 = ApiHookConfig.f245611b.get(102607);
        if (r104 == null) goto L11;
        f06.a[] r105 = r104.f479473i;
    L12:
        f06.a[] r111 = r105;
        int r112 = r111.length;
        int r113 = 0;
    L14:
        if (r113 >= r112) goto L21;
        f06.a r114 = r111[r113];
        int r115 = r113;
        int r211 = r112;
        f06.a[] r212 = r111;
        f06.d r106 = r114.preInvoke(102607, "android/content/Context", "checkPermission", r210, r103, "int", r110);     // Catch: Exception -> L33
        if (r106.f474982a == true) goto L23;
        r102.add(r114);     // Catch: Exception -> L33
    L23:
        if (r106.f474982a == false) goto L25;
        int r107 = ((Integer) r106.f474983b).intValue();
    L26:
        if (r107 != 0) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L31;
        return false;
    L31:
        return true;
    L25:
        r107 = r210.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", r100, r101);
    L20:
        r113 = r115 + 1;
        r112 = r211;
        r111 = r212;
        goto L14
    L21:
        r106 = new f06.d(false, null);
        goto L23
    L11:
        r105 = ApiHookConfig.f245613d;
    L28:
        r108 = false;
        goto L29
    }

    public static String b(Context r100, String r101) {
        PolarisFileInputStreamWrapper r102 = null;
        String r103 = null;
        r103 = null;
        PolarisFileInputStreamWrapper r104 = null;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L68;
        um7.e.b("readFile(); sdk >= Q return");
        return null;
    L68:
    L39:
        th = th;
        String r105 = null;
    L58:
        um7.e.a(th.getMessage());     // Catch: Throwable -> L49
        if (r102 == null) goto L48;
        r102.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        um7.e.a(e.getMessage());
    L48:
        return r105;
    L49:
        th = move-exception;
        if (r102 != null) goto L66;
    L55:
        throw th;
    L66:
        r102.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        um7.e.a(e.getMessage());
        goto L55
    L10:
        if (c(r100) == true) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L33;
        PolarisFileWrapper r107 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), a(r101));     // Catch: Throwable -> L39
        if (r107.exists() == true) goto L19;
    L26:
        PolarisFileInputStreamWrapper r108 = null;
    L28:
        if (TextUtils.isEmpty(r103) == false) goto L30;
        r107.delete();     // Catch: Throwable -> L31
    L31:
        th = th;
    L32:
        String r109 = r103;
        r102 = r108;
        r105 = r109;
    L30:
        String r110 = r103;
        r104 = r108;
    L34:
        if (r104 == null) goto L70;
        r104.close();     // Catch: IOException -> L37
        return r110;
    L37:
        e = move-exception;
        um7.e.a(e.getMessage());
        return r110;
    L70:
        return r110;
    L19:
        if (r107.canRead() == false) goto L26;
        r108 = new PolarisFileInputStreamWrapper(r107);     // Catch: Throwable -> L39
        byte[] r111 = new byte[r108.available()];     // Catch: Throwable -> L31
        r108.read(r111);     // Catch: Throwable -> L31
        String r112 = om7.f.a(r111);     // Catch: Throwable -> L31
        um7.e.b("readFile(); text = " + r112);     // Catch: Throwable -> L24
        r103 = r112;
    L24:
        th = th;
        r103 = r112;
        goto L32
    L33:
        r110 = null;
        goto L34
    L12:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L14;
        r106 = true;
        goto L15
    }

    public static void d(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        um7.e.b("writeFile() sdk >= Q; return ");
        return;
    L11:
        PolarisFileOutputStreamWrapper r103 = null;
    L29:
        th = th;
    L47:
        um7.e.a(th.getMessage());     // Catch: Throwable -> L37
        if (r103 == null) goto L56;
    L51:
        r103.close();     // Catch: IOException -> L34
        return;
    L34:
        e = move-exception;
        um7.e.b(e.getMessage());
        return;
    L56:
        return;
    L37:
        th = move-exception;
        if (r103 != null) goto L49;
    L43:
        throw th;
    L49:
        r103.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        um7.e.b(e.getMessage());
        goto L43
    L13:
        if (c(r100) == true) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L27;
        PolarisFileWrapper r105 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + a(r101));     // Catch: Throwable -> L29
        File r106 = r105.getParentFile();     // Catch: Throwable -> L29
        if (r106.exists() == true) goto L22;
        r106.mkdirs();     // Catch: Throwable -> L29
    L22:
        byte[] r107 = om7.f.b(r102);     // Catch: Throwable -> L29
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L29
        r108.write(r107);     // Catch: Throwable -> L25
        um7.e.b("writeFile(); write finish; fileDir = " + r106);     // Catch: Throwable -> L25
        r103 = r108;
    L25:
        th = th;
        r103 = r108;
    L27:
        if (r103 != null) goto L51;
        return;
    L15:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L17;
        r104 = true;
        goto L18
    }
}
