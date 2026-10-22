package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PdpDataFetchService$onError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $statusCode;
    final /* synthetic */ String $statusMsg;
    final /* synthetic */ PdpDataFetchService this$0;

    public PdpDataFetchService$onError$1(PdpDataFetchService r1, int r2, String r3) {
        this.this$0 = r1;
        this.$statusCode = r2;
        this.$statusMsg = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2627invoke() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.b(this.this$0, "onError: " + this.$statusCode + ", " + this.$statusMsg, null);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n> r0 = this.this$0.d2();
        if ((r0.a instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c) == false) goto L5;
        this.this$0.f2(com.bytedance.android.shopping.prepurchase.arch.container.intf.l.a(r0, new com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a(this.$statusCode, this.$statusMsg), null, 2));
        return;
    L5:
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.b(this.this$0, "receive error, but currentState isn't Loading.status=" + this.$statusCode + ", msg=" + this.$statusMsg + ", " + r0, null);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2627invoke();
        return Unit.INSTANCE;
    }
}
