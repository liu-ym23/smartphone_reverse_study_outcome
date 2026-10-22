package ti4;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DATA f546102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546104c;

    public s() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f546102a, r101.f546102a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546103b, r101.f546103b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546104c, r101.f546104c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        DATA r100 = this.f546102a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f546103b.hashCode()) * 31) + this.f546104c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "Page(data=" + this.f546102a + ", name=" + this.f546103b + ", displayName=" + this.f546104c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.f546102a = r100;
        this.f546103b = r101;
        this.f546104c = r101;
    }
}
