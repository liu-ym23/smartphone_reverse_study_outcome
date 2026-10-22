package com.larus.dora.impl.util;

/* JADX INFO: loaded from: classes27.dex */
public final class h {
    public static String a(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 17) goto L7;
        return null;
    L7:
        return "XX:XX:XX:XX" + r100.substring(11);
    }
}
