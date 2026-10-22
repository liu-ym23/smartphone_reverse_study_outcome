package org.jetbrains.compose.resources;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@InternalResourceApi
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f525841a;

    public final int hashCode() {
        return this.f525841a.hashCode();
    }

    public final String toString() {
        return "LanguageQualifier(language='" + this.f525841a + "')";
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
        this.f525841a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (k.class == r100.getClass()) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f525841a, ((k) r100).f525841a);
    }
}
