package com.huawei.hms.base.ui;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
public class LogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f277012a = null;

    public LogUtil() {
    }

    static {
        f277012a = PatternProtector.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = r100.length();
        int r102 = 1;
        if (1 == r101) goto L8;
        StringBuilder r103 = new StringBuilder(r101);
        int r104 = 0;
    L10:
        if (r104 >= r101) goto L19;
        char r105 = r100.charAt(r104);
        if (f277012a.matcher(String.valueOf(r105)).matches() == false) goto L17;
        if ((r102 % 2) != 0) goto L16;
        r105 = '*';
    L16:
        r102 = r102 + 1;
    L17:
        r103.append(r105);
        r104 = r104 + 1;
        goto L10
    L19:
        return r103.toString();
    L8:
        return String.valueOf('*');
    }

    private static String a(String r100, boolean r101) {
        StringBuilder r102 = new StringBuilder(512);
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == false) goto L6;
        r102.append(a(r100));
        goto L8
    L6:
        r102.append(r100);
    L8:
        return r102.toString();
    }

    public static void e(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, false);
    }

    public static void e(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r102);
    }
}
