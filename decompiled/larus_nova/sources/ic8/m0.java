package ic8;

import com.larus.platform.api.FlowDriveFileType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f489224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f489225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f489226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f489227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f489228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f489229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f489230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f489231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f489232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FlowDriveFileType f489233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public mr9.c f489234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f489235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Float f489236n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f489223a, r101.f489223a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489224b, r101.f489224b) == true) goto L15;
        return false;
    L15:
        if (this.f489225c == r101.f489225c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489226d, r101.f489226d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489227e, r101.f489227e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489228f, r101.f489228f) == true) goto L27;
        return false;
    L27:
        if (this.f489229g == r101.f489229g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489230h, r101.f489230h) == true) goto L33;
        return false;
    L33:
        if (this.f489231i == r101.f489231i) goto L36;
        return false;
    L36:
        if (this.f489232j == r101.f489232j) goto L39;
        return false;
    L39:
        if (this.f489233k == r101.f489233k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f489234l, r101.f489234l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f489235m, r101.f489235m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f489236n, r101.f489236n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f489223a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f489224b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f489225c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f489226d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f489227e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f489228f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        int r118 = 1231;
        if (this.f489229g == false) goto L25;
        int r119 = 1231;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f489230h;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        if (this.f489231i == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r123 + r124) * 31;
        if (this.f489232j == true) goto L38;
        r118 = 1237;
    L38:
        int r126 = (r125 + r118) * 31;
        FlowDriveFileType r127 = this.f489233k;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        mr9.c r130 = this.f489234l;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f489235m;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Float r136 = this.f489236n;
        if (r136 == null) goto L55;
        r101 = r136.hashCode();
    L55:
        return r135 + r101;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L33:
        r124 = 1237;
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = 1237;
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProcessFileInfo(fileOriginPath=" + this.f489223a + ", fileName=" + this.f489224b + ", fileSize=" + this.f489225c + ", fileType=" + this.f489226d + ", localAppPath=" + this.f489227e + ", fileMD5=" + this.f489228f + ", isMultiFile=" + this.f489229g + ", fileTosKey=" + this.f489230h + ", isMarkedPhoto=" + this.f489231i + ", isCroppedPhoto=" + this.f489232j + ", driveFileType=" + this.f489233k + ", instantUploadPolicy=" + this.f489234l + ", originalImageFormat=" + this.f489235m + ", duration=" + this.f489236n + ')';
    }

    public final FlowDriveFileType b() {
        return this.f489233k;
    }

    public final String c() {
        return this.f489224b;
    }

    public final long d() {
        return this.f489225c;
    }

    public final String e() {
        return this.f489226d;
    }

    public static m0 a(m0 r110, String r210, String r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r110.f489223a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r110.f489224b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = r110.f489225c;
    L14:
        long r103 = r102;
        if ((r213 & 8) == 0) goto L17;
        String r104 = r110.f489226d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r110.f489227e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r111 = r110.f489228f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        boolean r106 = r110.f489229g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r112 = r110.f489230h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        boolean r113 = r110.f489231i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        boolean r114 = r110.f489232j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        FlowDriveFileType r115 = r110.f489233k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        mr9.c r116 = r110.f489234l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        String r117 = r110.f489235m;
    L55:
        if ((r213 & 8192) == 0) goto L57;
        Float r118 = r110.f489236n;
    L59:
        return new m0(r100, r101, r103, r104, r105, r111, r106, r112, r113, r114, r115, r116, r117, r118);
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = null;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = false;
        goto L43
    L37:
        r113 = false;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r106 = false;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r102 = 0;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public /* synthetic */ m0(String r210, String r211, long r212, String r213, String r214, FlowDriveFileType r215, String r216, int r217) {
        if ((r217 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r217 & 4) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r217 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r217 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r217 & 1024) == 0) goto L21;
        FlowDriveFileType r110 = null;
    L23:
        if ((r217 & 4096) == 0) goto L25;
        String r111 = null;
    L26:
        this(r210, r100, r101, r102, r103, null, false, null, false, false, r110, null, r111, null);
        return;
    L25:
        r111 = r216;
        goto L26
    L21:
        r110 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public m0(String r100, String r101, long r102, String r103, String r104, String r105, boolean r106, String r107, boolean r110, boolean r111, FlowDriveFileType r112, mr9.c r113, String r114, Float r115) {
        this.f489223a = r100;
        this.f489224b = r101;
        this.f489225c = r102;
        this.f489226d = r103;
        this.f489227e = r104;
        this.f489228f = r105;
        this.f489229g = r106;
        this.f489230h = r107;
        this.f489231i = r110;
        this.f489232j = r111;
        this.f489233k = r112;
        this.f489234l = r113;
        this.f489235m = r114;
        this.f489236n = r115;
    }
}
