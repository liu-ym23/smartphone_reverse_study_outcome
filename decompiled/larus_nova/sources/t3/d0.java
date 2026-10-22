package t3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f544269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f544271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f544272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f544273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, byte[]> f544274h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f544267a, r101.f544267a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544268b, r101.f544268b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544269c, r101.f544269c) == true) goto L18;
        return false;
    L18:
        if (this.f544270d == r101.f544270d) goto L21;
        return false;
    L21:
        if (this.f544271e == r101.f544271e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f544272f, r101.f544272f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f544273g, r101.f544273g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f544274h, r101.f544274h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f544267a.hashCode() * 31) + this.f544268b.hashCode()) * 31;
        String r101 = this.f544269c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f544270d) * 31;
        if (this.f544271e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        byte[] r107 = this.f544272f;
        if (r107 == null) goto L15;
        r102 = Arrays.hashCode(r107);
    L15:
        return ((((r106 + r102) * 31) + this.f544273g.hashCode()) * 31) + this.f544274h.hashCode();
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BluetoothDeviceSnapshot(deviceId=" + this.f544267a + ", name=" + this.f544268b + ", localName=" + this.f544269c + ", RSSI=" + this.f544270d + ", connectable=" + this.f544271e + ", advertisData=" + Arrays.toString(this.f544272f) + ", advertisServiceUuids=" + this.f544273g + ", serviceData=" + this.f544274h + ')';
    }

    public d0(String r100, String r101, String r102, int r103, boolean r104, byte[] r105, List<String> r106, Map<String, byte[]> r107) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r106, "advertisServiceUuids");
        Intrinsics.checkNotNullParameter(r107, "serviceData");
        this.f544267a = r100;
        this.f544268b = r101;
        this.f544269c = r102;
        this.f544270d = r103;
        this.f544271e = r104;
        this.f544272f = r105;
        this.f544273g = r106;
        this.f544274h = r107;
    }
}
