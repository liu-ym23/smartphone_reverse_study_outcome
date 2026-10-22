package kc8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExpandCardViewMode f502574a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L9;
        return false;
    L9:
        if (this.f502574a == ((t0) r100).f502574a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f502574a.hashCode();
    }

    public final String toString() {
        return "SearchMixedMediaConfig(msgExpandMode=" + this.f502574a + ')';
    }

    public t0() {
        this(ExpandCardViewMode.NORMAL);
    }

    public t0(ExpandCardViewMode r100) {
        Intrinsics.checkNotNullParameter(r100, "msgExpandMode");
        this.f502574a = r100;
    }
}
