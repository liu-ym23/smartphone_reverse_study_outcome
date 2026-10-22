package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f474302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f474303b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f474302a, r101.f474302a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474303b, r101.f474303b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        o r100 = this.f474302a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        p r104 = this.f474303b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfCoreUIData(productImgUIData=" + this.f474302a + ", productInfoUIData=" + this.f474303b + ')';
    }

    public e(int r100) {
        this.f474302a = null;
        this.f474303b = null;
    }
}
