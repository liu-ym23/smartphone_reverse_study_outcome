package so8;

import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoomInAnimationState f542737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f542738b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f542737a == r101.f542737a) goto L12;
        return false;
    L12:
        if (this.f542738b == r101.f542738b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f542737a.hashCode() * 31;
        long r101 = this.f542738b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ZoomAnimationInfo(currentState=" + this.f542737a + ", currentStateTimeStamp=" + this.f542738b + ')';
    }

    public /* synthetic */ b(int r100) {
        this(ZoomInAnimationState.IDLE, AppHost.f326268a.getAppClock().currentTimeMillis());
    }

    public b(ZoomInAnimationState r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        this.f542737a = r100;
        this.f542738b = r101;
    }
}
