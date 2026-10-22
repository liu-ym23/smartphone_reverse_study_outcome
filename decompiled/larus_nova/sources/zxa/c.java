package zxa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f573904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573905b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f573904a, r101.f573904a) == true) goto L12;
        return false;
    L12:
        if (this.f573905b == r101.f573905b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f573904a.hashCode() * 31) + this.f573905b;
    }

    public final String toString() {
        return "KeyboardHint(text=" + this.f573904a + ", color=" + this.f573905b + ')';
    }

    public c(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f573904a = r100;
        this.f573905b = r101;
    }
}
