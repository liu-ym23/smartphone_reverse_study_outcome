package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 {
    public static String b(String r3) {
        tt5.a.h("TaskKeyGenerator", "parseDownloadCallbackKey, taskId: " + du5.b.g(r3));
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        Pattern r0 = yu5.c.a;
        String[] r4 = r3.split("_");
        if (r4.length >= 2) goto L9;
        return "";
    L9:
        return r4[1];
    }

    public static String c(String r3) {
        tt5.a.h("TaskKeyGenerator", "parseDownloadUniqueKey, taskId: " + du5.b.g(r3));
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return "";
    L6:
        Pattern r0 = yu5.c.a;
        String[] r1 = r3.split("_");
        if (r1.length >= 2) goto L10;
        return r3;
    L10:
        return r1[0];
    }

    public static String a(String r1, String r2) {
        return r1 + "_" + r2;
    }
}
