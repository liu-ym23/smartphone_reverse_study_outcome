package com.bytedance.locallife.common.utils;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257151a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r101 = false;
        goto L8
    }
}
