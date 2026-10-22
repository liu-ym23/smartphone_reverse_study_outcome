package com.larus.audioplayer.impl.stream;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f290457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f290458b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f290457a, r101.f290457a) == true) goto L12;
        return false;
    L12:
        if (this.f290458b == r101.f290458b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = Arrays.hashCode(this.f290457a) * 31;
        if (this.f290458b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "StreamChunkData(data=" + Arrays.toString(this.f290457a) + ", isFinished=" + this.f290458b + ')';
    }

    public v(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f290457a = r100;
        this.f290458b = false;
    }
}
