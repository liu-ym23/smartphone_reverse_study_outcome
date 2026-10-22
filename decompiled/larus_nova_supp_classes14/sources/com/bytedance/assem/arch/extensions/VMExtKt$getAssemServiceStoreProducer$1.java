package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.assem.arch.core.Assembler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/assem/arch/core/d;", "invoke", "()Lcom/bytedance/assem/arch/core/d;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class VMExtKt$getAssemServiceStoreProducer$1 extends Lambda implements Function0<com.bytedance.assem.arch.core.d> {
    final /* synthetic */ FragmentActivity $this_getAssemServiceStoreProducer;

    public VMExtKt$getAssemServiceStoreProducer$1(FragmentActivity r1) {
        this.$this_getAssemServiceStoreProducer = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1103invoke() {
        return invoke();
    }

    public final com.bytedance.assem.arch.core.d invoke() {
        Assembler.a r0 = Assembler.Companion;
        FragmentActivity r1 = this.$this_getAssemServiceStoreProducer;
        r0.getClass();
        return Assembler.a.a(r1).findAssemServiceStore(this.$this_getAssemServiceStoreProducer);
    }
}
