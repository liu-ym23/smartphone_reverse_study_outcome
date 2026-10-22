package com.larus.dora.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d0 {
    public static final String a(DoraVideoType r100, DoraSKU r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "doraSku");
        boolean r102 = v19.h.f552477a;
        boolean r103 = v19.h.a(null);
        DoraResourceUtil r104 = DoraResourceUtil.f338111a;
        return DoraResourceUtil.i(r100.fileName(r101, r103));
    }
}
