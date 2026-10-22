package com.volcengine.zeus;

import android.os.Build;
import com.volcengine.zeus.flipped.FlippedV2Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static void a() {
        int r0 = Build.VERSION.SDK_INT;
        boolean r2 = true;
        if (r0 < 30) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
        FlippedV2Impl r3 = new FlippedV2Impl();
    L24:
        r3.invokeHiddenApiRestrictions();
        return;
    L14:
        if (r0 < 28) goto L16;
    L21:
        if (r2 == false) goto L23;
        r3 = new cqc.b();
        goto L24
    L23:
        r3 = new cqc.a();
        goto L24
    L16:
        if (r0 == 27) goto L18;
    L20:
        r2 = false;
        goto L21
    L18:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L20;
    L5:
        if (r0 == 29) goto L7;
    L9:
        r1 = false;
        goto L11
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}
