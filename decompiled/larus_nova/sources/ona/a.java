package ona;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f524399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f524400b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f524399a == r101.f524399a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f524400b, r101.f524400b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f524399a * 31;
        Integer r101 = this.f524400b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SensorInfo(listenerHashCode=" + this.f524399a + ", sensorHashCode=" + this.f524400b + ')';
    }

    public a(int r100, Integer r101) {
        this.f524399a = r100;
        this.f524400b = r101;
    }
}
