package l14;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f506963g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506957a, r101.f506957a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506958b, r101.f506958b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506959c, r101.f506959c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506960d, r101.f506960d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506961e, r101.f506961e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506962f, r101.f506962f) == true) goto L27;
        return false;
    L27:
        if (this.f506963g == r101.f506963g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f506957a.hashCode() * 31) + this.f506958b.hashCode()) * 31;
        String r101 = this.f506959c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f506960d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f506961e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f506962f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((r110 + r102) * 31) + this.f506963g;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FitContainerAdModel(aid=" + this.f506957a + ", desc=" + this.f506958b + ", userName=" + this.f506959c + ", rawAdData=" + this.f506960d + ", cellRoomRawData=" + this.f506961e + ", imprId=" + this.f506962f + ", bottomOffset=" + this.f506963g + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        this.f506957a = r100;
        this.f506958b = r101;
        this.f506959c = r102;
        this.f506960d = r103;
        this.f506961e = r104;
        this.f506962f = r105;
        this.f506963g = r106;
    }
}
