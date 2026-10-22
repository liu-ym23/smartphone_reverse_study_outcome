package fub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f478918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f478919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f478920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f478921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f478922h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f478915a, r101.f478915a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478916b, r101.f478916b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478917c, r101.f478917c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f478918d, r101.f478918d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f478919e, r101.f478919e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f478920f, r101.f478920f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f478921g, r101.f478921g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f478922h, r101.f478922h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f478915a.hashCode() * 31) + this.f478916b.hashCode()) * 31;
        String r101 = this.f478917c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f478918d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f478919e.hashCode()) * 31) + this.f478920f.hashCode()) * 31;
        String r108 = this.f478921g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f478922h.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecordingUploadFileParam(uri=" + this.f478915a + ", fileName=" + this.f478916b + ", mimeType=" + this.f478917c + ", fileSizeBytes=" + this.f478918d + ", mountPoint=" + this.f478919e + ", mountNodeToken=" + this.f478920f + ", uploadCode=" + this.f478921g + ", extraRust=" + this.f478922h + ')';
    }

    public c(String r100, String r101, Long r102, String r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter("minutes_artifact", "mountPoint");
        Intrinsics.checkNotNullParameter(r103, "mountNodeToken");
        Intrinsics.checkNotNullParameter(r104, "extraRust");
        this.f478915a = r100;
        this.f478916b = r101;
        this.f478917c = null;
        this.f478918d = r102;
        this.f478919e = "minutes_artifact";
        this.f478920f = r103;
        this.f478921g = null;
        this.f478922h = r104;
    }
}
