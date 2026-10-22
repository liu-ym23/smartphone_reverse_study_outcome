package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f465868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f465869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f465870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f465871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<q> f465872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f465873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<f> f465874i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f465866a, r101.f465866a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465867b, r101.f465867b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465868c, r101.f465868c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465869d, r101.f465869d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465870e, r101.f465870e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465871f, r101.f465871f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465872g, r101.f465872g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465873h, r101.f465873h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465874i, r101.f465874i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465866a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465867b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f465868c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        y r110 = this.f465869d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        m r113 = this.f465870e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        m r116 = this.f465871f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<q> r119 = this.f465872g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        q r122 = this.f465873h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<f> r125 = this.f465874i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "CanvasInstructionTab(tabLabel=" + this.f465866a + ", tabName=" + this.f465867b + ", tabType=" + this.f465868c + ", extra=" + this.f465869d + ", icon=" + this.f465870e + ", darkModeIcon=" + this.f465871f + ", optionList=" + this.f465872g + ", singleOption=" + this.f465873h + ", featureOptionPanelList=" + this.f465874i + ')';
    }

    public l(String r100, String r101, Integer r102, y r103, m r104, m r105, List<q> r106, q r107, List<f> r108) {
        this.f465866a = r100;
        this.f465867b = r101;
        this.f465868c = r102;
        this.f465869d = r103;
        this.f465870e = r104;
        this.f465871f = r105;
        this.f465872g = r106;
        this.f465873h = r107;
        this.f465874i = r108;
    }
}
