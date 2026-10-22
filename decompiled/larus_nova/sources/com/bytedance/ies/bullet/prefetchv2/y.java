package com.bytedance.ies.bullet.prefetchv2;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, x> f247613a = null;

    static {
        f247613a = new ConcurrentHashMap();
    }

    public static x a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        ConcurrentHashMap<String, x> r101 = f247613a;
        if (r101.size() <= 10) goto L5;
        j.c("Session 可能存在泄漏");
    L5:
        x r102 = r101.get(r100);
        if (r102 != null) goto L8;
        r102 = new x();
    L8:
        r101.put(r100, r102);
        return r102;
    }
}
