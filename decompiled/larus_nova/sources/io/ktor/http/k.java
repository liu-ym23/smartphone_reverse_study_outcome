package io.ktor.http;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f491884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f491885c;

    public final String toString() {
        return "HeaderValueParam(name=" + this.f491883a + ", value=" + this.f491884b + ", escapeValue=" + this.f491885c + ')';
    }

    public final int hashCode() {
        String r100 = this.f491883a;
        Locale r101 = Locale.ROOT;
        int r102 = r100.toLowerCase(r101).hashCode();
        return r102 + ((r102 * 31) + this.f491884b.toLowerCase(r101).hashCode());
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == false) goto L9;
        k r101 = (k) r100;
        if (StringsKt.equals(r101.f491883a, this.f491883a, true) == false) goto L9;
        if (StringsKt.equals(r101.f491884b, this.f491884b, true) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f491883a = r100;
        this.f491884b = r101;
        this.f491885c = false;
    }
}
