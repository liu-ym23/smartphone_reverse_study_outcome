package v96;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.event.common.e f553810a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f553810a, ((m) r100).f553810a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f553810a.hashCode();
    }

    public final String toString() {
        return "YataUpdateApiInfo(eventInput=" + this.f553810a + ')';
    }

    public m(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInput");
        this.f553810a = r100;
    }
}
