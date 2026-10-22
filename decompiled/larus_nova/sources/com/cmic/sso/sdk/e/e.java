package com.cmic.sso.sdk.e;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, TokenListener> f273492a;

    static {
        f273492a = new ConcurrentHashMap(16);
    }

    public static boolean a() {
        return f273492a.isEmpty();
    }

    public static boolean a(String r100) {
        return !f273492a.containsKey(r100);
    }

    public static void b(String r100) {
        f273492a.remove(r100);
    }

    public static TokenListener c(String r100) {
        return f273492a.get(r100);
    }

    public static void a(String r100, TokenListener r101) {
        f273492a.put(r100, r101);
    }
}
