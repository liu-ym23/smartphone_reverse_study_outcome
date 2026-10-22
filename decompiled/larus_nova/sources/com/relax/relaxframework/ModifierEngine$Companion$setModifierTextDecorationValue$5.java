package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierTextDecorationValue$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Long> $color;
    final /* synthetic */ s0 $line;
    final /* synthetic */ int $modifier;
    final /* synthetic */ s0 $style;

    public ModifierEngine$Companion$setModifierTextDecorationValue$5(Function0<Long> r100, int r101, s0 r102, s0 r103) {
        this.$color = r100;
        this.$modifier = r101;
        this.$line = r102;
        this.$style = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        long r100 = this.$color.invoke().longValue();
        qpa.d.h(this.$modifier, this.$line.a(), this.$style.a(), r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
