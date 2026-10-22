package com.bytedance.awemeopen.apps.photo.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    static {
    }

    public static ViewTreeObserver a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r3.isAlive());
    L6:
        if (r1 != null) goto L8;
        boolean r4 = false;
    L9:
        if (r4 == true) goto L11;
        return null;
    L11:
        return r3;
    L8:
        r4 = r1.booleanValue();
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
