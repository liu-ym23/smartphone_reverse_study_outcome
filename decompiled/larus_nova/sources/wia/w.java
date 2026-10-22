package wia;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f559905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f559907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f559908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.obric.capabilitykit.m f559909e;

    public w(long r100, String r101, String r102, int r103, com.obric.capabilitykit.m r104) {
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r104, "action");
        this.f559905a = r100;
        this.f559906b = r101;
        this.f559907c = r102;
        this.f559908d = r103;
        this.f559909e = r104;
    }

    public /* synthetic */ w(String r100, String r101, int r110, com.obric.capabilitykit.m r111) {
        this(-1, r100, r101, r110, r111);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f559905a == r101.f559905a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559906b, r101.f559906b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559907c, r101.f559907c) == true) goto L18;
        return false;
    L18:
        if (this.f559908d == r101.f559908d) goto L21;
        return false;
    L21:
        if (this.f559909e == r101.f559909e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f559905a;
        return (((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f559906b.hashCode()) * 31) + this.f559907c.hashCode()) * 31) + this.f559908d) * 31) + this.f559909e.hashCode();
    }

    public final String toString() {
        return "EntityHistoryDao(indexId=" + this.f559905a + ", id=" + this.f559906b + ", data=" + this.f559907c + ", type=" + this.f559908d + ", action=" + this.f559909e + ')';
    }
}
