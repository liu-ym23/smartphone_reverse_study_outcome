package com.bytedance.gkfs.io;

import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f245230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f245231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f245232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f245233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f245234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f245235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f245236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f245237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f245238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f245239j;

    public n() {
        this(null, 0, 0, null, 0, 0, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L22;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f245232c, r101.f245232c) == true) goto L8;
        return false;
    L8:
        if (this.f245233d == r101.f245233d) goto L10;
        return false;
    L10:
        if (this.f245234e == r101.f245234e) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245235f, r101.f245235f) == true) goto L14;
        return false;
    L14:
        if (this.f245236g == r101.f245236g) goto L16;
        return false;
    L16:
        if (this.f245237h == r101.f245237h) goto L18;
        return false;
    L18:
        if (this.f245238i == r101.f245238i) goto L20;
        return false;
    L20:
        if (this.f245239j == r101.f245239j) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        p r100 = this.f245232c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f245233d;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f245234e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        e r107 = this.f245235f;
        if (r107 == null) goto L9;
        r101 = r107.hashCode();
    L9:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f245236g;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f245237h;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f245238i;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f245239j;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSIOStatistics(status=" + this.f245232c + ", headerTimeCost=" + this.f245233d + ", headerStorageCost=" + this.f245234e + ", chunkStatistics=" + this.f245235f + ", tailTimeCost=" + this.f245237h + ", tailStorageCost=" + this.f245238i + ", totalTimeCost=" + this.f245239j + ", fileDilutedStorageCost=" + this.f245230a + ')';
    }

    public n(p r100, long r101, long r102, e r103, long r104, long r105, long r110, long r111) {
        this.f245232c = r100;
        this.f245233d = r101;
        this.f245234e = r102;
        this.f245235f = r103;
        this.f245236g = r104;
        this.f245237h = r105;
        this.f245238i = r110;
        this.f245239j = r111;
        Iterator<T> r106 = r103.f245199c.entrySet().iterator();
        int r107 = 0;
        int r108 = 0;
    L4:
        if (r106.hasNext() == false) goto L6;
        r108 = r108 + ((GkFSChunkStorageInfo) ((Map.Entry) r106.next()).getValue()).b();
        goto L4
    L6:
        this.f245230a = (r102 + ((long) r108)) + this.f245238i;
        long r109 = this.f245234e;
        Iterator<T> r112 = this.f245235f.f245199c.entrySet().iterator();
    L8:
        if (r112.hasNext() == false) goto L10;
        r107 = r107 + ((GkFSChunkStorageInfo) ((Map.Entry) r112.next()).getValue()).f245293h;
        goto L8
    L10:
        this.f245231b = (r109 + ((long) r107)) + this.f245238i;
    }

    public n(p r110, long r210, long r211, e r212, long r213, long r214, long r215, int r310) {
        if ((r310 & 1) == 0) goto L5;
        p r100 = p.f245245d;
    L7:
        if ((r310 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r310 & 8) == 0) goto L17;
        e r103 = e.f245196d;
    L19:
        if ((r310 & 32) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r310 & 64) == 0) goto L25;
        long r112 = 0;
    L27:
        if ((r310 & 128) == 0) goto L29;
        long r113 = 0;
    L30:
        this(r100, r101, r102, r103, 0, r111, r112, r113);
        return;
    L29:
        r113 = r215;
        goto L30
    L25:
        r112 = r214;
        goto L27
    L21:
        r111 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
