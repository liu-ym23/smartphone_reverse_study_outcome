package kh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements e<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503449a;

    public c() {
        this(0);
    }

    public final int hashCode() {
        String r100 = this.f503449a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ExtraMessage(value=" + this.f503449a + ")";
    }

    @Override // kh2.e
    public final String getValue() {
        return this.f503449a;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f503449a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f503449a, ((c) r100).f503449a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public /* synthetic */ c(int r100) {
        this("");
    }
}
