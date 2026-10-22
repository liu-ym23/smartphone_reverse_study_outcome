package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 {
    public static String b(String r100) {
        tt5.a.h("TaskKeyGenerator", "parseDownloadCallbackKey, taskId: " + du5.b.g(r100));
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        Pattern r101 = yu5.c.f569228a;
        String[] r102 = r100.split("_");
        if (r102.length >= 2) goto L9;
        return "";
    L9:
        return r102[1];
    }

    public static String c(String r100) {
        tt5.a.h("TaskKeyGenerator", "parseDownloadUniqueKey, taskId: " + du5.b.g(r100));
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Pattern r101 = yu5.c.f569228a;
        String[] r102 = r100.split("_");
        if (r102.length >= 2) goto L10;
        return r100;
    L10:
        return r102[0];
    }

    public static String a(String r100, String r101) {
        return r100 + "_" + r101;
    }
}
