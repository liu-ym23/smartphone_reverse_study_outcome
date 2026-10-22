package op3;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f524700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<M> f524701b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f524700a, r101.f524700a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f524701b, r101.f524701b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        d r100 = this.f524700a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f<M> r104 = this.f524701b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SpaceModule(id=" + this.f524700a + ", target=" + this.f524701b + ")";
    }

    public c(d r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f524700a = r100;
        this.f524701b = r101;
    }
}
