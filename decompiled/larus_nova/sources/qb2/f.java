package qb2;

import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f532289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f532290b;

    public f() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f532289a, r101.f532289a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f532290b, r101.f532290b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        p r100 = this.f532289a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g r104 = this.f532290b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RenderConfigSet(rendConfig=" + this.f532289a + ", rendConfigV2=" + this.f532290b + ")";
    }

    public f(p r100, g r101) {
        this.f532289a = r100;
        this.f532290b = r101;
    }
}
