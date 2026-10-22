package org.jetbrains.compose.resources;

import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f525843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<s> f525844b;

    @InternalResourceApi
    public n() {
        throw null;
    }

    public final int hashCode() {
        return this.f525843a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        if (this.f525843a == ((n) r100).f525843a) goto L16;
        return false;
    L16:
        return true;
    }

    public n(int r100, Set r101) {
        this.f525843a = r100;
        this.f525844b = r101;
    }
}
