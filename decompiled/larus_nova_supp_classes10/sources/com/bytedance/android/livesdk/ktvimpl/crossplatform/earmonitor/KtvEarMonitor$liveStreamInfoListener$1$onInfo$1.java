package com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor;

import com.bytedance.android.livesdk.sharedpref.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import pd2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class KtvEarMonitor$liveStreamInfoListener$1$onInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KtvEarMonitor.f this$0;

    public KtvEarMonitor$liveStreamInfoListener$1$onInfo$1(KtvEarMonitor.f r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m252invoke() {
        if (this.this$0.a.d.get() == true) goto L5;
        this.this$0.a.g();
        d.n.getClass();
        d.z();
    L5:
        KtvEarMonitor r0 = this.this$0.a;
        r0.d.set(true);
        r0.b();
        r0.q();
        Boolean r1 = (Boolean) c.j.getValue();
        if (r1 == null) goto L9;
        r1.booleanValue();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m252invoke();
        return Unit.INSTANCE;
    }
}
