package tf1;

import com.bytedance.android.livesdkapi.depend.model.live.RoomBorderInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomBorderInfo.StaticBorderInfo f545707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f545708b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f545707a, r101.f545707a) == true) goto L8;
        return false;
    L8:
        if (this.f545708b == r101.f545708b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        RoomBorderInfo.StaticBorderInfo r100 = this.f545707a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f545708b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "StaticBorderModel(staticBorderInfo=" + this.f545707a + ", duration=" + this.f545708b + ")";
    }

    public b(RoomBorderInfo.StaticBorderInfo r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "staticBorderInfo");
        this.f545707a = r100;
        this.f545708b = r101;
    }
}
