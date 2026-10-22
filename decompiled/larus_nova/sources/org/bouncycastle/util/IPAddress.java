package org.bouncycastle.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes42.dex */
public class IPAddress {
    public IPAddress() {
    }

    private static boolean isMaskValue(String r100, int r101) {
        int r102 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L8
        if (r102 < 0) goto L11;
        if (r102 > r101) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L13:
        return false;
    }

    public static boolean isValid(String r100) {
        if (isValidIPv4(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isValidIPv6(r100) == true) goto L8;
        return false;
    }

    public static boolean isValidIPv4(String r100) {
        if (r100.length() != 0) goto L5;
        return false;
    L5:
        String r101 = r100.concat(".");
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r101.length()) goto L19;
        int r104 = r101.indexOf(46, r102);
        if (r104 <= r102) goto L19;
        if (r103 == 4) goto L11;
        int r105 = CastIntegerProtector.parseInt(r101.substring(r102, r104));     // Catch: NumberFormatException -> L22
        if (r105 < 0) goto L18;
        if (r105 > 255) goto L18;
        r102 = r104 + 1;
        r103 = r103 + 1;
    L18:
        return false;
    L11:
        return false;
    L19:
        if (r103 != 4) goto L30;
        return true;
    L30:
        return false;
    }

    public static boolean isValidIPv4WithNetmask(String r100) {
        int r101 = r100.indexOf(HTTP.URL_DEFAULT);
        String r102 = r100.substring(r101 + 1);
        if (r101 > 0) goto L5;
        return false;
    L5:
        if (isValidIPv4(r100.substring(0, r101)) == true) goto L7;
        return false;
    L7:
        if (isValidIPv4(r102) == false) goto L9;
    L10:
        return true;
    L9:
        if (isMaskValue(r102, 32) == true) goto L10;
        return false;
    }

    public static boolean isValidIPv6(String r100) {
        if (r100.length() != 0) goto L5;
        return false;
    L5:
        String r101 = r100.concat(":");
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L7:
        if (r102 >= r101.length()) goto L33;
        int r105 = r101.indexOf(58, r102);
        if (r105 < r102) goto L33;
        if (r103 == 8) goto L11;
        if (r102 == r105) goto L26;
        String r106 = r101.substring(r102, r105);
        if (r105 == (r101.length() - 1)) goto L16;
    L38:
        int r107 = CastIntegerProtector.parseInt(r101.substring(r102, r105), 16);     // Catch: NumberFormatException -> L37
        if (r107 < 0) goto L25;
        if (r107 > 65535) goto L25;
    L32:
        r102 = r105 + 1;
        r103 = r103 + 1;
    L25:
        return false;
    L16:
        if (r106.indexOf(46) <= 0) goto L38;
        if (isValidIPv4(r106) == false) goto L19;
        r103 = r103 + 1;
        goto L32
    L19:
        return false;
    L26:
        if (r105 != 1) goto L28;
    L31:
        r104 = true;
        goto L32
    L28:
        if (r105 == (r101.length() - 1)) goto L31;
        if (r104 == false) goto L31;
        return false;
    L11:
        return false;
    L33:
        if (r103 == 8) goto L35;
        if (r104 == true) goto L35;
        return false;
    L35:
        return true;
    }

    public static boolean isValidIPv6WithNetmask(String r100) {
        int r101 = r100.indexOf(HTTP.URL_DEFAULT);
        String r102 = r100.substring(r101 + 1);
        if (r101 > 0) goto L5;
        return false;
    L5:
        if (isValidIPv6(r100.substring(0, r101)) == true) goto L7;
        return false;
    L7:
        if (isValidIPv6(r102) == false) goto L9;
    L10:
        return true;
    L9:
        if (isMaskValue(r102, 128) == true) goto L10;
        return false;
    }

    public static boolean isValidWithNetMask(String r100) {
        if (isValidIPv4WithNetmask(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isValidIPv6WithNetmask(r100) == true) goto L8;
        return false;
    }
}
