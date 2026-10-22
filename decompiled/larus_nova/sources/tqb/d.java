package tqb;

import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkLynxHostParams f547244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkLynxHostOptions f547245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f547246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f547247d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f547244a, r101.f547244a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547245b, r101.f547245b) == true) goto L15;
        return false;
    L15:
        if (this.f547246c == r101.f547246c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547247d, r101.f547247d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f547244a.hashCode() * 31) + this.f547245b.hashCode()) * 31;
        if (this.f547246c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        g r103 = this.f547247d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkLynxHostEntry(params=" + this.f547244a + ", options=" + this.f547245b + ", renderOnCreate=" + this.f547246c + ", runtime=" + this.f547247d + ')';
    }

    public d(LarkLynxHostParams r100, LarkLynxHostOptions r101, boolean r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "options");
        this.f547244a = r100;
        this.f547245b = r101;
        this.f547246c = r102;
        this.f547247d = r103;
    }
}
