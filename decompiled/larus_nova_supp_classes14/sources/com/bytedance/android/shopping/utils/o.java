package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    public static float a() {
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.f() == false) goto L17;
        Float r1 = r0.getCurrentFontScale();
        if (r1 == null) goto L7;
        float r2 = r1.floatValue();
    L9:
        if (r2 <= 1.0f) goto L14;
        if (r2 > 1.15f) goto L14;
        return 1.15f;
    L14:
        if (r2 <= 1.15d) goto L17;
        return 1.3f;
    L7:
        r2 = 1.0f;
    L17:
        return 1.0f;
    }

    static {
    }
}
