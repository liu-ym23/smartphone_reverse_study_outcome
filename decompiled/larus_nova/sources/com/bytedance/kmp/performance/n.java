package com.bytedance.kmp.performance;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f252763a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function2<? super Composer, ? super Integer, Unit> r100) {
        this.f252763a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Composer r100, Integer r101) {
        Composer r102 = r100;
        int r103 = r101.intValue();
        if ((r103 & 3) != 2) goto L9;
        if (r102.getSkipping() == false) goto L9;
        r102.skipToGroupEnd();
    L15:
        return Unit.INSTANCE;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1114051435, r103, -1, "com.bytedance.kmp.performance.KPerfViewWrapper.<anonymous>.<anonymous> (KPerfViewWrapper.kt:327)");
    L11:
        this.f252763a.invoke(r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
        goto L15
    }
}
