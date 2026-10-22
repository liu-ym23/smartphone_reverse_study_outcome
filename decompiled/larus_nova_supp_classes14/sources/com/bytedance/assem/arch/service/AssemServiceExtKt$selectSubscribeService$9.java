package com.bytedance.assem.arch.service;

import com.bytedance.assem.arch.extensions.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", "A", "B", "C", "D", "E", "it", "Lcom/bytedance/assem/arch/extensions/n;", "invoke", "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/n;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$9 extends Lambda implements Function1<a, n<Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;

    public AssemServiceExtKt$selectSubscribeService$9(KProperty1 r1, KProperty1 r2, KProperty1 r3, KProperty1 r4, KProperty1 r5) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        this.$prop3 = r3;
        this.$prop4 = r4;
        this.$prop5 = r5;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((a) r1);
    }

    public final n<Object, Object, Object, Object, Object> invoke(a r8) {
        return new n(this.$prop1.get(r8), this.$prop2.get(r8), this.$prop3.get(r8), this.$prop4.get(r8), this.$prop5.get(r8));
    }
}
