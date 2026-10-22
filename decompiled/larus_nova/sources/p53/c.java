package p53;

import com.bytedance.android.ec.model.response.LynxCellData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxCellData f527772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f527773b;

    public /* synthetic */ c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f527772a, r101.f527772a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527773b, r101.f527773b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        LynxCellData r100 = this.f527772a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f527773b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentLynxCellVO(data=" + this.f527772a + ", trackParams=" + this.f527773b + ")";
    }

    public c(LynxCellData r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f527772a = r100;
        this.f527773b = r101;
    }
}
