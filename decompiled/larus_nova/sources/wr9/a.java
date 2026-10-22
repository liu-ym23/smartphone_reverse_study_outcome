package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Integer> f560876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<Boolean> f560877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<Boolean> f560878c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f560876a, r101.f560876a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560877b, r101.f560877b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560878c, r101.f560878c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f560876a.hashCode() * 31) + this.f560877b.hashCode()) * 31) + this.f560878c.hashCode();
    }

    public final String toString() {
        return "BatteryState(levelPercent=" + this.f560876a + ", isCharging=" + this.f560877b + ", isPowerSaveMode=" + this.f560878c + ')';
    }

    public a(d<Integer> r100, d<Boolean> r101, d<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "levelPercent");
        Intrinsics.checkNotNullParameter(r101, "isCharging");
        Intrinsics.checkNotNullParameter(r102, "isPowerSaveMode");
        this.f560876a = r100;
        this.f560877b = r101;
        this.f560878c = r102;
    }
}
