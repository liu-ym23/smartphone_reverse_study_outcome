package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u00062$\u0010\b\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "D", "E", "Lcom/bytedance/assem/arch/extensions/n;", "it", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/n;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$10 extends Lambda implements Function1<n<Object, Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function5 $observer;

    public AssemServiceExtKt$selectSubscribeService$10(Ref.ObjectRef r1, Function5 r2) {
        this.$lastValue = r1;
        this.$observer = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((n) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(n<Object, Object, Object, Object, Object> r8) {
        if ((!Intrinsics.areEqual(r8, (n) this.$lastValue.element)) == false) goto L9;
        Function5 r1 = this.$observer;
        if (r1 == null) goto L7;
        Unit r0 = (Unit) r1.invoke(r8.a, r8.b, r8.c, r8.d, r8.e);
    L7:
        this.$lastValue.element = r8;
        return;
    }
}
