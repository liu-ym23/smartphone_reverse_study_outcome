package fh8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f477123a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f477123a, ((j) r100).f477123a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f477123a.hashCode();
    }

    public final String toString() {
        return "MarkdownEmbeddedBlockInputData(blocks=" + this.f477123a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends i> r100) {
        Intrinsics.checkNotNullParameter(r100, "blocks");
        this.f477123a = r100;
    }
}
