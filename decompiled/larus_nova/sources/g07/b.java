package g07;

import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f479492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoModel f479493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f479494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f479495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f479496l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f479497m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f479498n;

    public b() {
        this(null, null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f479485a, r101.f479485a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479486b, r101.f479486b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479487c, r101.f479487c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479488d, r101.f479488d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479489e, r101.f479489e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479490f, r101.f479490f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f479491g, r101.f479491g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f479485a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f479486b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f479487c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f479488d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f479489e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f479490f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f479491g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
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
        return "VideoItem(vid=" + this.f479485a + ", jsonModel=" + this.f479486b + ", playAuthToken=" + this.f479487c + ", playDomain=" + this.f479488d + ", preloadTaskKey=" + this.f479489e + ", directUrl=" + this.f479490f + ", localUrl=" + this.f479491g + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L23;
        r106 = null;
    L23:
        this.f479485a = r100;
        this.f479486b = r101;
        this.f479487c = r102;
        this.f479488d = r103;
        this.f479489e = r104;
        this.f479490f = r105;
        this.f479491g = r106;
        this.f479497m = -1;
        this.f479498n = new a();
    }
}
