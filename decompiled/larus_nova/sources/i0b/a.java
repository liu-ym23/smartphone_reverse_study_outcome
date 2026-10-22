package i0b;

import android.util.Size;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f487914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f487915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Size f487916g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487910a, r101.f487910a) == true) goto L12;
        return false;
    L12:
        if (this.f487911b == r101.f487911b) goto L15;
        return false;
    L15:
        if (this.f487912c == r101.f487912c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487913d, r101.f487913d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487914e, r101.f487914e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f487915f, r101.f487915f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f487916g, r101.f487916g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f487910a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f487911b) * 31) + this.f487912c) * 31;
        String r104 = this.f487913d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f487914e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f487915f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Size r113 = this.f487916g;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoadDocThumbnailParams(thumbnailUrl=" + this.f487910a + ", docType=" + this.f487911b + ", secretType=" + this.f487912c + ", secretUrl=" + this.f487913d + ", secretKey=" + this.f487914e + ", secretNonce=" + this.f487915f + ", overrideSize=" + this.f487916g + ')';
    }

    public a(String r100, int r101, int r102, String r103, String r104, String r105, Size r106) {
        this.f487910a = r100;
        this.f487911b = r101;
        this.f487912c = r102;
        this.f487913d = r103;
        this.f487914e = r104;
        this.f487915f = r105;
        this.f487916g = r106;
    }
}
