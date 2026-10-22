package com.bytedance.salamander.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<no name provided>", "", "result", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncRemove$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ Function0<Unit> $completion;

    public SLKVStorage$asyncRemove$2(Function0<Unit> r100) {
        this.$completion = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit r100) {
        this.$completion.invoke();
    }
}
