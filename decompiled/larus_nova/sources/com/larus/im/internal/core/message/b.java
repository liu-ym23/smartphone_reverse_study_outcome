package com.larus.im.internal.core.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347783a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f347783a, ((b) r100).f347783a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f347783a.hashCode();
    }

    public final String toString() {
        return "BatchSendKey(localMessageId=" + this.f347783a + ')';
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        this.f347783a = r100;
    }
}
