package kh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements e<String> {
    public final String a;

    public c() {
        this(0);
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ExtraMessage(value=" + this.a + ")";
    }

    @Override // kh2.e
    public final String getValue() {
        return this.a;
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public /* synthetic */ c(int r1) {
        this("");
    }
}
