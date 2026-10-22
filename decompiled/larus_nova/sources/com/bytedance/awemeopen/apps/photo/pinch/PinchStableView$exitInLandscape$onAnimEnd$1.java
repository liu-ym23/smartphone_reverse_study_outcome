package com.bytedance.awemeopen.apps.photo.pinch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PinchStableView$exitInLandscape$onAnimEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onExitEnd;
    final /* synthetic */ PinchStableView this$0;

    public PinchStableView$exitInLandscape$onAnimEnd$1(Function0<Unit> r100, PinchStableView r101) {
        this.$onExitEnd = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onExitEnd.invoke();
        PinchStableView r100 = this.this$0;
        int r101 = PinchStableView.f197789k;
        r100.h();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
