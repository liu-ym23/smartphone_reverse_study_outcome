package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierTextDecorationValue$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Long> $color;
    final /* synthetic */ Function0<Integer> $line;
    final /* synthetic */ int $modifier;
    final /* synthetic */ Function0<Integer> $style;

    public ModifierEngine$Companion$setModifierTextDecorationValue$3(Function0<Integer> r100, Function0<Long> r101, Function0<Integer> r102, int r103) {
        this.$line = r100;
        this.$color = r101;
        this.$style = r102;
        this.$modifier = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = this.$line.invoke().intValue();
        long r101 = this.$color.invoke().longValue();
        int r102 = this.$style.invoke().intValue();
        int r103 = this.$modifier;
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        qpa.d.h(r103, r100, r102, r101);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
