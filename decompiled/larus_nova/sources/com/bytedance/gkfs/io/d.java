package com.bytedance.gkfs.io;

import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f245193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f245194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GkFSChunkStorageInfo f245195c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f245194b, r101.f245194b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245195c, r101.f245195c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f245194b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GkFSChunkStorageInfo r104 = this.f245195c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunk(meta=" + this.f245194b + ", storageInfo=" + this.f245195c + ")";
    }

    public d(f r100, GkFSChunkStorageInfo r101) {
        this.f245194b = r100;
        this.f245195c = r101;
        this.f245193a = r100.f245200a;
    }
}
