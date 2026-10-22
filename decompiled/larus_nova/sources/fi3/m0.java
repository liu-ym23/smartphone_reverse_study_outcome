package fi3;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f477289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f477291c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L12;
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f477289a, r101.f477289a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477290b, r101.f477290b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477291c, r101.f477291c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f477289a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f477290b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f477291c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpHybridMessageParams(globalDataKeys=" + this.f477289a + ", eventName=" + this.f477290b + ", params=" + this.f477291c + ")";
    }

    public m0(List<String> r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        this.f477289a = r100;
        this.f477290b = r101;
        this.f477291c = r102;
    }
}
