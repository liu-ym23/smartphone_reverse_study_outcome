package com.lynx.tasm;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f383510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxMemoryCollectionStatus f383511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f383512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f383513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f383514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f383515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f383516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f383517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f383518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f383519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f383520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f383521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f383522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f383523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<r0> f383524o;

    public static p0 a(long r210, LynxMemoryCollectionStatus r310, long r311, long r312, int r313, long r314, List<r0> r315) {
        HashMap r100 = new HashMap();
        Iterator<r0> r101 = r315.iterator();
        long r102 = 0;
        long r110 = 0;
        long r111 = 0;
        long r211 = 0;
        long r212 = 0;
    L4:
        if (r101.hasNext() == false) goto L17;
        r0 r103 = r101.next();
        r110 = r110 + r103.f383575e;
        r111 = r111 + r103.f383576f;
        r211 = r211 + r103.f383577g;
        r212 = r212 + r103.f383579i;
        String r104 = r103.f383581k;
        if (r104 == null) goto L16;
        if (r104.isEmpty() == true) goto L16;
        if ("-1".equals(r104) == true) goto L16;
        if (r100.containsKey(r104) == false) goto L14;
        long r105 = ((Long) r100.get(r104)).longValue();
    L15:
        r100.put(r104, Long.valueOf(Math.max(r105, r103.f383580j)));
        goto L4
    L14:
        r105 = 0;
    L16:
        r102 = r102 + r103.f383580j;
        goto L4
    L17:
        Iterator r106 = r100.values().iterator();
        long r213 = r102;
    L19:
        if (r106.hasNext() == false) goto L21;
        r213 = r213 + ((Long) r106.next()).longValue();
        goto L19
    L21:
        long r112 = ((r110 + r211) + r212) + r213;
        if (r314 <= 0) goto L24;
        double r107 = r112 / r314;
    L26:
        return new p0(r210, r310, r311, r312, r313, r315.size(), r112, r314, r107, r110, r111, r211, r212, r213, r315);
    L24:
        r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L26
    }

    public p0(long r100, LynxMemoryCollectionStatus r101, long r102, long r103, int r110, int r111, long r112, long r113, double r114, long r115, long r210, long r211, long r212, long r213, List<r0> r214) {
        this.f383510a = r100;
        this.f383511b = r101;
        this.f383512c = r102;
        this.f383513d = r103;
        this.f383514e = r110;
        this.f383515f = r111;
        this.f383516g = r112;
        this.f383517h = r113;
        this.f383518i = r114;
        this.f383519j = r115;
        this.f383520k = r210;
        this.f383521l = r211;
        this.f383522m = r212;
        this.f383523n = r213;
        ArrayList r104 = new ArrayList(r214);
        Collections.sort(r104, new o0());
        this.f383524o = Collections.unmodifiableList(r104);
    }
}
