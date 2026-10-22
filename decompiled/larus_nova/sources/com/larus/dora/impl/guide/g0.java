package com.larus.dora.impl.guide;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g0 implements by7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraKeepAliveGuide f335941a;

    @Override // by7.e
    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    @Override // by7.e
    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public g0(DoraKeepAliveGuide r100) {
        this.f335941a = r100;
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("current_page", this.f335941a.f335913a);
    }
}
