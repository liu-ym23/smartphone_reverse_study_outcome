package mr9;

import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f515025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f515026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ResourceUploadInstantInfo f515028g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f515022a, r101.f515022a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515023b, r101.f515023b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515024c, r101.f515024c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515025d, r101.f515025d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515026e, r101.f515026e) == true) goto L24;
        return false;
    L24:
        if (this.f515027f == r101.f515027f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f515028g, r101.f515028g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f515022a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f515023b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f515024c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f515025d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        n r113 = this.f515026e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f515027f == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        ResourceUploadInstantInfo r118 = this.f515028g;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "ResourceUploadResult(tosKey=" + this.f515022a + ", aliasName=" + this.f515023b + ", resourceId=" + this.f515024c + ", imageResult=" + this.f515025d + ", videoResult=" + this.f515026e + ", isInstantUploadHit=" + this.f515027f + ", instantUploadInfo=" + this.f515028g + ')';
    }

    public static l a(l r100, String r101, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f515022a;
    L5:
        String r102 = r101;
        if ((r112 & 2) == 0) goto L8;
        r110 = r100.f515023b;
    L8:
        String r103 = r110;
        if ((r112 & 4) == 0) goto L11;
        r111 = r100.f515024c;
    L11:
        String r104 = r111;
        if ((r112 & 8) == 0) goto L14;
        d r105 = r100.f515025d;
    L16:
        if ((r112 & 16) == 0) goto L18;
        n r106 = r100.f515026e;
    L20:
        if ((r112 & 32) == 0) goto L22;
        boolean r107 = r100.f515027f;
    L24:
        if ((r112 & 64) == 0) goto L26;
        ResourceUploadInstantInfo r108 = r100.f515028g;
    L27:
        r100.getClass();
        return new l(r102, r103, r104, r105, r106, r107, r108);
    L26:
        r108 = null;
        goto L27
    L22:
        r107 = false;
        goto L24
    L18:
        r106 = null;
        goto L20
    L14:
        r105 = null;
        goto L16
    }

    public l(String r100, String r101, String r102, d r103, n r104, boolean r105, ResourceUploadInstantInfo r106) {
        this.f515022a = r100;
        this.f515023b = r101;
        this.f515024c = r102;
        this.f515025d = r103;
        this.f515026e = r104;
        this.f515027f = r105;
        this.f515028g = r106;
    }

    public /* synthetic */ l(String r110, String r111, String r112, d r113, n r114, boolean r115, ResourceUploadInstantInfo r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        d r102 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        n r103 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r117 & 64) == 0) goto L25;
        ResourceUploadInstantInfo r105 = null;
    L26:
        this(r110, r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
