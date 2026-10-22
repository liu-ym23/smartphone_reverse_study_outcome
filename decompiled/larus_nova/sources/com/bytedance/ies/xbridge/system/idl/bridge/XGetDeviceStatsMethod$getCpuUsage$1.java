package com.bytedance.ies.xbridge.system.idl.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class XGetDeviceStatsMethod$getCpuUsage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Float, Unit> $callback;
    final /* synthetic */ a this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public XGetDeviceStatsMethod$getCpuUsage$1(a r100, Function1<? super Float, Unit> r101) {
        this.$callback = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = a.f249545c;
        throw null;
    }
}
