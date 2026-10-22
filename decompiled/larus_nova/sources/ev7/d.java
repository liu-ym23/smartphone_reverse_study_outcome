package ev7;

import com.google.archivepatcher.shared.PatchConstants$DeltaFormat;
import iv7.m;

/* JADX INFO: loaded from: classes23.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PatchConstants$DeltaFormat f474476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f474477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f474478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f474479d;

    public final int hashCode() {
        int r100 = (((((this.f474476a.hashCode() ^ 1000003) * 1000003) ^ this.f474477b.hashCode()) * 1000003) ^ this.f474478c.hashCode()) * 1000003;
        long r101 = this.f474479d;
        return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "DeltaDescriptor{deltaFormat=" + this.f474476a + ", deltaFriendlyOldFileRange=" + this.f474477b + ", deltaFriendlyNewFileRange=" + this.f474478c + ", deltaLength=" + this.f474479d + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // ev7.f
    public final PatchConstants$DeltaFormat a() {
        return this.f474476a;
    }

    @Override // ev7.f
    public final m b() {
        return this.f474478c;
    }

    @Override // ev7.f
    public final m c() {
        return this.f474477b;
    }

    @Override // ev7.f
    public final long d() {
        return this.f474479d;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (this.f474476a.equals(r101.a()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.f474477b.equals(r101.c()) == false) goto L16;
        if (this.f474478c.equals(r101.b()) == false) goto L16;
        if (this.f474479d != r101.d()) goto L16;
        return true;
    L18:
        return false;
    }

    public d(PatchConstants$DeltaFormat r100, iv7.a r101, iv7.a r102, long r103) {
        if (r100 == null) goto L7;
        this.f474476a = r100;
        this.f474477b = r101;
        this.f474478c = r102;
        this.f474479d = r103;
        return;
    L7:
        throw new NullPointerException("Null deltaFormat");
    }
}
