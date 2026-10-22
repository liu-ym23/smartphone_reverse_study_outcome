package xa;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PredictElementType f563021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f563022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f563023c;

    public final String toString() {
        return "Prediction(elementType=" + this.f563021a + ", value=" + this.f563022b + ", confidence=" + this.f563023c + ')';
    }

    public final int hashCode() {
        int r100 = this.f563021a.hashCode() * 31;
        T r101 = this.f563022b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f563021a == r101.f563021a) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f563022b, r101.f563022b) == false) goto L13;
        return true;
    }

    public b(PredictElementType r100, T r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        this.f563021a = r100;
        this.f563022b = r101;
        this.f563023c = r102;
    }
}
