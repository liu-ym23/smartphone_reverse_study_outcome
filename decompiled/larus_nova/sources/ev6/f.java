package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f474310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f474311c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f474309a, r101.f474309a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474310b, r101.f474310b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474311c, r101.f474311c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474309a.hashCode() * 31;
        Float r101 = this.f474310b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Float r105 = this.f474311c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfImageUIData(imageUrl=" + this.f474309a + ", width=" + this.f474310b + ", height=" + this.f474311c + ')';
    }

    public f(String r100, Float r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        this.f474309a = r100;
        this.f474310b = r101;
        this.f474311c = r102;
    }

    public /* synthetic */ f(String r100, Float r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, null);
    }
}
