package com.obric.assistant.settings.autogui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<v0> f391953b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f391952a, r101.f391952a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391953b, r101.f391953b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f391952a.hashCode() * 31) + this.f391953b.hashCode();
    }

    public final String toString() {
        return "ObricRiskPreferenceUiState(pageName=" + this.f391952a + ", rows=" + this.f391953b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s0(String r100, List<? extends v0> r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "rows");
        this.f391952a = r100;
        this.f391953b = r101;
    }

    public static s0 a(s0 r100, List r101) {
        String r102 = r100.f391952a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "pageName");
        Intrinsics.checkNotNullParameter(r101, "rows");
        return new s0(r102, r101);
    }
}
