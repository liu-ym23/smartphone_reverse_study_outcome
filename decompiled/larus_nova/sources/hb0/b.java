package hb0;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static String a(String r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append(" failed: ");
        switch(r101) {
            case 12288: goto L19;
            case 12289: goto L18;
            case 12290: goto L17;
            case 12291: goto L16;
            case 12292: goto L15;
            case 12293: goto L14;
            case 12294: goto L13;
            case 12295: goto L12;
            case 12296: goto L11;
            case 12297: goto L10;
            case 12298: goto L9;
            case 12299: goto L8;
            case 12300: goto L7;
            case 12301: goto L6;
            case 12302: goto L5;
            default: goto L20;
        };
    L5:
        String r103 = "EGL_CONTEXT_LOST";
    L21:
        r102.append(r103);
        return r102.toString();
    L6:
        r103 = "EGL_BAD_SURFACE";
        goto L21
    L7:
        r103 = "EGL_BAD_PARAMETER";
        goto L21
    L8:
        r103 = "EGL_BAD_NATIVE_WINDOW";
        goto L21
    L9:
        r103 = "EGL_BAD_NATIVE_PIXMAP";
        goto L21
    L10:
        r103 = "EGL_BAD_MATCH";
        goto L21
    L11:
        r103 = "EGL_BAD_DISPLAY";
        goto L21
    L12:
        r103 = "EGL_BAD_CURRENT_SURFACE";
        goto L21
    L13:
        r103 = "EGL_BAD_CONTEXT";
        goto L21
    L14:
        r103 = "EGL_BAD_CONFIG";
        goto L21
    L15:
        r103 = "EGL_BAD_ATTRIBUTE";
        goto L21
    L16:
        r103 = "EGL_BAD_ALLOC";
        goto L21
    L17:
        r103 = "EGL_BAD_ACCESS";
        goto L21
    L18:
        r103 = "EGL_NOT_INITIALIZED";
        goto L21
    L19:
        r103 = "EGL_SUCCESS";
        goto L21
    L20:
        r103 = "0x" + Integer.toHexString(r101);
        goto L21
    }
}
