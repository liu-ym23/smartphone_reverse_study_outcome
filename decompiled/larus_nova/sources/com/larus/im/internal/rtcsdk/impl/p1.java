package com.larus.im.internal.rtcsdk.impl;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.service.audio.l f349975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f349976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.im.internal.rtcsdk.impl.trace.a f349977c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f349975a, r101.f349975a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349976b, r101.f349976b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349977c, r101.f349977c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f349975a.hashCode() * 31;
        ByteBuffer r101 = this.f349976b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        com.larus.im.internal.rtcsdk.impl.trace.a r105 = this.f349977c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProcessedAudioFrame(frame=" + this.f349975a + ", extra=" + this.f349976b + ", trace=" + this.f349977c + ')';
    }

    public p1(com.larus.im.service.audio.l r100, ByteBuffer r101, com.larus.im.internal.rtcsdk.impl.trace.a r102) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.f349975a = r100;
        this.f349976b = r101;
        this.f349977c = r102;
    }
}
