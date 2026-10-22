package com.bytedance.gkfs.io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f245200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f245201b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f245200a, r101.f245200a) == true) goto L8;
        return false;
    L8:
        if (this.f245201b == r101.f245201b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f245200a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f245201b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunkMeta(id=" + this.f245200a + ", offset=" + this.f245201b + ")";
    }

    public f(c r100, long r101) {
        this.f245200a = r100;
        this.f245201b = r101;
    }
}
