package sk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542430c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f542428a, r101.f542428a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542429b, r101.f542429b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f542430c, r101.f542430c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f542428a.hashCode() * 31) + this.f542429b.hashCode()) * 31) + this.f542430c.hashCode();
    }

    public final String toString() {
        return "ElapsedBlockTrackParams(messageId=" + this.f542428a + ", foldStatus=" + this.f542429b + ", conversationId=" + this.f542430c + ')';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "foldStatus");
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        this.f542428a = r100;
        this.f542429b = r101;
        this.f542430c = r102;
    }
}
