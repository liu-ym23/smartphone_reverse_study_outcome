package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/adapter/p;", "impl", "", "invoke", "(Lcom/bytedance/salamander/adapter/p;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class SLKVStorage$Companion$createStorage$1 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ Function1<o, Unit> $onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public SLKVStorage$Companion$createStorage$1(Function1<? super o, Unit> r1) {
        this.$onComplete = r1;
        super(1);
    }

    public final void invoke(p r3) {
        if (r3 != null) goto L4;
        this.$onComplete.invoke(null);
    L4:
        Function1<o, Unit> r0 = this.$onComplete;
        Intrinsics.checkNotNull(r3);
        r0.invoke(new o(r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((p) r1);
        return Unit.INSTANCE;
    }
}
