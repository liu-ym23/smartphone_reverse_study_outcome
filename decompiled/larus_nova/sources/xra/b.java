package xra;

import com.ss.android.ainote.model.AINoteImageUploadState;
import com.ss.android.ainote.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f564924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f564925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AINoteImageUploadState f564926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f564927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f564928j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f564919a, r101.f564919a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f564920b, r101.f564920b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f564921c, r101.f564921c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f564922d, r101.f564922d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f564923e, r101.f564923e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f564924f, r101.f564924f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f564925g, r101.f564925g) == true) goto L30;
        return false;
    L30:
        if (this.f564926h == r101.f564926h) goto L33;
        return false;
    L33:
        if (this.f564927i == r101.f564927i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f564928j, r101.f564928j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f564919a.hashCode() * 31) + this.f564920b.hashCode()) * 31) + this.f564921c.hashCode()) * 31;
        String r101 = this.f564922d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f564923e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        s r108 = this.f564924f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        s r111 = this.f564925g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((r110 + r112) * 31) + this.f564926h.hashCode()) * 31) + this.f564927i) * 31;
        String r114 = this.f564928j;
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
        return "AINoteGalleryImage(imageId=" + this.f564919a + ", localUri=" + this.f564920b + ", originLocalUri=" + this.f564921c + ", uploadToken=" + this.f564922d + ", remoteKey=" + this.f564923e + ", thumbSource=" + this.f564924f + ", originSource=" + this.f564925g + ", uploadState=" + this.f564926h + ", retryCount=" + this.f564927i + ", lastErrorMessage=" + this.f564928j + ')';
    }

    public final s b() {
        s r100 = this.f564924f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f564925g;
    }

    public /* synthetic */ b(String r110, String r111, String r112, String r113, String r114, s r210, s r211, AINoteImageUploadState r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r213 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r213 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 32) == 0) goto L21;
        s r104 = null;
    L23:
        if ((r213 & 64) == 0) goto L25;
        s r115 = null;
    L27:
        if ((r213 & 128) == 0) goto L29;
        AINoteImageUploadState r116 = AINoteImageUploadState.LOCAL;
    L30:
        this(r100, r111, r101, r102, r103, r104, r115, r116, 0, null);
        return;
    L29:
        r116 = r212;
        goto L30
    L25:
        r115 = r211;
        goto L27
    L21:
        r104 = r210;
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
        r100 = r110;
        goto L7
    }

    public static b a(b r110, String r111, String r112, String r113, String r114, AINoteImageUploadState r210, int r211, String r212, int r213) {
        s r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = r110.f564919a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = r110.f564920b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = r110.f564921c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = r110.f564922d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r110.f564923e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        s r115 = r110.f564924f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        r100 = r110.f564925g;
    L29:
        s r116 = r100;
        if ((r213 & 128) == 0) goto L32;
        AINoteImageUploadState r117 = r110.f564926h;
    L34:
        if ((r213 & 256) == 0) goto L36;
        int r118 = r110.f564927i;
    L38:
        if ((r213 & 512) == 0) goto L40;
        String r119 = r110.f564928j;
    L41:
        Intrinsics.checkNotNullParameter(r101, "imageId");
        Intrinsics.checkNotNullParameter(r102, "localUri");
        Intrinsics.checkNotNullParameter(r103, "originLocalUri");
        Intrinsics.checkNotNullParameter(r117, "uploadState");
        return new b(r101, r102, r103, r104, r105, r115, r116, r117, r118, r119);
    L40:
        r119 = r212;
        goto L41
    L36:
        r118 = r211;
        goto L38
    L32:
        r117 = r210;
        goto L34
    L25:
        r115 = null;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public b(String r100, String r101, String r102, String r103, String r104, s r105, s r106, AINoteImageUploadState r107, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "imageId");
        Intrinsics.checkNotNullParameter(r101, "localUri");
        Intrinsics.checkNotNullParameter(r102, "originLocalUri");
        Intrinsics.checkNotNullParameter(r107, "uploadState");
        this.f564919a = r100;
        this.f564920b = r101;
        this.f564921c = r102;
        this.f564922d = r103;
        this.f564923e = r104;
        this.f564924f = r105;
        this.f564925g = r106;
        this.f564926h = r107;
        this.f564927i = r110;
        this.f564928j = r111;
    }
}
