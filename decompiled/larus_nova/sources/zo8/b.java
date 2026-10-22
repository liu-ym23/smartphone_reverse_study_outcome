package zo8;

import com.larus.bmhome.bigimg.n1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f573135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f573139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f573140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f573141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f573142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f573143i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f573135a, r101.f573135a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573136b, r101.f573136b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573137c, r101.f573137c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573138d, r101.f573138d) == true) goto L21;
        return false;
    L21:
        if (this.f573139e == r101.f573139e) goto L24;
        return false;
    L24:
        if (this.f573140f == r101.f573140f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f573141g, r101.f573141g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f573142h, r101.f573142h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f573143i, r101.f573143i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f573135a.hashCode() * 31) + this.f573136b.hashCode()) * 31;
        String r101 = this.f573137c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f573138d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        int r108 = 1231;
        if (this.f573139e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f573140f == true) goto L18;
        r108 = 1237;
    L18:
        int r111 = (r110 + r108) * 31;
        String r112 = this.f573141g;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f573142h;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f573143i;
        if (r118 == null) goto L31;
        r102 = r118.hashCode();
    L31:
        return r117 + r102;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageContent(imageUrl=" + this.f573135a + ", thumbImageUrl=" + this.f573136b + ", creationIndex=" + this.f573137c + ", creationTaskId=" + this.f573138d + ", canPublish=" + this.f573139e + ", isBlockContent=" + this.f573140f + ", canvasId=" + this.f573141g + ", canvasSubId=" + this.f573142h + ", imageResourceKey=" + this.f573143i + ')';
    }

    @Override // zo8.a
    public final String a() {
        return this.f573138d;
    }

    @Override // zo8.a
    public final String b() {
        return this.f573137c;
    }

    public b(n1 r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r101, "thumbImageUrl");
        this.f573135a = r100;
        this.f573136b = r101;
        this.f573137c = r102;
        this.f573138d = r103;
        this.f573139e = r104;
        this.f573140f = r105;
        this.f573141g = r106;
        this.f573142h = r107;
        this.f573143i = r110;
    }

    public /* synthetic */ b(n1 r110, String r111, String r112, String r113, boolean r114, boolean r115, String r210, String r211, String r212, int r213) {
        if ((r213 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 16) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r213 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r213 & 64) == 0) goto L21;
        String r116 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, r111, r100, r101, r102, r103, r116, r117, r118);
        return;
    L29:
        r118 = r212;
        goto L30
    L25:
        r117 = r211;
        goto L27
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
