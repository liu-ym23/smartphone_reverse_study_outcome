package com.larus.kmp.voice_setting.voice.dialog.v2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f353118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f353119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Float> f353120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f353121d;

    public h0() {
        this(0.0f, null, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Float.compare(this.f353118a, r101.f353118a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f353119b, r101.f353119b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353120c, r101.f353120c) == true) goto L18;
        return false;
    L18:
        if (this.f353121d == r101.f353121d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((Float.floatToIntBits(this.f353118a) * 31) + Float.floatToIntBits(this.f353119b)) * 31) + this.f353120c.hashCode()) * 31;
        long r101 = this.f353121d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "VoiceChatSpeakerWaveFrame(amplitude=" + this.f353118a + ", blurAmplitude=" + this.f353119b + ", samples=" + this.f353120c + ", sequence=" + this.f353121d + ')';
    }

    public /* synthetic */ h0(float r100, List r101, long r102, int r110) {
        if ((r110 & 1) == 0) goto L5;
        float r103 = 0.0f;
    L7:
        if ((r110 & 4) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        List r104 = r101;
        if ((r110 & 8) == 0) goto L12;
        r102 = 0;
    L12:
        this(r103, 0.0f, r104, r102);
        return;
    L5:
        r103 = r100;
        goto L7
    }

    public h0(float r100, float r101, List<Float> r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "samples");
        this.f353118a = r100;
        this.f353119b = r101;
        this.f353120c = r102;
        this.f353121d = r103;
    }
}
