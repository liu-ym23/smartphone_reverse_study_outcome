package com.bytedance.applog.priority.original;

import kotlin.UByte;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static final String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r100 == null) goto L11;
        if (r102 >= r100.length) goto L11;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L9;
        r101.append('0');
    L9:
        r101.append(r103);
        r102 = r102 + 1;
    L11:
        return r101.toString();
    }
}
