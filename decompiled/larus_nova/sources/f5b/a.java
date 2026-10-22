package f5b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements y28.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f475661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f475663c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f475661a == r101.f475661a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475662b, r101.f475662b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475663c, r101.f475663c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f475661a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f475662b.hashCode()) * 31;
        CharSequence r102 = this.f475663c;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "AISmartReplyVO(messageId=" + this.f475661a + ", aiReplyId=" + this.f475662b + ", answerDigest=" + this.f475663c + ')';
    }

    @Override // y28.b
    public final boolean isContentSame(y28.b r100) {
        a r101 = (a) r100;
        if (this != r101) goto L6;
        return true;
    L6:
        if (r101 == null) goto L8;
        Class<a> r102 = a.class;
    L10:
        if (Intrinsics.areEqual(a.class, r102) == true) goto L13;
    L11:
        return false;
    L13:
        if (this.f475661a != r101.f475661a) goto L11;
        if (Intrinsics.areEqual(this.f475662b, r101.f475662b) == false) goto L11;
        if (Intrinsics.areEqual(this.f475663c, r101.f475663c) == false) goto L11;
        return true;
    L8:
        r102 = null;
        goto L10
    }

    @Override // y28.b
    public final boolean isItemSame(y28.b r100) {
        a r101 = (a) r100;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475662b, r101.f475662b) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (this.f475661a != r101.f475661a) goto L7;
        r102 = true;
        goto L8
    }

    public a(long r100, String r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r101, "aiReplyId");
        this.f475661a = r100;
        this.f475662b = r101;
        this.f475663c = r102;
    }
}
