package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "D", "it", "Lcom/bytedance/assem/arch/extensions/m;", "invoke", "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/m;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$7 extends Lambda implements Function1<a, m<Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;

    public AssemServiceExtKt$selectSubscribeService$7(KProperty1 r1, KProperty1 r2, KProperty1 r3, KProperty1 r4) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        this.$prop3 = r3;
        this.$prop4 = r4;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }

    public final m<Object, Object, Object, Object> invoke(a r6) {
        return new m(this.$prop1.get(r6), this.$prop2.get(r6), this.$prop3.get(r6), this.$prop4.get(r6));
    }
}
