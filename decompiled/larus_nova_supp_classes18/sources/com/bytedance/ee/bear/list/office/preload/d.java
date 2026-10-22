package com.bytedance.ee.bear.list.office.preload;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final ConcurrentHashMap<String, g> a = null;
    public static final ConcurrentHashMap<String, String> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static String a(String r1, String r2) {
        return r1 + '#' + r2;
    }
}
