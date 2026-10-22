package com.bytedance.locallife.host.share;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f258964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f258966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f258967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f258968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f258969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f258970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f258971h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f258964a, r101.f258964a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f258965b, r101.f258965b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f258966c, r101.f258966c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258967d, r101.f258967d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f258968e, r101.f258968e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f258969f, r101.f258969f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f258970g, r101.f258970g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f258971h, r101.f258971h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f258964a.hashCode() * 31) + this.f258965b.hashCode()) * 31;
        String r101 = this.f258966c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f258967d.hashCode()) * 31;
        String r105 = this.f258968e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f258969f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f258970g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((r110 + r102) * 31) + this.f258971h.hashCode();
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
        return "LifeShareRequest(scene=" + this.f258964a + ", title=" + this.f258965b + ", description=" + this.f258966c + ", url=" + this.f258967d + ", imageUrl=" + this.f258968e + ", contentId=" + this.f258969f + ", poiId=" + this.f258970g + ", trackParams=" + this.f258971h + ')';
    }

    public s(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Map<String, ? extends Object> r107) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r107, "trackParams");
        this.f258964a = r100;
        this.f258965b = r101;
        this.f258966c = r102;
        this.f258967d = r103;
        this.f258968e = r104;
        this.f258969f = r105;
        this.f258970g = r106;
        this.f258971h = r107;
    }
}
