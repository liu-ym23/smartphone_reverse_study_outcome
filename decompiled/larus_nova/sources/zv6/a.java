package zv6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f573731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f573732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573733c;

    public a() {
        this(null, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f573731a, r101.f573731a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573732b, r101.f573732b) == true) goto L15;
        return false;
    L15:
        if (this.f573733c == r101.f573733c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f573731a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f573732b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f573733c;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonOpenImagePreviewData(images=" + this.f573731a + ", descriptionList=" + this.f573732b + ", index=" + this.f573733c + ')';
    }

    public a(List<String> r100, List<String> r101, int r102) {
        this.f573731a = r100;
        this.f573732b = r101;
        this.f573733c = r102;
    }
}
