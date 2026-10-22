package com.bytedance.gkfs.storage;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ChunkIndexingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient com.bytedance.gkfs.io.c f245256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.io.a f245257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f245258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f245259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient a f245260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient long f245261g;

    public final int e() {
        return ((Number) this.f245255a.getValue()).intValue();
    }

    public final String toString() {
        return "ChunkIndexingInfo(id=" + this.f245256b + ", blockId=" + this.f245257c + ", reference=" + Arrays.toString(this.f245258d) + ", opt=" + this.f245259e + ", blockInfo=" + this.f245260f + ", timeCost=" + this.f245261g + ")";
    }

    public final int hashCode() {
        return (((this.f245256b.hashCode() * 31) + this.f245257c.f245185a) * 31) + this.f245260f.hashCode();
    }

    public final com.bytedance.gkfs.io.a b() {
        return this.f245257c;
    }

    public final a c() {
        return this.f245260f;
    }

    public final com.bytedance.gkfs.io.c d() {
        return this.f245256b;
    }

    public final String[] f() {
        return this.f245258d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(ChunkIndexingInfo.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        ChunkIndexingInfo r102 = (ChunkIndexingInfo) r100;
        if ((!Intrinsics.areEqual(this.f245256b, r102.f245256b)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f245257c, r102.f245257c)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f245260f, r102.f245260f)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.gkfs.storage.ChunkIndexingInfo");
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ ChunkIndexingInfo(com.bytedance.gkfs.io.c r100, com.bytedance.gkfs.io.a r110, String[] r111, boolean r112, long r113) {
        this(r100, r110, r111, r112, new a(0), r113);
    }

    public static ChunkIndexingInfo a(ChunkIndexingInfo r110, String[] r111, a r112, long r113, int r114) {
        com.bytedance.gkfs.io.a r100 = null;
        if ((r114 & 1) == 0) goto L5;
        com.bytedance.gkfs.io.c r101 = r110.f245256b;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r100 = r110.f245257c;
    L9:
        com.bytedance.gkfs.io.a r102 = r100;
        if ((r114 & 4) == 0) goto L12;
        r111 = r110.f245258d;
    L12:
        String[] r103 = r111;
        if ((r114 & 8) == 0) goto L15;
        boolean r104 = r110.f245259e;
    L17:
        if ((r114 & 16) == 0) goto L19;
        r112 = r110.f245260f;
    L19:
        a r105 = r112;
        if ((r114 & 32) == 0) goto L22;
        r113 = r110.f245261g;
    L22:
        r110.getClass();
        return new ChunkIndexingInfo(r101, r102, r103, r104, r105, r113);
    L15:
        r104 = false;
        goto L17
    L5:
        r101 = null;
        goto L7
    }

    public ChunkIndexingInfo(com.bytedance.gkfs.io.c r100, com.bytedance.gkfs.io.a r101, String[] r102, boolean r103, a r104, long r105) {
        this.f245256b = r100;
        this.f245257c = r101;
        this.f245258d = r102;
        this.f245259e = r103;
        this.f245260f = r104;
        this.f245261g = r105;
        this.f245255a = LazyKt.lazy(new ChunkIndexingInfo$rc$2(this));
    }
}
