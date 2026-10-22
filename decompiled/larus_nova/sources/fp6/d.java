package fp6;

import com.bytedance.forest.Forest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Forest f478291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f478292b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f478291a, r101.f478291a) == true) goto L12;
        return false;
    L12:
        if (this.f478292b == r101.f478292b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Forest r100 = this.f478291a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f478292b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForestClientWrapper(forest=" + this.f478291a + ", syncRequest=" + this.f478292b + ')';
    }

    public d(Forest r100) {
        this.f478291a = r100;
        this.f478292b = true;
    }
}
