package fjc;

/* JADX INFO: loaded from: classes40.dex */
public final class f {
    public static String a(int r100) {
        switch(r100) {
            case -1: goto L35;
            case 0: goto L33;
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            case 14: goto L5;
            default: goto L4;
        };
    L5:
        return "SCREEN_ORIENTATION_LOCKED";
    L7:
        return "SCREEN_ORIENTATION_FULL_USER";
    L9:
        return "SCREEN_ORIENTATION_USER_PORTRAIT";
    L11:
        return "SCREEN_ORIENTATION_USER_LANDSCAPE";
    L13:
        return "SCREEN_ORIENTATION_FULL_SENSOR";
    L15:
        return "SCREEN_ORIENTATION_REVERSE_PORTRAIT";
    L17:
        return "SCREEN_ORIENTATION_REVERSE_LANDSCAPE";
    L19:
        return "SCREEN_ORIENTATION_SENSOR_PORTRAIT";
    L21:
        return "SCREEN_ORIENTATION_SENSOR_LANDSCAPE";
    L23:
        return "SCREEN_ORIENTATION_NOSENSOR";
    L25:
        return "SCREEN_ORIENTATION_SENSOR";
    L27:
        return "SCREEN_ORIENTATION_BEHIND";
    L29:
        return "SCREEN_ORIENTATION_USER";
    L31:
        return "SCREEN_ORIENTATION_PORTRAIT";
    L33:
        return "SCREEN_ORIENTATION_LANDSCAPE";
    L35:
        return "SCREEN_ORIENTATION_UNSPECIFIED";
    L4:
        return Integer.toString(r100);
    }
}
