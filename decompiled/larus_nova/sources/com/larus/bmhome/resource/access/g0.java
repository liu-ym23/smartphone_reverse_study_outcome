package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f313659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CountDownLatch f313660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mr9.h f313661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final mr9.c f313662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f313663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v f313664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d0 f313665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f313666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f313667n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f313654a, r101.f313654a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313655b, r101.f313655b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313656c, r101.f313656c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313657d, r101.f313657d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313658e, r101.f313658e) == true) goto L24;
        return false;
    L24:
        if (this.f313659f == r101.f313659f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313660g, r101.f313660g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f313661h, r101.f313661h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f313662i, r101.f313662i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f313663j, r101.f313663j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f313664k, r101.f313664k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f313665l, r101.f313665l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f313666m, r101.f313666m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f313667n, r101.f313667n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f313654a.hashCode() * 31) + this.f313655b.hashCode()) * 31;
        String r101 = this.f313656c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f313657d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f313658e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f313659f == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        CountDownLatch r113 = this.f313660g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f313661h.hashCode()) * 31;
        mr9.c r116 = this.f313662i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f313663j;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return ((((((((r118 + r102) * 31) + this.f313664k.hashCode()) * 31) + this.f313665l.hashCode()) * 31) + this.f313666m.hashCode()) * 31) + this.f313667n.hashCode();
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceBizContext(fileIdentifier=" + this.f313654a + ", uploadBizScene=" + this.f313655b + ", bizScope=" + this.f313656c + ", uploadSourceScene=" + this.f313657d + ", fileExtension=" + this.f313658e + ", limitUploaderCount=" + this.f313659f + ", latch=" + this.f313660g + ", resourceCenterUploadParam=" + this.f313661h + ", instantUploadPolicy=" + this.f313662i + ", uploadFileSize=" + this.f313663j + ", options=" + this.f313664k + ", timeoutConfig=" + this.f313665l + ", ext=" + this.f313666m + ", runtimeExt=" + this.f313667n + ')';
    }

    public static g0 a(g0 r110, mr9.c r210, Long r211, int r212) {
        Map<String, String> r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = r110.f313654a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = r110.f313655b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = r110.f313656c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = r110.f313657d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = r110.f313658e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r111 = r110.f313659f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        CountDownLatch r112 = r110.f313660g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        mr9.h r113 = r110.f313661h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        mr9.c r114 = r110.f313662i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Long r115 = r110.f313663j;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        v r116 = r110.f313664k;
    L47:
        if ((r212 & 2048) == 0) goto L49;
        d0 r106 = r110.f313665l;
    L51:
        if ((r212 & 4096) == 0) goto L53;
        Map<String, String> r107 = r110.f313666m;
    L55:
        if ((r212 & 8192) == 0) goto L57;
        r100 = r110.f313667n;
    L57:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r102, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r113, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r116, "options");
        Intrinsics.checkNotNullParameter(r106, "timeoutConfig");
        Intrinsics.checkNotNullParameter(r107, "ext");
        Intrinsics.checkNotNullParameter(r100, "runtimeExt");
        return new g0(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r106, r107, r100);
    L53:
        r107 = null;
        goto L55
    L49:
        r106 = null;
        goto L51
    L45:
        r116 = null;
        goto L47
    L41:
        r115 = r211;
        goto L43
    L37:
        r114 = r210;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = false;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public g0(String r100, String r101, String r102, String r103, String r104, boolean r105, CountDownLatch r106, mr9.h r107, mr9.c r110, Long r111, v r112, d0 r113, Map<String, String> r114, Map<String, String> r115) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r101, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r107, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r112, "options");
        Intrinsics.checkNotNullParameter(r113, "timeoutConfig");
        Intrinsics.checkNotNullParameter(r114, "ext");
        Intrinsics.checkNotNullParameter(r115, "runtimeExt");
        this.f313654a = r100;
        this.f313655b = r101;
        this.f313656c = r102;
        this.f313657d = r103;
        this.f313658e = r104;
        this.f313659f = r105;
        this.f313660g = r106;
        this.f313661h = r107;
        this.f313662i = r110;
        this.f313663j = r111;
        this.f313664k = r112;
        this.f313665l = r113;
        this.f313666m = r114;
        this.f313667n = r115;
    }
}
