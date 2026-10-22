package com.bytedance.assem.arch.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "T", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/extensions/c;", "async", "", "invoke", "(Lcom/bytedance/assem/arch/extensions/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IConfigurableVMSubscriber$asyncSubscribe$2 extends Lambda implements Function1<com.bytedance.assem.arch.extensions.c<Object>, Unit> {
    final /* synthetic */ Function2 $onError;
    final /* synthetic */ Function1 $onLoading;
    final /* synthetic */ Function2 $onSuccess;
    final /* synthetic */ e this$0;

    public IConfigurableVMSubscriber$asyncSubscribe$2(e r1, Function1 r2, Function2 r3, Function2 r4) {
        this.this$0 = r1;
        this.$onLoading = r2;
        this.$onError = r3;
        this.$onSuccess = r4;
        super(1);
    }

    public final void invoke(com.bytedance.assem.arch.extensions.c<Object> r3) {
        com.bytedance.tiktok.proxy.a r0 = this.this$0.dh();
        if (r0 != null) goto L6;
        r0 = this.this$0.pF().oq();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r3 instanceof com.bytedance.assem.arch.extensions.h) == false) goto L13;
        Function1 r4 = this.$onLoading;
        if (r4 == null) goto L24;
        r4.invoke(r0);
        return;
    L24:
        return;
    L13:
        if ((r3 instanceof com.bytedance.assem.arch.extensions.e) == false) goto L18;
        Function2 r1 = this.$onError;
        if (r1 == null) goto L26;
        r1.invoke(r0, ((com.bytedance.assem.arch.extensions.e) r3).a);
        return;
    L26:
        return;
    L18:
        if ((r3 instanceof com.bytedance.assem.arch.extensions.i) == false) goto L28;
        Function2 r2 = this.$onSuccess;
        if (r2 == null) goto L29;
        r2.invoke(r0, ((com.bytedance.assem.arch.extensions.i) r3).a);
        return;
    L29:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.assem.arch.extensions.c) r1);
        return Unit.INSTANCE;
    }
}
