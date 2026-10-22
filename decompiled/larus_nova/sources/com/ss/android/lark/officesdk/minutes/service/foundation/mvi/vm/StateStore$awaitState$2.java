package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class StateStore$awaitState$2 extends AdaptedFunctionReference implements Function1<l, Unit> {
    public StateStore$awaitState$2(Object r100) {
        super(1, r100, CompletableDeferred.class, BitableAnalytic.SelectSceneClickType.COMPLETE, "complete(Ljava/lang/Object;)Z", 8);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((CompletableDeferred) this.receiver).complete(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(l r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
