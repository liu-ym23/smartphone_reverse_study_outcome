package com.bytedance.assem.arch.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\b\b\u0005\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u00022\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0004H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "C", "D", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "a", "b", "c", "d", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$8 extends Lambda implements Function4<Object, Object, Object, Object, Unit> {
    final /* synthetic */ Function5 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$8(e r1, Function5 r2) {
        this.this$0 = r1;
        this.$subscriber = r2;
        super(4);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1173invoke(Object r8, Object r9, Object r10, Object r11) {
        com.bytedance.tiktok.proxy.a r0 = this.this$0.dh();
        if (r0 != null) goto L6;
        r0 = this.this$0.pF().oq();
    L6:
        com.bytedance.tiktok.proxy.a r2 = r0;
        if (r2 == null) goto L10;
        Unit r12 = (Unit) this.$subscriber.invoke(r2, r8, r9, r10, r11);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        m1173invoke(r1, r2, r3, r4);
        return Unit.INSTANCE;
    }
}
