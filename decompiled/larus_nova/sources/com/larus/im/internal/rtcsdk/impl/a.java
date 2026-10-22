package com.larus.im.internal.rtcsdk.impl;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f349839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f349840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f349841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.im.internal.rtcsdk.impl.trace.a f349842d;

    public final String toString() {
        return "AudioCacheFrame(bufferArray=" + Arrays.toString(this.f349839a) + ", extra=" + Arrays.toString(this.f349840b) + ", extraSize=" + this.f349841c + ", trace=" + this.f349842d + ')';
    }

    public final int hashCode() {
        int r100 = Arrays.hashCode(this.f349839a) * 31;
        byte[] r101 = this.f349840b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.f349841c;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Arrays.equals(this.f349839a, r101.f349839a) == true) goto L11;
        return false;
    L11:
        byte[] r102 = this.f349840b;
        if (r102 == null) goto L20;
        byte[] r103 = r101.f349840b;
        if (r103 != null) goto L17;
        return false;
    L17:
        if (Arrays.equals(r102, r103) == true) goto L23;
        return false;
    L23:
        if (this.f349841c == r101.f349841c) goto L25;
        return false;
    L25:
        return true;
    L20:
        if (r101.f349840b == null) goto L23;
        return false;
    }

    public a(byte[] r110, byte[] r111, int r112) {
        com.larus.im.internal.rtcsdk.impl.trace.a r113 = new com.larus.im.internal.rtcsdk.impl.trace.a(0, 0, 0, 0, false, 0, 511);
        Intrinsics.checkNotNullParameter(r110, "bufferArray");
        Intrinsics.checkNotNullParameter(r113, "trace");
        this.f349839a = r110;
        this.f349840b = r111;
        this.f349841c = r112;
        this.f349842d = r113;
    }
}
