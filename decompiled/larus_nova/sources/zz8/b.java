package zz8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f574101a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f574101a, ((b) r100).f574101a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f574101a.hashCode();
    }

    public final String toString() {
        return "EnterpriseAuthRequestConfig(platformAppId=" + this.f574101a + ')';
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "platformAppId");
        this.f574101a = r100;
    }
}
