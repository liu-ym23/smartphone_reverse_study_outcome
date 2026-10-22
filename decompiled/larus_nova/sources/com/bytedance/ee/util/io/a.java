package com.bytedance.ee.util.io;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f243143a = null;

    static {
        f243143a = new String[]{"tar.gz", "tar.bz2", "tar.lzma"};
    }

    public static String a(long r100) {
        if (r100 <= 0) goto L5;
        float r101 = r100;
    L6:
        String r102 = "B";
        if (r101 < 0.0f) goto L13;
        if (r101 >= 1024.0f) goto L13;
        return Long.toString(r100) + "B";
    L13:
        if (r101 < 1024.0f) goto L16;
        r101 = r101 / 1024.0f;
        r102 = "KB";
    L16:
        if (r101 < 1024.0f) goto L19;
        r101 = r101 / 1024.0f;
        r102 = "MB";
    L19:
        if (r101 < 1024.0f) goto L22;
        r101 = r101 / 1024.0f;
        r102 = "GB";
    L22:
        if (r101 < 1024.0f) goto L25;
        r101 = r101 / 1024.0f;
        r102 = "TB";
    L25:
        if (r101 < 1024.0f) goto L28;
        r101 = r101 / 1024.0f;
        r102 = "PB";
    L28:
        return String.format("%.2f", new Object[]{Float.valueOf(r101)}) + r102;
    L5:
        r101 = 0.0f;
        goto L6
    }

    public static String b(String r110) {
        tt5.a.b("FilePropsUtil", "getExtWithDot: name=" + r110);
        String r100 = "";
        if (TextUtils.isEmpty(r110) == false) goto L21;
        return "";
    L21:
        int r101 = r110.lastIndexOf(".");     // Catch: Exception -> L17
        if (r101 != (-1)) goto L9;
        return "";
    L9:
        String[] r102 = f243143a;     // Catch: Exception -> L17
        int r103 = r102.length;     // Catch: Exception -> L17
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        String r105 = "." + r102[r104];     // Catch: Exception -> L17
        if (r110.endsWith(r105) == true) goto L13;
        r104 = r104 + 1;     // Catch: Exception -> L17
        goto L10
    L13:
        return r105;
    L15:
        r100 = r110.substring(r101);     // Catch: Exception -> L17
    L19:
        tt5.a.k("FilePropsUtil", "FilePropsUtil.getExtWithDot=" + r100);
        return r100;
    L17:
        e = move-exception;
        tt5.a.f("FilePropsUtil", e, false);
        goto L19
    }

    public static String c(String r110) {
        tt5.a.b("FilePropsUtil", "getExtension: name=" + r110);
        String r100 = "";
        if (TextUtils.isEmpty(r110) == false) goto L24;
        return "";
    L24:
        int r101 = r110.lastIndexOf(".");     // Catch: Exception -> L20
        if (r101 != (-1)) goto L10;
        return "";
    L10:
        String[] r102 = f243143a;
        int r103 = r102.length;     // Catch: Exception -> L20
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L18;
        if (r110.endsWith("." + r102[r104]) == true) goto L16;
        r104 = r104 + 1;     // Catch: Exception -> L20
        goto L12
    L16:
        return r102[r104];
    L18:
        r100 = r110.substring(r101 + 1);     // Catch: Exception -> L20
    L22:
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getExtension: extension=" + r100);
        return r100;
    L20:
        e = move-exception;
        tt5.a.f("FilePropsUtil", e, false);
        goto L22
    }

    public static String d(String r110) {
        tt5.a.b("FilePropsUtil", "getFileNameWithoutExtension: fullName=" + r110);
        if (TextUtils.isEmpty(r110) == false) goto L6;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameWithoutExtension: fullName is empty");
        return "";
    L6:
        int r100 = r110.lastIndexOf(".");
        if (r100 != (-1)) goto L10;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameWithoutExtension: DOT index is invalid");
        return r110;
    L10:
        if (r100 != 0) goto L13;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameWithoutExtension: DOT index is zero");
        return "";
    L13:
        String[] r101 = f243143a;
        int r102 = r101.length;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L24;
        String r104 = r101[r103];
        if (r110.endsWith("." + r104) == false) goto L18;
        r100 = r110.length() - (r104.length() + 1);
    L18:
        r103 = r103 + 1;
        goto L14
    L24:
        return r110.substring(0, r100);
    L21:
        e = move-exception;
        tt5.a.e("FilePropsUtil", "getFileNameWithoutExtension: ", e, false);
        return "";
    }

    public static String e(long r100) {
        if (r100 >= 0) goto L6;
        return "";
    L6:
        String[] r101 = {"B", "K", "M", "G"};
        double r102 = r100;
        int r103 = 0;
    L8:
        if (r103 >= 4) goto L15;
        String r104 = r101[r103];
        if (r102 < 1024.0d) goto L12;
        r102 = r102 / 1024.0d;
        r103 = r103 + 1;
        goto L8
    L12:
        return (Math.round(r102 * 100.0d) / 100.0d) + " " + r104;
    L15:
        return (Math.round(r102 * 100.0d) / 100.0d) + " " + r101[3];
    }
}
