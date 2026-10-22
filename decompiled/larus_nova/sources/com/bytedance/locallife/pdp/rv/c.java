package com.bytedance.locallife.pdp.rv;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f261705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f261706b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Double.compare(this.f261705a, r101.f261705a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f261706b, r101.f261706b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f261705a);
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f261706b.hashCode();
    }

    public final String toString() {
        return "RVItemExposureConfig(rate=" + this.f261705a + ", noticeName=" + this.f261706b + ')';
    }

    public c() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, "poi_nested_scroll_pingback");
    }

    public c(double r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "noticeName");
        this.f261705a = r100;
        this.f261706b = r101;
    }
}
