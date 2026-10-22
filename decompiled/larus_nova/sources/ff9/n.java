package ff9;

import com.larus.im.internal.network.link.impl.rtc.RTCConnectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RTCConnectionType f476773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f476774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f476775c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f476773a == r101.f476773a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476774b, r101.f476774b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f476775c, r101.f476775c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f476773a.hashCode() * 31) + this.f476774b.hashCode()) * 31;
        k r101 = this.f476775c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowRTCRoomServiceConfig(connectionType=" + this.f476773a + ", commonConfig=" + this.f476774b + ", mergeConfig=" + this.f476775c + ')';
    }

    public n(RTCConnectionType r100, j r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "connectionType");
        Intrinsics.checkNotNullParameter(r101, "commonConfig");
        this.f476773a = r100;
        this.f476774b = r101;
        this.f476775c = r102;
    }
}
