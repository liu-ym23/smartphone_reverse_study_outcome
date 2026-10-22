package com.obric.aiagent.messenger.stub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f384920a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f384920a, ((m1) r100).f384920a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f384920a.hashCode();
    }

    public final String toString() {
        return "Failure(reason=" + this.f384920a + ')';
    }

    public m1() {
        Intrinsics.checkNotNullParameter("encode_exception", "reason");
        this.f384920a = "encode_exception";
    }
}
