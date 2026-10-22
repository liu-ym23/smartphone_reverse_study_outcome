package ny3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f521191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f521192d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f521189a, r101.f521189a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521190b, r101.f521190b) == true) goto L15;
        return false;
    L15:
        if (this.f521191c == r101.f521191c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f521192d, r101.f521192d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f521189a.hashCode() * 31) + this.f521190b.hashCode()) * 31) + this.f521191c) * 31) + this.f521192d.hashCode();
    }

    public final String toString() {
        return "CommentDiggBuryEvent(aid=" + this.f521189a + ", cid=" + this.f521190b + ", diggType=" + this.f521191c + ", sessionId=" + this.f521192d + ')';
    }

    public a(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, "cid");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        this.f521189a = r100;
        this.f521190b = r101;
        this.f521191c = r102;
        this.f521192d = r103;
    }
}
