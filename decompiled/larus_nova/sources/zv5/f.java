package zv5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573700d;

    public f() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f573697a, r101.f573697a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573698b, r101.f573698b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573699c, r101.f573699c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573700d, r101.f573700d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f573697a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f573698b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f573699c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f573700d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchComponentBuildConfig(queryDataSourceClassName=" + this.f573697a + ", intermediateDataSourceClassName=" + this.f573698b + ", filterDataSourceClassName=" + this.f573699c + ", recentConvDataSourceClassName=" + this.f573700d + ')';
    }

    public f(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f573697a = r100;
        this.f573698b = r101;
        this.f573699c = null;
        this.f573700d = null;
    }
}
