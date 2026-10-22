package com.larus.audioplayer.impl.stream;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f290420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f290421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f290422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f290423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f290424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final short f290425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final short f290426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f290427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f290428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short f290429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final short f290430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f290431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f290432m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f290420a, r101.f290420a) == true) goto L12;
        return false;
    L12:
        if (this.f290421b == r101.f290421b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f290422c, r101.f290422c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f290423d, r101.f290423d) == true) goto L21;
        return false;
    L21:
        if (this.f290424e == r101.f290424e) goto L24;
        return false;
    L24:
        if (this.f290425f == r101.f290425f) goto L27;
        return false;
    L27:
        if (this.f290426g == r101.f290426g) goto L30;
        return false;
    L30:
        if (this.f290427h == r101.f290427h) goto L33;
        return false;
    L33:
        if (this.f290428i == r101.f290428i) goto L36;
        return false;
    L36:
        if (this.f290429j == r101.f290429j) goto L39;
        return false;
    L39:
        if (this.f290430k == r101.f290430k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f290431l, r101.f290431l) == true) goto L45;
        return false;
    L45:
        if (this.f290432m == r101.f290432m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((this.f290420a.hashCode() * 31) + this.f290421b) * 31) + this.f290422c.hashCode()) * 31) + this.f290423d.hashCode()) * 31) + this.f290424e) * 31) + this.f290425f) * 31) + this.f290426g) * 31) + this.f290427h) * 31) + this.f290428i) * 31) + this.f290429j) * 31) + this.f290430k) * 31) + this.f290431l.hashCode()) * 31) + this.f290432m;
    }

    public final String toString() {
        return "WavHeader(chunkId=" + this.f290420a + ", chunkSize=" + this.f290421b + ", format=" + this.f290422c + ", subchunk1Id=" + this.f290423d + ", subchunk1Size=" + this.f290424e + ", audioFormat=" + this.f290425f + ", channels=" + this.f290426g + ", sampleRate=" + this.f290427h + ", byteRate=" + this.f290428i + ", blockAlign=" + this.f290429j + ", bitsPerSample=" + this.f290430k + ", subchunk2Id=" + this.f290431l + ", subchunk2Size=" + this.f290432m + ')';
    }

    public a0(String r100, int r101, String r102, String r103, int r104, short r105, short r106, int r107, int r110, short r111, short r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "chunkId");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r103, "subchunk1Id");
        Intrinsics.checkNotNullParameter(r113, "subchunk2Id");
        this.f290420a = r100;
        this.f290421b = r101;
        this.f290422c = r102;
        this.f290423d = r103;
        this.f290424e = r104;
        this.f290425f = r105;
        this.f290426g = r106;
        this.f290427h = r107;
        this.f290428i = r110;
        this.f290429j = r111;
        this.f290430k = r112;
        this.f290431l = r113;
        this.f290432m = r114;
    }
}
