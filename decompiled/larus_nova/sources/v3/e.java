package v3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f552789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f552790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f552791e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f552787a, r101.f552787a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552788b, r101.f552788b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552789c, r101.f552789c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f552790d, r101.f552790d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f552791e, r101.f552791e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f552787a.hashCode() * 31;
        String r101 = this.f552788b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f552789c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Double r108 = this.f552790d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f552791e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WifiInfoSnapshot(ssid=" + this.f552787a + ", bssid=" + this.f552788b + ", secure=" + this.f552789c + ", signalStrength=" + this.f552790d + ", frequency=" + this.f552791e + ')';
    }

    public e(String r100, String r101, Boolean r102, Double r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "ssid");
        this.f552787a = r100;
        this.f552788b = r101;
        this.f552789c = r102;
        this.f552790d = r103;
        this.f552791e = r104;
    }
}
