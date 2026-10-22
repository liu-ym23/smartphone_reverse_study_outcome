package com.larus.dora.obric.device_management.setting.earbuds;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {
    public static boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = SystemClock.elapsedRealtime();
        Object r102 = r100.getTag(123400002);
        if ((r102 instanceof Long) == false) goto L5;
        Long r103 = (Long) r102;
    L6:
        if (r103 == null) goto L8;
        long r104 = r103.longValue();
    L10:
        if ((r101 - r104) >= 500) goto L12;
        return true;
    L12:
        r100.setTag(123400002, Long.valueOf(r101));
        return false;
    L8:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
