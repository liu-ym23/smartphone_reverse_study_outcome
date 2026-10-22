package v88;

import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static final boolean a(Integer r100) {
        if (b(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (c(r100) == true) goto L8;
        return false;
    }

    public static final boolean b(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.intValue() != 11) goto L7;
        return true;
    }

    public static final boolean c(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r100 != null) goto L13;
    L15:
        return false;
    L13:
        if (r100.intValue() != 32) goto L15;
    L16:
        return true;
    L9:
        if (r100.intValue() == 7) goto L16;
    L5:
        if (r100.intValue() == 6) goto L16;
        goto L6
    }

    public static final boolean d(int r100) {
        return SetsKt.setOf(new Integer[]{13, 14, 15, 16, 17}).contains(Integer.valueOf(r100));
    }

    public static final boolean e(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r100 != null) goto L13;
    L15:
        return false;
    L13:
        if (r100.intValue() != 10) goto L15;
    L16:
        return true;
    L9:
        if (r100.intValue() == 9) goto L16;
    L5:
        if (r100.intValue() == 8) goto L16;
        goto L6
    }

    public static final boolean f(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.intValue() != 21) goto L11;
    L12:
        return true;
    L5:
        if (r100.intValue() == 2) goto L12;
        goto L6
    }

    public static final boolean g(int r100) {
        if (SetsKt.setOf(new Integer[]{1, 3, 5, 6, 7, 8, 9, 10, 11, 18}).contains(Integer.valueOf(r100)) == false) goto L5;
        return true;
    L5:
        if (a(Integer.valueOf(r100)) == false) goto L7;
        return true;
    L7:
        if (e(Integer.valueOf(r100)) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final String h(int r100) {
        if (r100 != 21) goto L5;
        return "WakeMode.GESTURE_NOTE";
    L5:
        if (r100 == 32) goto L26;
        switch(r100) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L29;
        };
    L9:
        return "WakeMode.RECORD_MINUTES_CALL";
    L10:
        return "WakeMode.RECORD_MINUTES_GUI";
    L11:
        return "WakeMode.RECORD_MINUTES_GESTURE";
    L12:
        return "WakeMode.RECORD_MINUTES_VUI";
    L13:
        return "WakeMode.RECORD_MINUTES_IM";
    L29:
        return "WakeMode Undefined: " + r100;
    L14:
        return "WakeMode.ENV_OBSERVE";
    L15:
        return "WakeMode.SI_By_GESTURE";
    L16:
        return "WakeMode.SI_By_VUI";
    L17:
        return "WakeMode.SI_By_GUI";
    L18:
        return "WakeMode.LIVE_AI_TOUCH";
    L19:
        return "WakeMode.LIVE_AI_VOICE";
    L20:
        return "WakeMode.EXPLORE";
    L21:
        return "WakeMode.ONBOARDING";
    L22:
        return "WakeMode.KEY";
    L23:
        return "WakeMode.RADIO";
    L24:
        return "WakeMode.VOICE";
    L25:
        return "WakeMode.INVALID";
    L26:
        return "WakeMode.LIVE_AI_VIDEO_STREAM";
    }
}
