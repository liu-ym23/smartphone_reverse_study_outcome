package xf9;

import com.larus.im.ws.FlowWsConnectionState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f563547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowWsConnectionState f563548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f563549c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f563547a == r101.f563547a) goto L12;
        return false;
    L12:
        if (this.f563548b == r101.f563548b) goto L15;
        return false;
    L15:
        if (this.f563549c == r101.f563549c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f563547a * 31) + this.f563548b.hashCode()) * 31) + this.f563549c;
    }

    public final String toString() {
        return "FlowWsConnectEvent(channelId=" + this.f563547a + ", connectionState=" + this.f563548b + ", channelTypeVal=" + this.f563549c + ')';
    }

    public e(int r100, FlowWsConnectionState r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "connectionState");
        this.f563547a = r100;
        this.f563548b = r101;
        this.f563549c = r102;
    }
}
