package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$scheduleFlushElementTreeAfterInvokeUIMethod$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RenderFnRenderer this$0;

    public RenderFnRenderer$scheduleFlushElementTreeAfterInvokeUIMethod$1(RenderFnRenderer r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RenderFnRenderer r100 = this.this$0;
        if (r100.f405426j == true) goto L7;
        p r101 = r100.h();
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Any");
        r100.x(r101, r102);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
