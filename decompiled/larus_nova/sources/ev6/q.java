package ev6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f474411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends a> f474413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f474414d;

    public q() {
        this(false, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f474411a == r101.f474411a) goto L12;
        return false;
    L12:
        if (this.f474412b == r101.f474412b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474413c, r101.f474413c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474414d, r101.f474414d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f474411a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f474412b) * 31;
        List<? extends a> r102 = this.f474413c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        f0 r106 = this.f474414d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductLabelUIData(visible=" + this.f474411a + ", priority=" + this.f474412b + ", labels=" + this.f474413c + ", soldInfo=" + this.f474414d + ')';
    }

    public q(boolean r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this.f474411a = r100;
        this.f474412b = r101;
        this.f474413c = null;
        this.f474414d = null;
    }
}
