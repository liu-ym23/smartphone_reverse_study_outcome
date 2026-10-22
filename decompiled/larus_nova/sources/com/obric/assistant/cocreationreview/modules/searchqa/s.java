package com.obric.assistant.cocreationreview.modules.searchqa;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f387584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f387586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f387587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<r> f387588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f387589j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f387580a, r101.f387580a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387581b, r101.f387581b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387582c, r101.f387582c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387583d, r101.f387583d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387584e, r101.f387584e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387585f, r101.f387585f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387586g, r101.f387586g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387587h, r101.f387587h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387588i, r101.f387588i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387589j, r101.f387589j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f387580a.hashCode() * 31) + this.f387581b.hashCode()) * 31) + this.f387582c.hashCode()) * 31;
        String r101 = this.f387583d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f387584e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f387585f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f387586g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((r110 + r112) * 31) + this.f387587h.hashCode()) * 31) + this.f387588i.hashCode()) * 31;
        String r114 = this.f387589j;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
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
        return "SearchQaLocalReference(title=" + this.f387580a + ", description=" + this.f387581b + ", sourceType=" + this.f387582c + ", entityType=" + this.f387583d + ", entityId=" + this.f387584e + ", entityPackageName=" + this.f387585f + ", index=" + this.f387586g + ", imageUris=" + this.f387587h + ", images=" + this.f387588i + ", url=" + this.f387589j + ')';
    }

    public /* synthetic */ s(String r110, String r111, String r112, String r113, String r114, Integer r115, List r116, List r117, String r210, int r211) {
        if ((r211 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r211 & 64) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        List r104 = CollectionsKt.emptyList();
    L23:
        if ((r211 & 256) == 0) goto L25;
        List r105 = CollectionsKt.emptyList();
    L27:
        if ((r211 & 512) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, "", r111, r100, r101, r102, r103, r104, r105, r118);
        return;
    L29:
        r118 = r210;
        goto L30
    L25:
        r105 = r117;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
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

    public s(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, List<String> r107, List<r> r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "sourceType");
        Intrinsics.checkNotNullParameter(r107, "imageUris");
        Intrinsics.checkNotNullParameter(r110, "images");
        this.f387580a = r100;
        this.f387581b = r101;
        this.f387582c = r102;
        this.f387583d = r103;
        this.f387584e = r104;
        this.f387585f = r105;
        this.f387586g = r106;
        this.f387587h = r107;
        this.f387588i = r110;
        this.f387589j = r111;
    }
}
