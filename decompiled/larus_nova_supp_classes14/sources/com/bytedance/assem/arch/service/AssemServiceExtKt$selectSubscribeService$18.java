package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\b\b\u0003\u0010\u0005*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "Lcom/bytedance/assem/arch/viewModel/h;", "S", "Lcom/bytedance/assem/arch/extensions/k;", "it", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/k;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$18 extends Lambda implements Function1<k<Object, Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function2 $observer;

    public AssemServiceExtKt$selectSubscribeService$18(Ref.ObjectRef r1, Function2 r2) {
        this.$lastValue = r1;
        this.$observer = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((k) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(k<Object, Object> r4) {
        if ((!Intrinsics.areEqual(r4, (k) this.$lastValue.element)) == false) goto L9;
        Function2 r0 = this.$observer;
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke(r4.a, r4.b);
    L7:
        this.$lastValue.element = r4;
        return;
    }
}
