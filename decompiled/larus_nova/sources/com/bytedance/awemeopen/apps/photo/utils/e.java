package com.bytedance.awemeopen.apps.photo.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    static {
    }

    public static ViewTreeObserver a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isAlive());
    L6:
        if (r102 != null) goto L8;
        boolean r103 = false;
    L9:
        if (r103 == true) goto L11;
        return null;
    L11:
        return r101;
    L8:
        r103 = r102.booleanValue();
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
