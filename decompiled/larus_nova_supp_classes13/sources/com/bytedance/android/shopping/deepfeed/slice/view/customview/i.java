package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final String a(Map r3, String... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Object r2 = r3.get(r4[r1]);
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r2.toString();
    L8:
        return null;
    }
}
