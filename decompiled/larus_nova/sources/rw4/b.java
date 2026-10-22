package rw4;

import com.bytedance.ee.bear.contract.export.DocumentExportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocumentExportType f539680a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f539680a == ((b) r100).f539680a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f539680a.hashCode();
    }

    public final String toString() {
        return "DocumentExportClickParams(exportType=" + this.f539680a + ')';
    }

    public b(DocumentExportType r100) {
        Intrinsics.checkNotNullParameter(r100, "exportType");
        this.f539680a = r100;
    }
}
