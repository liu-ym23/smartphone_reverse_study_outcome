package kza;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GallerySource f506784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f506785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f506786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f506787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f506789f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f506784a == r101.f506784a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506785b, r101.f506785b) == true) goto L15;
        return false;
    L15:
        if (this.f506786c == r101.f506786c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506787d, r101.f506787d) == true) goto L21;
        return false;
    L21:
        if (this.f506788e == r101.f506788e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506789f, r101.f506789f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f506784a.hashCode() * 31) + this.f506785b.hashCode()) * 31) + this.f506786c) * 31;
        f r101 = this.f506787d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f506788e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        c r107 = this.f506789f;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuGalleryPreviewRequest(source=" + this.f506784a + ", items=" + this.f506785b + ", startIndex=" + this.f506786c + ", loadMoreDelegate=" + this.f506787d + ", enablePhotoEdit=" + this.f506788e + ", callback=" + this.f506789f + ')';
    }

    public /* synthetic */ n(GallerySource r100, List r101, boolean r110, c r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r100 = GallerySource.DEFAULT;
    L5:
        GallerySource r102 = r100;
        if ((r112 & 16) == 0) goto L8;
        boolean r103 = false;
    L10:
        if ((r112 & 32) == 0) goto L12;
        r111 = null;
    L12:
        this(r102, r101, 0, null, r103, r111);
        return;
    L8:
        r103 = r110;
        goto L10
    }

    public n(GallerySource r100, List<m> r101, int r102, f r103, boolean r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f506784a = r100;
        this.f506785b = r101;
        this.f506786c = r102;
        this.f506787d = r103;
        this.f506788e = r104;
        this.f506789f = r105;
    }
}
