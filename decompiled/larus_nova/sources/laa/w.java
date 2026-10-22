package laa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508245b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f508244a, r101.f508244a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508245b, r101.f508245b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f508244a.hashCode() * 31) + this.f508245b.hashCode();
    }

    public final String toString() {
        return "PendingComplexTaskReplyTarget(replyMessageId=" + this.f508244a + ", source=" + this.f508245b + ')';
    }

    public w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyMessageId");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f508244a = r100;
        this.f508245b = r101;
    }
}
