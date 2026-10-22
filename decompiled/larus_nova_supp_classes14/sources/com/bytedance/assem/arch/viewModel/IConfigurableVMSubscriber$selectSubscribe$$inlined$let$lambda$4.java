package com.bytedance.assem.arch.viewModel;

import com.bytedance.assem.arch.reused.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0010\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\b\b\u0005\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u00022\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0004H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "C", "D", "LLcom/bytedance/tiktok/proxy/IVMReceiver;;", "RECEIVER", "a", "b", "c", "d", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "com/bytedance/assem/arch/viewModel/IConfigurableVMSubscriber$selectSubscribe$7$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$$inlined$let$lambda$4 extends Lambda implements Function4<Object, Object, Object, Object, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ com.bytedance.tiktok.proxy.c $it;
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ KProperty1 $prop1$inlined;
    final /* synthetic */ KProperty1 $prop2$inlined;
    final /* synthetic */ KProperty1 $prop3$inlined;
    final /* synthetic */ KProperty1 $prop4$inlined;
    final /* synthetic */ Function5 $subscriber$inlined;
    final /* synthetic */ AssemViewModel $this_selectSubscribe$inlined;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$$inlined$let$lambda$4(com.bytedance.tiktok.proxy.c r1, e r2, AssemViewModel r3, i r4, KProperty1 r5, KProperty1 r6, KProperty1 r7, KProperty1 r8, Function1 r9, Function5 r10) {
        this.$it = r1;
        this.this$0 = r2;
        this.$this_selectSubscribe$inlined = r3;
        this.$config$inlined = r4;
        this.$prop1$inlined = r5;
        this.$prop2$inlined = r6;
        this.$prop3$inlined = r7;
        this.$prop4$inlined = r8;
        this.$onError$inlined = r9;
        this.$subscriber$inlined = r10;
        super(4);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1165invoke(final Object r10, final Object r11, final Object r12, final Object r13) {
        final com.bytedance.tiktok.proxy.a r0 = this.$it.oq();
        if (r0 == null) goto L6;
        o.a(r0, new AnonymousClass1(r0, this, r10, r11, r12, r13));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        m1165invoke(r1, r2, r3, r4);
        return Unit.INSTANCE;
    }
}
