package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class PatternProtector extends a<String> {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.PATTERN;
    }

    public PatternProtector() {
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String r100) {
        if (c.b() == false) goto L13;
        return Pattern.compile(r100);
    L6:
        th = move-exception;
        String r101 = (String) a.tryProtect(protectorType, th, String.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return Pattern.compile(r101);
    L13:
        return Pattern.compile(r100);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String r100, int r101) {
        if (c.b() == false) goto L13;
        return Pattern.compile(r100, r101);
    L6:
        th = move-exception;
        String r102 = (String) a.tryProtect(protectorType, th, String.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return Pattern.compile(r102, r101);
    L13:
        return Pattern.compile(r100, r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean matches(String r100, CharSequence r101) {
        if (c.b() == false) goto L13;
        return Pattern.matches(r100, r101);
    L6:
        th = move-exception;
        Boolean r102 = (Boolean) a.tryProtect(protectorType, th, Boolean.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.booleanValue();
    L13:
        return Pattern.matches(r100, r101);
    }
}
