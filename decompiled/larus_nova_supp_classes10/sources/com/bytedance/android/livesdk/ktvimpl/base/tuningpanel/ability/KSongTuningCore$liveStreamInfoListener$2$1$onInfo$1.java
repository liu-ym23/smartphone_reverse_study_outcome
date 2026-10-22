package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import pd2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class KSongTuningCore$liveStreamInfoListener$2$1$onInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KSongTuningCore$liveStreamInfoListener$2.a this$0;

    public KSongTuningCore$liveStreamInfoListener$2$1$onInfo$1(KSongTuningCore$liveStreamInfoListener$2.a r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m218invoke() {
        if (this.this$0.a.this$0.b.f.get() == true) goto L5;
        this.this$0.a.this$0.getClass();
        d.n.getClass();
        d.z();
    L5:
        b r0 = this.this$0.a.this$0;
        r0.b.f.set(true);
        r0.b();
        r0.P();
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue();
        if (r1 == null) goto L8;
        r1.booleanValue();
    L8:
        xs2.b.a().post(new cb0.b(0));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m218invoke();
        return Unit.INSTANCE;
    }
}
