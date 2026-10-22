package pi8;

import com.larus.im.bean.message.ItemData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemData f529382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f529385d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f529382a, r101.f529382a) == true) goto L12;
        return false;
    L12:
        if (this.f529383b == r101.f529383b) goto L15;
        return false;
    L15:
        if (this.f529384c == r101.f529384c) goto L18;
        return false;
    L18:
        if (this.f529385d == r101.f529385d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f529382a.hashCode() * 31) + this.f529383b) * 31) + this.f529384c) * 31) + this.f529385d;
    }

    public final String toString() {
        return "SearchHolderFirstShowData(itemData=" + this.f529382a + ", position=" + this.f529383b + ", viewWidth=" + this.f529384c + ", viewHeight=" + this.f529385d + ')';
    }

    public l(ItemData r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        this.f529382a = r100;
        this.f529383b = r101;
        this.f529384c = r102;
        this.f529385d = r103;
    }
}
