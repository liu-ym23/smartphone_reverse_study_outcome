package com.bytedance.gkfs;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class UtilsKt$traceTimePrecise$1$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ long $startTime;

    public UtilsKt$traceTimePrecise$1$1(long r100) {
        this.$startTime = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return System.nanoTime() - this.$startTime;
    }
}
