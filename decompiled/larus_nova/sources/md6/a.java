package md6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f513286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f513287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f513288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f513289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f513290e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f513286a == r101.f513286a) goto L12;
        return false;
    L12:
        if (this.f513287b == r101.f513287b) goto L15;
        return false;
    L15:
        if (this.f513288c == r101.f513288c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f513289d, r101.f513289d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f513290e, r101.f513290e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f513286a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f513287b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f513288c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Long r106 = this.f513289d;
        if (r106 != null) goto L5;
        int r107 = 0;
    L7:
        return ((((r105 + r107) * 31) + this.f513290e.hashCode()) * 31) + 0;
    L5:
        r107 = r106.hashCode();
        goto L7
    }

    public final String toString() {
        return "FrameData(frameStartTime=" + this.f513286a + ", frameEndTime=" + this.f513287b + ", currentTime=" + this.f513288c + ", launchTimeStampMs=" + this.f513289d + ", id=" + this.f513290e + ", metaFrameData=null)";
    }

    public a(long r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter("", "id");
        this.f513286a = r100;
        this.f513287b = r101;
        this.f513288c = r102;
        this.f513289d = null;
        this.f513290e = "";
    }
}
