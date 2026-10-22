package rw4;

import com.bytedance.ee.bear.contract.export.DocumentExportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final boolean a;
    public final DocumentExportType b;
    public final long c;
    public final int d;
    public final String e;
    public final sbb.e f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        long r2 = this.c;
        int r3 = (((r1 + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.d) * 31;
        String r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L11:
        return ((r3 + r5) * 31) + this.f.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocumentExportResult(success=" + this.a + ", exportType=" + this.b + ", duration=" + this.c + ", errorCode=" + this.d + ", errorMsg=" + this.e + ", resourceType=" + this.f + ')';
    }

    public c(boolean r2, DocumentExportType r3, long r4, int r6, String r7, sbb.e r8) {
        Intrinsics.checkNotNullParameter(r3, "exportType");
        Intrinsics.checkNotNullParameter(r8, "resourceType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
