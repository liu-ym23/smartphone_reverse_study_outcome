package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class SSRFetcher$registerCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ISSRFetchCallback $cb;
    final /* synthetic */ b this$0;

    public SSRFetcher$registerCallback$1(b r1, ISSRFetchCallback r2) {
        this.this$0 = r1;
        this.$cb = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m452invoke() {
        b r0 = this.this$0;
        int r1 = b.b;
        monitor-enter(r0);
        r0.getClass();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m452invoke();
        return Unit.INSTANCE;
    }
}
