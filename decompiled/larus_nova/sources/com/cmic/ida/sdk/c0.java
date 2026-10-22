package com.cmic.ida.sdk;

import com.cmic.ida.sdk.auth.GetScriptListener;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, GetScriptListener> f273090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, g> f273091b;

    static {
        f273090a = new ConcurrentHashMap(16);
        f273091b = new ConcurrentHashMap();
    }

    public static GetScriptListener a(String r100) {
        return f273090a.get(r100);
    }

    public static void b(String r100) {
        f273090a.remove(r100);
    }

    public static boolean c(String r100) {
        return !f273090a.containsKey(r100);
    }

    public static void a(String r100, GetScriptListener r101) {
        f273090a.put(r100, r101);
    }
}
