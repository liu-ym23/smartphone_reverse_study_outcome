package com.obric.assistant.settings.autogui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f391896b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f391895a, r101.f391895a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391896b, r101.f391896b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f391895a.hashCode() * 31) + this.f391896b.hashCode();
    }

    public final String toString() {
        return "AuthorizationPageConfig(pageName=" + this.f391895a + ", authorizations=" + this.f391896b + ')';
    }

    public b(String r100, List<a> r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "authorizations");
        this.f391895a = r100;
        this.f391896b = r101;
    }
}
