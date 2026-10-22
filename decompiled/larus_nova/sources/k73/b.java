package k73;

import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f501993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f501995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f501996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f501997h;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f501990a, r101.f501990a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501991b, r101.f501991b) == true) goto L10;
        return false;
    L10:
        if (this.f501992c == r101.f501992c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501993d, r101.f501993d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f501994e, r101.f501994e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f501995f, r101.f501995f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501996g, r101.f501996g) == true) goto L20;
        return false;
    L20:
        if (this.f501997h == r101.f501997h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f501990a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f501991b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f501992c) * 31;
        n r107 = this.f501993d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f501994e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.f501995f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        d r116 = this.f501996g;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.f501997h;
        ?? r119 = r118;
        if (r118 == false) goto L29;
        r119 = 1;
    L29:
        return r117 + r119;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoComponentInfo(sessionId=" + this.f501990a + ", videoId=" + this.f501991b + ", videoDurationMs=" + this.f501992c + ", lynxModel=" + this.f501993d + ", scene=" + this.f501994e + ", schemaQueryMap=" + this.f501995f + ", stateCallback=" + this.f501996g + ", disableCenterPlayIcon=" + this.f501997h + ")";
    }

    public b(String r100, String r101, int r102, n r103, String r104, Map r105, d r110, boolean r111, int r112) {
        if ((r112 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r112 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r112 & 16) == 0) goto L12;
        r104 = VideoComponentScene.HEAD_VIDEO.getScene();
    L12:
        if ((r112 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r112 & 64) == 0) goto L18;
        r110 = null;
    L18:
        if ((r112 & 128) == 0) goto L20;
        r111 = false;
    L20:
        Intrinsics.checkNotNullParameter(r104, "scene");
        this.f501990a = r100;
        this.f501991b = r101;
        this.f501992c = r102;
        this.f501993d = r103;
        this.f501994e = r104;
        this.f501995f = r105;
        this.f501996g = r110;
        this.f501997h = r111;
    }
}
