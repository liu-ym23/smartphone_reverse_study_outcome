package wr9;

import com.larus.power.state.api.ThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<ThermalLevel> f560904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<ThermalLevel> f560905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<ThermalLevel> f560906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<Integer> f560907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d<Double> f560908e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f560904a, r101.f560904a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560905b, r101.f560905b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560906c, r101.f560906c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560907d, r101.f560907d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f560908e, r101.f560908e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f560904a.hashCode() * 31) + this.f560905b.hashCode()) * 31) + this.f560906c.hashCode()) * 31) + this.f560907d.hashCode()) * 31) + this.f560908e.hashCode();
    }

    public final String toString() {
        return "ThermalState(effectiveStatus=" + this.f560904a + ", batteryDerivedStatus=" + this.f560905b + ", aospStatus=" + this.f560906c + ", aospRawStatus=" + this.f560907d + ", batteryTemperatureCelsius=" + this.f560908e + ')';
    }

    public l(d<ThermalLevel> r100, d<ThermalLevel> r101, d<ThermalLevel> r102, d<Integer> r103, d<Double> r104) {
        Intrinsics.checkNotNullParameter(r100, "effectiveStatus");
        Intrinsics.checkNotNullParameter(r101, "batteryDerivedStatus");
        Intrinsics.checkNotNullParameter(r102, "aospStatus");
        Intrinsics.checkNotNullParameter(r103, "aospRawStatus");
        Intrinsics.checkNotNullParameter(r104, "batteryTemperatureCelsius");
        this.f560904a = r100;
        this.f560905b = r101;
        this.f560906c = r102;
        this.f560907d = r103;
        this.f560908e = r104;
    }
}
