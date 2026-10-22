package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes32.dex */
public class ColorUtils {
    public ColorUtils() {
    }

    private static native int nativeParse(String r100);

    private static native boolean nativeValidate(String r100);

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return false;
    L7:
        return nativeValidate(r100);
    }

    public static int b(String r100) {
        if (android.text.TextUtils.isEmpty(r100) == false) goto L7;
        return 0;
    L7:
        return nativeParse(r100);
    }
}
