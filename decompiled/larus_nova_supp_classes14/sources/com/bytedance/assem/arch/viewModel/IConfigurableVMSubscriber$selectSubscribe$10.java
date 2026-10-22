package com.bytedance.assem.arch.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0011\u001a\u00020\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u0006\"\b\b\u0006\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u00042\u0006\u0010\r\u001a\u00028\u0005H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "A", "B", "C", "D", "E", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "a", "b", "c", "d", "e", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$selectSubscribe$10 extends Lambda implements Function5<Object, Object, Object, Object, Object, Unit> {
    final /* synthetic */ Function6 $subscriber;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$selectSubscribe$10(e r1, Function6 r2) {
        this.this$0 = r1;
        this.$subscriber = r2;
        super(5);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1169invoke(Object r9, Object r10, Object r11, Object r12, Object r13) {
        com.bytedance.tiktok.proxy.a r0 = this.this$0.dh();
        if (r0 != null) goto L6;
        r0 = this.this$0.pF().oq();
    L6:
        com.bytedance.tiktok.proxy.a r2 = r0;
        if (r2 == null) goto L10;
        Unit r14 = (Unit) this.$subscriber.invoke(r2, r9, r10, r11, r12, r13);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        m1169invoke(r1, r2, r3, r4, r5);
        return Unit.INSTANCE;
    }
}
