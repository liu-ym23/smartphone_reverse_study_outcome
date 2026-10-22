package ir5;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final List<h> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewSelectionContext(sessionId=" + this.a + ", resourceKey=" + this.b + ", resourceExt=" + this.c + ", resourceVersion=" + this.d + ", selections=" + this.e + ')';
    }

    public i(String r2, String r3, String r4, String r5, List<h> r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "resourceKey");
        Intrinsics.checkNotNullParameter(r5, "resourceVersion");
        Intrinsics.checkNotNullParameter(r6, "selections");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
