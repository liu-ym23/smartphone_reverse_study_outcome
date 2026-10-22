package com.bytedance.salamander.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/adapter/p;", "impl", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/adapter/p;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class SLKVStorage$Companion$createStorage$1 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ Function1<o, Unit> $onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public SLKVStorage$Companion$createStorage$1(Function1<? super o, Unit> r100) {
        this.$onComplete = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        if (r100 != null) goto L4;
        this.$onComplete.invoke(null);
    L4:
        Function1<o, Unit> r101 = this.$onComplete;
        Intrinsics.checkNotNull(r100);
        r101.invoke(new o(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
