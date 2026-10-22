package t39;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f544474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f544475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f544476g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f544470a, r101.f544470a) == true) goto L12;
        return false;
    L12:
        if (this.f544471b == r101.f544471b) goto L15;
        return false;
    L15:
        if (this.f544472c == r101.f544472c) goto L18;
        return false;
    L18:
        if (this.f544473d == r101.f544473d) goto L21;
        return false;
    L21:
        if (this.f544474e == r101.f544474e) goto L24;
        return false;
    L24:
        if (this.f544475f == r101.f544475f) goto L27;
        return false;
    L27:
        if (this.f544476g == r101.f544476g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f544470a.hashCode() * 31) + this.f544471b) * 31) + this.f544472c) * 31) + this.f544473d) * 31;
        long r101 = this.f544474e;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f544475f) * 31) + this.f544476g;
    }

    public final String toString() {
        return "BluetoothBandwidthPhoneEnvironmentInfo(networkStatus=" + this.f544470a + ", a2dpPlayingState=" + this.f544471b + ", bluetoothConnectedDeviceCount=" + this.f544472c + ", glassesConnectedPhoneCount=" + this.f544473d + ", glassesConnectedPhoneCountUpdateTimeMs=" + this.f544474e + ", transportRttAvg=" + this.f544475f + ", transportRttMax=" + this.f544476g + ')';
    }

    public o(String r100, int r101, int r102, int r103, long r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, Constants.OperatorKey.KEY_NETWORK_STATUS);
        this.f544470a = r100;
        this.f544471b = r101;
        this.f544472c = r102;
        this.f544473d = r103;
        this.f544474e = r104;
        this.f544475f = r105;
        this.f544476g = r106;
    }
}
