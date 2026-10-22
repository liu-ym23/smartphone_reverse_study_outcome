package com.larus.navigation.api;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f359643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f359644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f359645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f359646d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f359643a, r101.f359643a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f359644b, r101.f359644b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f359645c, r101.f359645c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359646d, r101.f359646d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f359643a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f359644b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f359645c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f359646d;
        if (r106 != null) goto L5;
        int r107 = 0;
    L7:
        return r105 + r107;
    L5:
        r107 = r106.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowNaviGeoPoint(latitude=" + this.f359643a + ", longitude=" + this.f359644b + ", altitude=" + this.f359645c + ", name=" + this.f359646d + ')';
    }

    public a(double r100, double r101, double r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        this.f359643a = r100;
        this.f359644b = r101;
        this.f359645c = r102;
        this.f359646d = null;
        boolean r104 = true;
        if ((-90.0d) <= r100) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L23;
        if ((-180.0d) <= r101) goto L15;
    L17:
        r104 = false;
    L18:
        if (r104 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException(("longitude must be in range [-180.0, 180.0], was " + r101).toString());
    L15:
        if (r101 > 180.0d) goto L17;
    L23:
        throw new IllegalArgumentException(("latitude must be in range [-90.0, 90.0], was " + r100).toString());
    L8:
        if (r100 > 90.0d) goto L10;
        r105 = true;
        goto L11
    }
}
