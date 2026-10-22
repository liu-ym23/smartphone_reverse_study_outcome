package com.ss.android.lark.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f444744a = null;

    static {
        f444744a = PatternProtector.compile("<at.*?[^>]user_id=\\\"([\\s\\S]*?)\">([\\s\\S]*?)</at>");
        PatternProtector.compile("<at.*?[^>]user_id=\\\"(\\d+)\">([\\s\\S]*?)</at>");
    }

    public static CharSequence c(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        SpannableStringBuilder r101 = new SpannableStringBuilder(r100);
        Matcher r102 = f444744a.matcher(r101);
    L8:
        if (r102.find() == false) goto L10;
        String r103 = r102.group(2);
        r101.replace(r102.start(), r102.end(), Matcher.quoteReplacement(r103));
        r102 = f444744a.matcher(r101);
        goto L8
    L10:
        return r101;
    }

    public static String a(String r100, String r101) {
        return "<at user_id=\"" + r100 + "\">@" + r101 + "</at>";
    }

    public static String b(String r100, String r101) {
        return "<at user_id=\"" + r100 + "\">" + r101 + "</at>";
    }
}
