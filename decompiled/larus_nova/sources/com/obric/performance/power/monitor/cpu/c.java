package com.obric.performance.power.monitor.cpu;

import androidx.camera.video.AudioStats;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f403816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f403817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f403818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f403819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f403820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f403821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, Map<Long, Long>> f403822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f403823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f403824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Integer, Long> f403825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<Integer, Map<Integer, Long>> f403826k;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Double.compare(this.f403816a, r101.f403816a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f403817b, r101.f403817b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f403818c, r101.f403818c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f403819d, r101.f403819d) == 0) goto L21;
        return false;
    L21:
        if (this.f403820e == r101.f403820e) goto L24;
        return false;
    L24:
        if (this.f403821f == r101.f403821f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f403822g, r101.f403822g) == true) goto L30;
        return false;
    L30:
        if (this.f403823h == r101.f403823h) goto L33;
        return false;
    L33:
        if (this.f403824i == r101.f403824i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f403825j, r101.f403825j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f403826k, r101.f403826k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f403816a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f403817b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f403818c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f403819d);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f403820e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f403821f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Map<Integer, Map<Long, Long>> r112 = this.f403822g;
        int r113 = 0;
        if (r112 != null) goto L5;
        int r114 = 0;
    L6:
        long r115 = this.f403823h;
        int r116 = (((r111 + r114) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f403824i;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        Map<Integer, Long> r119 = this.f403825j;
        if (r119 != null) goto L9;
        int r120 = 0;
    L10:
        int r121 = (r118 + r120) * 31;
        Map<Integer, Map<Integer, Long>> r122 = this.f403826k;
        if (r122 == null) goto L15;
        r113 = r122.hashCode();
    L15:
        return r121 + r113;
    L9:
        r120 = r119.hashCode();
        goto L10
    L5:
        r114 = r112.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("(cpuUsage:");
        r100.append(this.f403816a);
        r100.append(", cpuSpeed:");
        r100.append(this.f403817b);
        r100.append(", normalizerCpuUsage:");
        r100.append(this.f403818c);
        r100.append(", systemCpuUsage:");
        r100.append(this.f403819d);
        r100.append(", deviceCpuTime:");
        r100.append(this.f403820e);
        r100.append(", deviceIdleTime:");
        r100.append(this.f403821f);
        r100.append(", deviceFreqCpuMap:");
        Object r101 = this.f403822g;
        Object r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(", processCpuTime:");
        r100.append(this.f403823h);
        r100.append(", processWallTime:");
        r100.append(this.f403824i);
        r100.append(", threadCpuMap:");
        r100.append(this.f403825j);
        r100.append(", threadPolicyCpuMap:");
        Map<Integer, Map<Integer, Long>> r103 = this.f403826k;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    }

    public c(Object r100) {
        this.f403816a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f403817b = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f403818c = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f403819d = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f403820e = 0;
        this.f403821f = 0;
        this.f403822g = null;
        this.f403823h = 0;
        this.f403824i = 0;
        this.f403825j = null;
        this.f403826k = null;
    }
}
