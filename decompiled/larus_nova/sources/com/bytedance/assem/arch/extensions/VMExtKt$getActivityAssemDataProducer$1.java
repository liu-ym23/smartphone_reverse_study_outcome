package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/assem/arch/core/b;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/assem/arch/core/b;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class VMExtKt$getActivityAssemDataProducer$1 extends Lambda implements Function0<com.bytedance.assem.arch.core.b> {
    final /* synthetic */ FragmentActivity $this_getActivityAssemDataProducer;

    public VMExtKt$getActivityAssemDataProducer$1(FragmentActivity r100) {
        this.$this_getActivityAssemDataProducer = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ com.bytedance.assem.arch.core.b invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.bytedance.assem.arch.core.b invoke() {
        Assembler.a r100 = Assembler.Companion;
        FragmentActivity r101 = this.$this_getActivityAssemDataProducer;
        r100.getClass();
        return Assembler.a.a(r101).findAssemDataNode(this.$this_getActivityAssemDataProducer);
    }
}
