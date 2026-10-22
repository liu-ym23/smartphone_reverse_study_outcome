package yb0;

import java.util.Locale;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567059a = 0;

    public a() {
    }

    static {
    }

    public static String a(String r110, String r111) {
        int r100 = 1;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return "";
    L12:
        if (r111.length() != 0) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == true) goto L88;
        if (r110 != null) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == false) goto L25;
    L55:
        boolean r104 = true;
    L56:
        String r105 = "";
    L58:
        if (r105.length() != 0) goto L60;
        boolean r106 = true;
    L61:
        if (r106 == true) goto L89;
        StringBuilder r107 = new StringBuilder();
        int r108 = r111.length();
        int r109 = 0;
    L64:
        if (r109 >= r108) goto L69;
        char r112 = r111.charAt(r109);
        if (Character.isLetterOrDigit(r112) == false) goto L68;
        r107.append(r112);
    L68:
        r109 = r109 + 1;
        goto L64
    L69:
        int r113 = r107.toString().length();
        if (r113 > 0) goto L72;
    L74:
        r104 = false;
    L75:
        if (r104 == true) goto L77;
        return "";
    L77:
        if (r105.length() >= 2) goto L80;
        return "";
    L80:
        return r105;
    L72:
        if ((((double) r105.length()) / ((double) r113)) < 0.5d) goto L74;
    L89:
        return "";
    L60:
        r106 = false;
        goto L61
    L25:
        if (r111.length() != 0) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == true) goto L55;
        if (r110 == null) goto L54;
        Locale r115 = Locale.ROOT;
        String r116 = r110.toLowerCase(r115);
        String r117 = r111.toLowerCase(r115);
        int r118 = r116.length();
        int r119 = r117.length();
        int[] r120 = new int[r119 + 1];
        int r121 = -1;
        if (1 > r118) goto L48;
        int r122 = 0;
        int r123 = 1;
    L34:
        if (r100 > r119) goto L45;
        int r124 = 1;
        int r125 = 0;
    L36:
        int r126 = r120[r124];
        if (r116.charAt(r123 - 1) != r117.charAt(r124 - 1)) goto L42;
        r104 = true;
        int r127 = r125 + 1;
        r120[r124] = r127;
        if (r127 <= r122) goto L43;
        r121 = r123;
        r122 = r127;
    L43:
        if (r124 == r119) goto L46;
        r124 = r124 + 1;
        r125 = r126;
    L46:
        if (r123 == r118) goto L49;
        r123 = r123 + 1;
        r100 = 1;
    L49:
        if (r122 == 0) goto L56;
        if (r121 <= 0) goto L56;
        r105 = r110.substring(r121 - r122, r121);
        goto L58
    L42:
        r104 = true;
        r120[r124] = 0;
        goto L43
    L45:
        r104 = true;
        goto L46
    L48:
        r104 = true;
        r122 = 0;
        goto L49
    L54:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        r114 = false;
        goto L28
    L19:
        if (r110.length() == 0) goto L22;
        r103 = false;
        goto L23
    L88:
        return "";
    L14:
        r102 = false;
        goto L15
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L10
    }
}
