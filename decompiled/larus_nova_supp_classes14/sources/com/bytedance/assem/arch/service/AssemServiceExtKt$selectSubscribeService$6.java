package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "Lcom/bytedance/assem/arch/extensions/l;", "it", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$6 extends Lambda implements Function1<l<Object, Object, Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function3 $observer;

    public AssemServiceExtKt$selectSubscribeService$6(Ref.ObjectRef r1, Function3 r2) {
        this.$lastValue = r1;
        this.$observer = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((l) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(l<Object, Object, Object> r5) {
        if ((!Intrinsics.areEqual(r5, (l) this.$lastValue.element)) == false) goto L9;
        Function3 r0 = this.$observer;
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(r5.a, r5.b, r5.c);
    L7:
        this.$lastValue.element = r5;
        return;
    }
}
