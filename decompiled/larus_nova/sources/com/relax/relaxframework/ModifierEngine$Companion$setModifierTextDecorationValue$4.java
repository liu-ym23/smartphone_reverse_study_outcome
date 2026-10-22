package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierTextDecorationValue$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Long> $color;
    final /* synthetic */ s0 $line;
    final /* synthetic */ int $modifier;
    final /* synthetic */ Function0<Integer> $style;

    public ModifierEngine$Companion$setModifierTextDecorationValue$4(Function0<Long> r100, Function0<Integer> r101, int r102, s0 r103) {
        this.$color = r100;
        this.$style = r101;
        this.$modifier = r102;
        this.$line = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        long r100 = this.$color.invoke().longValue();
        int r101 = this.$style.invoke().intValue();
        int r102 = this.$modifier;
        double r103 = this.$line.a();
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        qpa.d.h(r102, r103, r101, r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
