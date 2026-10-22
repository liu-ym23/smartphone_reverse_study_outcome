package com.larus.dora.impl.device.manage;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes27.dex */
public final class r0 {
    public static final boolean a(Integer r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (new IntRange(0, 100).contains(r100.intValue()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final String b(Integer r100) {
        if (a(r100) == false) goto L5;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append('%');
        return r101.toString();
    L5:
        return "-";
    }
}
