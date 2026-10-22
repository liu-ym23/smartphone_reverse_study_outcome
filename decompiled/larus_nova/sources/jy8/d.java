package jy8;

import com.larus.canvas.service.bean.Icon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f500954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Icon f500956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Icon f500957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f500958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500959f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f500954a == r101.f500954a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500955b, r101.f500955b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500956c, r101.f500956c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500957d, r101.f500957d) == true) goto L21;
        return false;
    L21:
        if (this.f500958e == r101.f500958e) goto L24;
        return false;
    L24:
        if (this.f500959f == r101.f500959f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f500954a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f500955b.hashCode()) * 31;
        Icon r102 = this.f500956c;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        Icon r106 = this.f500957d;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        int r107 = (r105 + r103) * 31;
        int r108 = 1231;
        if (this.f500958e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f500959f == true) goto L19;
        r108 = 1237;
    L19:
        return r110 + r108;
    L13:
        r109 = 1237;
        goto L14
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasOptionListItem(id=" + this.f500954a + ", itemName=" + this.f500955b + ", cover=" + this.f500956c + ", icon=" + this.f500957d + ", isCoverLoading=" + this.f500958e + ", isIconLoading=" + this.f500959f + ')';
    }

    public d(long r100, String r101, Icon r102, Icon r103, boolean r104, boolean r105, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = false;
    L15:
        if ((r110 & 32) == 0) goto L17;
        r105 = false;
    L17:
        Intrinsics.checkNotNullParameter(r101, "itemName");
        this.f500954a = r100;
        this.f500955b = r101;
        this.f500956c = r102;
        this.f500957d = r103;
        this.f500958e = r104;
        this.f500959f = r105;
    }
}
