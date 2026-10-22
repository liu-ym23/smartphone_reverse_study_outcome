package com.larus.office.base.utils;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "path");
        return Boolean.valueOf(n.d(r101));
    }
}
