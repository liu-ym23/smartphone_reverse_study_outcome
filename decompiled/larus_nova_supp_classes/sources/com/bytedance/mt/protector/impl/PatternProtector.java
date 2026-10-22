package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PatternProtector extends a<String> {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.PATTERN;
    }

    public PatternProtector() {
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String r2) {
        if (c.b() == false) goto L13;
        return Pattern.compile(r2);
    L6:
        th = move-exception;
        String r0 = (String) a.tryProtect(protectorType, th, String.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return Pattern.compile(r0);
    L13:
        return Pattern.compile(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String r2, int r3) {
        if (c.b() == false) goto L13;
        return Pattern.compile(r2, r3);
    L6:
        th = move-exception;
        String r0 = (String) a.tryProtect(protectorType, th, String.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return Pattern.compile(r0, r3);
    L13:
        return Pattern.compile(r2, r3);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean matches(String r1, CharSequence r2) {
        if (c.b() == false) goto L13;
        return Pattern.matches(r1, r2);
    L6:
        th = move-exception;
        Boolean r3 = (Boolean) a.tryProtect(protectorType, th, Boolean.class);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return r3.booleanValue();
    L13:
        return Pattern.matches(r1, r2);
    }
}
