package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public class IPAddressUtils {
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = null;
    private static final Pattern IPV6_STD_PATTERN = null;
    private static Pattern ipv4Pattern;

    public IPAddressUtils() {
    }

    static {
        ipv4Pattern = PatternProtector.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        IPV6_STD_PATTERN = PatternProtector.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        IPV6_HEX_COMPRESSED_PATTERN = PatternProtector.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean isIpv6HexCompressedAddress(String r100) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(r100).matches();
    L4:
        return false;
    }

    public static boolean isIpv6StdAddress(String r100) {
        return IPV6_STD_PATTERN.matcher(r100).matches();
    L4:
        return false;
    }

    public static boolean isValidIpv4(String r100) {
        if (r100 != null) goto L46;
        return false;
    L46:
        if (r100.length() >= 7) goto L8;
        return false;
    L8:
        if (r100.length() <= 15) goto L10;
        return false;
    L10:
        if (r100.equals("") == true) goto L51;
        if (ipv4Pattern.matcher(r100).matches() == false) goto L52;
        return true;
    L52:
        return false;
    L51:
        return false;
    L44:
        int r101 = r100.indexOf(46);     // Catch: Exception -> L43
        if (r101 != (-1)) goto L18;
        return false;
    L18:
        if (r100.charAt(0) != '-') goto L20;
        return false;
    L20:
        if (CastIntegerProtector.parseInt(r100.substring(0, r101)) > 255) goto L56;
        int r102 = r101 + 1;     // Catch: Exception -> L43
        int r103 = r100.indexOf(46, r102);     // Catch: Exception -> L43
        if (r103 != (-1)) goto L25;
        return false;
    L25:
        if (r100.charAt(r102) != '-') goto L27;
        return false;
    L27:
        if (CastIntegerProtector.parseInt(r100.substring(r102, r103)) > 255) goto L59;
        int r104 = r103 + 1;     // Catch: Exception -> L43
        int r105 = r100.indexOf(46, r104);     // Catch: Exception -> L43
        if (r105 != (-1)) goto L32;
        return false;
    L32:
        if (r100.charAt(r104) != '-') goto L34;
        return false;
    L34:
        if (CastIntegerProtector.parseInt(r100.substring(r104, r105)) > 255) goto L62;
        int r106 = r105 + 1;     // Catch: Exception -> L43
        if (r100.charAt(r106) != '-') goto L38;
        return false;
    L38:
        if (CastIntegerProtector.parseInt(r100.substring(r106, r100.length())) > 255) goto L64;
        if (r100.charAt(r100.length() - 1) == '.') goto L65;
        return true;
    L65:
        return false;
    L64:
        return false;
    L62:
        return false;
    L59:
        return false;
    L56:
        return false;
    L66:
        return false;
    }

    public static boolean isValidIpv6(String r100) {
        if (isIpv6StdAddress(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isIpv6HexCompressedAddress(r100) == true) goto L8;
        return false;
    }
}
