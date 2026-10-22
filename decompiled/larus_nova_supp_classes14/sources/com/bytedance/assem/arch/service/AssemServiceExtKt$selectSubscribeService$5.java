package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "it", "Lcom/bytedance/assem/arch/extensions/l;", "invoke", "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/l;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$5 extends Lambda implements Function1<a, l<Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;

    public AssemServiceExtKt$selectSubscribeService$5(KProperty1 r1, KProperty1 r2, KProperty1 r3) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        this.$prop3 = r3;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }

    public final l<Object, Object, Object> invoke(a r5) {
        return new l(this.$prop1.get(r5), this.$prop2.get(r5), this.$prop3.get(r5));
    }
}
