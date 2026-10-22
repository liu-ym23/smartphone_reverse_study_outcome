package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class k {
    public static void a(Context r100) {
    }

    public static void a(Context r100, String r101, boolean r102) {
        a(r100);
        PreferenceManager.getDefaultSharedPreferences(r100).edit().putBoolean(r101, r102).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9302a(Context r100, String r101, boolean r102) {
        a(r100);
        return PreferenceManager.getDefaultSharedPreferences(r100).getBoolean(r101, r102);
    }

    public static void a(Map<String, String> r100, String r101, String r102) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        if (r102 == null) goto L9;
        r100.put(r101, r102);
        return;
    L9:
        return;
    L8:
        return;
    }
}
