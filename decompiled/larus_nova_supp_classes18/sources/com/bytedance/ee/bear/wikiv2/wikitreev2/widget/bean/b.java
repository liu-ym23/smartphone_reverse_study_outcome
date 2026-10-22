package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static String c(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return "";
    L5:
        if (r2.contains("-") == true) goto L7;
        return r2;
    L7:
        Pattern r1 = yu5.c.a;
        String[] r4 = r2.split("-");
        if (r3 >= 0) goto L10;
        return "";
    L10:
        if (r3 < r4.length) goto L12;
        return "";
    L12:
        return r4[r3];
    }

    public static String b(boolean r0, String r1, String r2) {
        if (r0 == true) goto L4;
        return r2;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1 = r1 + "/" + r2;
    L8:
        return r1;
    }

    public static String a(String r1, String r2, int r3, String r4) {
        String r5 = r1 + "-" + r2 + "-" + r3;
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return r5;
    L6:
        return r5 + "-" + r4;
    }
}
