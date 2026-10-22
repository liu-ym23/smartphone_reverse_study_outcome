package com.obric.aiagent.messenger.stub;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f384925a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f384925a, ((n1) r100).f384925a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f384925a);
    }

    public final String toString() {
        return "Success(bodyBytes=" + Arrays.toString(this.f384925a) + ')';
    }

    public n1(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bodyBytes");
        this.f384925a = r100;
    }
}
