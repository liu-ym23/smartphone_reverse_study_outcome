package com.huawei.hms.framework.common;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
public class CheckParamUtils {
    private static final String IPV6_REGEX = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    private static final String TAG = "CheckParamUtils";
    private static Pattern ipv6Pattern;

    public CheckParamUtils() {
    }

    static {
        ipv6Pattern = PatternProtector.compile(IPV6_REGEX);
    }

    public static boolean isIpV4(String r100) {
        if (r100 != null) goto L5;
    L26:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L26;
        if (r100.length() > 15) goto L26;
        if (r100.replace(".", "").matches("[0-9]+") == true) goto L12;
        return false;
    L12:
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length == 4) goto L15;
        return false;
    L15:
        int r102 = r101.length;
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L24;
        String r104 = r101[r103];
        if (r104.length() > 4) goto L23;
        if (CastIntegerProtector.parseInt(r104) > 255) goto L23;
        r103 = r103 + 1;
    L23:
        return false;
    L24:
        return true;
    }

    public static boolean isIpV6(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r100.length() >= 2) goto L8;
        return false;
    L8:
        if (r100.length() <= 39) goto L11;
        return false;
    L11:
        return ipv6Pattern.matcher(r100).matches();
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static void checkOffsetAndCount(long r100, long r101, long r102) {
        if ((r101 | r102) < 0) goto L10;
        if (r101 > r100) goto L10;
        if ((r100 - r101) < r102) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static long checkNumParam(long r100, long r101, long r102, long r103, String r104) {
        if (r100 <= r102) goto L5;
    L9:
        return r103;
    L5:
        if (r100 < r101) goto L9;
        Logger.d(TAG, r104);
        return r100;
    }

    public static int checkNumParam(int r100, int r101, int r102, int r103, String r104) {
        if (r100 > r102) goto L7;
        if (r100 < r101) goto L7;
        Logger.d(TAG, r104);
        return r100;
    L7:
        return r103;
    }
}
