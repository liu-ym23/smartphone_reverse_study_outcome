package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class HmsHiAnalyticsUtils {
    public HmsHiAnalyticsUtils() {
    }

    public static boolean getInitFlag() {
        return a.b();
    }

    public static void enableLog() {
        c.a();
    }

    public static void onReport() {
        a.c();
    }

    public static void onEvent(int r100, String r101, LinkedHashMap<String, String> r102) {
        a.a(r100, r101, r102);
    }

    public static void onStreamEvent(int r100, String r101, LinkedHashMap<String, String> r102) {
        a.b(r100, r101, r102);
    }

    public static void onEvent(Context r100, String r101, String r102) {
        a.a(r100, r101, r102);
    }

    public static void init(Context r100, boolean r101, boolean r102, boolean r103, String r104, String r105) {
        new b(r100).a(r101).c(r102).b(r103).a(0, r104).a(1, r104).a(r105).a();
    }
}
