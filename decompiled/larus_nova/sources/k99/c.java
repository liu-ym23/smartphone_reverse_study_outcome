package k99;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502164b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f502163a, r101.f502163a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502164b, r101.f502164b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502163a.hashCode() * 31) + this.f502164b.hashCode();
    }

    public final String toString() {
        return "OfflineMessageContext(cvsId=" + this.f502163a + ", botId=" + this.f502164b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f502163a = r100;
        this.f502164b = r101;
    }
}
