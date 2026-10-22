package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\b\b\u0003\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "Lcom/bytedance/assem/arch/viewModel/h;", "S", "it", "Lcom/bytedance/assem/arch/extensions/k;", "invoke", "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/k;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$15 extends Lambda implements Function1<a, k<Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;

    public AssemServiceExtKt$selectSubscribeService$15(KProperty1 r1, KProperty1 r2) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }

    public final k<Object, Object> invoke(a r4) {
        return new k(this.$prop1.get(r4), this.$prop2.get(r4));
    }
}
