package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f465831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f465832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f465833e;

    public h() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f465829a, r101.f465829a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465830b, r101.f465830b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465831c, r101.f465831c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465832d, r101.f465832d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465833e, r101.f465833e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465829a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465830b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<j> r107 = this.f465831c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        j r110 = this.f465832d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.f465833e;
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
        return "CanvasGenerateData(genePrompt=" + this.f465829a + ", modelName=" + this.f465830b + ", refImages=" + this.f465831c + ", imageOriRaw=" + this.f465832d + ", imageTargetRaw=" + this.f465833e + ')';
    }

    public h(String r100, String r101, List<j> r102, j r103, j r104) {
        this.f465829a = r100;
        this.f465830b = r101;
        this.f465831c = r102;
        this.f465832d = r103;
        this.f465833e = r104;
    }
}
