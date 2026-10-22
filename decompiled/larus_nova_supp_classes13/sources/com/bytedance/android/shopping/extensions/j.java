package com.bytedance.android.shopping.extensions;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static final int a(int r1) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L7;
        Resources r2 = r0.getResources();
        if (r2 == null) goto L7;
        return r2.getDimensionPixelOffset(r1);
    L7:
        return 0;
    }

    public static final int b(int r1) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L7;
        Resources r2 = r0.getResources();
        if (r2 == null) goto L7;
        return r2.getColor(r1);
    L7:
        return 0;
    }

    public static final String c(int r1) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L6;
        String r2 = r0.getString(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    public static final String d(int r3, Object r4) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L6;
        String r5 = r0.getString(r3, new Object[]{r4});
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "";
    }

    public static final String e(int r3, Object r4, Object r5) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L6;
        String r6 = r0.getString(r3, new Object[]{r4, r5});
        if (r6 == null) goto L6;
        return r6;
    L6:
        return "";
    }
}
