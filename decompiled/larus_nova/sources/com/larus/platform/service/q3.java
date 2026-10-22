package com.larus.platform.service;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.z3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f365794a = null;

    public q3() {
    }

    static {
        f365794a = LazyKt.lazy(new p3());
    }

    public static z3 a() {
        return (z3) f365794a.getValue();
    }

    public static IVideoController b(String r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "tag");
        z3 r103 = a();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.m(r100, false, r101);
    }
}
