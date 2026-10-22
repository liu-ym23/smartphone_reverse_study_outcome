package com.obric.assistant.common.utils;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static Object a(List r100, Continuation r101) {
        if (r100.isEmpty() == true) goto L10;
        Object r102 = BuildersKt.withContext(Dispatchers.getMain(), new ActivityUtilsKt$waitUntilDestroy$2(2000, r100, true, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r102;
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}
