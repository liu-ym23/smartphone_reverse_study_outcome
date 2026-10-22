package com.xiaomi.NetworkBoost;

/* JADX INFO: loaded from: classes41.dex */
public class Version {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f463007a;

    public Version() {
    }

    public static int getServiceVersion() {
        return f463007a;
    }

    public static boolean isSupport(int r100) {
        if (r100 > f463007a) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setServiceVersion(int r100) {
        f463007a = r100;
    }
}
