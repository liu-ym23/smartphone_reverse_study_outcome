package u7b;

import kotlin.text.Typography;
import x7b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static boolean a(char r100) {
        switch(r100) {
            case 33: goto L8;
            case 34: goto L8;
            case 35: goto L8;
            case 36: goto L8;
            case 37: goto L8;
            case 38: goto L8;
            case 39: goto L8;
            case 40: goto L8;
            case 41: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 44: goto L8;
            case 45: goto L8;
            case 46: goto L8;
            case 47: goto L8;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 58: goto L10;
            case 59: goto L10;
            case 60: goto L10;
            case 61: goto L10;
            case 62: goto L10;
            case 63: goto L10;
            case 64: goto L10;
            default: goto L4;
        };
    L4:
        switch(r100) {
            case 91: goto L11;
            case 92: goto L11;
            case 93: goto L11;
            case 94: goto L11;
            case 95: goto L11;
            case 96: goto L11;
            default: goto L5;
        };
    L5:
        switch(r100) {
            case 123: goto L12;
            case 124: goto L12;
            case 125: goto L12;
            case 126: goto L12;
            default: goto L6;
        };
    L6:
        return false;
    L12:
        return true;
    L11:
        return true;
    L10:
        return true;
    L8:
        return true;
    }

    public static boolean b(e r100) {
        if (r100.d() == true) goto L6;
        return false;
    L6:
        if (r100.h(Typography.less) == true) goto L8;
        int r101 = 0;
        boolean r102 = true;
    L24:
        if (r100.d() == false) goto L48;
        char r103 = r100.j();
        if (r103 == ' ') goto L71;
        if (r103 != '\\') goto L29;
        r100.g();
        if (a(r100.j()) == false) goto L46;
        r100.g();
    L46:
        r102 = false;
        goto L24
    L29:
        if (r103 != '(') goto L31;
        r101 = r101 + 1;
        if (r101 > 32) goto L72;
        r100.g();
        goto L46
    L72:
        return false;
    L31:
        if (r103 != ')') goto L33;
        if (r101 == 0) goto L48;
        r101 = r101 - 1;
        r100.g();
        goto L46
    L33:
        if (Character.isISOControl(r103) == true) goto L71;
        r100.g();
    L71:
        return !r102;
    L48:
        return true;
    L8:
        if (r100.d() == false) goto L21;
        char r104 = r100.j();
        if (r104 == '\n') goto L21;
        if (r104 == '<') goto L21;
        if (r104 == '>') goto L19;
        if (r104 != '\\') goto L15;
        r100.g();
        if (a(r100.j()) == false) goto L8;
        r100.g();
        goto L8
    L15:
        r100.g();
        goto L8
    L19:
        r100.g();
        return true;
    L21:
        return false;
    }

    public static boolean c(e r100) {
    L3:
        if (r100.d() == false) goto L13;
        switch(r100.j()) {
            case 91: goto L11;
            case 92: goto L8;
            case 93: goto L7;
            default: goto L6;
        };
    L7:
        return true;
    L8:
        r100.g();
        if (a(r100.j()) == false) goto L3;
        r100.g();
        goto L3
    L11:
        return false;
    L6:
        r100.g();
        goto L3
    L13:
        return true;
    }

    public static boolean d(e r100, char r101) {
    L3:
        if (r100.d() == false) goto L18;
        char r102 = r100.j();
        if (r102 == '\\') goto L6;
        if (r102 == r101) goto L10;
        if (r101 == ')') goto L14;
    L17:
        r100.g();
        goto L3
    L14:
        if (r102 != '(') goto L17;
        return false;
    L10:
        return true;
    L6:
        r100.g();
        if (a(r100.j()) == false) goto L3;
        r100.g();
        goto L3
    L18:
        return true;
    }
}
