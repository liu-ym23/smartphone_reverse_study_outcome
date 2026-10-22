package com.larus.dora.impl.ota;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f337771a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f337771a, ((j) r100).f337771a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f337771a.hashCode();
    }

    public final String toString() {
        return "DoraOTAParam(otaFileSavePath=" + this.f337771a + ')';
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "otaFileSavePath");
        this.f337771a = r100;
    }
}
