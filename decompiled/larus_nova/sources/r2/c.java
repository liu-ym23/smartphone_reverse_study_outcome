package r2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f535696a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f535696a, ((c) r100).f535696a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f535696a.hashCode();
    }

    public final String toString() {
        return "AppletChatActionBarConfig(items=" + this.f535696a + ')';
    }

    public c() {
        this(CollectionsKt.emptyList());
    }

    public c(List<e> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f535696a = r100;
    }
}
