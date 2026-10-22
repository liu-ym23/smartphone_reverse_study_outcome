package com.ss.ugc.effectplatform.util;

import bytekn.foundation.encryption.MD5;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.FileType;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f458038a = null;

    public i() {
    }

    static {
        f458038a = new i();
    }

    public static String a(String r100) {
        if (r100 == null) goto L9;
        String r101 = FileManager.f21782a;
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == false) goto L8;
        return StringsKt.dropLast(r100, 1) + "_tmp" + r101;
    L8:
        return r100.concat("_tmp");
    L9:
        return null;
    }

    public static String d(String r100) {
        String r101 = FileManager.f21782a;
        bytekn.foundation.io.file.b r102 = FileManager.j(r100);
        MD5 r103 = new MD5();
        byte[] r104 = new byte[1024];
        int r105 = r102.a(r104, 1024);
    L3:
        if (r105 <= 0) goto L5;
        r103.update(r104, 0, r105);
        r105 = r102.a(r104, 1024);
        goto L3
    L5:
        byte[] r106 = r103.e();
        r102.close();
        return bytekn.foundation.encryption.b.a(r106);
    }

    public static String e(String r100) {
        if (r100 == null) goto L9;
        int r101 = StringsKt.lastIndexOf$default(r100, FileManager.f21782a, 0, false, 6, null);
        if (r101 >= 0) goto L8;
        return null;
    L8:
        return r100.substring(r101 + 1, r100.length());
    L9:
        return null;
    }

    public static long f(String r100) {
        if (r100 == null) goto L29;
        String r101 = FileManager.f21782a;
        bytekn.foundation.io.file.d r102 = FileManager.a(new PolarisFileWrapper(r100));
        if (r102.getType() != FileType.Directory) goto L21;
        List r103 = FileManager.m(r100);
        if (r103 == null) goto L20;
        Iterator r104 = r103.iterator();
        long r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L19;
        bytekn.foundation.io.file.d r106 = (bytekn.foundation.io.file.d) r104.next();
        if (r106.getType() != FileType.Directory) goto L14;
        long r107 = f(r106.f21791b.f21799b);
    L18:
        r105 = r105 + r107;
        goto L10
    L14:
        Long r108 = r106.f21795f;
        if (r108 == null) goto L17;
        r107 = r108.longValue();
        goto L18
    L17:
        r107 = 0;
        goto L18
    L19:
        return r105;
    L20:
        return 0;
    L21:
        Long r109 = r102.f21795f;
        if (r109 != null) goto L24;
        return 0;
    L24:
        return r109.longValue();
    L29:
        return 0;
    }

    public static String g(String r100) {
        if (r100 == null) goto L9;
        int r101 = StringsKt.lastIndexOf$default(r100, FileManager.f21782a, 0, false, 6, null);
        if (r101 >= 0) goto L8;
        return null;
    L8:
        return r100.substring(0, r101);
    L9:
        return null;
    }

    public final boolean delete(bytekn.foundation.io.file.f r100) {
        if (r100 == null) goto L9;
        String r101 = FileManager.f21782a;
        boolean r102 = FileManager.n(r100);
        if (r102 == false) goto L6;
    L8:
        return r102;
    L6:
        if (FileManager.c(r100) == false) goto L8;
        Logger.e$default(Logger.INSTANCE, "FileUtils", "remove file: " + r100.f21799b + " failed!", null, 4, null);
        h(r100.f21799b, r100.f21799b + "_dirty", true);
        goto L8
    L9:
        return false;
    }

    public final boolean delete(String r100) {
        if (r100 == null) goto L9;
        String r101 = FileManager.f21782a;
        boolean r102 = FileManager.o(r100);
        if (r102 == false) goto L6;
    L8:
        return r102;
    L6:
        if (FileManager.d(r100) == false) goto L8;
        Logger.e$default(Logger.INSTANCE, "FileUtils", "remove file: " + r100 + " failed!", null, 4, null);
        h(r100, r100.concat("_dirty"), true);
        goto L8
    L9:
        return false;
    }

    public static void i(String r100, com.ss.ugc.effectplatform.download.d r101) {
        String r102 = FileManager.f21782a;
        b(r101, FileManager.l(r100, false), 0, null);
    }

    public static boolean h(String r100, String r101, boolean r102) {
        if (r100 == null) goto L23;
        String r103 = FileManager.f21782a;
        if (new PolarisFileWrapper(r100).getAbsoluteFile().renameTo(new PolarisFileWrapper(r101).getAbsoluteFile()) == true) goto L21;
        if (r102 == false) goto L24;
        new PolarisFileWrapper(r100).getAbsoluteFile();
        if (r101 == null) goto L10;
        new PolarisFileWrapper(r101).getAbsoluteFile();
    L10:
        if (r101 == null) goto L12;
        boolean r104 = FileManager.d(r101);
    L13:
        if (r104 == false) goto L16;
        if (r101 == null) goto L16;
        FileManager.o(r101);
    L16:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101);
        if (r105.exists() == true) goto L20;
        return false;
    L20:
        return r105.renameTo(r106);
    L12:
        r104 = false;
        goto L13
    L24:
        return false;
    L21:
        return true;
    L23:
        return false;
    }

    public static long b(bytekn.foundation.io.file.b r110, bytekn.foundation.io.file.e r111, long r112, Function2 r113) {
        byte[] r100 = new byte[8192];
        int r101 = r110.a(r100, 8192);
        long r102 = 0;
    L4:
        if (r101 <= 0) goto L12;
        r111.b(r100, r101);
        r102 = r102 + ((long) r101);
        if (r102 >= r112) goto L11;
        if (r112 <= 0) goto L11;
        if (r113 == null) goto L11;
        Unit r103 = (Unit) r113.invoke(Integer.valueOf((int) ((r102 / r112) * 100)), Long.valueOf(r112));
    L11:
        r101 = r110.a(r100, 8192);
        goto L4
    L12:
        if (r113 == null) goto L14;
        Unit r114 = (Unit) r113.invoke(100, Long.valueOf(r112));
    L14:
        r111.a();
        r111.close();
        return r102;
    }

    public static String c(bytekn.foundation.io.file.b r110, bytekn.foundation.io.file.j r111, long r112, Function2 r113) {
        MD5 r100 = new MD5();
        byte[] r101 = new byte[8192];
        int r102 = r110.a(r101, 8192);
        long r103 = 0;
    L4:
        if (r102 <= 0) goto L12;
        r111.b(r101, r102);
        r103 = r103 + ((long) r102);
        r100.update(r101, 0, r102);
        if (r103 >= r112) goto L11;
        if (r112 <= 0) goto L11;
        if (r113 == null) goto L11;
        Unit r104 = (Unit) r113.invoke(Integer.valueOf((int) ((r103 / r112) * 100)), Long.valueOf(r112));
    L11:
        r102 = r110.a(r101, 8192);
        goto L4
    L12:
        if (r113 == null) goto L14;
        Unit r114 = (Unit) r113.invoke(100, Long.valueOf(r112));
    L14:
        byte[] r115 = r100.e();
        r111.a();
        r111.close();
        return bytekn.foundation.encryption.b.a(r115);
    }
}
