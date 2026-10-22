package f31;

import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f475336c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1 f475337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f475338b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f475337a, r101.f475337a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475338b, r101.f475338b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        v1 r100 = this.f475337a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        u1 r104 = this.f475338b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkmicRtcLiveCoreData(rtcInfo=" + this.f475337a + ", liveCoreInfo=" + this.f475338b + ")";
    }

    public g(v1 r100, u1 r101) {
        this.f475337a = r100;
        this.f475338b = r101;
    }
}
