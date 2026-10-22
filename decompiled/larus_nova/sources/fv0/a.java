package fv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f478952e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f478948a, r101.f478948a) == true) goto L8;
        return false;
    L8:
        if (this.f478949b == r101.f478949b) goto L10;
        return false;
    L10:
        if (this.f478950c == r101.f478950c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478951d, r101.f478951d) == true) goto L14;
        return false;
    L14:
        if (this.f478952e == r101.f478952e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f478948a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f478949b) * 31) + this.f478950c) * 31;
        String r104 = this.f478951d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f478952e;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FrequencyParams(scene=" + this.f478948a + ", dailyLimit=" + this.f478949b + ", lifetimeLimit=" + this.f478950c + ", activityId=" + this.f478951d + ", minInterval=" + this.f478952e + ")";
    }

    public a() {
        this("", 0, 0, "", 0);
    }

    public a(String r100, int r101, int r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "activityId");
        this.f478948a = r100;
        this.f478949b = r101;
        this.f478950c = r102;
        this.f478951d = r103;
        this.f478952e = r104;
    }
}
