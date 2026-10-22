package com.xiaomi.push;

import java.util.Random;

/* JADX INFO: loaded from: classes41.dex */
public class fw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Random f463624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final char[] f594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f463625b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f463626c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f463627d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f463628e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static char[] f463629f;

    static {
        f594a = "&quot;".toCharArray();
        f463625b = "&apos;".toCharArray();
        f463626c = "&amp;".toCharArray();
        f463627d = "&lt;".toCharArray();
        f463628e = "&gt;".toCharArray();
        f463624a = new Random();
        f463629f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        StringBuilder r103 = new StringBuilder((int) (((double) r102) * 1.3d));
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r102) goto L47;
        char r106 = r101[r104];
        if (r106 > '>') goto L46;
        if (r106 != '<') goto L15;
        if (r104 <= r105) goto L14;
        r103.append(r101, r105, r104 - r105);
    L14:
        r105 = r104 + 1;
        r103.append(f463627d);
        goto L46
    L15:
        if (r106 != '>') goto L20;
        if (r104 <= r105) goto L18;
        r103.append(r101, r105, r104 - r105);
    L18:
        r105 = r104 + 1;
        r103.append(f463628e);
        goto L46
    L20:
        if (r106 != '&') goto L37;
        if (r104 <= r105) goto L23;
        r103.append(r101, r105, r104 - r105);
    L23:
        int r107 = r104 + 5;
        if (r102 > r107) goto L26;
    L35:
        r105 = r104 + 1;
        r103.append(f463626c);
        goto L46
    L26:
        if (r101[r104 + 1] != '#') goto L35;
        if (Character.isDigit(r101[r104 + 2]) == false) goto L35;
        if (Character.isDigit(r101[r104 + 3]) == false) goto L35;
        if (Character.isDigit(r101[r104 + 4]) == false) goto L35;
        if (r101[r107] == ';') goto L46;
    L37:
        if (r106 != '\"') goto L42;
        if (r104 <= r105) goto L40;
        r103.append(r101, r105, r104 - r105);
    L40:
        r105 = r104 + 1;
        r103.append(f594a);
        goto L46
    L42:
        if (r106 != '\'') goto L46;
        if (r104 <= r105) goto L45;
        r103.append(r101, r105, r104 - r105);
    L45:
        r105 = r104 + 1;
        r103.append(f463625b);
    L46:
        r104 = r104 + 1;
        goto L6
    L47:
        if (r105 != 0) goto L49;
        return r100;
    L49:
        if (r104 <= r105) goto L52;
        r103.append(r101, r105, r104 - r105);
    L52:
        return r103.toString();
    }

    public static final String b(String r100) {
        return a(a(a(a(a(r100, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    public static String a(int r100) {
        if (r100 >= 1) goto L6;
        return null;
    L6:
        char[] r101 = new char[r100];
        int r102 = 0;
    L7:
        if (r102 >= r100) goto L10;
        r101[r102] = f463629f[f463624a.nextInt(71)];
        r102 = r102 + 1;
        goto L7
    L10:
        return new String(r101);
    }

    public static String a(byte[] r100) {
        return String.valueOf(ax.a(r100));
    }

    public static final String a(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r103 = r100.indexOf(r101, 0);
        if (r103 < 0) goto L14;
        char[] r104 = r100.toCharArray();
        char[] r105 = r102.toCharArray();
        int r106 = r101.length();
        StringBuilder r107 = new StringBuilder(r104.length);
        r107.append(r104, 0, r103);
        r107.append(r105);
        int r108 = r103 + r106;
    L8:
        int r109 = r100.indexOf(r101, r108);
        if (r109 <= 0) goto L11;
        r107.append(r104, r108, r109 - r108);
        r107.append(r105);
        r108 = r109 + r106;
        goto L8
    L11:
        r107.append(r104, r108, r104.length - r108);
        return r107.toString();
    L14:
        return r100;
    }
}
