package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.SubtitleAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubtitleAction f378991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f378992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f378993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f378994d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (this.f378991a == r101.f378991a) goto L12;
        return false;
    L12:
        if (this.f378992b == r101.f378992b) goto L15;
        return false;
    L15:
        if (this.f378993c == r101.f378993c) goto L18;
        return false;
    L18:
        if (this.f378994d == r101.f378994d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f378991a.hashCode() * 31) + this.f378992b) * 31) + this.f378993c) * 31;
        if (this.f378994d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "action=" + this.f378991a + ", startIndex=" + this.f378992b + ", endIndex=" + this.f378993c;
    }

    public y0(SubtitleAction r100, int r101, int r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f378991a = r100;
        this.f378992b = r101;
        this.f378993c = r102;
        this.f378994d = r103;
    }
}
