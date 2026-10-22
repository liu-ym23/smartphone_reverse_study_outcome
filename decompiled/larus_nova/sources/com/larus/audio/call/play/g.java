package com.larus.audio.call.play;

import com.larus.voicecall.impl.plugins.i0;
import com.larus.voicecall.impl.plugins.j0;
import com.larus.voicecall.impl.plugins.k0;
import com.larus.voicecall.impl.plugins.s0;
import com.larus.voicecall.impl.plugins.t0;
import com.larus.voicecall.impl.plugins.u0;
import com.larus.voicecall.impl.plugins.v0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<byte[], Unit> f289324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<byte[], Unit> f289325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<byte[], Unit> f289326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<byte[], Unit> f289327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<byte[], Unit> f289328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<byte[], Unit> f289329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<byte[], String, String, Unit> f289330g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f289324a, r101.f289324a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f289325b, r101.f289325b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f289326c, r101.f289326c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f289327d, r101.f289327d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f289328e, r101.f289328e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f289329f, r101.f289329f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f289330g, r101.f289330g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f289324a.hashCode() * 31) + this.f289325b.hashCode()) * 31) + this.f289326c.hashCode()) * 31) + this.f289327d.hashCode()) * 31) + this.f289328e.hashCode()) * 31) + this.f289329f.hashCode()) * 31) + this.f289330g.hashCode();
    }

    public final String toString() {
        return "DumpConfig(rawTTSPerRound=" + this.f289324a + ", rawTTSAll=" + this.f289325b + ", processedTTSAll=" + this.f289326c + ", processedTTSPerRound=" + this.f289327d + ", rawTTSPerRoundWithSilent=" + this.f289328e + ", processedTTSPerRoundWithSilent=" + this.f289329f + ", firstFrame=" + this.f289330g + ')';
    }

    public g(s0 r100, t0 r101, u0 r102, v0 r103, i0 r104, j0 r105, k0 r106) {
        Intrinsics.checkNotNullParameter(r100, "rawTTSPerRound");
        Intrinsics.checkNotNullParameter(r101, "rawTTSAll");
        Intrinsics.checkNotNullParameter(r102, "processedTTSAll");
        Intrinsics.checkNotNullParameter(r103, "processedTTSPerRound");
        Intrinsics.checkNotNullParameter(r104, "rawTTSPerRoundWithSilent");
        Intrinsics.checkNotNullParameter(r105, "processedTTSPerRoundWithSilent");
        Intrinsics.checkNotNullParameter(r106, "firstFrame");
        this.f289324a = r100;
        this.f289325b = r101;
        this.f289326c = r102;
        this.f289327d = r103;
        this.f289328e = r104;
        this.f289329f = r105;
        this.f289330g = r106;
    }
}
