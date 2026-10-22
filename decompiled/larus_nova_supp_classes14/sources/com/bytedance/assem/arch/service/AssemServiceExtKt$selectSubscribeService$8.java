package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u00052\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "D", "Lcom/bytedance/assem/arch/extensions/m;", "it", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/m;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$8 extends Lambda implements Function1<m<Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function4 $observer;

    public AssemServiceExtKt$selectSubscribeService$8(Ref.ObjectRef r1, Function4 r2) {
        this.$lastValue = r1;
        this.$observer = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((m) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(m<Object, Object, Object, Object> r6) {
        if ((!Intrinsics.areEqual(r6, (m) this.$lastValue.element)) == false) goto L9;
        Function4 r0 = this.$observer;
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(r6.a, r6.b, r6.c, r6.d);
    L7:
        this.$lastValue.element = r6;
        return;
    }
}
