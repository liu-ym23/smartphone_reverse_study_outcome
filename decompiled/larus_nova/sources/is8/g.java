package is8;

import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f495670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UploadMediaType f495671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f495672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f495673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f495674e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f495670a, r101.f495670a) == true) goto L12;
        return false;
    L12:
        if (this.f495671b == r101.f495671b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495672c, r101.f495672c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495673d, r101.f495673d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495674e, r101.f495674e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f495670a.hashCode() * 31) + this.f495671b.hashCode()) * 31) + this.f495672c.hashCode()) * 31) + this.f495673d.hashCode()) * 31) + this.f495674e.hashCode();
    }

    public final String toString() {
        return "UploadRequest(source=" + this.f495670a + ", mediaType=" + this.f495671b + ", bizContext=" + this.f495672c + ", policy=" + this.f495673d + ", metadata=" + this.f495674e + ')';
    }

    public g(i r100, UploadMediaType r101, c r102, f r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "mediaType");
        Intrinsics.checkNotNullParameter(r102, "bizContext");
        Intrinsics.checkNotNullParameter(r103, "policy");
        Intrinsics.checkNotNullParameter(r104, "metadata");
        this.f495670a = r100;
        this.f495671b = r101;
        this.f495672c = r102;
        this.f495673d = r103;
        this.f495674e = r104;
    }
}
