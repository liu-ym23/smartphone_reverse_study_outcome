package com.volcengine.zeus;

import android.os.Build;
import com.volcengine.zeus.flipped.FlippedV2Impl;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a() {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = true;
        if (r100 < 30) goto L5;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        cqc.c r103 = new FlippedV2Impl();
    L24:
        r103.invokeHiddenApiRestrictions();
        return;
    L14:
        if (r100 < 28) goto L16;
    L21:
        if (r101 == false) goto L23;
        r103 = new cqc.b();
        goto L24
    L23:
        r103 = new cqc.a();
        goto L24
    L16:
        if (r100 == 27) goto L18;
    L20:
        r101 = false;
        goto L21
    L18:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L20;
    L5:
        if (r100 == 29) goto L7;
    L9:
        r102 = false;
        goto L11
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}
