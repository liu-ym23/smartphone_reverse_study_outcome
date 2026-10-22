package tw6;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f547772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f547773b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f547772a, r101.f547772a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547773b, r101.f547773b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String[] r100 = this.f547772a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.f547773b;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public final String toString() {
        return "PreloadSwitch(preloadSchemaList=" + Arrays.toString(this.f547772a) + ", preloadSchemaListV2=" + Arrays.toString(this.f547773b) + ')';
    }

    public c(String[] r100, String[] r101) {
        this.f547772a = r100;
        this.f547773b = r101;
    }
}
