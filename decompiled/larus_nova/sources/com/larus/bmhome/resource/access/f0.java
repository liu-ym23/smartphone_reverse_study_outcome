package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceMediaType f313643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f313644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mr9.l f313647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f313648f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f313643a == r101.f313643a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313644b, r101.f313644b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313645c, r101.f313645c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313646d, r101.f313646d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313647e, r101.f313647e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313648f, r101.f313648f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f313643a.hashCode() * 31) + this.f313644b.hashCode()) * 31;
        String r101 = this.f313645c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f313646d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        mr9.l r108 = this.f313647e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f313648f.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceArtifact(mediaType=" + this.f313643a + ", resourceInput=" + this.f313644b + ", tosKey=" + this.f313645c + ", resourceId=" + this.f313646d + ", uploadResult=" + this.f313647e + ", metadata=" + this.f313648f + ')';
    }

    public static f0 a(f0 r100, Map r101) {
        ResourceMediaType r102 = r100.f313643a;
        j0 r103 = r100.f313644b;
        String r104 = r100.f313645c;
        String r105 = r100.f313646d;
        mr9.l r106 = r100.f313647e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "resourceInput");
        Intrinsics.checkNotNullParameter(r101, "metadata");
        return new f0(r102, r103, r104, r105, r106, r101);
    }

    public f0(ResourceMediaType r100, j0 r101, String r102, String r103, mr9.l r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "mediaType");
        Intrinsics.checkNotNullParameter(r101, "resourceInput");
        Intrinsics.checkNotNullParameter(r105, "metadata");
        this.f313643a = r100;
        this.f313644b = r101;
        this.f313645c = r102;
        this.f313646d = r103;
        this.f313647e = r104;
        this.f313648f = r105;
    }

    public /* synthetic */ f0(ResourceMediaType r110, j0 r111, String r112, String r113, mr9.l r114, Map r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        mr9.l r102 = null;
    L15:
        if ((r116 & 32) == 0) goto L17;
        Map r103 = MapsKt.emptyMap();
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
