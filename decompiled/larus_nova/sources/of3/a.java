package of3;

import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f523072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f523073b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f523072a, r101.f523072a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f523073b, r101.f523073b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        FrameLayout r100 = this.f523072a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f523073b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxPendant(lynxViewContainer=" + this.f523072a + ", lynxCard=" + this.f523073b + ")";
    }

    public a(FrameLayout r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxViewContainer");
        Intrinsics.checkNotNullParameter(r101, "lynxCard");
        this.f523072a = r100;
        this.f523073b = r101;
    }
}
