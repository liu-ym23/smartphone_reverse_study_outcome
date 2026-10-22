package com.bytedance.gkfs.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChunkIndexingInfo f245305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f245306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f245307c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f245305a, r101.f245305a) == true) goto L8;
        return false;
    L8:
        if (this.f245306b == r101.f245306b) goto L10;
        return false;
    L10:
        if (this.f245307c == r101.f245307c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        ChunkIndexingInfo r100 = this.f245305a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f245306b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f245307c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ChunkIndexingTidyUpInfo(indexingInfo=" + this.f245305a + ", isTidyUp=" + this.f245306b + ", needDelete=" + this.f245307c + ")";
    }

    public final ChunkIndexingInfo a() {
        return this.f245305a;
    }

    public final boolean b() {
        return this.f245307c;
    }

    public final boolean c() {
        return this.f245306b;
    }

    public b(ChunkIndexingInfo r100, boolean r101, boolean r102) {
        this.f245305a = r100;
        this.f245306b = r101;
        this.f245307c = r102;
    }
}
