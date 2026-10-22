package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "Lcom/bytedance/assem/arch/viewModel/h;", "S", "Lcom/bytedance/assem/arch/extensions/j;", "it", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/j;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$14 extends Lambda implements Function1<j<Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function1 $observer;

    public AssemServiceExtKt$selectSubscribeService$14(Ref.ObjectRef r1, Function1 r2) {
        this.$lastValue = r1;
        this.$observer = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(j<Object> r3) {
        if ((!Intrinsics.areEqual(r3, (j) this.$lastValue.element)) == false) goto L9;
        Function1 r0 = this.$observer;
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(r3.a);
    L7:
        this.$lastValue.element = r3;
        return;
    }
}
