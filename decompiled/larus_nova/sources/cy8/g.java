package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f465827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f465828c;

    public g() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f465826a, r101.f465826a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465827b, r101.f465827b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465828c, r101.f465828c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465826a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Long> r104 = this.f465827b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f465828c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasFilterConfItem(matchUiId=" + this.f465826a + ", optionList=" + this.f465827b + ", defaultOptionId=" + this.f465828c + ')';
    }

    public g(String r100, List<Long> r101, Long r102) {
        this.f465826a = r100;
        this.f465827b = r101;
        this.f465828c = r102;
    }
}
