package com.bytedance.gkfs.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f245308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f245309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f245310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f245311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f245312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f245313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f245314g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f245308a == r101.f245308a) goto L8;
        return false;
    L8:
        if (this.f245309b == r101.f245309b) goto L10;
        return false;
    L10:
        if (this.f245310c == r101.f245310c) goto L12;
        return false;
    L12:
        if (this.f245311d == r101.f245311d) goto L14;
        return false;
    L14:
        if (this.f245312e == r101.f245312e) goto L16;
        return false;
    L16:
        if (this.f245313f == r101.f245313f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f245314g, r101.f245314g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f245308a * 31;
        long r101 = this.f245309b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f245310c) * 31;
        long r103 = this.f245311d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f245312e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f245313f;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        d r109 = this.f245314g;
        if (r109 == null) goto L5;
        int r110 = r109.hashCode();
    L7:
        return r108 + r110;
    L5:
        r110 = 0;
        goto L7
    }

    public final String toString() {
        return "GkFSChunkTidyInfo(deleteChunkCount=" + this.f245308a + ", deleteChunkSize=" + this.f245309b + ", refsReduceChunkCount=" + this.f245310c + ", indexingCost=" + this.f245311d + ", ioCost=" + this.f245312e + ", timeCost=" + this.f245313f + ", generalStorageInfo=" + this.f245314g + ")";
    }

    public c(int r100, int r101, long r102, long r103, long r104, d r110) {
        this.f245308a = r100;
        this.f245309b = 0;
        this.f245310c = r101;
        this.f245311d = r102;
        this.f245312e = r103;
        this.f245313f = r104;
        this.f245314g = r110;
    }
}
