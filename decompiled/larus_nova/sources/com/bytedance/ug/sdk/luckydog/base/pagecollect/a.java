package com.bytedance.ug.sdk.luckydog.base.pagecollect;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f271742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f271743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f271745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f271746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Long> f271747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f271748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f271749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f271750i;

    public a() {
        this(0, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L50:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L49;
        a r101 = (a) r100;
        if (this.f271742a != r101.f271742a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L49;
        if (this.f271743b != r101.f271743b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L49;
        if (this.f271744c != r101.f271744c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L49;
        if (this.f271745d != r101.f271745d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L49;
        if (this.f271746e != r101.f271746e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L49;
        if (Intrinsics.areEqual(this.f271747f, r101.f271747f) == false) goto L49;
        if (this.f271748g != r101.f271748g) goto L36;
        boolean r107 = true;
    L37:
        if (r107 == false) goto L49;
        if (this.f271749h != r101.f271749h) goto L41;
        boolean r108 = true;
    L42:
        if (r108 == false) goto L49;
        if (this.f271750i != r101.f271750i) goto L46;
        boolean r109 = true;
    L47:
        if (r109 == false) goto L49;
    L46:
        r109 = false;
        goto L47
    L41:
        r108 = false;
        goto L42
    L36:
        r107 = false;
        goto L37
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L49:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    public final int hashCode() {
        int r100 = this.f271742a * 31;
        boolean r101 = this.f271743b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f271744c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f271745d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f271746e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        List<Long> r110 = this.f271747f;
        if (r110 == null) goto L8;
        int r111 = r110.hashCode();
    L9:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f271748g;
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f271749h) * 31;
        long r115 = this.f271750i;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L8:
        r111 = 0;
        goto L9
    }

    public final String toString() {
        return "MemCollectResult(memType=" + this.f271742a + ", effectiveCollect=" + this.f271743b + ", maxMemSize=" + this.f271744c + ", maxMemSizeReal=" + this.f271745d + ", memStableSize=" + this.f271746e + ", memLevelList=" + this.f271747f + ", memLevelMaxTime=" + this.f271748g + ", curCompareCnt=" + this.f271749h + ", curCollectDuration=" + this.f271750i + ")";
    }

    public a(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r101 & 32) == 0) goto L8;
        ArrayList r102 = new ArrayList();
    L9:
        this.f271742a = r100;
        this.f271743b = false;
        this.f271744c = 0;
        this.f271745d = 0;
        this.f271746e = 0;
        this.f271747f = r102;
        this.f271748g = 0;
        this.f271749h = 0;
        this.f271750i = 0;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
