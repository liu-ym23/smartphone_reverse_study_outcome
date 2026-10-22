package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f477241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f477242b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a1) == false) goto L10;
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.f477241a, r101.f477241a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477242b, r101.f477242b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f477241a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f477242b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateGlobalDataParams(data=" + this.f477241a + ", needNotify=" + this.f477242b + ")";
    }

    public a1(Map<String, ? extends Object> r100, Boolean r101) {
        this.f477241a = r100;
        this.f477242b = r101;
    }
}
