package com.bytedance.lottie;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f264422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f264423b;

    static {
        f264422a = new HashSet();
        f264423b = 0;
    }

    public static void a() {
        int r100 = f264423b;
        if (r100 <= 0) goto L6;
        f264423b = r100 - 1;
        return;
    }

    public static void b(String r100) {
        Set<String> r101 = f264422a;
        if (((HashSet) r101).contains(r100) == false) goto L5;
        return;
    L5:
        ((HashSet) r101).add(r100);
    }
}
