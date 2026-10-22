package mtb;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i extends c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515685b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f515684a, r101.f515684a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515685b, r101.f515685b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f515684a.hashCode() * 31) + this.f515685b.hashCode();
    }

    public final String toString() {
        return "OfficeFeishuDepartmentItem(displayName=" + this.f515684a + ", id=" + this.f515685b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f515684a = r100;
        this.f515685b = r101;
    }
}
