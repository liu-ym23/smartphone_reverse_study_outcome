package com.bytedance.retrofit2.mime;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class MimeUtil {
    private static final Pattern CHARSET = null;

    static {
        CHARSET = PatternProtector.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    private MimeUtil() {
    }

    public static String parseCharset(String r100) {
        return parseCharset(r100, "UTF-8");
    }

    public static String parseCharset(String r100, String r101) {
        Matcher r102 = CHARSET.matcher(r100);     // Catch: IllegalArgumentException -> L7
        if (r102.find() == false) goto L6;
        return r102.group(1).replaceAll("[\"\\\\]", "");
    L6:
        return r101;
    }
}
