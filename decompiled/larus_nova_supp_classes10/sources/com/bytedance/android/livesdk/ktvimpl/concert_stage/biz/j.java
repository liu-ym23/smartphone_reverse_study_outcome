package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements xb6.b {
    public final /* synthetic */ ConcertStageComponent a;

    public final Pair<Boolean, String> a() {
        return xb6.b.a.k();
    }

    public final Pair<Boolean, String> b() {
        return xb6.b.a.a();
    }

    public final Pair<Boolean, String> c() {
        return xb6.b.a.b();
    }

    public final Pair<Boolean, String> e() {
        return xb6.b.a.e();
    }

    public final Pair<Boolean, String> g() {
        return xb6.b.a.l();
    }

    public final Pair<Boolean, String> h() {
        return xb6.b.a.g();
    }

    public final Pair<Boolean, String> k() {
        return xb6.b.a.i();
    }

    public final Pair<Boolean, String> m() {
        return xb6.b.a.c();
    }

    public j(ConcertStageComponent r1) {
        this.a = r1;
    }

    public final Pair<Boolean, String> d(z0 r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r4.getSwitchToSilence() == false) goto L19;
        js1.a r5 = this.a.n;
        if (r5 == null) goto L9;
        vb6.g r6 = r5.a;
        if (r6 == null) goto L9;
        yb6.e r7 = r6.j();
    L11:
        if (r7 == null) goto L13;
        r7.d0(StreamType.AUDIO, "handleKickOutMsg switchToSilence");
    L13:
        if (r7 == null) goto L15;
        r7.g0(false, "handleKickOutMsg switchToSilence");
    L15:
        if (r7 == null) goto L18;
        r7.v();
    L18:
        return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
    L9:
        r7 = null;
        goto L11
    L19:
        js1.a r8 = this.a.n;
        if (r8 == null) goto L24;
        vb6.g r9 = r8.a;
        if (r9 == null) goto L24;
        r9.i1("leave chorus", false);
    L24:
        f2.b(2131915912, 0);
        return new Pair(Boolean.TRUE, "concert chorus");
    }

    public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.d(r2);
    }

    public final Pair<Boolean, String> j(z0 r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        w.b("ConcertStageComponent", "interceptPermitMsg  hasInitClient " + this.a.s);
        ConcertStageComponent r0 = this.a;
        if (r0.s == true) goto L5;
        r0.r = r4;
        return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
    L5:
        r0.s = false;
        return new Pair(Boolean.FALSE, "chorus concert interceptPermitMsg");
    }

    public final Pair<Boolean, String> l(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.m(r2);
    }

    public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "secToUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserIdString");
        return xb6.b.a.j(r3, r4);
    }
}
