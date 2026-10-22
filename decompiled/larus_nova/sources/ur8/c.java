package ur8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f551386a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f551386a, ((c) r100).f551386a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f551386a.hashCode();
    }

    public final String toString() {
        return "MentionDeleteEvent(ids=" + this.f551386a + ')';
    }

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        this.f551386a = r100;
    }
}
