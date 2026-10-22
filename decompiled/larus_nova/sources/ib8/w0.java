package ib8;

import com.larus.bmhome.block.newheader.foldcontainer.HeadTitleLoadingTarget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f489129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f489131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f489132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f489133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f489134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f489135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HeadTitleLoadingTarget f489136i;

    public w0() {
        this(false, false, null, null, null, 0.0f, false, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (this.f489128a == r101.f489128a) goto L12;
        return false;
    L12:
        if (this.f489129b == r101.f489129b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489130c, r101.f489130c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489131d, r101.f489131d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489132e, r101.f489132e) == true) goto L24;
        return false;
    L24:
        if (Float.compare(this.f489133f, r101.f489133f) == 0) goto L27;
        return false;
    L27:
        if (this.f489134g == r101.f489134g) goto L30;
        return false;
    L30:
        if (this.f489135h == r101.f489135h) goto L33;
        return false;
    L33:
        if (this.f489136i == r101.f489136i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f489128a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f489129b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f489130c;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        List<String> r109 = this.f489131d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f489132e;
        if (r112 == null) goto L22;
        r106 = r112.hashCode();
    L22:
        int r113 = (((r111 + r106) * 31) + Float.floatToIntBits(this.f489133f)) * 31;
        if (this.f489134g == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f489135h == true) goto L31;
        r100 = 1237;
    L31:
        return ((r115 + r100) * 31) + this.f489136i.hashCode();
    L25:
        r114 = 1237;
        goto L26
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeadTitleInfo(headNeedTopMargin=" + this.f489128a + ", startShimmerAnimation=" + this.f489129b + ", headTitle=" + this.f489130c + ", headTitleList=" + this.f489131d + ", headIcon=" + this.f489132e + ", arrowRotation=" + this.f489133f + ", arrowVisible=" + this.f489134g + ", showLoadingIndicator=" + this.f489135h + ", loadingTarget=" + this.f489136i + ')';
    }

    public static w0 a(w0 r110, HeadTitleLoadingTarget r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        boolean r100 = r110.f489128a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r101 = r110.f489129b;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r102 = r110.f489130c;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List<String> r103 = r110.f489131d;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r104 = r110.f489132e;
    L23:
        if ((r112 & 32) == 0) goto L25;
        float r105 = r110.f489133f;
    L27:
        if ((r112 & 64) == 0) goto L29;
        boolean r106 = r110.f489134g;
    L31:
        if ((r112 & 128) == 0) goto L33;
        boolean r113 = r110.f489135h;
    L35:
        if ((r112 & 256) == 0) goto L37;
        r111 = r110.f489136i;
    L37:
        HeadTitleLoadingTarget r114 = r111;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r114, "loadingTarget");
        return new w0(r100, r101, r102, r103, r104, r105, r106, r113, r114);
    L33:
        r113 = false;
        goto L35
    L29:
        r106 = false;
        goto L31
    L25:
        r105 = 0.0f;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public /* synthetic */ w0(boolean r110, boolean r111, String r112, List r113, String r114, float r115, boolean r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        float r105 = 0.0f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r116 = true;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r117 = false;
    L35:
        if ((r212 & 256) == 0) goto L37;
        HeadTitleLoadingTarget r118 = HeadTitleLoadingTarget.CONTAINER;
    L38:
        this(r100, r101, r102, r103, r104, r105, r116, r117, r118);
        return;
    L37:
        r118 = null;
        goto L38
    L33:
        r117 = r211;
        goto L35
    L29:
        r116 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public w0(boolean r100, boolean r101, String r102, List<String> r103, String r104, float r105, boolean r106, boolean r107, HeadTitleLoadingTarget r110) {
        Intrinsics.checkNotNullParameter(r110, "loadingTarget");
        this.f489128a = r100;
        this.f489129b = r101;
        this.f489130c = r102;
        this.f489131d = r103;
        this.f489132e = r104;
        this.f489133f = r105;
        this.f489134g = r106;
        this.f489135h = r107;
        this.f489136i = r110;
    }
}
