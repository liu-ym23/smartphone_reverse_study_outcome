package ld7;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f508755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f508757c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f508755a, r101.f508755a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508756b, r101.f508756b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508757c, r101.f508757c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f508755a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f508756b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f508757c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MethodCallLimitsBean(runtime_call_count=" + this.f508755a + ", runtime_call_frequency=" + this.f508756b + ", url=" + this.f508757c + ')';
    }

    public m(Integer r100, String r101, List<String> r102) {
        this.f508755a = r100;
        this.f508756b = r101;
        this.f508757c = r102;
    }
}
