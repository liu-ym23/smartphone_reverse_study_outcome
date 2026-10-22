package x40;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f562427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f562428b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f562427a, r101.f562427a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f562428b, r101.f562428b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f562427a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Long> r104 = this.f562428b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActivityTimeStepCacheData(roomId=" + this.f562427a + ", timeStepMap=" + this.f562428b + ")";
    }

    public i(Long r100, Map<String, Long> r101) {
        this.f562427a = r100;
        this.f562428b = r101;
    }
}
