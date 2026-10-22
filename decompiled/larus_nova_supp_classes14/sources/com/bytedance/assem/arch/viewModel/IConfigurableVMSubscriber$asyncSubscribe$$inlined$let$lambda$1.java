package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.reused.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "T", "LLcom/bytedance/tiktok/proxy/IVMReceiver;;", "RECEIVER", "Lcom/bytedance/assem/arch/extensions/c;", "async", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/c;)V", "om/bytedance/assem/arch/viewModel/IConfigurableVMSubscriber.asyncSubscribe.1.", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$asyncSubscribe$$inlined$let$lambda$1 extends Lambda implements Function1<com.bytedance.assem.arch.extensions.c<Object>, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ com.bytedance.tiktok.proxy.c $holder;
    final /* synthetic */ Function2 $onError$inlined;
    final /* synthetic */ Function1 $onLoading$inlined;
    final /* synthetic */ Function2 $onSuccess$inlined;
    final /* synthetic */ KProperty1 $prop$inlined;
    final /* synthetic */ AssemViewModel $this_asyncSubscribe$inlined;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$asyncSubscribe$$inlined$let$lambda$1(com.bytedance.tiktok.proxy.c r1, e r2, AssemViewModel r3, i r4, KProperty1 r5, Function1 r6, Function2 r7, Function2 r8) {
        this.$holder = r1;
        this.this$0 = r2;
        this.$this_asyncSubscribe$inlined = r3;
        this.$config$inlined = r4;
        this.$prop$inlined = r5;
        this.$onLoading$inlined = r6;
        this.$onError$inlined = r7;
        this.$onSuccess$inlined = r8;
        super(1);
    }

    public final void invoke(final com.bytedance.assem.arch.extensions.c<Object> r3) {
        final com.bytedance.tiktok.proxy.a r0 = this.$holder.oq();
        if (r0 == null) goto L6;
        o.a(r0, new AnonymousClass1(r0, this, r3));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.assem.arch.extensions.c) r1);
        return Unit.INSTANCE;
    }
}
