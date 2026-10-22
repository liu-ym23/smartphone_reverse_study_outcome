package com.ss.android.lark.utils;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public final class y0 {
    public static boolean d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.trim().length() <= 0) goto L8;
        return false;
    }

    public static boolean a(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return r100.trim().toLowerCase().equals(r101.trim().toLowerCase());
    L6:
        if (r100 != r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static SpannableString c(CharSequence r100, List<String> r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Log.e("high color failed: text is empty");
        return new SpannableString("");
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        CharSequence r103 = "";
    L13:
        SpannableString r104 = SpannableString.valueOf(r103);
        if (CollectionUtils.isEmpty(r101) == false) goto L17;
        return r104;
    L17:
        if (TextUtils.isEmpty(r100) == false) goto L20;
        r100 = "";
    L23:
        String r105 = r100.toString().toLowerCase();
        Iterator<String> r106 = r101.iterator();
    L25:
        if (r106.hasNext() == false) goto L39;
        String r107 = r106.next();
        if (TextUtils.isEmpty(r107) == true) goto L25;
        String r108 = r107.toLowerCase();
        if (r105.contains(r108) == false) goto L25;
        Matcher r109 = PatternProtector.compile(Pattern.quote(r108)).matcher(r105);     // Catch: Exception -> L37
    L34:
        if (r109.find() == false) goto L25;
        r104.setSpan(new ForegroundColorSpan(r102), r109.start(), r109.end(), 33);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        Log.e("high color failed: " + e.getMessage());
        goto L25
    L39:
        return r104;
    L20:
        if (r100.length() < 100) goto L23;
        r100 = r100.subSequence(0, 100);
        goto L23
    L10:
        if (r100.length() >= 100) goto L12;
        r103 = r100;
        goto L13
    L12:
        r103 = r100.subSequence(0, 100);
        goto L13
    }

    public static CharSequence b(CharSequence r100, int r101, int r102, String r103, int r104) {
        if (r100 == null) goto L22;
        if (r103 == null) goto L22;
        if (r101 > r102) goto L22;
        CharSequence r105 = r100;
        r105 = r100;
        if (r101 == (-1)) goto L22;
        if (r102 == (-1)) goto L22;
        if (r101 >= 0) goto L12;
        r101 = 0;
    L12:
        String r106 = (String) r100;
        if (r102 < r106.length()) goto L15;
        r102 = r106.length();
    L15:
        int r107 = r101 + r106.subSequence(r101, r102).toString().toLowerCase().indexOf(r103.toLowerCase());
        SpannableString r108 = SpannableString.valueOf(r100);
        r105 = r108;
        if (r107 == (-1)) goto L22;
        ForegroundColorSpan r109 = new ForegroundColorSpan(r104);
        if ((r103.length() + r107) <= r106.length()) goto L20;
        int r110 = r106.length();
    L21:
        r108.setSpan(r109, r107, r110, 33);
        r105 = r108;
        goto L22
    L20:
        r110 = r103.length() + r107;
    L22:
        return r105;
    }
}
