package com.larus.dora.impl.alive;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements by7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f332003a;

    public g() {
        this.f332003a = "device_manage";
    }

    @Override // by7.e
    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    @Override // by7.e
    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("current_page", this.f332003a);
    }
}
