package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.j;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "Lcom/bytedance/assem/arch/viewModel/h;", "S", "it", "Lcom/bytedance/assem/arch/extensions/j;", "invoke", "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/j;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$11 extends Lambda implements Function1<a, j<Object>> {
    final /* synthetic */ KProperty1 $prop1;

    public AssemServiceExtKt$selectSubscribeService$11(KProperty1 r1) {
        this.$prop1 = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }

    public final j<Object> invoke(a r3) {
        return new j(this.$prop1.get(r3));
    }
}
