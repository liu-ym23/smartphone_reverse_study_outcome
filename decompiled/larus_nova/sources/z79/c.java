package z79;

import com.larus.bmhome.bigimg.m1;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.GalleryType;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DriveFileItem f570691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f570692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f570693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GalleryType f570694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f570695e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f570691a, r101.f570691a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570692b, r101.f570692b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570693c, r101.f570693c) == true) goto L18;
        return false;
    L18:
        if (this.f570694d == r101.f570694d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f570695e, r101.f570695e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        DriveFileItem r100 = this.f570691a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m1 r104 = this.f570692b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.f570693c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f570694d.hashCode()) * 31;
        String r110 = this.f570695e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "DriveGalleryData(file=" + this.f570691a + ", imageData=" + this.f570692b + ", videoData=" + this.f570693c + ", resourceType=" + this.f570694d + ", key=" + this.f570695e + ')';
    }

    public c(DriveFileItem r100, m1 r101, g r102, GalleryType r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r103, "resourceType");
        this.f570691a = r100;
        this.f570692b = r101;
        this.f570693c = r102;
        this.f570694d = r103;
        this.f570695e = r104;
    }
}
