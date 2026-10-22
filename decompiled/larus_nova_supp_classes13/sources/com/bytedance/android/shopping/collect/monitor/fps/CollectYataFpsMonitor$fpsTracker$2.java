package com.bytedance.android.shopping.collect.monitor.fps;

import et3.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Let3/c;", "invoke", "()Let3/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class CollectYataFpsMonitor$fpsTracker$2 extends Lambda implements Function0<c> {
    final /* synthetic */ CollectYataFpsMonitor this$0;

    public CollectYataFpsMonitor$fpsTracker$2(CollectYataFpsMonitor r1) {
        this.this$0 = r1;
        super(0);
    }

    public final c invoke() {
        String r0 = this.this$0.a.getSceneName();
        c r1 = new c(r0);
        r1.c(new CollectYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(this, r0));
        return r1;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m682invoke() {
        return invoke();
    }
}
