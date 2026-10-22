package com.bytedance.android.shopping.collect.monitor.fps;

import et3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CollectYataFpsMonitor$stop$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CollectYataFpsMonitor this$0;

    public CollectYataFpsMonitor$stop$1(CollectYataFpsMonitor r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m685invoke() {
        ((c) this.this$0.b.getValue()).f();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m685invoke();
        return Unit.INSTANCE;
    }
}
