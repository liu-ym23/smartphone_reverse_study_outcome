package rw4;

import com.bytedance.ee.bear.contract.export.DocumentExportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final DocumentExportType a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DocumentExportClickParams(exportType=" + this.a + ')';
    }

    public b(DocumentExportType r2) {
        Intrinsics.checkNotNullParameter(r2, "exportType");
        this.a = r2;
    }
}
