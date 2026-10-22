package com.skydoves.balloon;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Balloon$relay$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ Function1<Balloon, Unit> $block;
    final /* synthetic */ Balloon this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public Balloon$relay$1(Balloon r100, Function1<? super Balloon, Unit> r101, Balloon r102) {
        this.this$0 = r100;
        this.$block = r101;
        this.$balloon = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.f406025h == true) goto L6;
        this.$block.invoke(this.$balloon);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
