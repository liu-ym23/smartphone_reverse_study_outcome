package com.bytedance.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes21.dex */
public final class o<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f264578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f264579b;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f264578a, this.f264579b});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(d r100) {
        this.f264578a = r100;
        this.f264579b = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        V r102 = this.f264578a;
        if (r102 != null) goto L11;
    L13:
        Throwable r103 = this.f264579b;
        if (r103 != null) goto L16;
    L19:
        return false;
    L16:
        if (r101.f264579b == null) goto L19;
        return r103.toString().equals(this.f264579b.toString());
    L11:
        if (r102.equals(r101.f264578a) == false) goto L13;
        return true;
    }

    public o(Throwable r100) {
        this.f264579b = r100;
        this.f264578a = null;
    }
}
