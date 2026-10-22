package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<no name provided>", "", "value", "", "", "Lcom/relax/relaxframework/LTViewCommonCallbackTuple;", AbsMethodDelegate.TAG_INVOKE, "([Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxLottieImpl$stop$2 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ Function1<Integer, Unit> $commonCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public RxLottieImpl$stop$2(Function1<? super Integer, Unit> r100) {
        this.$commonCallback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Function1<Integer, Unit> r101 = this.$commonCallback;
        Object r102 = r100[0];
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.invoke((Integer) r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object[] r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
