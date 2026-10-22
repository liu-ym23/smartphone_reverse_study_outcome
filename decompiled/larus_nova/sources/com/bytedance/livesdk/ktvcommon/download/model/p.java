package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256006a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f256006a, ((p) r100).f256006a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f256006a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StorageConfig(rootDir=" + this.f256006a + ")";
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rootDir");
        this.f256006a = r100;
    }
}
