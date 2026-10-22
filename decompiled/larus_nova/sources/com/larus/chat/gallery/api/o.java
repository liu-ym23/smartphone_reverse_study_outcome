package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f324170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f324171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PreviewMediaType f324172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f324173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f324174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f324175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f324176g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f324170a, r101.f324170a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324171b, r101.f324171b) == true) goto L15;
        return false;
    L15:
        if (this.f324172c == r101.f324172c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f324173d, r101.f324173d) == true) goto L21;
        return false;
    L21:
        if (this.f324174e == r101.f324174e) goto L24;
        return false;
    L24:
        if (this.f324175f == r101.f324175f) goto L27;
        return false;
    L27:
        if (this.f324176g == r101.f324176g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f324170a.hashCode() * 31) + this.f324171b.hashCode()) * 31) + this.f324172c.hashCode()) * 31;
        String r101 = this.f324173d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f324174e) * 31) + this.f324175f) * 31;
        long r104 = this.f324176g;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewMediaItem(itemKey=" + this.f324170a + ", uri=" + this.f324171b + ", type=" + this.f324172c + ", thumbnailUri=" + this.f324173d + ", width=" + this.f324174e + ", height=" + this.f324175f + ", durationMs=" + this.f324176g + ')';
    }

    public final PreviewMediaType getType() {
        return this.f324172c;
    }

    public o(String r100, String r101, PreviewMediaType r102, String r103, int r104, int r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f324170a = r100;
        this.f324171b = r101;
        this.f324172c = r102;
        this.f324173d = r103;
        this.f324174e = r104;
        this.f324175f = r105;
        this.f324176g = r106;
    }

    public static o a(o r100, String r110, String r111, String r112, int r113, int r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r110 = r100.f324170a;
    L5:
        String r101 = r110;
        if ((r115 & 2) == 0) goto L8;
        r111 = r100.f324171b;
    L8:
        String r102 = r111;
        if ((r115 & 4) == 0) goto L11;
        PreviewMediaType r116 = r100.f324172c;
    L12:
        PreviewMediaType r103 = r116;
        if ((r115 & 8) == 0) goto L15;
        r112 = r100.f324173d;
    L15:
        String r104 = r112;
        if ((r115 & 16) == 0) goto L18;
        r113 = r100.f324174e;
    L18:
        int r105 = r113;
        if ((r115 & 32) == 0) goto L21;
        r114 = r100.f324175f;
    L21:
        int r106 = r114;
        if ((r115 & 64) == 0) goto L24;
        long r107 = r100.f324176g;
    L25:
        Intrinsics.checkNotNullParameter(r101, "itemKey");
        Intrinsics.checkNotNullParameter(r102, "uri");
        Intrinsics.checkNotNullParameter(r103, "type");
        return new o(r101, r102, r103, r104, r105, r106, r107);
    L24:
        r107 = 0;
        goto L25
    L11:
        r116 = null;
        goto L12
    }

    public /* synthetic */ o(String r110, String r111, PreviewMediaType r112, String r113, int r114, int r115, long r116, int r117) {
        if ((r117 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r117 & 32) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r117 & 64) == 0) goto L17;
        long r103 = 0;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
