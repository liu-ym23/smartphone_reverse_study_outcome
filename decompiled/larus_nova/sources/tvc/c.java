package tvc;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public final class c {
    public static int a(CharSequence r100, int r101) {
        if (r101 < r100.length()) goto L6;
        return -1;
    L6:
        if (r100.charAt(r101) != '<') goto L22;
    L7:
        r101 = r101 + 1;
        if (r101 >= r100.length()) goto L21;
        char r102 = r100.charAt(r101);
        if (r102 == '\n') goto L21;
        if (r102 == '<') goto L21;
        if (r102 == '>') goto L20;
        if (r102 != '\\') goto L7;
        int r103 = r101 + 1;
        if (d.a(r100, r103) == false) goto L7;
        r101 = r103;
        goto L7
    L20:
        return r101 + 1;
    L21:
        return -1;
    L22:
        int r104 = 0;
        int r105 = r101;
    L24:
        if (r105 >= r100.length()) goto L51;
        char r106 = r100.charAt(r105);
        if (r106 == 0) goto L48;
        if (r106 == ' ') goto L48;
        if (r106 != '\\') goto L31;
        int r107 = r105 + 1;
        if (d.a(r100, r107) == false) goto L47;
        r105 = r107;
    L47:
        r105 = r105 + 1;
        goto L24
    L31:
        if (r106 != '(') goto L33;
        r104 = r104 + 1;
        if (r104 <= 32) goto L47;
        return -1;
    L33:
        if (r106 != ')') goto L35;
        if (r104 == 0) goto L74;
        r104 = r104 - 1;
    L74:
        return r105;
    L35:
        if (Character.isISOControl(r106) == false) goto L47;
        if (r105 != r101) goto L74;
        return -1;
    L48:
        if (r105 != r101) goto L74;
        return -1;
    L51:
        return r100.length();
    }

    public static int b(CharSequence r100, int r101) {
    L3:
        if (r101 >= r100.length()) goto L15;
        switch(r100.charAt(r101)) {
            case 91: goto L11;
            case 92: goto L8;
            case 93: goto L7;
            default: goto L13;
        };
    L8:
        int r102 = r101 + 1;
        if (d.a(r100, r102) == false) goto L13;
        r101 = r102;
        goto L13
    L7:
        return r101;
    L11:
        return -1;
    L13:
        r101 = r101 + 1;
        goto L3
    L15:
        return r100.length();
    }

    public static int c(CharSequence r100, int r101) {
        String r102 = (String) r100;
        if (r101 < r102.length()) goto L5;
        return -1;
    L5:
        char r103 = r102.charAt(r101);
        char r104 = Typography.quote;
        if (r103 == '\"') goto L13;
        r104 = '\'';
        if (r103 == '\'') goto L13;
        if (r103 == '(') goto L12;
        return -1;
    L12:
        r104 = ')';
    L13:
        int r105 = d(r102, r101 + 1, r104);
        if (r105 != (-1)) goto L17;
        return -1;
    L17:
        if (r105 < r102.length()) goto L19;
    L23:
        return -1;
    L19:
        if (r102.charAt(r105) != r104) goto L23;
        return r105 + 1;
    }

    public static int d(CharSequence r100, int r101, char r102) {
    L3:
        if (r101 >= r100.length()) goto L19;
        char r103 = r100.charAt(r101);
        if (r103 != '\\') goto L9;
        int r104 = r101 + 1;
        if (d.a(r100, r104) == false) goto L9;
        r101 = r104;
    L17:
        r101 = r101 + 1;
    L9:
        if (r103 == r102) goto L10;
        if (r102 != ')') goto L17;
        if (r103 != '(') goto L17;
        return -1;
    L10:
        return r101;
    L19:
        return r100.length();
    }
}
