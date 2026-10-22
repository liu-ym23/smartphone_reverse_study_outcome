package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f235373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f235375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f235376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f235377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f235378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f235379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f235380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g0 f235381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeSpaceTab f235382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OfficeUploadStatus f235383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f235384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f235385m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OfficeUploadTaskSource f235386n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f235387o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f235388p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f235373a, r101.f235373a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235374b, r101.f235374b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235375c, r101.f235375c) == true) goto L18;
        return false;
    L18:
        if (this.f235376d == r101.f235376d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235377e, r101.f235377e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235378f, r101.f235378f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235379g, r101.f235379g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f235380h, r101.f235380h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f235381i, r101.f235381i) == true) goto L36;
        return false;
    L36:
        if (this.f235382j == r101.f235382j) goto L39;
        return false;
    L39:
        if (this.f235383k == r101.f235383k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f235384l, r101.f235384l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f235385m, r101.f235385m) == true) goto L48;
        return false;
    L48:
        if (this.f235386n == r101.f235386n) goto L51;
        return false;
    L51:
        if (this.f235387o == r101.f235387o) goto L54;
        return false;
    L54:
        if (this.f235388p == r101.f235388p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f235373a.hashCode() * 31;
        String r101 = this.f235374b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f235375c.hashCode()) * 31;
        if (this.f235376d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r104 + r105) * 31) + this.f235377e.hashCode()) * 31;
        String r107 = this.f235378f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f235379g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f235380h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((((((r112 + r114) * 31) + this.f235381i.hashCode()) * 31) + this.f235382j.hashCode()) * 31) + this.f235383k.hashCode()) * 31;
        Integer r116 = this.f235384l;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f235385m;
        if (r119 == null) goto L30;
        r102 = r119.hashCode();
    L30:
        int r120 = (((r118 + r102) * 31) + this.f235386n.hashCode()) * 31;
        long r121 = this.f235387o;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.f235388p;
        return r122 + ((int) (r123 ^ (r123 >>> 32)));
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
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeUploadTask(localId=" + this.f235373a + ", driveKey=" + this.f235374b + ", filePointer=" + this.f235375c + ", isFileUseUri=" + this.f235376d + ", displayName=" + this.f235377e + ", mimeType=" + this.f235378f + ", totalBytes=" + this.f235379g + ", uploadedBytes=" + this.f235380h + ", target=" + this.f235381i + ", refreshTab=" + this.f235382j + ", status=" + this.f235383k + ", errorCode=" + this.f235384l + ", errorMessage=" + this.f235385m + ", source=" + this.f235386n + ", createdAt=" + this.f235387o + ", updatedAt=" + this.f235388p + ')';
    }

    public /* synthetic */ h0(String r210, String r211, String r212, boolean r213, String r214, String r215, Long r216, Long r310, g0 r311, OfficeUploadStatus r312, Integer r313, OfficeUploadTaskSource r314, int r315) {
        if ((r315 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r315 & 64) == 0) goto L9;
        Long r110 = null;
    L11:
        if ((r315 & 128) == 0) goto L13;
        Long r111 = null;
    L15:
        if ((r315 & 512) == 0) goto L17;
        OfficeSpaceTab r112 = OfficeSpaceTab.MINE;
    L19:
        if ((r315 & 1024) == 0) goto L21;
        OfficeUploadStatus r113 = OfficeUploadStatus.UNSTARTED;
    L23:
        if ((r315 & 2048) == 0) goto L25;
        Integer r114 = null;
    L27:
        if ((r315 & 8192) == 0) goto L29;
        OfficeUploadTaskSource r115 = OfficeUploadTaskSource.LOCAL;
    L31:
        if ((r315 & 16384) == 0) goto L33;
        long r116 = System.currentTimeMillis();
    L35:
        if ((r315 & 32768) == 0) goto L37;
        long r217 = System.currentTimeMillis();
    L38:
        this(r210, r100, r212, r213, r214, r215, r110, r111, r311, r112, r113, r114, null, r115, r116, r217);
        return;
    L37:
        r217 = 0;
        goto L38
    L33:
        r116 = 0;
        goto L35
    L29:
        r115 = r314;
        goto L31
    L25:
        r114 = r313;
        goto L27
    L21:
        r113 = r312;
        goto L23
    L17:
        r112 = null;
        goto L19
    L13:
        r111 = r310;
        goto L15
    L9:
        r110 = r216;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public h0(String r110, String r111, String r112, boolean r113, String r114, String r115, Long r116, Long r117, g0 r118, OfficeSpaceTab r119, OfficeUploadStatus r210, Integer r211, String r212, OfficeUploadTaskSource r213, long r214, long r215) {
        Intrinsics.checkNotNullParameter(r110, "localId");
        Intrinsics.checkNotNullParameter(r112, "filePointer");
        Intrinsics.checkNotNullParameter(r114, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r118, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r119, "refreshTab");
        Intrinsics.checkNotNullParameter(r210, "status");
        Intrinsics.checkNotNullParameter(r213, "source");
        this.f235373a = r110;
        this.f235374b = r111;
        this.f235375c = r112;
        this.f235376d = r113;
        this.f235377e = r114;
        this.f235378f = r115;
        this.f235379g = r116;
        this.f235380h = r117;
        this.f235381i = r118;
        this.f235382j = r119;
        this.f235383k = r210;
        this.f235384l = r211;
        this.f235385m = r212;
        this.f235386n = r213;
        this.f235387o = r214;
        this.f235388p = r215;
    }

    public static h0 a(h0 r110, String r111, String r112, String r210, boolean r211, String r212, String r213, Long r214, Long r215, g0 r216, OfficeSpaceTab r217, OfficeUploadStatus r218, Integer r219, String r310, OfficeUploadTaskSource r311, long r312, long r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.f235373a;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.f235374b;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.f235375c;
    L15:
        if ((r314 & 8) == 0) goto L17;
        boolean r103 = r110.f235376d;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.f235377e;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.f235378f;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Long r106 = r110.f235379g;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Long r107 = r110.f235380h;
    L35:
        if ((r314 & 256) == 0) goto L37;
        g0 r113 = r110.f235381i;
    L39:
        if ((r314 & 512) == 0) goto L41;
        OfficeSpaceTab r114 = r110.f235382j;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        OfficeUploadStatus r115 = r110.f235383k;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Integer r116 = r110.f235384l;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.f235385m;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        OfficeUploadTaskSource r118 = r110.f235386n;
    L58:
        String r315 = r117;
        Integer r220 = r116;
        if ((r314 & 16384) == 0) goto L61;
        long r119 = r110.f235387o;
    L62:
        long r316 = r119;
        if ((r314 & 32768) == 0) goto L65;
        long r120 = r110.f235388p;
    L66:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "localId");
        Intrinsics.checkNotNullParameter(r102, "filePointer");
        Intrinsics.checkNotNullParameter(r104, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r113, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r114, "refreshTab");
        Intrinsics.checkNotNullParameter(r115, "status");
        Intrinsics.checkNotNullParameter(r118, "source");
        return new h0(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r220, r315, r118, r316, r120);
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
