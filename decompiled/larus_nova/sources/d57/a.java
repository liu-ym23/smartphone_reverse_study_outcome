package d57;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f467057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f467058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f467060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f467061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f467062g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f467056a, r101.f467056a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467057b, r101.f467057b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f467058c, r101.f467058c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f467059d, r101.f467059d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f467060e, r101.f467060e) == true) goto L24;
        return false;
    L24:
        if (this.f467061f == r101.f467061f) goto L27;
        return false;
    L27:
        if (this.f467062g == r101.f467062g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f467056a.hashCode() * 31) + Arrays.hashCode(this.f467057b)) * 31) + this.f467058c.hashCode()) * 31) + this.f467059d.hashCode()) * 31) + this.f467060e.hashCode()) * 31) + this.f467061f) * 31;
        long r101 = this.f467062g;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SnapshotEntity(uri='" + this.f467056a + "', queryKeys='" + this.f467057b + "', content='" + this.f467058c + "', head='" + this.f467059d + "', version=" + this.f467060e + ", sdk=" + this.f467061f + ", expireTime=" + this.f467062g + ')';
    }

    public a(String r100, String[] r101, String r102, String r103, String r104, int r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "urlWithQuery");
        Intrinsics.checkNotNullParameter(r101, "queryKeys");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "head");
        Intrinsics.checkNotNullParameter(r104, "version");
        this.f467056a = r100;
        this.f467057b = r101;
        this.f467058c = r102;
        this.f467059d = r103;
        this.f467060e = r104;
        this.f467061f = r105;
        this.f467062g = r106;
    }
}
