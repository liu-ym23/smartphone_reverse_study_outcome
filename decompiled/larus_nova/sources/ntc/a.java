package ntc;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final itc.g f520569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f520570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f520571d;

    public final int hashCode() {
        int r100 = (((this.f520568a.hashCode() ^ 1000003) * 1000003) ^ this.f520569b.hashCode()) * 1000003;
        long r101 = this.f520570c;
        return ((r100 ^ ((int) (r101 ^ (r101 >>> 32)))) * 1000003) ^ this.f520571d;
    }

    public final String toString() {
        return "ImmutableEventData{name=" + this.f520568a + ", attributes=" + this.f520569b + ", epochNanos=" + this.f520570c + ", totalAttributeCount=" + this.f520571d + i.f25855d;
    }

    @Override // ntc.c
    public final String getName() {
        return this.f520568a;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f520568a.equals(((a) r101).f520568a) == false) goto L16;
        a r102 = (a) r101;
        if (this.f520569b.equals(r102.f520569b) == false) goto L16;
        if (this.f520570c != r102.f520570c) goto L16;
        if (this.f520571d != r102.f520571d) goto L16;
        return true;
    L16:
        return false;
    L18:
        return false;
    }

    public a(String r100, itc.g r101, long r102, int r103) {
        if (r100 == null) goto L11;
        this.f520568a = r100;
        if (r101 == null) goto L9;
        this.f520569b = r101;
        this.f520570c = r102;
        this.f520571d = r103;
        return;
    L9:
        throw new NullPointerException("Null attributes");
    L11:
        throw new NullPointerException("Null name");
    }
}
