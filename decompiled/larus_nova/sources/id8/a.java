package id8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f489353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f489354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f489355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f489356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f489357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f489358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f489359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f489360j;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f489351a, r101.f489351a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489352b, r101.f489352b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489353c, r101.f489353c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489354d, r101.f489354d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489355e, r101.f489355e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489356f, r101.f489356f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489357g, r101.f489357g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489358h, r101.f489358h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f489359i, r101.f489359i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f489360j, r101.f489360j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f489351a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f489352b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f489353c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f489354d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f489355e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f489356f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f489357g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f489358h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f489359i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f489360j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "ImmutableImage(key=" + this.f489351a + ", md5=" + this.f489352b + ", imageThumb=" + this.f489353c + ", imageOri=" + this.f489354d + ", resourceId=" + this.f489355e + ", localResPath=" + this.f489356f + ", identifier=" + this.f489357g + ", ext=" + this.f489358h + ", isMarked=" + this.f489359i + ", isCropped=" + this.f489360j + ')';
    }

    public final String getIdentifier() {
        return this.f489357g;
    }

    public a(String r100, String r101, b r102, b r103, String r104, String r105, String r106, Map<String, String> r107, Boolean r108, Boolean r110) {
        this.f489351a = r100;
        this.f489352b = r101;
        this.f489353c = r102;
        this.f489354d = r103;
        this.f489355e = r104;
        this.f489356f = r105;
        this.f489357g = r106;
        this.f489358h = r107;
        this.f489359i = r108;
        this.f489360j = r110;
    }
}
