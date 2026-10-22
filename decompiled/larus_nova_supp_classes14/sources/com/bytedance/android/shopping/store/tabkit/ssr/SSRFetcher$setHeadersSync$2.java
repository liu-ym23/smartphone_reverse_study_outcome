package com.bytedance.android.shopping.store.tabkit.ssr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bytes", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class SSRFetcher$setHeadersSync$2 extends Lambda implements Function1<byte[], Unit> {
    final /* synthetic */ b this$0;

    public SSRFetcher$setHeadersSync$2(b r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(byte[] r4) {
        b r0 = this.this$0;
        int r1 = b.b;
        r0.c("t_tab_ssr_rcv_hydrate_url_res", null);
        b.a(this.this$0, r4, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((byte[]) r1);
        return Unit.INSTANCE;
    }
}
