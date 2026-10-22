package ve5;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554397c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f554395a, r101.f554395a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554396b, r101.f554396b) == true) goto L15;
        return false;
    L15:
        if (this.f554397c == r101.f554397c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f554395a.hashCode() * 31) + this.f554396b.hashCode()) * 31) + this.f554397c;
    }

    public final String toString() {
        return "MentionSnapshot(token=" + this.f554395a + ", displayName=" + this.f554396b + ", userType=" + this.f554397c + ')';
    }

    public m(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.f554395a = r100;
        this.f554396b = r101;
        this.f554397c = r102;
    }
}
