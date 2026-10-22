package com.larus.im.internal.utils;

import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b {
    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        com.larus.im.internal.delegate.a.f348188b.e("ChunkLogger", e(r100, r101));
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        com.larus.im.internal.delegate.a.f348188b.i("ChunkLogger", e(r100, r101));
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        com.larus.im.internal.delegate.a.f348188b.w("ChunkLogger", e(r100, r101));
    }

    public static String e(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return r101;
    L11:
        return "<" + r100 + "> " + r101;
    L4:
        if (StringsKt.isBlank(r101) == true) goto L7;
        r102 = false;
        goto L8
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        com.larus.im.internal.delegate.a r103 = com.larus.im.internal.delegate.a.f348188b;
        r103.e("ChunkLogger", e(r100, r101));
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r104 = ExceptionsKt.stackTraceToString(r102);
    L6:
        r103.e("ChunkLogger", e(r100, r104));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
