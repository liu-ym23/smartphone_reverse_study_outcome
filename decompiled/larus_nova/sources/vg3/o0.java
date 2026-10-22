package vg3;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f554692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554693b;

    public final int hashCode() {
        return (this.f554693b * 31) + Arrays.hashCode(this.f554692a);
    }

    public final String toString() {
        return "VisibleInfo(lastPositions=" + Arrays.toString(this.f554692a) + ", totalCount=" + this.f554693b + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(o0.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        o0 r102 = (o0) r100;
        if (this.f554693b == r102.f554693b) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.f554692a, r102.f554692a) == true) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.prepurchase.business.pdp.intf.VisibleInfo");
    L8:
        r101 = null;
        goto L10
    }

    public o0(int[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "lastPositions");
        this.f554692a = r100;
        this.f554693b = r101;
    }
}
