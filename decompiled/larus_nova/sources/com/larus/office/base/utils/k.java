package com.larus.office.base.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class k implements Function1 {
    public /* synthetic */ k() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "path");
        boolean r102 = false;
        if (r101.size() != 2) goto L8;
        if (Intrinsics.areEqual(ListProtector.get(r101, 0), "file") == false) goto L8;
        r102 = true;
    L8:
        return Boolean.valueOf(r102);
    }
}
