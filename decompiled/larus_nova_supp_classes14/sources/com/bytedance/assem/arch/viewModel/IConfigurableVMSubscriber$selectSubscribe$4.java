package com.bytedance.assem.arch.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\b\b\u0003\u0010\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "a", "b", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$4 extends Lambda implements Function2<Object, Object, Unit> {
    final /* synthetic */ Function3 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$4(e r1, Function3 r2) {
        this.this$0 = r1;
        this.$subscriber = r2;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1171invoke(Object r3, Object r4) {
        com.bytedance.tiktok.proxy.a r0 = this.this$0.dh();
        if (r0 != null) goto L6;
        r0 = this.this$0.pF().oq();
    L6:
        if (r0 == null) goto L9;
        Unit r5 = (Unit) this.$subscriber.invoke(r0, r3, r4);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        m1171invoke(r1, r2);
        return Unit.INSTANCE;
    }
}
