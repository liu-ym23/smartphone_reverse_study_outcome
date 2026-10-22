package com.bytedance.salamander.anniex;

import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXAnnieXRedirectImplProcessorKt {
    public static final boolean a(final String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "any");
        Intrinsics.checkNotNullParameter(r101, "args");
        return com.bytedance.rts.foundation.j.m(new ArrayList(ArraysKt.toList(r101)), new AnnieXAnnieXRedirectImplProcessorKt$isAnyOf$1(r100));
    }
}
