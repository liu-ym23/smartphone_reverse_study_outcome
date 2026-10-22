package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f486562c;

    public c3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c3) == true) goto L8;
        return false;
    L8:
        c3 r101 = (c3) r100;
        if (this.f486560a == r101.f486560a) goto L12;
        return false;
    L12:
        if (this.f486561b == r101.f486561b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486562c, r101.f486562c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486560a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486561b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        List<String> r104 = this.f486562c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxVerifyConfig(enableIntercept=" + this.f486560a + ", enableReport=" + this.f486561b + ", innerDomains=" + this.f486562c + ')';
    }

    public /* synthetic */ c3(int r100) {
        this(false, false, null);
    }

    public c3(boolean r100, boolean r101, List<String> r102) {
        this.f486560a = r100;
        this.f486561b = r101;
        this.f486562c = r102;
    }
}
