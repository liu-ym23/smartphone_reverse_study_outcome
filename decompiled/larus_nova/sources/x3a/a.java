package x3a;

import ic8.m0;
import java.util.UUID;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f562404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f562405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f562406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f562407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f562408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f562409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f562410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pair<Integer, Integer> f562411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f562412i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f562404a, r101.f562404a) == true) goto L12;
        return false;
    L12:
        if (this.f562405b == r101.f562405b) goto L15;
        return false;
    L15:
        if (this.f562406c == r101.f562406c) goto L18;
        return false;
    L18:
        if (this.f562407d == r101.f562407d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f562408e, r101.f562408e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f562404a.hashCode() * 31) + this.f562405b) * 31) + this.f562406c) * 31) + this.f562407d) * 31) + this.f562408e.hashCode();
    }

    public final String toString() {
        return "ImageProcessorWrapper(fileInfo=" + this.f562404a + ", width=" + this.f562405b + ", height=" + this.f562406c + ", dataSource=" + this.f562407d + ", key=" + this.f562408e + ')';
    }

    public /* synthetic */ a(m0 r100, int r101) {
        this(r100, 0, 0, r101, UUID.randomUUID().toString());
    }

    public a(m0 r100, int r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "fileInfo");
        Intrinsics.checkNotNullParameter(r104, "key");
        this.f562404a = r100;
        this.f562405b = r101;
        this.f562406c = r102;
        this.f562407d = r103;
        this.f562408e = r104;
        this.f562409f = System.currentTimeMillis();
        this.f562410g = "";
    }
}
