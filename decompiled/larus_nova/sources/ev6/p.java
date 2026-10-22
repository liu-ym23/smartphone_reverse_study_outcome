package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f474408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n0 f474409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f474410c;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474408a, r101.f474408a) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474409b, r101.f474409b) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474410c, r101.f474410c) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        j r100 = this.f474408a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 0) * 31;
        n0 r104 = this.f474409b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b0 r107 = this.f474410c;
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
        return "ShelfProductInfoUIData(propsUIData=null, contentUIData=" + this.f474408a + ", soldInfoUIData=" + this.f474409b + ", priceAndBtnUIData=" + this.f474410c + ')';
    }

    public p(int r100) {
        this.f474408a = null;
        this.f474409b = null;
        this.f474410c = null;
    }
}
