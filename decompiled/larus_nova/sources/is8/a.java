package is8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthMode f495636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UploadEngineType f495637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f495639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f495640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UploadScene f495641f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f495636a == r101.f495636a) goto L12;
        return false;
    L12:
        if (this.f495637b == r101.f495637b) goto L15;
        return false;
    L15:
        if (this.f495638c == r101.f495638c) goto L18;
        return false;
    L18:
        if (this.f495639d == r101.f495639d) goto L21;
        return false;
    L21:
        if (this.f495640e == r101.f495640e) goto L24;
        return false;
    L24:
        if (this.f495641f == r101.f495641f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495636a.hashCode() * 31) + this.f495637b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f495638c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f495639d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f495640e == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f495641f.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResolvedUploadRoute(authMode=" + this.f495636a + ", engineType=" + this.f495637b + ", needRegister=" + this.f495638c + ", needPreParse=" + this.f495639d + ", needResourceCenter=" + this.f495640e + ", uploadScene=" + this.f495641f + ')';
    }

    public a(AuthMode r100, UploadEngineType r101, boolean r102, boolean r103, boolean r104, UploadScene r105) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        Intrinsics.checkNotNullParameter(r101, "engineType");
        Intrinsics.checkNotNullParameter(r105, "uploadScene");
        this.f495636a = r100;
        this.f495637b = r101;
        this.f495638c = r102;
        this.f495639d = r103;
        this.f495640e = r104;
        this.f495641f = r105;
    }
}
