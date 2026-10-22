package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static String c(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (r100.contains("-") == true) goto L7;
        return r100;
    L7:
        Pattern r102 = yu5.c.f569228a;
        String[] r103 = r100.split("-");
        if (r101 >= 0) goto L10;
        return "";
    L10:
        if (r101 < r103.length) goto L12;
        return "";
    L12:
        return r103[r101];
    }

    public static String b(boolean r100, String r101, String r102) {
        if (r100 == true) goto L4;
        return r102;
    L4:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r101 = r101 + HTTP.URL_DEFAULT + r102;
    L8:
        return r101;
    }

    public static String a(String r100, String r101, int r102, String r103) {
        String r104 = r100 + "-" + r101 + "-" + r102;
        if (TextUtils.isEmpty(r103) == false) goto L6;
        return r104;
    L6:
        return r104 + "-" + r103;
    }
}
