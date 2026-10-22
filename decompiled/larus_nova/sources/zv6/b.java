package zv6;

import jx6.h;
import jx6.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f573734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f573736c;

    public b() {
        this(null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f573734a, r101.f573734a) == true) goto L12;
        return false;
    L12:
        if (this.f573735b == r101.f573735b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573736c, r101.f573736c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f573734a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f573735b) * 31;
        p r104 = this.f573736c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FoodBigImagePageData(actionParams=" + this.f573734a + ", position=" + this.f573735b + ", itemInfo=" + this.f573736c + ')';
    }

    public b(h r100, int r101, p r102) {
        this.f573734a = r100;
        this.f573735b = r101;
        this.f573736c = r102;
    }
}
