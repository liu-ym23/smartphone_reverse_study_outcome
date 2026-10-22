package com.bytedance.crash.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(File r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (r100.exists() == true) goto L6;
        r100.mkdirs();     // Catch: Exception -> L9
    L12:
        return;
    L6:
        if (r100.isDirectory() == true) goto L12;
        r100.delete();     // Catch: Exception -> L9
        r100.mkdirs();     // Catch: Exception -> L9
        goto L12
    }

    public static void e(File r100) {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.isDirectory() == false) goto L14;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        e(r101[r103]);
        r103 = r103 + 1;
    L14:
        h.b(r100);     // Catch: Throwable -> L13
        return;
    }

    public static String f(File r100) {
        if (r100.exists() == true) goto L5;
    L16:
        return null;
    L5:
        if (r100.isDirectory() == true) goto L16;
        int r101 = (int) r100.length();
        byte[] r102 = new byte[r101];
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L13
        String r104 = new String(r102, 0, r103.read(r102, 0, r101));     // Catch: Throwable -> L12
        r103.close();     // Catch: IOException -> L17
    L11:
        return r104;
    L14:
        if (r103 == null) goto L16;
        r103.close();     // Catch: IOException -> L18
    L13:
        r103 = null;
        goto L14
    }

    public static void g(String r110) {
        Class<?> r100 = Integer.TYPE;     // Catch: Throwable -> L34
        Class<?>[] r101 = {String.class, r100, r100, r100};     // Catch: Throwable -> L34
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;     // Catch: Throwable -> L34
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;     // Catch: Throwable -> L34
        if (el9.a.a() == false) goto L38;
        Class<?> r104 = Class.forName("android.os.FileUtils");     // Catch: Throwable -> L18
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.os.FileUtils");     // Catch: Throwable -> L18
    L31:
        r104.getMethod("setPermissions", r101).invoke(null, new Object[]{r110, 493, -1, -1});     // Catch: Throwable -> L34
        return;
    L18:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L23;
        FastClassNotFoundHandler.b("android.os.FileUtils");     // Catch: Throwable -> L34
    L23:
        if ((th instanceof PluginClassNotFoundException) == false) goto L25;
        throw th;     // Catch: Throwable -> L34
    L25:
        if ((th instanceof ClassNotFoundException) == false) goto L27;
    L30:
        r104 = MiraPluginFix.forName("android.os.FileUtils");     // Catch: Throwable -> L34
        goto L31
    L27:
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;     // Catch: Throwable -> L34
    L38:
        r104 = Class.forName("android.os.FileUtils");     // Catch: Throwable -> L9
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.os.FileUtils");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L13;
        FastClassNotFoundHandler.b("android.os.FileUtils");     // Catch: Throwable -> L34
    L13:
        throw th;     // Catch: Throwable -> L34
    }

    public static PolarisFileWrapper b(File r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        c(r102);
        return r102;
    }

    public static PolarisFileWrapper d(File r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        if (r102.isDirectory() == false) goto L12;
        e(r102);
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r102;
    L6:
        if (r102.exists() == true) goto L11;
        r102.createNewFile();     // Catch: Exception -> L9
        goto L11
    }
}
