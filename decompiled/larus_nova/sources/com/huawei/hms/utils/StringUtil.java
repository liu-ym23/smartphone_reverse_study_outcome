package com.huawei.hms.utils;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
public class StringUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f277912a = null;

    static {
        f277912a = PatternProtector.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)");
    }

    private StringUtil() {
    }

    public static boolean checkVersion(String r100) {
        return f277912a.matcher(r100).find();
    }

    public static int convertVersion2Integer(String r100) {
        if (checkVersion(r100) == false) goto L11;
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length >= 3) goto L7;
        return 0;
    L7:
        int r102 = ((CastIntegerProtector.parseInt(r101[0]) * 10000000) + (CastIntegerProtector.parseInt(r101[1]) * 100000)) + (CastIntegerProtector.parseInt(r101[2]) * 1000);
        if (r101.length == 4) goto L10;
        return r102;
    L10:
        return r102 + CastIntegerProtector.parseInt(r101[3]);
    L11:
        return 0;
    }

    public static String objDesc(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        return r100.getClass().getName() + '@' + Integer.toHexString(r100.hashCode());
    }

    public static String addByteForNum(String r100, int r101, char r102) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        int r103 = r100.length();
        if (r103 != r101) goto L7;
        return r100;
    L7:
        if (r103 > r101) goto L9;
        StringBuffer r104 = new StringBuffer();
    L11:
        if (r103 >= r101) goto L13;
        r104.append(r102);
        r103 = r103 + 1;
        goto L11
    L13:
        r104.append(r100);
        return r104.toString();
    L9:
        return r100.substring(r103 - r101);
    }
}
