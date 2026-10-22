package com.obric.assistant.network.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f390347b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f390346a, r101.f390346a) == true) goto L12;
        return false;
    L12:
        if (this.f390347b == r101.f390347b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f390346a.hashCode() * 31;
        long r101 = this.f390347b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "OmniScreenshotEncryptedPayload(ciphertextBase64=" + this.f390346a + ", sourceSizeBytes=" + this.f390347b + ')';
    }

    public k(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "ciphertextBase64");
        this.f390346a = r100;
        this.f390347b = r101;
    }
}
