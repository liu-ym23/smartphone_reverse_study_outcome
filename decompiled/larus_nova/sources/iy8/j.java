package iy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f496586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f496588c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f496586a, r101.f496586a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496587b, r101.f496587b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496588c, r101.f496588c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f496586a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f496587b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f496588c.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeatureSelectorOptionPanelItem(id=" + this.f496586a + ", title=" + this.f496587b + ", optionList=" + this.f496588c + ')';
    }

    public j(Long r100, String r101, List<i> r102) {
        Intrinsics.checkNotNullParameter(r102, "optionList");
        this.f496586a = r100;
        this.f496587b = r101;
        this.f496588c = r102;
    }
}
