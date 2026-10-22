package zd5;

import com.bytedance.ee.bear.list.sort.SortAscType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f571310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f571312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f571314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SortAscType f571315f;

    public q(int r110, int r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "reportSort");
        this(r110, r111, r112, r113, null, null, 48);
    }

    public q(int r110, int r111, boolean r112, String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r113, "reportSort");
        this(r110, r111, r112, r113, r114, null, 32);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f571310a == r101.f571310a) goto L12;
        return false;
    L12:
        if (this.f571311b == r101.f571311b) goto L15;
        return false;
    L15:
        if (this.f571312c == r101.f571312c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f571313d, r101.f571313d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f571314e, r101.f571314e) == true) goto L24;
        return false;
    L24:
        if (this.f571315f == r101.f571315f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f571310a * 31) + this.f571311b) * 31;
        if (this.f571312c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f571313d.hashCode()) * 31;
        Integer r103 = this.f571314e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + this.f571315f.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SortType(resId=" + this.f571310a + ", rank=" + this.f571311b + ", asc=" + this.f571312c + ", reportSort=" + this.f571313d + ", forbiddenFilterResId=" + this.f571314e + ", sortAscType=" + this.f571315f + ')';
    }

    public q(int r100, int r101, boolean r102, String r103, Integer r104, SortAscType r105, int r106) {
        if ((r106 & 16) == 0) goto L6;
        r104 = 0;
    L6:
        if ((r106 & 32) == 0) goto L8;
        r105 = SortAscType.TIME;
    L8:
        Intrinsics.checkNotNullParameter(r103, "reportSort");
        Intrinsics.checkNotNullParameter(r105, "sortAscType");
        this.f571310a = r100;
        this.f571311b = r101;
        this.f571312c = r102;
        this.f571313d = r103;
        this.f571314e = r104;
        this.f571315f = r105;
    }
}
