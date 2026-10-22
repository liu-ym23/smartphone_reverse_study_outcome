package com.larus.im.internal.tracking.network;

import androidx.camera.video.AudioStats;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f350450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Double> f350451b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Double.compare(this.f350450a, r101.f350450a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350451b, r101.f350451b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f350450a);
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f350451b.hashCode();
    }

    public final String toString() {
        return "NetworkTrackSamplingConfig(defaultSampleRate=" + this.f350450a + ", pathSampleRates=" + this.f350451b + ')';
    }

    public /* synthetic */ z() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, MapsKt.emptyMap());
    }

    public z(double r100, Map<String, Double> r101) {
        Intrinsics.checkNotNullParameter(r101, "pathSampleRates");
        this.f350450a = r100;
        this.f350451b = r101;
    }
}
