package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxPageImpl$setupForRtsPipeline$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RxPageImpl $_this;
    final /* synthetic */ int $phase;

    public RxPageImpl$setupForRtsPipeline$1$1(int r100, RxPageImpl r101) {
        this.$phase = r100;
        this.$_this = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$phase != PagePhase.Destroy.getValue()) goto L5;
        RxPageImpl r100 = this.$_this;
        Intrinsics.checkNotNull(r100);
        ((LinkedHashMap) r100.B).clear();
    L5:
        RxPageImpl r101 = this.$_this;
        Intrinsics.checkNotNull(r101);
        RxPageImpl.b0(r101, this.$phase);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
