package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i0 f313680h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f313681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mr9.c f313682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f313683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mr9.h f313684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f0 f313686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f313687g;

    public static final class a {
    }

    public i0() {
        this(null, null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f313681a, r101.f313681a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313682b, r101.f313682b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313683c, r101.f313683c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313684d, r101.f313684d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313685e, r101.f313685e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313686f, r101.f313686f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313687g, r101.f313687g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        j0 r100 = this.f313681a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        mr9.c r104 = this.f313682b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f313683c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        mr9.h r110 = this.f313684d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f313685e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        f0 r116 = this.f313686f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.f313687g.hashCode();
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
        return "ResourceContextUpdate(resourceInput=" + this.f313681a + ", instantUploadPolicy=" + this.f313682b + ", uploadFileSize=" + this.f313683c + ", resourceCenterUploadParam=" + this.f313684d + ", fileExtension=" + this.f313685e + ", artifact=" + this.f313686f + ", attributes=" + this.f313687g + ')';
    }

    static {
        f313680h = new i0(null, null, null, null, null, null, null, 127);
    }

    public i0(j0 r100, mr9.c r101, Long r102, mr9.h r103, String r104, f0 r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r106, "attributes");
        this.f313681a = r100;
        this.f313682b = r101;
        this.f313683c = r102;
        this.f313684d = r103;
        this.f313685e = r104;
        this.f313686f = r105;
        this.f313687g = r106;
    }

    public /* synthetic */ i0(j0 r100, mr9.c r101, Long r102, mr9.h r110, String r111, f0 r112, Map r113, int r114) {
        f0 r103 = null;
        if ((r114 & 1) == 0) goto L5;
        j0 r104 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        mr9.c r105 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        mr9.h r107 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r108 = null;
    L23:
        if ((r114 & 32) != 0) goto L27;
        r103 = r112;
    L27:
        if ((r114 & 64) == 0) goto L29;
        r113 = MapsKt.emptyMap();
    L29:
        this(r104, r105, r106, r107, r108, r103, r113);
        return;
    L21:
        r108 = r111;
        goto L23
    L17:
        r107 = r110;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
