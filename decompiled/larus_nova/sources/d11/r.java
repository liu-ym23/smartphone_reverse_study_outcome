package d11;

import com.bytedance.android.live.revenuelink.connect.params.TimeOutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f466358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeOutType f466359b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L10;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f466358a, r101.f466358a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f466359b, r101.f466359b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f466358a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TimeOutType r104 = this.f466359b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimeOutParams(toUserId=" + this.f466358a + ", timeOutType=" + this.f466359b + ")";
    }

    public r(String r100, TimeOutType r101) {
        Intrinsics.checkNotNullParameter(r101, "timeOutType");
        this.f466358a = r100;
        this.f466359b = r101;
    }
}
