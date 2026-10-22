package ic8;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f489251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f489253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f489254f;

    public t() {
        this(false, null, null, null, null, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f489249a == r101.f489249a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489250b, r101.f489250b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489251c, r101.f489251c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489252d, r101.f489252d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489253e, r101.f489253e) == true) goto L24;
        return false;
    L24:
        if (this.f489254f == r101.f489254f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f489249a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f489250b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.f489251c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f489252d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Map<String, String> r112 = this.f489253e;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return ((r111 + r103) * 31) + this.f489254f;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeadTitleInfoSimplify(startShimmerAnimation=" + this.f489249a + ", headTitle=" + this.f489250b + ", headTitleList=" + this.f489251c + ", headIcon=" + this.f489252d + ", ext=" + this.f489253e + ", headerStatus=" + this.f489254f + ')';
    }

    public static t a(t r100) {
        boolean r101 = r100.f489249a;
        String r102 = r100.f489250b;
        List<String> r103 = r100.f489251c;
        String r104 = r100.f489252d;
        Map<String, String> r105 = r100.f489253e;
        r100.getClass();
        return new t(r101, r102, r103, r104, r105, 3);
    }

    public t(boolean r100, String r101, List<String> r102, String r103, Map<String, String> r104, int r105) {
        this.f489249a = r100;
        this.f489250b = r101;
        this.f489251c = r102;
        this.f489252d = r103;
        this.f489253e = r104;
        this.f489254f = r105;
    }

    public /* synthetic */ t(boolean r100, String r101, List r110, String r111, Map r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Map r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        int r107 = 1;
    L26:
        this(r102, r103, r104, r105, r106, r107);
        return;
    L25:
        r107 = r113;
        goto L26
    L21:
        r106 = r112;
        goto L23
    L17:
        r105 = r111;
        goto L19
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
