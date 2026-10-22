package com.larus.canvas.feature.component.logic.helper;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class f {
    public static final void a(StateFlowImpl r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reducer");
        r100.setValue(r101.invoke(r100.getValue()));
    }
}
