package la;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f508147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f508148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f508149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Object> f508150d;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f508147a, r101.f508147a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508148b, r101.f508148b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508149c, r101.f508149c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508150d, r101.f508150d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f508147a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f508148b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f508149c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Object> r110 = this.f508150d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoreData(currentUrl=" + this.f508147a + ", moreEnterFrom=" + this.f508148b + ", currentSessionId=" + this.f508149c + ", panelButtons=" + this.f508150d + ')';
    }

    public b(Object r100) {
        this.f508147a = null;
        this.f508148b = null;
        this.f508149c = null;
        this.f508150d = null;
    }
}
