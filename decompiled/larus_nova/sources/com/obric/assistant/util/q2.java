package com.obric.assistant.util;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q2 {
    static {
    }

    public static void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Typeface r101 = r100.getTypeface();
        if (r101 != null) goto L5;
        r101 = Typeface.DEFAULT;
    L5:
        int r102 = 0;
        if (r101 == null) goto L8;
        int r103 = r101.getStyle();
    L10:
        if ((r103 & 2) == 0) goto L12;
        boolean r104 = true;
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        Typeface r105 = Typeface.create(r101, 500, r104);
    L19:
        r100.setTypeface(r105);
        return;
    L16:
        if (r104 == false) goto L18;
        r102 = 2;
    L18:
        r105 = Typeface.create(r101, r102);
        goto L19
    L12:
        r104 = false;
        goto L14
    L8:
        r103 = 0;
        goto L10
    }
}
