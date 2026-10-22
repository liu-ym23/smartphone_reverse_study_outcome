package uk7;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f550527a;

    static {
        f550527a = il7.m.a().e("luckydog_intercept_path", "");
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("/luckycat/activity") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.startsWith("/luckycat/crossover/v:version/") == true) goto L9;
        return false;
    }
}
