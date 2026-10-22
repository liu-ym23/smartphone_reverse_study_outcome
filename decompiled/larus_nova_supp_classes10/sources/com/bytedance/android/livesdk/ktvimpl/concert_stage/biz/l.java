package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.view.SurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends gd2.a {
    public final /* synthetic */ ConcertStageComponent a;

    public l(ConcertStageComponent r1) {
        this.a = r1;
    }

    public final void d(String r2, final SurfaceView r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!Intrinsics.areEqual(r2, this.a.q)) == true) goto L9;
        this.a.o = r3;
        w.b("ConcertStageComponent", "onFirstRemoteVideoFrame");
        this.a.l(new ConcertStageComponent$rtcLinkListener$1$onFirstRemoteVideoFrame$1(r3));
        ConcertStageComponent.j(this.a);
        return;
    }
}
