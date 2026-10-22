package ir5;

import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewCategory;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f495465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OfficeDrivePreviewCategory f495466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f495467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f495468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f495469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f495470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f495471k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f495461a, r101.f495461a) == true) goto L12;
        return false;
    L12:
        if (this.f495462b == r101.f495462b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495463c, r101.f495463c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495464d, r101.f495464d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495465e, r101.f495465e) == true) goto L24;
        return false;
    L24:
        if (this.f495466f == r101.f495466f) goto L27;
        return false;
    L27:
        if (this.f495467g == r101.f495467g) goto L30;
        return false;
    L30:
        if (this.f495468h == r101.f495468h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f495469i, r101.f495469i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f495470j, r101.f495470j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f495471k, r101.f495471k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495461a.hashCode() * 31) + this.f495462b) * 31;
        String r101 = this.f495463c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f495464d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f495465e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((r107 + r109) * 31) + this.f495466f.hashCode()) * 31) + this.f495467g) * 31) + this.f495468h) * 31;
        e r111 = this.f495469i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f495470j;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f495471k.hashCode();
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
        return "OfficeDrivePreviewAiFileInfo(token=" + this.f495461a + ", objType=" + this.f495462b + ", title=" + this.f495463c + ", fileExt=" + this.f495464d + ", fileSize=" + this.f495465e + ", previewCategory=" + this.f495466f + ", currentIndex=" + this.f495467g + ", totalCount=" + this.f495468h + ", imageInfo=" + this.f495469i + ", source=" + this.f495470j + ", extra=" + this.f495471k + ')';
    }

    public c(String r100, int r101, String r102, String r103, Long r104, OfficeDrivePreviewCategory r105, int r106, int r107, e r110, String r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r105, "previewCategory");
        Intrinsics.checkNotNullParameter(r112, "extra");
        this.f495461a = r100;
        this.f495462b = r101;
        this.f495463c = r102;
        this.f495464d = r103;
        this.f495465e = r104;
        this.f495466f = r105;
        this.f495467g = r106;
        this.f495468h = r107;
        this.f495469i = r110;
        this.f495470j = r111;
        this.f495471k = r112;
    }
}
