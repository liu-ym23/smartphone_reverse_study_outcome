package kza;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryType f506777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f506778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f506779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GalleryItemType f506781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f506782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f506783g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f506777a == r101.f506777a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506778b, r101.f506778b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506779c, r101.f506779c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506780d, r101.f506780d) == true) goto L21;
        return false;
    L21:
        if (this.f506781e == r101.f506781e) goto L24;
        return false;
    L24:
        if (this.f506782f == r101.f506782f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506783g, r101.f506783g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506777a.hashCode() * 31;
        l r101 = this.f506778b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        p r105 = this.f506779c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f506780d.hashCode()) * 31) + this.f506781e.hashCode()) * 31) + this.f506782f) * 31;
        o r108 = this.f506783g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuGalleryPreviewItem(type=" + this.f506777a + ", image=" + this.f506778b + ", video=" + this.f506779c + ", messageId=" + this.f506780d + ", itemType=" + this.f506781e + ", groupIndex=" + this.f506782f + ", securityContext=" + this.f506783g + ')';
    }

    public final GalleryType getType() {
        return this.f506777a;
    }

    public m(GalleryType r100, l r101, p r102, String r103, GalleryItemType r104, int r105, o r106) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r104, "itemType");
        this.f506777a = r100;
        this.f506778b = r101;
        this.f506779c = r102;
        this.f506780d = r103;
        this.f506781e = r104;
        this.f506782f = r105;
        this.f506783g = r106;
    }

    public /* synthetic */ m(GalleryType r110, l r111, p r112, String r113, GalleryItemType r114, int r115, o r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        l r100 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        p r101 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r117 & 16) == 0) goto L17;
        GalleryItemType r103 = GalleryItemType.Lark;
    L19:
        if ((r117 & 32) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r117 & 64) == 0) goto L25;
        o r105 = null;
    L26:
        this(r110, r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
