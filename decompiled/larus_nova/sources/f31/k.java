package f31;

import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f475349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f475350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f475351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f475352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f475353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f475354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f475355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f475356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f475357j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L26;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f475348a, r101.f475348a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475349b, r101.f475349b) == true) goto L10;
        return false;
    L10:
        if (this.f475350c == r101.f475350c) goto L12;
        return false;
    L12:
        if (this.f475351d == r101.f475351d) goto L14;
        return false;
    L14:
        if (this.f475352e == r101.f475352e) goto L16;
        return false;
    L16:
        if (this.f475353f == r101.f475353f) goto L18;
        return false;
    L18:
        if (this.f475354g == r101.f475354g) goto L20;
        return false;
    L20:
        if (this.f475355h == r101.f475355h) goto L22;
        return false;
    L22:
        if (this.f475356i == r101.f475356i) goto L24;
        return false;
    L24:
        if (this.f475357j == r101.f475357j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r100 = this.f475348a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f475349b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((((((((r103 + r101) * 31) + this.f475350c) * 31) + this.f475351d) * 31) + this.f475352e) * 31) + this.f475353f) * 31;
        boolean r106 = this.f475354g;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f475355h;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return ((((r109 + r107) * 31) + this.f475356i) * 31) + this.f475357j;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiWindowStatus(linkerID=" + this.f475348a + ", uid=" + this.f475349b + ", x=" + this.f475350c + ", y=" + this.f475351d + ", width=" + this.f475352e + ", height=" + this.f475353f + ", isLocal=" + this.f475354g + ", realWindow=" + this.f475355h + ", windowType=" + this.f475356i + ", position=" + this.f475357j + ")";
    }

    public k(String r100, String r101, int r102, int r103, int r104, int r105, boolean r106, boolean r107, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r101, "uid");
        this.f475348a = r100;
        this.f475349b = r101;
        this.f475350c = r102;
        this.f475351d = r103;
        this.f475352e = r104;
        this.f475353f = r105;
        this.f475354g = r106;
        this.f475355h = r107;
        this.f475356i = r110;
        this.f475357j = r111;
    }

    public /* synthetic */ k(String r110, String r111, int r112, int r113, int r114, int r115, boolean r210, boolean r211, int r212, int r213, int r214) {
        if ((r213 & 256) == 0) goto L5;
        int r116 = WindowType.Anchor.ordinal();
    L7:
        if ((r213 & 512) == 0) goto L9;
        int r117 = -1;
    L10:
        this(r110, r111, r112, r113, r114, r115, r210, r211, r116, r117);
        return;
    L9:
        r117 = 0;
        goto L10
    L5:
        r116 = r212;
        goto L7
    }
}
