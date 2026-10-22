package com.larus.uaigc.chat.markdown.helper;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k1 {
    public static final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = System.currentTimeMillis();
        Object r102 = r100.getTag(123450001);
        if ((r102 instanceof Long) == false) goto L5;
        Long r103 = (Long) r102;
    L6:
        if (r103 == null) goto L8;
        long r104 = r103.longValue();
    L10:
        if ((r101 - r104) >= 500) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        r100.setTag(123450001, Long.valueOf(r101));
    L15:
        return r105;
    L12:
        r105 = false;
        goto L13
    L8:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
