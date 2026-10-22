package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class ConcertEarMonitor$liveStreamInfoListener$1$onInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c.C0015c this$0;

    public ConcertEarMonitor$liveStreamInfoListener$1$onInfo$1(c.C0015c r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m236invoke() {
        if (this.this$0.a.d.get() == true) goto L5;
        this.this$0.a.getClass();
        c.j();
        pd2.d.n.getClass();
        pd2.d.z();
    L5:
        c r0 = this.this$0.a;
        r0.d.set(true);
        r0.b();
        c.m();
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue();
        if (r1 == null) goto L9;
        r1.booleanValue();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m236invoke();
        return Unit.INSTANCE;
    }
}
