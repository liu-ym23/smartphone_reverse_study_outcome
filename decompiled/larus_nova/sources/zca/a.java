package zca;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f571280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571281b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f571280a, r101.f571280a) == true) goto L12;
        return false;
    L12:
        if (this.f571281b == r101.f571281b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f571280a.hashCode() * 31;
        if (this.f571281b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MessageExtInfo(ext=" + this.f571280a + ", agentExtCompleted=" + this.f571281b + ')';
    }

    public a(Map<String, String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        this.f571280a = r100;
        this.f571281b = r101;
    }
}
