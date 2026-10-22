package com.ss.ugc.effectplatform.util;

/* JADX INFO: loaded from: classes5.dex */
public final class s {
    public static final String a(String[] r100) {
        int r101 = r100.length - 1;
        if (r101 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r102 = new StringBuilder("[");
        int r103 = 0;
    L7:
        r102.append(r100[r103]);
        if (r103 == r101) goto L9;
        r102.append(", ");
        r103 = r103 + 1;
        goto L7
    L9:
        r102.append(']');
        return r102.toString();
    }
}
