package jr9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f500153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f500154d;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f500151a, r101.f500151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500152b, r101.f500152b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500153c, r101.f500153c) == true) goto L18;
        return false;
    L18:
        if (this.f500154d == r101.f500154d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f500151a.hashCode() * 31) + this.f500152b.hashCode()) * 31) + this.f500153c.hashCode()) * 31;
        if (this.f500154d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ShareSuggestionItem(id=" + this.f500151a + ", title=" + this.f500152b + ", imageList=" + this.f500153c + ", selected=" + this.f500154d + ')';
    }

    public e(String r100, String r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "imageList");
        this.f500151a = r100;
        this.f500152b = r101;
        this.f500153c = r102;
        this.f500154d = false;
    }
}
