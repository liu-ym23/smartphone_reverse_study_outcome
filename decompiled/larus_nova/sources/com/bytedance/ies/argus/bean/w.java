package com.bytedance.ies.argus.bean;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f246057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f246058b;

    public final String toString() {
        return "SignSuiteV2(signAlgorithm=" + this.f246057a + ", signature=" + Arrays.toString(this.f246058b) + ')';
    }

    public final int hashCode() {
        return (this.f246057a.hashCode() * 31) + Arrays.hashCode(this.f246058b);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(w.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ies.argus.bean.SignSuiteV2");
        w r102 = (w) r100;
        if (Intrinsics.areEqual(this.f246057a, r102.f246057a) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f246058b, r102.f246058b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public w(v r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "signAlgorithm");
        Intrinsics.checkNotNullParameter(r101, "signature");
        this.f246057a = r100;
        this.f246058b = r101;
    }
}
