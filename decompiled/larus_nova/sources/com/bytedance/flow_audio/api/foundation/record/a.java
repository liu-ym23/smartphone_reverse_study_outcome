package com.bytedance.flow_audio.api.foundation.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f243714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f243716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowAsrAudioEncoding f243717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f243718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f243719f;

    /* JADX INFO: renamed from: com.bytedance.flow_audio.api.foundation.record.a$a, reason: collision with other inner class name */
    public static final class C3489a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f243714a == r101.f243714a) goto L12;
        return false;
    L12:
        if (this.f243715b == r101.f243715b) goto L15;
        return false;
    L15:
        if (this.f243716c == r101.f243716c) goto L18;
        return false;
    L18:
        if (this.f243717d == r101.f243717d) goto L21;
        return false;
    L21:
        if (this.f243718e == r101.f243718e) goto L24;
        return false;
    L24:
        if (this.f243719f == r101.f243719f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f243714a * 31) + this.f243715b) * 31) + this.f243716c) * 31) + this.f243717d.hashCode()) * 31;
        if (this.f243718e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f243719f;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FlowAsrAudioFormat(sampleRate=" + this.f243714a + ", channelCount=" + this.f243715b + ", bitDepth=" + this.f243716c + ", encoding=" + this.f243717d + ", isInterleaved=" + this.f243718e + ", bitRate=" + this.f243719f + ')';
    }

    public /* synthetic */ a(int r100) {
        this(16000, 1, 16, FlowAsrAudioEncoding.PCM, true, 0);
    }

    public a(int r100, int r101, int r102, FlowAsrAudioEncoding r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r103, "encoding");
        this.f243714a = r100;
        this.f243715b = r101;
        this.f243716c = r102;
        this.f243717d = r103;
        this.f243718e = r104;
        this.f243719f = r105;
    }
}
