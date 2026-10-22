package rk9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f538424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f538425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f538426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f538427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f538428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f538429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f538430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f538431i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f538423a == r101.f538423a) goto L12;
        return false;
    L12:
        if (this.f538424b == r101.f538424b) goto L15;
        return false;
    L15:
        if (this.f538425c == r101.f538425c) goto L18;
        return false;
    L18:
        if (this.f538426d == r101.f538426d) goto L21;
        return false;
    L21:
        if (this.f538427e == r101.f538427e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f538428f, r101.f538428f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f538429g, r101.f538429g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f538430h, r101.f538430h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f538431i, r101.f538431i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f538423a * 31;
        int r101 = 1231;
        if (this.f538424b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f538425c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f538426d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f538427e == true) goto L19;
        r101 = 1237;
    L19:
        return ((((((((r107 + r101) * 31) + this.f538428f.hashCode()) * 31) + this.f538429g.hashCode()) * 31) + this.f538430h.hashCode()) * 31) + this.f538431i.hashCode();
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "RouteState(mode=" + this.f538423a + ", speakerphoneOn=" + this.f538424b + ", bluetoothScoOn=" + this.f538425c + ", bluetoothA2dpOn=" + this.f538426d + ", wiredHeadsetOn=" + this.f538427e + ", communicationDevice=" + this.f538428f + ", bluetoothCommunicationDevices=" + this.f538429g + ", bluetoothInputDevices=" + this.f538430h + ", externalOutputDevices=" + this.f538431i + ')';
    }

    public final String b() {
        return "{mode=" + this.f538423a + ",spk=" + this.f538424b + ",sco=" + this.f538425c + ",a2dp=" + this.f538426d + ",wired=" + this.f538427e + ",comm=" + this.f538428f + ",btComm=" + this.f538429g + ",btIn=" + this.f538430h + ",extOut=" + this.f538431i + '}';
    }

    public static void a(List r100, String r101, Object r102, Object r103) {
        if (Intrinsics.areEqual(r102, r103) == true) goto L6;
        r100.add(r101 + ':' + r102 + "->" + r103);
        return;
    }

    public l(int r100, boolean r101, boolean r102, boolean r103, boolean r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r105, "communicationDevice");
        Intrinsics.checkNotNullParameter(r106, "bluetoothCommunicationDevices");
        Intrinsics.checkNotNullParameter(r107, "bluetoothInputDevices");
        Intrinsics.checkNotNullParameter(r110, "externalOutputDevices");
        this.f538423a = r100;
        this.f538424b = r101;
        this.f538425c = r102;
        this.f538426d = r103;
        this.f538427e = r104;
        this.f538428f = r105;
        this.f538429g = r106;
        this.f538430h = r107;
        this.f538431i = r110;
    }
}
