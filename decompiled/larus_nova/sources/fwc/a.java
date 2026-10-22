package fwc;

import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static String a(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toLowerCase(Locale.ENGLISH);
    }

    public static String b(String r100) {
        return a(r100).trim();
    }
}
