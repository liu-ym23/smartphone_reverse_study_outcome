package com.huawei.hms.push;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f277611a = null;

    static {
        f277611a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return new String(r100, m.f277621a);
    }
}
