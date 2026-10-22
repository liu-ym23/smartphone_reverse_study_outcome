package mwc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516126a;

    public final int hashCode() {
        return this.f516126a.hashCode();
    }

    @Override // mwc.a
    public final String getValue() {
        return this.f516126a;
    }

    public final String toString() {
        return this.f516126a;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f516126a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f516126a, ((c) r100).f516126a) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
