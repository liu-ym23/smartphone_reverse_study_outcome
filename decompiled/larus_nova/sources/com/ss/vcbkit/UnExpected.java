package com.ss.vcbkit;

import com.bytedance.crash.d;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public class UnExpected {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f458542a;

    public UnExpected() {
    }

    private static void notReachHereNative(String r100, String r101, Map<String, String> r102) {
        if (f458542a == false) goto L6;
        d.a(r100, "", ThreadMethodProxy.currentThread().getName(), r101, r102);
        return;
    }
}
