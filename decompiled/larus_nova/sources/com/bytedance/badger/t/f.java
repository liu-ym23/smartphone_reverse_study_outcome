package com.bytedance.badger.t;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f199201a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f199201a, ((f) r100).f199201a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        byte[] r100 = this.f199201a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return Arrays.hashCode(r100);
    }

    public final String toString() {
        return "BytesVal(value=" + Arrays.toString(this.f199201a) + ")";
    }

    public f(byte[] r100) {
        this.f199201a = r100;
    }
}
