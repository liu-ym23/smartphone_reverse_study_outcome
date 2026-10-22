package com.bytedance.assem.arch.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\b\b\u0004\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0003H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "C", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "a", "b", "c", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$6 extends Lambda implements Function3<Object, Object, Object, Unit> {
    final /* synthetic */ Function4 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$6(e r1, Function4 r2) {
        this.this$0 = r1;
        this.$subscriber = r2;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1172invoke(Object r3, Object r4, Object r5) {
        com.bytedance.tiktok.proxy.a r0 = this.this$0.dh();
        if (r0 != null) goto L6;
        r0 = this.this$0.pF().oq();
    L6:
        if (r0 == null) goto L9;
        Unit r6 = (Unit) this.$subscriber.invoke(r0, r3, r4, r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        m1172invoke(r1, r2, r3);
        return Unit.INSTANCE;
    }
}
