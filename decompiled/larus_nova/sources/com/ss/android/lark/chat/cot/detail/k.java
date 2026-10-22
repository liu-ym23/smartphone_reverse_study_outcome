package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.cot.CotBlockStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CotDetailBlockType f414983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f414984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f414985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CotBlockStatus f414986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f414987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f414988g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f414982a, r101.f414982a) == true) goto L12;
        return false;
    L12:
        if (this.f414983b == r101.f414983b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f414984c, r101.f414984c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f414985d, r101.f414985d) == true) goto L21;
        return false;
    L21:
        if (this.f414986e == r101.f414986e) goto L24;
        return false;
    L24:
        if (this.f414987f == r101.f414987f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f414988g, r101.f414988g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f414982a.hashCode() * 31) + this.f414983b.hashCode()) * 31;
        String r101 = this.f414984c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        CharSequence r105 = this.f414985d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f414986e.hashCode()) * 31;
        if (this.f414987f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        b r110 = this.f414988g;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CotDetailItem(stableId=" + this.f414982a + ", blockType=" + this.f414983b + ", title=" + this.f414984c + ", body=" + this.f414985d + ", status=" + this.f414986e + ", isStreaming=" + this.f414987f + ", extra=" + this.f414988g + ')';
    }

    public final t b() {
        b r100 = this.f414988g;
        if ((r100 instanceof t) == false) goto L5;
        t r101 = (t) r100;
    L7:
        if (this.f414983b != CotDetailBlockType.STATUS) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public final u c() {
        b r100 = this.f414988g;
        if ((r100 instanceof u) == false) goto L5;
        u r101 = (u) r100;
    L7:
        if (this.f414983b != CotDetailBlockType.TOOLCALL) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public static k a(k r100, b r101) {
        String r102 = r100.f414982a;
        CotDetailBlockType r103 = r100.f414983b;
        String r104 = r100.f414984c;
        CharSequence r105 = r100.f414985d;
        CotBlockStatus r106 = r100.f414986e;
        boolean r107 = r100.f414987f;
        Intrinsics.checkNotNullParameter(r102, "stableId");
        Intrinsics.checkNotNullParameter(r103, "blockType");
        Intrinsics.checkNotNullParameter(r106, "status");
        return new k(r102, r103, r104, r105, r106, r107, r101);
    }

    public k(String r100, CotDetailBlockType r101, String r102, CharSequence r103, CotBlockStatus r104, boolean r105, b r106) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        Intrinsics.checkNotNullParameter(r101, "blockType");
        Intrinsics.checkNotNullParameter(r104, "status");
        this.f414982a = r100;
        this.f414983b = r101;
        this.f414984c = r102;
        this.f414985d = r103;
        this.f414986e = r104;
        this.f414987f = r105;
        this.f414988g = r106;
    }
}
