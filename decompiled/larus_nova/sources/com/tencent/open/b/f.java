package com.tencent.open.b;

import com.tencent.open.utils.i;

/* JADX INFO: loaded from: classes31.dex */
public class f {
    public static int a() {
        int r100 = i.a(com.tencent.open.utils.g.a(), null).a("Common_HttpRetryCount");
        if (r100 != 0) goto L6;
        return 2;
    L6:
        return r100;
    }

    public static int a(String r100) {
        if (com.tencent.open.utils.g.a() != null) goto L5;
        return 100;
    L5:
        int r101 = i.a(com.tencent.open.utils.g.a(), r100).a("Common_BusinessReportFrequency");
        if (r101 != 0) goto L9;
        return 100;
    L9:
        return r101;
    }
}
