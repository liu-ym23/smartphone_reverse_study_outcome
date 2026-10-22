package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxAttributedElementImpl$setAttribute__M_ElementAttribute_PFI64$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ElementAttribute $key;
    final /* synthetic */ Function0<Long> $value;
    final /* synthetic */ RxAttributedElementImpl this$0;

    public RxAttributedElementImpl$setAttribute__M_ElementAttribute_PFI64$1(RxAttributedElementImpl r100, ElementAttribute r101, Function0<Long> r102) {
        this.this$0 = r100;
        this.$key = r101;
        this.$value = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RxAttributedElementImpl r100 = this.this$0;
        ElementAttribute r101 = this.$key;
        long r102 = this.$value.invoke().longValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        r100.s0(r101, r102, AttributeNumberValuePattern.INT);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
