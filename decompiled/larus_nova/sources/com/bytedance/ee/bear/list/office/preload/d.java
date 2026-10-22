package com.bytedance.ee.bear.list.office.preload;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, g> f229150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f229151b = null;

    static {
        f229150a = new ConcurrentHashMap();
        f229151b = new ConcurrentHashMap();
    }

    public static String a(String r100, String r101) {
        return r100 + '#' + r101;
    }
}
