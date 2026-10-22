package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.reused.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\f\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\b\b\u0003\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0002H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "LLcom/bytedance/tiktok/proxy/IVMReceiver;;", "RECEIVER", "a", "b", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V", "com/bytedance/assem/arch/viewModel/IConfigurableVMSubscriber$selectSubscribeOnAsync$4$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribeOnAsync$$inlined$let$lambda$2 extends Lambda implements Function2<Object, Object, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ com.bytedance.tiktok.proxy.c $it;
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ KProperty1 $prop1$inlined;
    final /* synthetic */ KProperty1 $prop2$inlined;
    final /* synthetic */ Function3 $subscriber$inlined;
    final /* synthetic */ AssemViewModel $this_selectSubscribeOnAsync$inlined;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribeOnAsync$$inlined$let$lambda$2(com.bytedance.tiktok.proxy.c r1, e r2, AssemViewModel r3, i r4, KProperty1 r5, KProperty1 r6, Function1 r7, Function3 r8) {
        this.$it = r1;
        this.this$0 = r2;
        this.$this_selectSubscribeOnAsync$inlined = r3;
        this.$config$inlined = r4;
        this.$prop1$inlined = r5;
        this.$prop2$inlined = r6;
        this.$onError$inlined = r7;
        this.$subscriber$inlined = r8;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1176invoke(final Object r3, final Object r4) {
        final com.bytedance.tiktok.proxy.a r0 = this.$it.oq();
        if (r0 == null) goto L6;
        o.a(r0, new AnonymousClass1(r0, this, r3, r4));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        m1176invoke(r1, r2);
        return Unit.INSTANCE;
    }
}
