package org.apache.commons.lang3.time;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes42.dex */
public class FastTimeZone {
    private static final Pattern GMT_PATTERN = null;
    private static final TimeZone GREENWICH = null;

    static {
        GMT_PATTERN = PatternProtector.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
        GREENWICH = new GmtTimeZone(false, 0, 0);
    }

    public static TimeZone getGmtTimeZone(String r100) {
        if ("Z".equals(r100) == true) goto L19;
        if ("UTC".equals(r100) == true) goto L19;
        Matcher r101 = GMT_PATTERN.matcher(r100);
        if (r101.matches() == false) goto L16;
        int r102 = parseInt(r101.group(2));
        int r103 = parseInt(r101.group(4));
        if (r102 != 0) goto L15;
        if (r103 != 0) goto L15;
        return GREENWICH;
    L15:
        return new GmtTimeZone(parseSign(r101.group(1)), r102, r103);
    L16:
        return null;
    L19:
        return GREENWICH;
    }

    private static int parseInt(String r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return CastIntegerProtector.parseInt(r100);
    }

    private static boolean parseSign(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.charAt(0) != '-') goto L9;
        return true;
    L9:
        return false;
    }
}
