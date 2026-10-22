package com.bytedance.lighten.core.config;

import androidx.camera.video.AudioStats;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f254670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f254671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f254672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f254673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f254674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f254675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f254676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f254677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f254678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f254679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f254680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Integer> f254681l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L41:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L40;
        b r101 = (b) r100;
        if (this.f254670a != r101.f254670a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L40;
        if (this.f254671b != r101.f254671b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L40;
        if (Double.compare(this.f254672c, r101.f254672c) != 0) goto L40;
        if (Double.compare(this.f254673d, r101.f254673d) != 0) goto L40;
        if (Double.compare(this.f254674e, r101.f254674e) != 0) goto L40;
        if (Double.compare(this.f254675f, r101.f254675f) != 0) goto L40;
        if (Double.compare(this.f254676g, r101.f254676g) != 0) goto L40;
        if (Double.compare(this.f254677h, r101.f254677h) != 0) goto L40;
        if (this.f254678i != r101.f254678i) goto L31;
        boolean r104 = true;
    L32:
        if (r104 == false) goto L40;
        if (Double.compare(this.f254679j, r101.f254679j) != 0) goto L40;
        if (Double.compare(this.f254680k, r101.f254680k) != 0) goto L40;
        if (Intrinsics.areEqual(this.f254681l, r101.f254681l) == false) goto L40;
    L31:
        r104 = false;
        goto L32
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    public final int hashCode() {
        boolean r100 = this.f254670a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f254671b) * 31;
        long r103 = Double.doubleToLongBits(this.f254672c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.f254673d);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.f254674e);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = Double.doubleToLongBits(this.f254675f);
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = Double.doubleToLongBits(this.f254676g);
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = Double.doubleToLongBits(this.f254677h);
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f254678i) * 31;
        long r115 = Double.doubleToLongBits(this.f254679j);
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = Double.doubleToLongBits(this.f254680k);
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        List<Integer> r119 = this.f254681l;
        if (r119 == null) goto L8;
        int r120 = r119.hashCode();
    L10:
        return r118 + r120;
    L8:
        r120 = 0;
        goto L10
    }

    public final String toString() {
        return "LightenFrescoPoolLazyConfig(enable=" + this.f254670a + ", bitmapPoolType=" + this.f254671b + ", bitmapPoolMaxPoolSize=" + this.f254672c + ", bitmapPoolMaxBitmapSize=" + this.f254673d + ", nativeChunkSoftCapMb=" + this.f254674e + ", nativeChunkHardCapMb=" + this.f254675f + ", flexByteArrayMinKb=" + this.f254676g + ", flexByteArrayMaxKb=" + this.f254677h + ", flexByteArrayMaxThreads=" + this.f254678i + ", smallByteArraySoftCapKb=" + this.f254679j + ", smallByteArrayHardCapKb=" + this.f254680k + ", bitmapPoolBuckets=" + this.f254681l + ")";
    }

    public b() {
        this.f254670a = false;
        this.f254671b = 0;
        this.f254672c = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254673d = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254674e = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254675f = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254676g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254677h = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254678i = -1;
        this.f254679j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254680k = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f254681l = null;
    }
}
