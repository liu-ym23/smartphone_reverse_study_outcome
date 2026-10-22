package com.larus.dora.impl.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f332216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f332217b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f332218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f332219d = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        f332216a = r100;
        f332217b = r100;
        f332219d = new AtomicBoolean(false);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Intrinsics.checkNotNullParameter(r101, "name");
        f332216a.put(r100, r101);
    }
}
