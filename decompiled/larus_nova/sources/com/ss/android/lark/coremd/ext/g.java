package com.ss.android.lark.coremd.ext;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {
    public static final void a(j r100, h r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "contextProvider");
        Intrinsics.checkNotNullParameter(r102, "action");
        r102.invoke(r101.a(), r100);
    }
}
