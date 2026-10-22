package com.larus.doc.impl.offline;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements by7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrackParams f331279a;

    @Override // by7.e
    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    @Override // by7.e
    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public i(TrackParams r100) {
        this.f331279a = r100;
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.merge(this.f331279a);
    }
}
