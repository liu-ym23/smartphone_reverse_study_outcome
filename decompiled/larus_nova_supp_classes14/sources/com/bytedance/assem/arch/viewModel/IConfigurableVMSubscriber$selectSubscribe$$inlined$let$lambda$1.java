package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.reused.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\n\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "LLcom/bytedance/tiktok/proxy/IVMReceiver;;", "RECEIVER", "a", "", "nvok", "(Ljava/lang/Object;)V", "com/bytedance/assem/arch/viewModel/IConfigurableVMSubscriber$selectSubscribe$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$$inlined$let$lambda$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ com.bytedance.tiktok.proxy.c $it;
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ KProperty1 $prop1$inlined;
    final /* synthetic */ Function2 $subscriber$inlined;
    final /* synthetic */ AssemViewModel $this_selectSubscribe$inlined;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$$inlined$let$lambda$1(com.bytedance.tiktok.proxy.c r1, e r2, AssemViewModel r3, i r4, KProperty1 r5, Function1 r6, Function2 r7) {
        this.$it = r1;
        this.this$0 = r2;
        this.$this_selectSubscribe$inlined = r3;
        this.$config$inlined = r4;
        this.$prop1$inlined = r5;
        this.$onError$inlined = r6;
        this.$subscriber$inlined = r7;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1159invoke(final Object r3) {
        final com.bytedance.tiktok.proxy.a r0 = this.$it.oq();
        if (r0 == null) goto L6;
        o.a(r0, new AnonymousClass1(r0, this, r3));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1159invoke(r1);
        return Unit.INSTANCE;
    }
}
