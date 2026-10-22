package com.bytedance.livesdk.ktvcommon.download.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f255946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f255947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f255948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f255949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f255950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f255951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f255952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f255953j;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L26;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f255944a, r101.f255944a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255945b, r101.f255945b) == true) goto L10;
        return false;
    L10:
        if (this.f255946c == r101.f255946c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255947d, r101.f255947d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f255948e, r101.f255948e) == true) goto L16;
        return false;
    L16:
        if (this.f255949f == r101.f255949f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f255950g, r101.f255950g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f255951h, r101.f255951h) == true) goto L22;
        return false;
    L22:
        if (this.f255952i == r101.f255952i) goto L24;
        return false;
    L24:
        if (this.f255953j == r101.f255953j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    public final int hashCode() {
        String r100 = this.f255944a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255945b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f255946c) * 31;
        String r107 = this.f255947d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<f> r110 = this.f255948e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.f255949f) * 31;
        List<d> r113 = this.f255950g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<d> r116 = this.f255951h;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.f255952i;
        ?? r119 = 1;
        ?? r120 = r118;
        if (r118 == false) goto L28;
        r120 = 1;
    L28:
        int r121 = (r117 + r120) * 31;
        boolean r122 = this.f255953j;
        if (r122 == true) goto L33;
        r119 = r122;
    L33:
        return r121 + r119;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BatchInfo(batchId=" + this.f255944a + ", songId=" + this.f255945b + ", sequence=" + this.f255946c + ", description=" + this.f255947d + ", tasks=" + this.f255948e + ", progress=" + this.f255949f + ", successResults=" + this.f255950g + ", failedResults=" + this.f255951h + ", isCompleted=" + this.f255952i + ", isCancelled=" + this.f255953j + ")";
    }

    public b(String r100, String r101, int r102, String r103, List r104) {
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r103, "description");
        Intrinsics.checkNotNullParameter(r104, "tasks");
        Intrinsics.checkNotNullParameter(r105, "successResults");
        Intrinsics.checkNotNullParameter(r106, "failedResults");
        this.f255944a = r100;
        this.f255945b = r101;
        this.f255946c = r102;
        this.f255947d = r103;
        this.f255948e = r104;
        this.f255949f = 0;
        this.f255950g = r105;
        this.f255951h = r106;
        this.f255952i = false;
        this.f255953j = false;
    }
}
