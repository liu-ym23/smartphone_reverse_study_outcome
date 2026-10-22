package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends vb6.a {
    public final /* synthetic */ ConcertStageComponent a;

    public final void H1() {
        w.b("ConcertStageComponent", "onLinkSuccess, rtcSurfaceView: " + this.a.o);
        ConcertStageComponent.j(this.a);
    }

    public final void M1() {
        w.b("ConcertStageComponent", "onEndSuccess, rtcSurfaceView: " + this.a.o);
        ConcertStageComponent r0 = this.a;
        if (r0.w == true) goto L7;
        DataCenter r1 = r0.u;
        if (r1 == null) goto L7;
        r1.put("cmd_interact_state_change", new a1(4));
    L7:
        this.a.t = false;
        hd0.c.f().k(0);
        de2.b.b();
        this.a.o = null;
    }

    public final void Y4() {
        w.b("ConcertStageComponent", "onRtcAdvanceStartSuccess, rtcSurfaceView: " + this.a.o);
        ConcertStageComponent.j(this.a);
    }

    public i(ConcertStageComponent r1) {
        this.a = r1;
    }

    public final void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        c r2 = this.a.p;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.d.get() == true) goto L10;
        c.j();
        com.bytedance.android.live.pushstream.d r4 = c.k();
        if (r4 == null) goto L9;
        r4.I0(r2.f);
    L9:
        c.j();
        r2.b();
        return;
    L10:
        r2.b();
        c.m();
        Boolean r5 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j.getValue();
        if (r5 == null) goto L14;
        r5.booleanValue();
    L14:
        if (r2.d.get() == true) goto L19;
        c.j();
        return;
    }
}
