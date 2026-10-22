package zg4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f572084a = null;

    static {
        String r100 = "cnNoasanInnerFull".toLowerCase();
        String r101 = null;
        String[] r102 = "4.2.2-rc.9".split("-");     // Catch: Throwable -> L32
        String r103 = "";
        int r104 = 1;
        if (r102.length != 2) goto L6;
        r103 = "4.2.2-rc.9".split("-")[1];     // Catch: Throwable -> L32
    L6:
        String r105 = r102[0];     // Catch: Throwable -> L32
        if (r105 != null) goto L10;
        r105 = null;
    L21:
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L32
        r106.append(r105);     // Catch: Throwable -> L32
        if (r100.contains("oversea") == false) goto L25;
        r106.append(".oversea");     // Catch: Throwable -> L32
    L25:
        if (r100.contains("lite") == false) goto L28;
        r106.append(".lite");     // Catch: Throwable -> L32
    L28:
        if (TextUtils.isEmpty(r103) == true) goto L30;
        r106.append("-");     // Catch: Throwable -> L32
        r106.append(r103);     // Catch: Throwable -> L32
    L30:
        r101 = r106.toString();     // Catch: Throwable -> L32
    L35:
        if (TextUtils.isEmpty(r101) == true) goto L37;
        f572084a = r101;
        return;
    L37:
        f572084a = "4.2.2-rc.9";
        return;
    L10:
        if (Character.isDigit(r105.charAt(r105.length() - 1)) == true) goto L21;
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L32
        char r108 = r105.charAt(0);     // Catch: Throwable -> L32
    L14:
        if (r104 >= r105.length()) goto L20;
        char r109 = r105.charAt(r104);     // Catch: Throwable -> L32
        if (Character.isDigit(r105.charAt(r104)) == true) goto L19;
        if (r109 != '.') goto L20;
    L19:
        r107.append(r108);     // Catch: Throwable -> L32
        r104 = r104 + 1;     // Catch: Throwable -> L32
        r108 = r109;
    L20:
        r105 = r107.toString();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.toString();
        goto L35
    }
}
