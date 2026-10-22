package xp9;

import android.net.Uri;
import com.larus.platform.model.album.AlbumSelectItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Uri> f564765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f564766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AlbumSelectItem> f564767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f564768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f564769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f564770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f564771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f564772h;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f564765a, r101.f564765a) == true) goto L12;
        return false;
    L12:
        if (this.f564766b == r101.f564766b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f564767c, r101.f564767c) == true) goto L18;
        return false;
    L18:
        if (this.f564768d == r101.f564768d) goto L21;
        return false;
    L21:
        if (this.f564769e == r101.f564769e) goto L24;
        return false;
    L24:
        if (this.f564770f == r101.f564770f) goto L27;
        return false;
    L27:
        if (this.f564771g == r101.f564771g) goto L30;
        return false;
    L30:
        if (this.f564772h == r101.f564772h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f564765a.hashCode() * 31;
        int r101 = 1231;
        if (this.f564766b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        List<AlbumSelectItem> r104 = this.f564767c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f564768d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f564769e == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f564770f == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f564771g == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (r112 + r113) * 31;
        if (this.f564772h == true) goto L31;
        r101 = 1237;
    L31:
        return r114 + r101;
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumMultiSelectItem(uriList=" + this.f564765a + ", isMultiChooseMode=" + this.f564766b + ", itemList=" + this.f564767c + ", resultReasonSend=" + this.f564768d + ", isSelected=" + this.f564769e + ", skipAttachUpload=" + this.f564770f + ", forceClearAll=" + this.f564771g + ", isOriginalImageChecked=" + this.f564772h + ')';
    }

    public i(List r100, boolean r101, List r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r103 = false;
    L9:
        if ((r111 & 16) == 0) goto L12;
        r104 = false;
    L12:
        if ((r111 & 32) == 0) goto L15;
        r105 = false;
    L15:
        if ((r111 & 64) == 0) goto L18;
        r106 = false;
    L18:
        if ((r111 & 128) == 0) goto L20;
        r110 = false;
    L20:
        Intrinsics.checkNotNullParameter(r100, "uriList");
        this.f564765a = r100;
        this.f564766b = r101;
        this.f564767c = r102;
        this.f564768d = r103;
        this.f564769e = r104;
        this.f564770f = r105;
        this.f564771g = r106;
        this.f564772h = r110;
    }
}
