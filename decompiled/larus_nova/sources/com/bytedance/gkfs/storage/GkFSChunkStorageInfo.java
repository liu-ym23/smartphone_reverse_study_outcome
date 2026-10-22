package com.bytedance.gkfs.storage;

import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class GkFSChunkStorageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.gkfs.io.c f245287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<InputStream> f245288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChunkIndexingInfo f245289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f245290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f245291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f245292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f245293h;

    public final int b() {
        return ((Number) this.f245286a.getValue()).intValue();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GkFSChunkStorageInfo) == false) goto L20;
        GkFSChunkStorageInfo r101 = (GkFSChunkStorageInfo) r100;
        if (Intrinsics.areEqual(this.f245287b, r101.f245287b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245288c, r101.f245288c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f245289d, r101.f245289d) == true) goto L12;
        return false;
    L12:
        if (this.f245290e == r101.f245290e) goto L14;
        return false;
    L14:
        if (this.f245291f == r101.f245291f) goto L16;
        return false;
    L16:
        if (this.f245292g == r101.f245292g) goto L18;
        return false;
    L18:
        if (this.f245293h == r101.f245293h) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        com.bytedance.gkfs.io.c r100 = this.f245287b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function0<InputStream> r104 = this.f245288c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ChunkIndexingInfo r107 = this.f245289d;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f245290e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f245291f;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f245292g;
        return ((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f245293h;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunkStorageInfo(identity=" + this.f245287b + ", chunkReaderProvider=" + this.f245288c + ", indexing=" + this.f245289d + ", lockCost=" + this.f245290e + ", ioCost=" + this.f245291f + ", timeCost=" + this.f245292g + ", size=" + this.f245293h + ", dilutedSize=" + b() + ')';
    }

    public static GkFSChunkStorageInfo a(GkFSChunkStorageInfo r110, Function0 r111, long r112, long r113, int r210) {
        ChunkIndexingInfo r100 = null;
        if ((r210 & 1) == 0) goto L5;
        com.bytedance.gkfs.io.c r101 = r110.f245287b;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Function0 r102 = r110.f245288c;
    L11:
        if ((r210 & 4) == 0) goto L13;
        r100 = r110.f245289d;
    L13:
        ChunkIndexingInfo r103 = r100;
        if ((r210 & 8) == 0) goto L16;
        long r104 = r110.f245290e;
    L17:
        long r105 = r104;
        if ((r210 & 16) == 0) goto L20;
        long r106 = r110.f245291f;
    L22:
        if ((r210 & 32) == 0) goto L24;
        long r114 = r110.f245292g;
    L26:
        if ((r210 & 64) == 0) goto L28;
        int r115 = r110.f245293h;
    L29:
        r110.getClass();
        return new GkFSChunkStorageInfo(r101, r102, r103, r105, r106, r114, r115);
    L28:
        r115 = 0;
        goto L29
    L24:
        r114 = r113;
        goto L26
    L20:
        r106 = r112;
        goto L22
    L16:
        r104 = 0;
        goto L17
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GkFSChunkStorageInfo(com.bytedance.gkfs.io.c r100, Function0<? extends InputStream> r101, ChunkIndexingInfo r102, long r103, long r104, long r105, int r110) {
        this.f245287b = r100;
        this.f245288c = r101;
        this.f245289d = r102;
        this.f245290e = r103;
        this.f245291f = r104;
        this.f245292g = r105;
        this.f245293h = r110;
        this.f245286a = LazyKt.lazy(new GkFSChunkStorageInfo$dilutedSize$2(this));
    }
}
