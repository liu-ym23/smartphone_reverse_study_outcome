package com.obric.assistant.settings.autogui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f391929b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f391928a, r101.f391928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391929b, r101.f391929b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f391928a.hashCode() * 31) + this.f391929b.hashCode();
    }

    public final String toString() {
        return "ObricAutoExecuteAuthUiState(pageName=" + this.f391928a + ", rows=" + this.f391929b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(String r100, List<? extends c> r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "rows");
        this.f391928a = r100;
        this.f391929b = r101;
    }
}
