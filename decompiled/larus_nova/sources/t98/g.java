package t98;

import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AlbumThermalLevel f545122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f545123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f545124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f545125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f545126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Double f545127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f545128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f545129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f545130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f545131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f545132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f545133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f545134m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f545135n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f545136o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f545122a == r101.f545122a) goto L12;
        return false;
    L12:
        if (this.f545123b == r101.f545123b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545124c, r101.f545124c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f545125d, r101.f545125d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f545126e, r101.f545126e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f545127f, r101.f545127f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f545128g, r101.f545128g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f545129h, r101.f545129h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f545130i, r101.f545130i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f545131j, r101.f545131j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f545132k, r101.f545132k) == true) goto L42;
        return false;
    L42:
        if (this.f545133l == r101.f545133l) goto L45;
        return false;
    L45:
        if (this.f545134m == r101.f545134m) goto L48;
        return false;
    L48:
        if (this.f545135n == r101.f545135n) goto L51;
        return false;
    L51:
        if (this.f545136o == r101.f545136o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f545122a.hashCode() * 31;
        int r101 = 1231;
        if (this.f545123b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Boolean r104 = this.f545124c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f545125d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.f545126e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Double r114 = this.f545127f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Double r117 = this.f545128g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.f545129h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.f545130i;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.f545131j;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f545132k;
        if (r129 == null) goto L42;
        r105 = r129.hashCode();
    L42:
        int r130 = (r128 + r105) * 31;
        if (this.f545133l == false) goto L45;
        int r131 = 1231;
    L46:
        int r132 = (r130 + r131) * 31;
        if (this.f545134m == false) goto L49;
        int r133 = 1231;
    L50:
        int r134 = (r132 + r133) * 31;
        if (this.f545135n == false) goto L53;
        int r135 = 1231;
    L54:
        int r136 = (r134 + r135) * 31;
        if (this.f545136o == true) goto L59;
        r101 = 1237;
    L59:
        return r136 + r101;
    L53:
        r135 = 1237;
        goto L54
    L49:
        r133 = 1237;
        goto L50
    L45:
        r131 = 1237;
        goto L46
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumPowerSnapshot(thermalLevel=" + this.f545122a + ", thermalAvailable=" + this.f545123b + ", powerSaveMode=" + this.f545124c + ", batteryLevelPercent=" + this.f545125d + ", isCharging=" + this.f545126e + ", appCpuUsagePercent=" + this.f545127f + ", appCpuSpeedPercent=" + this.f545128g + ", isLowMemory=" + this.f545129h + ", availableMemoryBytes=" + this.f545130i + ", logicalCoreCount=" + this.f545131j + ", bigCoreCount=" + this.f545132k + ", cpuAvailable=" + this.f545133l + ", memoryAvailable=" + this.f545134m + ", batteryAvailable=" + this.f545135n + ", staticCpuAvailable=" + this.f545136o + ')';
    }

    public g(AlbumThermalLevel r100, boolean r101, Boolean r102, Integer r103, Boolean r104, Double r105, Double r110, Boolean r111, Long r112, Integer r113, Integer r114, boolean r115, boolean r116, boolean r117, boolean r118) {
        Intrinsics.checkNotNullParameter(r100, "thermalLevel");
        this.f545122a = r100;
        this.f545123b = r101;
        this.f545124c = r102;
        this.f545125d = r103;
        this.f545126e = r104;
        this.f545127f = r105;
        this.f545128g = r110;
        this.f545129h = r111;
        this.f545130i = r112;
        this.f545131j = r113;
        this.f545132k = r114;
        this.f545133l = r115;
        this.f545134m = r116;
        this.f545135n = r117;
        this.f545136o = r118;
    }
}
