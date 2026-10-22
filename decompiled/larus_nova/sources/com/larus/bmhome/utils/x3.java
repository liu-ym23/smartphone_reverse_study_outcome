package com.larus.bmhome.utils;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f315151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f315152b = null;

    static {
        f315151a = "";
        f315152b = LazyKt.lazy(new w3());
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L5;
        return "0";
    L5:
        if (r101 != null) goto L7;
        return "0";
    L7:
        String r102 = ((Keva) f315152b.getValue()).getString(r100, "");
        if (com.larus.utils.o0.d(r102) == true) goto L10;
    L13:
        return "0";
    L10:
        if (Intrinsics.areEqual(r102, r101) == false) goto L13;
        return "1";
    }
}
