package com.ss.android.ugc.aweme.performance;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes40.dex */
class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileFilter f451303a = null;

    static {
        f451303a = new AnonymousClass1();
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static int c(String r100) {
        int r101 = -1;
        PolarisFileInputStreamWrapper r102 = null;
        BufferedReader r103 = null;
        BufferedReader r104 = null;
        PolarisFileInputStreamWrapper r105 = null;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 IOException -> L24
        BufferedReader r107 = new BufferedReader(new InputStreamReader(r106));     // Catch: Throwable -> L16 IOException -> L28
        goto L19
    L33:
        String r108 = r107.readLine();     // Catch: Throwable -> L13 IOException -> L15
        if (r108 != null) goto L8;
    L12:
        a(r106);
    L26:
        a(r107);
        return r101;
    L8:
        if (r108.matches("0-[\\d]+$") == false) goto L12;
        r101 = CastIntegerProtector.parseInt(r108.substring(2)) + 1;
        goto L12
    L15:
        r103 = r107;
    L13:
        Throwable th10 = th;
        r104 = r107;
    L18:
        BufferedReader r109 = r104;
        r102 = r106;
    L22:
        a(r102);
        a(r109);
        throw th10;
    L16:
        th = move-exception;
        th10 = th;
    L19:
        r107 = r103;
        r105 = r106;
    L25:
        a(r105);
        goto L26
    L24:
        r107 = null;
    L20:
        th = move-exception;
        th10 = th;
        r109 = null;
        goto L22
    }

    public static int b(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L17;
        byte r102 = r100[r101];
        if (r102 == 10) goto L24;
        if (Character.isDigit(r102) == true) goto L8;
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = r101 + 1;
    L10:
        if (r103 >= r100.length) goto L15;
        if (Character.isDigit(r100[r103]) == false) goto L15;
        r103 = r103 + 1;
    L15:
        return CastIntegerProtector.parseInt(new String(r100, 0, r101, r103 - r101));
    L24:
        return -1;
    L17:
        return -1;
    }
}
