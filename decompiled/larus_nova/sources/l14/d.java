package l14;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506969f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f506964a, r101.f506964a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506965b, r101.f506965b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506966c, r101.f506966c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506967d, r101.f506967d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506968e, r101.f506968e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506969f, r101.f506969f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f506964a.hashCode() * 31) + this.f506965b.hashCode()) * 31;
        String r101 = this.f506966c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f506967d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f506968e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f506969f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "VideoLeftBottomAdModel(aid=" + this.f506964a + ", desc=" + this.f506965b + ", userName=" + this.f506966c + ", rawAdData=" + this.f506967d + ", cellRoomRawData=" + this.f506968e + ", imprId=" + this.f506969f + ')';
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        this.f506964a = r100;
        this.f506965b = r101;
        this.f506966c = r102;
        this.f506967d = r103;
        this.f506968e = r104;
        this.f506969f = r105;
    }
}
