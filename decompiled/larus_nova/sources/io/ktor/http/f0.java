package io.ktor.http;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f491859b;

    public f0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f491858a = r100;
    }

    public final boolean a(Function1<? super Character, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        boolean r101 = c(r100);
        if (r101 == false) goto L5;
        this.f491859b++;
    L5:
        return r101;
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        if (c(r100) == true) goto L6;
        return;
    L6:
        if (c(r100) == false) goto L8;
        this.f491859b++;
        goto L6
    }

    public final boolean c(Function1<? super Character, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        if (this.f491859b < this.f491858a.length()) goto L5;
    L7:
        return false;
    L5:
        if (r100.invoke(Character.valueOf(this.f491858a.charAt(this.f491859b))).booleanValue() == false) goto L7;
        return true;
    }
}
