package fy8;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f479324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479325b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f479324a == r101.f479324a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479325b, r101.f479325b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f479324a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f479325b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SelectorPanelStatusChangeInfo(isSelected=" + this.f479324a + ", displayName=" + this.f479325b + ')';
    }

    public m(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.f479324a = r100;
        this.f479325b = r101;
    }
}
