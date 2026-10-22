package com.unicom.online.account.kernel;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f462062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f462063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f462064c;

    static {
        f462062a = "l";
        f462063b = 0;
        f462064c = 0;
    }

    public l() {
    }

    public static String a(Context r100) {
        if (f462064c > 0) goto L5;
        return null;
    L5:
        String r101 = b();
        return m.a(r100, a(r101, r101));
    L8:
        f462064c = 0;
        return null;
    }

    private static String a(String r100, String r101) {
        return "OAlog" + r100 + r101;
    }

    private static void a() {
        int r100 = f462064c;
        if (r100 <= 0) goto L7;
        int r101 = r100 - 1;
    L5:
        f462064c = r101;
        return;
    L7:
        r101 = 0;
        goto L5
    }

    public static void a(Context r100, int r101) {
        String r102 = b();
        if (r101 != 0) goto L5;
        r102 = f462062a + f462063b;
    L5:
        m.c(r100, a(r102, r102));
        a();
    }

    public static boolean a(Context r100, String r101) {
        boolean r102 = false;
        if (f462064c >= 20) goto L5;
    L8:
        int r103 = f462064c;
        if (r103 < 0) goto L11;
        f462064c = r103 + 1;
    L12:
        String r104 = b();
        if (an.b(r101).booleanValue() == false) goto L19;
        String r105 = a(r104, r104);
        if (an.b(r105).booleanValue() == false) goto L19;
        r102 = m.a(r100, r105, r101);
        if (r102 == true) goto L19;
        a();
    L19:
        return r102;
    L11:
        f462064c = 0;
        goto L12
    L5:
        if (f462063b <= 2147483627) goto L7;
        m.d(r100, "OAlog");
        f462063b = 0;
        f462064c = 0;
        goto L8
    L7:
        a(r100, 0);
        f462063b++;
        goto L8
    }

    private static String b() {
        StringBuilder r100 = new StringBuilder();
        r100.append(f462062a);
        r100.append((f462063b + f462064c) - 1);
        return r100.toString();
    }
}
