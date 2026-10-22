package me6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f513490b;

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f513489a, r101.f513489a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513490b, r101.f513490b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513489a.hashCode() * 31;
        List<T> r101 = this.f513490b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CombineResult(effect=" + this.f513489a + ", nodes=" + this.f513490b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, List<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        this.f513489a = r100;
        this.f513490b = r101;
    }
}
