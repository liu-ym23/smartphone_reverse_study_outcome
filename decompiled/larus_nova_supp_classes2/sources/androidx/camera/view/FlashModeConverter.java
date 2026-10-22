package androidx.camera.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static String nameOf(int r3) {
        if (r3 != 0) goto L4;
        return "AUTO";
    L4:
        if (r3 != 1) goto L6;
        return "ON";
    L6:
        if (r3 != 2) goto L10;
        return "OFF";
    L10:
        throw new IllegalArgumentException("Unknown flash mode " + r3);
    }

    public static int valueOf(String r5) {
        if (r5 == null) goto L25;
        byte r4 = -1;
        switch(r5.hashCode()) {
            case 2527: goto L15;
            case 78159: goto L11;
            case 2020783: goto L7;
            default: goto L18;
        };
    L18:
        switch(r4) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L20;
        };
    L21:
        return 0;
    L22:
        return 2;
    L23:
        return 1;
    L20:
        throw new IllegalArgumentException("Unknown flash mode name ".concat(r5));
    L7:
        if (r5.equals("AUTO") == false) goto L18;
        r4 = 2;
        goto L18
    L11:
        if (r5.equals("OFF") == false) goto L18;
        r4 = 1;
        goto L18
    L15:
        if (r5.equals("ON") == false) goto L18;
        r4 = 0;
        goto L18
    L25:
        throw new NullPointerException("name cannot be null");
    }
}
