package com.bytedance.gkfs.cdc;

import com.bytedance.gkfs.io.p;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f245150g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f245151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f245153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.bytedance.gkfs.io.c, Long> f245154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<com.bytedance.gkfs.io.c, Long> f245155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f245156f;

    public static final class a {
    }

    public c() {
        this(null, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f245151a, r101.f245151a) == true) goto L8;
        return false;
    L8:
        if (this.f245152b == r101.f245152b) goto L10;
        return false;
    L10:
        if (this.f245153c == r101.f245153c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245154d, r101.f245154d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f245155e, r101.f245155e) == true) goto L16;
        return false;
    L16:
        if (this.f245156f == r101.f245156f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        p r100 = this.f245151a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f245152b) * 31) + this.f245153c) * 31;
        Map<com.bytedance.gkfs.io.c, Long> r104 = this.f245154d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<com.bytedance.gkfs.io.c, Long> r107 = this.f245155e;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f245156f;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSCDCStatistics(status=" + this.f245151a + ", minSizeSuppress=" + this.f245152b + ", maxSizeSuppress=" + this.f245153c + ", chunkCDCTimeCost=" + this.f245154d + ", chunkTimeCost=" + this.f245155e + ", totalTimeCost=" + this.f245156f + ")";
    }

    static {
        f245150g = new c(null, 0, 63);
    }

    public c(p r100, long r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = p.f245245d;
    L5:
        p r101 = r100;
        if ((r111 & 8) == 0) goto L8;
        Map r102 = MapsKt.emptyMap();
    L10:
        if ((r111 & 16) == 0) goto L12;
        Map r103 = MapsKt.emptyMap();
    L14:
        if ((r111 & 32) == 0) goto L16;
        r110 = 0;
    L16:
        this(r101, 0, 0, r102, r103, r110);
        return;
    L12:
        r103 = null;
        goto L14
    L8:
        r102 = null;
        goto L10
    }

    public c(p r100, int r101, int r102, Map<com.bytedance.gkfs.io.c, Long> r103, Map<com.bytedance.gkfs.io.c, Long> r104, long r105) {
        this.f245151a = r100;
        this.f245152b = r101;
        this.f245153c = r102;
        this.f245154d = r103;
        this.f245155e = r104;
        this.f245156f = r105;
    }
}
