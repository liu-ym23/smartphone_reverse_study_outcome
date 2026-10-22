package io.ktor.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f491959b;

    public final int hashCode() {
        return this.f491959b;
    }

    public final String toString() {
        return this.f491958a;
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f491958a = r100;
        this.f491959b = r100.toLowerCase(Locale.ROOT).hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == false) goto L5;
        f r101 = (f) r100;
    L7:
        if (r101 == null) goto L14;
        String r102 = r101.f491958a;
        if (r102 != null) goto L11;
        return false;
    L11:
        if (StringsKt.equals(r102, this.f491958a, true) != true) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L5:
        r101 = null;
        goto L7
    }
}
